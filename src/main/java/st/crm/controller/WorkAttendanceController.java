package st.crm.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import st.core.session.HtmlUtil;
import st.core.tool.Constant;
import st.crm.model.DicModel;
import st.crm.model.WorkAttendanceModel;
import st.crm.service.DicService;
import st.crm.service.WorkAttendanceService;

@Controller
@RequestMapping("/workAttendanceController")
public class WorkAttendanceController {

	@Autowired
	private WorkAttendanceService<WorkAttendanceModel> workAttendanceService;

	@Autowired
	private DicService<DicModel> dicService;

	@RequestMapping(value = "getWa.do", method = RequestMethod.POST, produces = "application/text;charset=UTF-8")
	@ResponseBody
	public void getWa(HttpServletResponse response) throws Exception {
		DicModel dic = new DicModel();
		dic.setPcode(Constant.STU_CHECK.toString());
		List<DicModel> l = dicService.selectAll(dic);
		HtmlUtil.writerJson(response, l);
	}

	@RequestMapping(value = "insertbatchWa.do", method = RequestMethod.POST, produces = "application/text;charset=UTF-8")
	@ResponseBody
	public String insertbatch(WorkAttendanceModel wam, String auserid) throws Exception {
		String[] userid = auserid.split(",");
		WorkAttendanceModel wamTemp = new WorkAttendanceModel();
		wamTemp.setTime(wam.getTime());

		for (int i = 1; i < userid.length; i++) {
			wamTemp.setUserid(Integer.parseInt(userid[i]));
			List<WorkAttendanceModel> wamL = workAttendanceService.selectAll(wamTemp);
			if (wamL.size() == 0) {
				wam.setUserid(Integer.parseInt(userid[i]));
				workAttendanceService.insert(wam);
			} else {
				wam.setId(wamL.get(0).getId());
				wam.setUserid(Integer.parseInt(userid[i]));
				workAttendanceService.update(wam);
			}
		}
		return "修改成功";
	}

	@RequestMapping(value = "insertWa.do", method = RequestMethod.POST, produces = "application/text;charset=UTF-8")
	@ResponseBody
	public String insert(WorkAttendanceModel wam, String auserid) throws Exception {
		WorkAttendanceModel wamTemp = new WorkAttendanceModel();
		wamTemp.setUserid(Integer.parseInt(auserid));
		wamTemp.setTime(wam.getTime());
		wam.setUserid(Integer.parseInt(auserid));
		List<WorkAttendanceModel> wamL = workAttendanceService.selectAll(wamTemp);
		if (wamL.size() == 0) {
			workAttendanceService.insert(wam);
		} else {
			wam.setId(wamL.get(0).getId());
			workAttendanceService.update(wam);
		}
		return "修改成功";
	}

	@RequestMapping(value = "getMyWa.do", method = RequestMethod.POST, produces = "application/text;charset=UTF-8")
	@ResponseBody
	public void getMyWa(HttpServletResponse response) throws Exception {
		WorkAttendanceModel wam = new WorkAttendanceModel();
		wam.setUserid(2);
		List<WorkAttendanceModel> l = workAttendanceService.selectAll(wam);
		HtmlUtil.writerJson(response, l);
	}

}
