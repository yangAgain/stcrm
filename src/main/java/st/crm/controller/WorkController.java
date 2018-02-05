package st.crm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import st.core.session.HtmlUtil;
import st.core.tool.Constant;
import st.crm.model.AssignmentModel;
import st.crm.model.ClassModel;
import st.crm.model.DicModel;
import st.crm.model.UserModel;
import st.crm.model.WorkModel;
import st.crm.service.AssignmentService;
import st.crm.service.ClassService;
import st.crm.service.DicService;
import st.crm.service.WorkService;

@Controller
@RequestMapping("/workController")
public class WorkController {

	@Autowired
	private WorkService<WorkModel> workService;

	@Autowired
	private DicService<DicModel> dicService;

	@Autowired
	private ClassService<ClassModel> classService;

	@Autowired
	private AssignmentService<AssignmentModel> assignmentService;

	@RequestMapping(value = "insertWork.do", method = RequestMethod.POST)
	@ResponseBody
	public void insertWork(WorkModel wm) throws Exception {
		if (wm.getId() != null) {
			workService.update(wm);
			return;
		}
		workService.insert(wm);
	}

	@RequestMapping(value = "selectOne.do", method = RequestMethod.GET)
	@ResponseBody
	public void select(WorkModel wm, HttpServletResponse response) throws Exception {
		WorkModel m = workService.selectId(wm.getId());
		HtmlUtil.writerJson(response, m);
	}

	@RequestMapping(value = "getGradeStandard.do", method = RequestMethod.POST)
	@ResponseBody
	public void getGradeStandard(HttpServletResponse response) throws Exception {
		DicModel dm = new DicModel();
		dm.setPcode(Constant.GRADE_STANDARD.toString());
		List<DicModel> l = dicService.selectAll(dm);
		HtmlUtil.writerJson(response, l);
	}

	@RequestMapping(value = "getMyAllAssignment.do", method = RequestMethod.POST, produces = "application/text;charset=UTF-8")
	@ResponseBody
	public void getMyAllAssignment(HttpServletResponse response, HttpServletRequest request) throws Exception {
		UserModel um = (UserModel) request.getSession().getAttribute("user");
		ClassModel cm = new ClassModel();
		cm.setId(um.getClassid());
		ClassModel temp = classService.selectAll(cm).get(0);
		AssignmentModel asm = new AssignmentModel();
		asm.setTeacherid(temp.getTeacherid());
		List<AssignmentModel> l = assignmentService.selectAll(asm);
		List<AssignmentModel> l2 = new ArrayList<>();
		WorkModel wm = new WorkModel();
		for (AssignmentModel asmTemp : l) {
			wm.setAssignmentid(asmTemp.getId());
			List<WorkModel> l3 = workService.selectAll(wm);
			if (l3 != null && !l3.isEmpty()) {
				WorkModel wmTemp = l3.get(0);
				asmTemp.setWorkModel(wmTemp);
			}
			l2.add(asmTemp);
		}
		HtmlUtil.writerJson(response, l2);
	}
}
