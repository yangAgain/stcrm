package st.crm.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import st.core.session.HtmlUtil;
import st.crm.model.LeaveModel;
import st.crm.model.UserModel;
import st.crm.service.LeaveService;
import st.crm.service.UserService;

@Controller
@RequestMapping("/leaveController")
public class LeaveContoller {
	@Autowired
	private LeaveService<LeaveModel> leaveService;

	@Autowired
	private UserService<UserModel> userModel;

	@RequestMapping(value = "getMyLeave.do", method = RequestMethod.POST, produces = "application/text;charset=UTF-8")
	@ResponseBody
	public void getMyLeave(HttpServletResponse response, LeaveModel lm, HttpServletRequest request) throws Exception {
		UserModel um = (UserModel) request.getSession().getAttribute("user");
		lm.setUserid(um.getId());
		List<LeaveModel> l = leaveService.selectAll(lm);
		List<LeaveModel> l2 = new ArrayList<>();
		for (LeaveModel lmTemp : l) {
			lmTemp.setUserModel(um);
			l2.add(lmTemp);
		}
		HtmlUtil.writerJson(response, l2);
	}

	@RequestMapping(value = "getAllLeave.do", method = RequestMethod.POST, produces = "application/text;charset=UTF-8")
	@ResponseBody
	public void getAllLeave(HttpServletResponse response) throws Exception {
		LeaveModel lm = new LeaveModel();
		List<LeaveModel> l = leaveService.selectAll(lm);
		List<LeaveModel> l2 = new ArrayList<>();
		for (LeaveModel lmTemp : l) {
			lmTemp.setUserModel((UserModel) userModel.selectId(lmTemp.getUserid()));
			l2.add(lmTemp);
		}
		HtmlUtil.writerJson(response, l2);
	}

	@RequestMapping(value = "submitLeave.do", method = RequestMethod.POST)
	@ResponseBody
	public String submitLeave(LeaveModel lm) throws Exception {
		lm.setStatus("6");
		lm.setUserid(2);
		lm.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		leaveService.insert(lm);
		return "³É¹¦";
	}

	@RequestMapping(value = "updateLeave.do", method = RequestMethod.POST, produces = "application/text;charset=UTF-8")
	@ResponseBody
	public String updateLeave(LeaveModel lm) throws Exception {
		leaveService.update(lm);
		return "ok";
	}
}
