package st.crm.model;

/**
 * @author ��Ȼ ��Ӧ�ʾ�ش��Ĵ𰸱�
 *
 */
public class QuestionAnswerModel {
	private Integer id;
	private String answers;
	private Integer creatQuestionid;
	private Integer studentid;

	public String getAnswers() {
		return answers;
	}

	public void setAnswers(String answers) {
		this.answers = answers;
	}

	public Integer getCreatQuestionid() {
		return creatQuestionid;
	}

	public void setCreatQuestionid(Integer creatQuestionid) {
		this.creatQuestionid = creatQuestionid;
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

	
}
