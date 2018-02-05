package st.crm.model;

import st.core.model.BaseModel;
import st.core.tool.FormatEmpty;

public class UserModel extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String username;
	private String password;
	private String truename;
	private Integer roleid;
	private Integer page;
	private Integer rows;
	private Integer pageTemp;
	private WorkAttendanceModel workAttendanceModel;
	private WorkModel workModel;
	private Integer projectNumber;
	private String classname;
	private QuestionAnswerModel questionAnswer;

	public QuestionAnswerModel getQuestionAnswer() {
		return questionAnswer;
	}

	public void setQuestionAnswer(QuestionAnswerModel questionAnswer) {
		this.questionAnswer = questionAnswer;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public Integer getProjectNumber() {
		return projectNumber;
	}

	public void setProjectNumber(Integer projectNumber) {
		this.projectNumber = projectNumber;
	}

	public WorkModel getWorkModel() {
		return workModel;
	}

	public void setWorkModel(WorkModel workModel) {
		this.workModel = workModel;
	}

	public WorkAttendanceModel getWorkAttendanceModel() {
		return workAttendanceModel;
	}

	public void setWorkAttendanceModel(WorkAttendanceModel workAttendanceModel) {
		this.workAttendanceModel = workAttendanceModel;
	}

	public Integer getPageTemp() {
		if (!FormatEmpty.isEmpty(page) && !FormatEmpty.isEmpty(rows)) {
			pageTemp = (page - 1) * rows;
		}
		return pageTemp;
	}

	public void setPageTemp(Integer pageTemp) {
		this.pageTemp = pageTemp;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	private Integer classid;

	public Integer getClassid() {
		return classid;
	}

	public void setClassid(Integer classid) {
		this.classid = classid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTruename() {
		return truename;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}

}
