package st.crm.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import st.core.session.HtmlUtil;
import st.crm.model.ClassModel;
import st.crm.service.ClassService;

@Controller
@RequestMapping("/classController")
public class ClassController {
	@Autowired
	private ClassService<ClassModel> classService;

	@RequestMapping(value = "getClass.do", method = RequestMethod.POST, produces = "application/text;charset=UTF-8")
	public void getClass(HttpServletResponse response) throws Exception {
		List<ClassModel> l = classService.selectAll(new ClassModel());
		HtmlUtil.writerJson(response, l);
	}

	@RequestMapping(value = "getOneClass.do")
	public void getOneClass(HttpServletResponse response, ClassModel cm) throws Exception {
		ClassModel c = classService.selectId(cm);
		HtmlUtil.writerJson(response, c);
	}

	@RequestMapping(value = "insertClass.do")
	@ResponseBody
	public void insertClass(ClassModel cm) throws Exception {
		ClassModel cmTemp = new ClassModel();
		cmTemp.setClassname(cm.getClassname());
		List<ClassModel> l = classService.selectAll(cmTemp);
		if (cm.getId() != null) {
			classService.update(cm);
			return;
		}
		if (l.size() != 0) {
			return;
		}
		classService.insert(cm);
	}

}
