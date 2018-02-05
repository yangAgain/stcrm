package st.crm.model;

/**
 * @author 杨然 对应学生项目表
 *
 */
public class ProjectModel {
	private Integer id;
	private String projectName;
	private Integer allSorce;
	private Integer studentSorce;
	private Integer teacherSorce;
	private String grade;
	private String space;
	private Integer studentid;
	private String stuName;

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public Integer getStudentid() {
		return studentid;
	}

	public void setStudentid(Integer studentid) {
		this.studentid = studentid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Integer getAllSorce() {
		return allSorce;
	}

	public void setAllSorce(Integer allSorce) {
		this.allSorce = allSorce;
	}

	public Integer getStudentSorce() {
		return studentSorce;
	}

	public void setStudentSorce(Integer studentSorce) {
		this.studentSorce = studentSorce;
	}

	public Integer getTeacherSorce() {
		return teacherSorce;
	}

	public void setTeacherSorce(Integer teacherSorce) {
		this.teacherSorce = teacherSorce;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getSpace() {
		return space;
	}

	public void setSpace(String space) {
		this.space = space;
	}

}
