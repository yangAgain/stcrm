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
import st.core.tool.FormatMD5;
import st.crm.model.ClassModel;
import st.crm.model.UserModel;
import st.crm.model.WorkAttendanceModel;
import st.crm.model.WorkModel;
import st.crm.service.ClassService;
import st.crm.service.UserService;
import st.crm.service.WorkAttendanceService;
import st.crm.service.WorkService;

@Controller
@RequestMapping("/userController")
public class UserController {

	@Autowired
	private UserService<UserModel> userService;

	@Autowired
	private WorkAttendanceService<WorkAttendanceModel> workAttendanceService;

	@Autowired
	private WorkService<WorkModel> workService;

	@Autowired
	private ClassService<ClassModel> classService;

	@RequestMapping(value = "getStu.do", method = RequestMethod.POST, produces = "application/text;charset=UTF-8")
	@ResponseBody
	public void getStuWA(HttpServletResponse response, String timeT, HttpServletRequest request) throws Exception {
		String time = null;
		if (timeT != null && timeT != "") {
			time = timeT;
		} else {
			time = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		}
		UserModel um = new UserModel();
		UserModel um2 = (UserModel) request.getSession().getAttribute("user");
		ClassModel cm = new ClassModel();
		cm.setTeacherid(um2.getId());
		um.setClassid(classService.selectAll(cm).get(0).getId());
		WorkAttendanceModel wam = new WorkAttendanceModel();
		List<UserModel> l = userService.selectAll(um);
		List<UserModel> l2 = new ArrayList<>();
		for (UserModel umTemp : l) {
			wam.setUserid(umTemp.getId());
			wam.setTime(time);
			List<WorkAttendanceModel> l3 = workAttendanceService.selectAll(wam);
			if (l3.size() == 0) {
				umTemp.setWorkAttendanceModel(new WorkAttendanceModel());
				l2.add(umTemp);
			} else {
				umTemp.setWorkAttendanceModel(l3.get(0));
				l2.add(umTemp);
			}
		}
		HtmlUtil.writerJson(response, l2);
	}

	@RequestMapping(value = "lookStuWork.do", method = RequestMethod.POST, produces = "application/text;charset=UTF-8")
	@ResponseBody
	public void lookStuWork(HttpServletResponse response, HttpServletRequest request) throws Exception {
		String asmid = (String) request.getSession().getAttribute("asmid");
		UserModel um = (UserModel) request.getSession().getAttribute("user");
		ClassModel cm = new ClassModel();
		cm.setTeacherid(um.getId());
		List<ClassModel> cmL = classService.selectAll(cm);
		UserModel temp = new UserModel();
		temp.setClassid(cmL.get(cmL.size() - 1).getId());
		List<UserModel> l = userService.selectAll(temp);
		List<UserModel> l2 = new ArrayList<>();
		WorkModel wm = new WorkModel();
		wm.setAssignmentid(Integer.parseInt(asmid));
		for (UserModel umTemp : l) {
			wm.setStudentid(umTemp.getId());
			List<WorkModel> l3 = workService.selectAll(wm);
			if (l3.size() == 0) {
				umTemp.setWorkModel(new WorkModel());
				l2.add(umTemp);
			} else {
				umTemp.setWorkModel(l3.get(0));
				l2.add(umTemp);
			}
		}
		HtmlUtil.writerJson(response, l2);
	}

	@RequestMapping(value = "getStudent.do")
	@ResponseBody
	public void getStudent(HttpServletResponse response, HttpServletRequest request) throws Exception {
		UserModel um = (UserModel) request.getSession().getAttribute("user");
		ClassModel cm = new ClassModel();
		cm.setTeacherid(um.getId());
		List<ClassModel> cmL = classService.selectAll(cm);
		UserModel temp = new UserModel();
		temp.setClassid(cmL.get(cmL.size() - 1).getId());
		List<UserModel> l = userService.selectAll(temp);
		HtmlUtil.writerJson(response, l);
	}
	
	@RequestMapping(value = "login.do")
	@ResponseBody
	public String login(UserModel um, HttpServletRequest request) throws Exception {
		String s = "";
		um.setPassword(FormatMD5.MD5(um.getPassword()));
		List<UserModel> l = userService.selectAll(um);
		if (l.size() == 1) {
			s = "loginsuccess";
			request.getSession().setAttribute("user", l.get(0));

		} else {
			s = "loginfail";
		}
		return s;
	}

	@RequestMapping(value = "getAllUser.do")
	public void getAllUser(HttpServletResponse response, UserModel um) throws Exception {
		List<UserModel> l = userService.selectAll(um);
		HtmlUtil.writerJson(response, l);
	}

	@RequestMapping(value = "getOneUser.do")
	public void getOneUser(HttpServletResponse response, UserModel um) throws Exception {
		UserModel umTemp = userService.selectId(um);
		HtmlUtil.writerJson(response, umTemp);
	}

	@RequestMapping(value = "insertUser.do", produces = "application/text;charset=UTF-8")
	@ResponseBody
	public void insertUser(UserModel um) throws Exception {
		UserModel umTemp = new UserModel();
		um.setPassword(FormatMD5.MD5(um.getPassword()));
		umTemp.setUsername(um.getUsername());
		List<UserModel> l = userService.selectAll(umTemp);
		if (um.getId() != null) {
			userService.update(um);
			return;
		}
		if (l.size() != 0) {
			return;
		}
		userService.insert(um);
	}
}
