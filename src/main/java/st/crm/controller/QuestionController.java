package st.crm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import st.core.session.HtmlUtil;
import st.core.session.JSONUtil;
import st.crm.model.CreateQuestionModel;
import st.crm.model.QuestionAnswerModel;
import st.crm.model.QuestionQaModel;
import st.crm.model.UserModel;
import st.crm.service.CreateQuestionService;
import st.crm.service.QuestionAnswerService;
import st.crm.service.QuestionQaService;
import st.crm.service.UserService;

@Controller
@RequestMapping("/questionController")
public class QuestionController {

	@Autowired
	private CreateQuestionService<CreateQuestionModel> createQuestionService;

	@Autowired
	private QuestionQaService<QuestionQaModel> questionQaService;

	@Autowired
	private QuestionAnswerService<QuestionAnswerModel> questionAnswerService;

	@Autowired
	private UserService<UserModel> userService;

	@RequestMapping(value = "insertCQ.do")
	@ResponseBody
	public void insertCQ(CreateQuestionModel cqm) throws Exception {
		if (cqm.getId() != null) {
			createQuestionService.updateName(cqm);
			return;
		}
		createQuestionService.insert(cqm);
	}

	@RequestMapping(value = "insertCQ2.do")
	@ResponseBody
	public void insertCQ2(CreateQuestionModel cqm) throws Exception {
		createQuestionService.update(cqm);
	}

	@RequestMapping(value = "allCQ.do")
	public void allCQ(HttpServletResponse response) throws Exception {
		List<CreateQuestionModel> l = createQuestionService.selectAll(new CreateQuestionModel());
		HtmlUtil.writerJson(response, l);
	}

	@RequestMapping(value = "getOneCQ.do")
	public void getOneCQ(HttpServletResponse response, CreateQuestionModel cqm) throws Exception {
		HtmlUtil.writerJson(response, createQuestionService.selectId(cqm.getId()));
	}

	@RequestMapping(value = "getOneQQA.do")
	public void getOneQQA(HttpServletResponse response, QuestionQaModel qqa) throws Exception {
		HtmlUtil.writerJson(response, questionQaService.selectId(qqa.getId()));
	}

	@RequestMapping(value = "insertQQA.do")
	@ResponseBody
	public void insertQQA(QuestionQaModel qqa) throws Exception {
		if (qqa.getId() != null) {
			questionQaService.update(qqa);
			return;
		}
		questionQaService.insert(qqa);
	}

	@RequestMapping(value = "allQQA.do")
	public void allQQA(HttpServletResponse response) throws Exception {
		List<QuestionQaModel> l = questionQaService.selectAll(new QuestionQaModel());
		HtmlUtil.writerJson(response, l);
	}

	@RequestMapping(value = "getQuestion.do")
	public void getQuestion(HttpServletResponse response, CreateQuestionModel cqm, HttpServletRequest request)
			throws Exception {
		CreateQuestionModel temp = createQuestionService.selectAll(cqm).get(0);
		List<QuestionQaModel> l = new ArrayList<>();
		if (temp.getQqaid() == null) {
			HtmlUtil.writerJson(response, l);
			return;
		}
		QuestionAnswerModel qam = new QuestionAnswerModel();
		UserModel um = (UserModel) request.getSession().getAttribute("user");
		qam.setStudentid(um.getId());
		qam.setCreatQuestionid(cqm.getId());
		List<QuestionAnswerModel> qamL = questionAnswerService.selectAll(qam);
		String answers = "";
		if (qamL.size() != 0) {
			QuestionAnswerModel qamTemp = qamL.get(0);
			answers = qamTemp.getAnswers();
		}
		String[] arrayAnswer = answers.split(",");
		String cqmL = temp.getQqaid();
		String[] array = cqmL.split(",");
		QuestionQaModel qqa = new QuestionQaModel();
		for (int i = 1; i < array.length; i++) {
			qqa.setId(Integer.parseInt(array[i]));
			QuestionQaModel qamTemp = questionQaService.selectAll(qqa).get(0);
			if (arrayAnswer.length == array.length) {
				qamTemp.setAnswer(arrayAnswer[i]);
			}
			l.add(qamTemp);
		}
		HtmlUtil.writerJson(response, l);
	}

	@RequestMapping(value = "toLookit.do")
	public ModelAndView toLookit(CreateQuestionModel cqm, HttpServletRequest request) throws Exception {
		ModelAndView m = new ModelAndView();
		m.setViewName("feedback2");
		request.getSession().setAttribute("creatQid", cqm.getId());
		m.addObject("creatQuestion", createQuestionService.selectId(cqm));
		return m;
	}

	@RequestMapping(value = "getStudentAnswer.do")
	public void getStudentAnswer(HttpServletRequest request, HttpServletResponse response) {
		UserModel um = new UserModel();
		QuestionAnswerModel qam = new QuestionAnswerModel();
		Integer i = (Integer) request.getSession().getAttribute("creatQid");
		qam.setCreatQuestionid(i);
		um.setQuestionAnswer(qam);
		List<UserModel> l = userService.selectAboutQA(um);
		List<Map<String, Object>> l2 = new ArrayList<>();
		for (UserModel u : l) {
			Map<String, Object> map = new HashMap<>();
			map.put("truename", u.getTruename());
			map.put("answer",
					u.getQuestionAnswer().getAnswers().substring(1, u.getQuestionAnswer().getAnswers().length()));
			map.put("classname", u.getClassname());
			l2.add(map);
		}
		System.out.println(JSONUtil.toJSONString(l2));
		HtmlUtil.writerJson(response, l2);
	}

	@RequestMapping(value = "getQuestion2.do")
	public void getQuestion2(HttpServletResponse response, QuestionAnswerModel qam) throws Exception {
		CreateQuestionModel temp = createQuestionService.selectId(qam.getCreatQuestionid());
		List<QuestionQaModel> l = new ArrayList<>();
		if (temp.getQqaid() == null) {
			HtmlUtil.writerJson(response, l);
			return;
		}
		List<QuestionAnswerModel> qamL = questionAnswerService.selectAll(qam);
		String answers = "";
		if (qamL.size() != 0) {
			QuestionAnswerModel qamTemp = qamL.get(0);
			answers = qamTemp.getAnswers();
		}
		String[] arrayAnswer = answers.split(",");
		String cqmL = temp.getQqaid();
		String[] array = cqmL.split(",");
		QuestionQaModel qqa = new QuestionQaModel();
		for (int i = 1; i < array.length; i++) {
			qqa.setId(Integer.parseInt(array[i]));
			QuestionQaModel qamTemp = questionQaService.selectAll(qqa).get(0);
			if (arrayAnswer.length == array.length) {
				qamTemp.setAnswer(arrayAnswer[i]);
			}
			l.add(qamTemp);
		}
		HtmlUtil.writerJson(response, l);
	}

	@RequestMapping(value = "answer1.do")
	@ResponseBody
	public void answer1(QuestionAnswerModel qam, HttpServletRequest request) throws Exception {
		UserModel um = (UserModel) request.getSession().getAttribute("user");
		QuestionAnswerModel qamTemp = new QuestionAnswerModel();
		qamTemp.setStudentid(um.getId());
		qam.setStudentid(um.getId());
		qamTemp.setCreatQuestionid(qam.getCreatQuestionid());
		List<QuestionAnswerModel> l = questionAnswerService.selectAll(qamTemp);
		if (l.size() != 0) {
			qam.setId(l.get(0).getId());
			questionAnswerService.update(qam);
			return;
		}
		questionAnswerService.insert(qam);
	}
}
