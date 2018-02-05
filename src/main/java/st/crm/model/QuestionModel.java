package st.crm.model;

/**
 * @author 杨然
 *	对应问卷学生回答表（一个学生对应多个问卷）
 */
public class QuestionModel {
	private Integer id;
	private Integer userid;
	private Integer createQuestionid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getCreatQuestionid() {
		return createQuestionid;
	}

	public void setCreatQuestionid(Integer createQuestionid) {
		this.createQuestionid = createQuestionid;
	}
}
