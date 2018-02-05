package st.crm.model;

/**
 * @author 杨然 对应作业完成状况表
 */
public class WorkModel {
	private Integer id;
	private Integer studentid;
	private Integer assignmentid;
	private Integer oneselfSorce;
	private Integer oneselfGrade;
	private Integer teacherSorce;
	private String teacherGrade;
	private DicModel dicModel;

	public DicModel getDicModel() {
		return dicModel;
	}

	public void setDicModel(DicModel dicModel) {
		this.dicModel = dicModel;
	}

	public Integer getOneselfGrade() {
		return oneselfGrade;
	}

	public void setOneselfGrade(Integer oneselfGrade) {
		this.oneselfGrade = oneselfGrade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStudentid() {
		return studentid;
	}

	public void setStudentid(Integer studentid) {
		this.studentid = studentid;
	}

	public Integer getAssignmentid() {
		return assignmentid;
	}

	public void setAssignmentid(Integer assignmentid) {
		this.assignmentid = assignmentid;
	}

	public Integer getOneselfSorce() {
		return oneselfSorce;
	}

	public void setOneselfSorce(Integer oneselfSorce) {
		this.oneselfSorce = oneselfSorce;
	}


	public Integer getTeacherSorce() {
		return teacherSorce;
	}

	public void setTeacherSorce(Integer teacherSorce) {
		this.teacherSorce = teacherSorce;
	}

	public String getTeacherGrade() {
		return teacherGrade;
	}

	public void setTeacherGrade(String teacherGrade) {
		this.teacherGrade = teacherGrade;
	}

}
