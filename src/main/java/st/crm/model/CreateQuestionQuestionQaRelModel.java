package st.crm.model;

/**
 * @author 杨然 对应创建问卷表和问卷的问题的关联表
 *
 */
public class CreateQuestionQuestionQaRelModel {
	private Integer id;
	private Integer createQuestionid;
	private String questionQaid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCreateQuestionid() {
		return createQuestionid;
	}

	public void setCreateQuestionid(Integer createQuestionid) {
		this.createQuestionid = createQuestionid;
	}

	public String getQuestionQaid() {
		return questionQaid;
	}

	public void setQuestionQaid(String questionQaid) {
		this.questionQaid = questionQaid;
	}

}
