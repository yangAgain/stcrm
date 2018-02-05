package st.crm.model;

/**
 * @author 杨然 对应布置作业表（一个老师对应多个作业）
 */
public class AssignmentModel {
	private Integer id;
	private Integer teacherid;
	private String question;
	private String gradeStandard;
	private String type;
	private String time;
	private WorkModel workModel;

	public WorkModel getWorkModel() {
		return workModel;
	}

	public void setWorkModel(WorkModel workModel) {
		this.workModel = workModel;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTeacherid() {
		return teacherid;
	}

	public void setTeacherid(Integer teacherid) {
		this.teacherid = teacherid;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getGradeStandard() {
		return gradeStandard;
	}

	public void setGradeStandard(String gradeStandard) {
		this.gradeStandard = gradeStandard;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
