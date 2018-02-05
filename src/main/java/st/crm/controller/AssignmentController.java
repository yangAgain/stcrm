package st.crm.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import st.core.session.HtmlUtil;
import st.core.session.JSONUtil;
import st.crm.model.AssignmentModel;
import st.crm.model.UserModel;
import st.crm.service.AssignmentService;

@Controller
@RequestMapping("/assignmentController")
public class AssignmentController {

	@Autowired
	private AssignmentService<AssignmentModel> assignmentService;

	@RequestMapping(value = "insertAssignment.do", method = RequestMethod.POST, produces = "application/text;charset=UTF-8")
	@ResponseBody
	public void insertAssignment(AssignmentModel asm) throws Exception {
		if (asm.getId() != null) {
			assignmentService.update(asm);
			return;
		}
		asm.setTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		assignmentService.insert(asm);
	}

	@RequestMapping(value = "getMyAllAssignment.do", method = RequestMethod.POST, produces = "application/text;charset=UTF-8")
	@ResponseBody
	public void getMyAllAssignment(HttpServletResponse response, HttpServletRequest request) throws Exception {
		UserModel um = (UserModel) request.getSession().getAttribute("user");
		AssignmentModel asm = new AssignmentModel();
		asm.setTeacherid(um.getId());
		List<AssignmentModel> l = assignmentService.selectAll(asm);
		System.out.println(JSONUtil.toJSONString(l));
		HtmlUtil.writerJson(response, l);

	}

	@RequestMapping(value = "toLook.do", method = RequestMethod.GET, produces = "application/text;charset=UTF-8")
	public ModelAndView deleteAssignment(String asmid, HttpServletRequest request) throws Exception {
		ModelAndView m = new ModelAndView();
		request.getSession().setAttribute("asmid", asmid);
		m.setViewName("viewWork");
		return m;
	}

}
