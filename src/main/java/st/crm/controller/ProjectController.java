package st.crm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import st.core.session.HtmlUtil;
import st.crm.model.ProjectModel;
import st.crm.model.UserModel;
import st.crm.service.ProjectService;

@Controller
@RequestMapping("/projectController")
public class ProjectController {

	@Autowired
	private ProjectService<ProjectModel> projectService;

	@RequestMapping(value = "getMyProject.do")
	@ResponseBody
	public void getMyProject(HttpServletResponse response, HttpServletRequest request) throws Exception {
		ProjectModel pm = new ProjectModel();
		UserModel um = (UserModel) request.getSession().getAttribute("user");
		pm.setStudentid(um.getId());
		List<ProjectModel> l = projectService.selectAll(pm);
		HtmlUtil.writerJson(response, l);
	}

	@RequestMapping(value = "getStuProject2.do")
	public void getMyProject2(HttpServletResponse response, ProjectModel pm) throws Exception {
		List<ProjectModel> l = projectService.selectAll(pm);
		HtmlUtil.writerJson(response, l);
	}

	@RequestMapping(value = "insertProject.do")
	@ResponseBody
	public void insertProject(ProjectModel pm) throws Exception {
		if (pm.getId() != null) {
			projectService.update(pm);
			return;
		}
		projectService.insert(pm);
	}

	@RequestMapping(value = "selectOne.do")
	@ResponseBody
	public void selectOne(ProjectModel pm, HttpServletResponse response) throws Exception {
		HtmlUtil.writerJson(response, projectService.selectId(pm.getId()));
	}

	@RequestMapping(value = "toStuPro.do")
	public ModelAndView toStuPro(String studentid) {
		ModelAndView m = new ModelAndView();
		m.setViewName("stuProject2");
		m.addObject("studentid", studentid);
		return m;
	}

	@RequestMapping(value = "getStuProject.do")
	@ResponseBody
	public void getStuProject(HttpServletResponse response, ProjectModel pm) throws Exception {
		List<ProjectModel> l = projectService.selectAll(pm);
		HtmlUtil.writerJson(response, l);
	}
}
