package st.crm.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import st.core.session.HtmlUtil;
import st.crm.model.UserModel;
import st.crm.service.UserService;

@Controller
@RequestMapping("/teacherController")
public class TeacherController {
	@Autowired
	private UserService<UserModel> userService;

	@RequestMapping(value = "getTeacher.do", method = RequestMethod.POST, produces = "application/text;charset=UTF-8")
	@ResponseBody
	public void getTeaher(HttpServletResponse response) throws Exception {
		UserModel um = new UserModel();
		um.setRoleid(2);
		List<UserModel> l = userService.selectAll(um);
		HtmlUtil.writerJson(response, l);
	}
}
