package st.crm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import st.core.session.HtmlUtil;
import st.crm.model.PermissionModel;
import st.crm.model.RoleModel;
import st.crm.model.RolePermissionRelModel;
import st.crm.service.PermissionService;
import st.crm.service.RolePermissionRelService;
import st.crm.service.RoleService;
import st.fifter.Auth;

@Controller
@RequestMapping("/menuController")
public class MenuController {

	@Autowired
	private PermissionService<PermissionModel> permissionService;

	@Autowired
	private RoleService<RoleModel> roleService;
	@Autowired
	private RolePermissionRelService<RolePermissionRelModel> rolePermissionRelService;

	@RequestMapping(value = "getPermission.do")
	public void getPermission(HttpServletResponse response, String roleid) throws Exception {
		RolePermissionRelModel rpm = new RolePermissionRelModel();
		rpm.setRoleid(Integer.parseInt(roleid));
		List<PermissionModel> l = permissionService.selectAll(new PermissionModel());
		List<PermissionModel> result = new ArrayList<>();
		String perid = rolePermissionRelService.selectAll(rpm).get(0).getPermissionid();
		String[] array = perid.split(",");
		int length = array.length;
		Map<String, Object> jsonMap = new HashMap<>();
		for (PermissionModel pm : l) {
			Integer parentid = Integer.parseInt(pm.getParentid());
			if (0 == parentid) {
				result.add(pm);
				continue;
			}
			for (PermissionModel pm2 : result) {
				if (parentid == pm2.getId()) {
					for (int i = 1; i < length; i++) {
						if (Integer.parseInt(array[i]) == pm.getId()) {
							pm.setChecked("true");
						}
					}
					pm2.getChildren().add(pm);
					break;
				}
			}
		}
		jsonMap.put("list", result);
		HtmlUtil.writerJson(response, jsonMap);
	}

	@RequestMapping(value = "getRolePermission.do")
	public void getRolePermission(HttpServletResponse response, RolePermissionRelModel rpm) throws Exception {
		String arrays = rolePermissionRelService.selectAll(rpm).get(0).getPermissionid();
		String[] array = arrays.split(",");
		int length = array.length;
		PermissionModel pm = new PermissionModel();
		List<PermissionModel> l = new ArrayList<>();
		List<PermissionModel> result = new ArrayList<>();
		for (int i = 1; i < length; i++) {
			pm.setId(Integer.parseInt(array[i]));
			l.add(permissionService.selectId(pm));
		}
		for (PermissionModel pmTemp : l) {
			Integer parentid = Integer.parseInt(pmTemp.getParentid());
			if (0 == parentid) {
				result.add(pmTemp);
				continue;
			}
			for (PermissionModel pmTemp2 : result) {
				if (parentid == pmTemp2.getId()) {
					pmTemp2.getChildren().add(pmTemp);
					break;
				}
			}
		}
		Map<String, Object> jsonMap = new HashMap<>();
		jsonMap.put("list", result);
		HtmlUtil.writerJson(response, jsonMap);
	}

	@RequestMapping(value = "getRole.do")
	public void getRole(HttpServletResponse response, RoleModel rm) throws Exception {
		List<RoleModel> l = roleService.selectAll(rm);
		HtmlUtil.writerJson(response, l);
	}

	@Auth(verifyLogin = true)
	@RequestMapping(value = "changeRolePermission.do")
	@ResponseBody
	public String changeRolePermission(RolePermissionRelModel rpm) throws Exception {
		RolePermissionRelModel temp = new RolePermissionRelModel();
		temp.setRoleid(rpm.getRoleid());
		List<RolePermissionRelModel> l = rolePermissionRelService.selectAll(temp);
		if (l.size() != 0) {
			rpm.setId(l.get(0).getId());
			rolePermissionRelService.update(rpm);
			return "ok";
		}
		rolePermissionRelService.insert(rpm);
		return "ok";
	}

}
