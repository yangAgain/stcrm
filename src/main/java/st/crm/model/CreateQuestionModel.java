package st.crm.model;

/**
 * @author 杨然 对应创建问卷表（一个教务对应多个问卷）
 */
public class CreateQuestionModel {
	private Integer id;
	private String questionName;
	private Integer userid;
	private String qqaid;

	public String getQqaid() {
		return qqaid;
	}

	public void setQqaid(String qqaid) {
		this.qqaid = qqaid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuestionName() {
		return questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

}
