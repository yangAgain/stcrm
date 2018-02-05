package st.crm.model;

/**
 * @author 杨然
 *	对应月度考核表
 */
public class AssessmentModel {
	private Integer id;
	private Integer ranking;
	private Integer sorce;
	private Integer userid;
	private Integer username;
	private Integer attSorce;
	private Integer wordSorce;
	private Integer dailySroce;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRanking() {
		return ranking;
	}

	public void setRanking(Integer ranking) {
		this.ranking = ranking;
	}

	public Integer getSorce() {
		return sorce;
	}

	public void setSorce(Integer sorce) {
		this.sorce = sorce;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getUsername() {
		return username;
	}

	public void setUsername(Integer username) {
		this.username = username;
	}

	public Integer getAttSorce() {
		return attSorce;
	}

	public void setAttSorce(Integer attSorce) {
		this.attSorce = attSorce;
	}

	public Integer getWordSorce() {
		return wordSorce;
	}

	public void setWordSorce(Integer wordSorce) {
		this.wordSorce = wordSorce;
	}

	public Integer getDailySroce() {
		return dailySroce;
	}

	public void setDailySroce(Integer dailySroce) {
		this.dailySroce = dailySroce;
	}

}
