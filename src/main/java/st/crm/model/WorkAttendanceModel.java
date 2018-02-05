package st.crm.model;

/**
 * @author 杨然 对应考勤表，每天六次，以及这一天的考勤成绩
 *
 */
public class WorkAttendanceModel {
	private Integer id;
	private Integer userid;
	private String oneCheck;
	private String twoCheck;
	private String threeCheck;
	private String fourCheck;
	private String fiveCheck;
	private String sixCheck;
	private Integer source;
	private String time;

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

	public String getOneCheck() {
		return oneCheck;
	}

	public void setOneCheck(String oneCheck) {
		this.oneCheck = oneCheck;
	}

	public String getTwoCheck() {
		return twoCheck;
	}

	public void setTwoCheck(String twoCheck) {
		this.twoCheck = twoCheck;
	}

	public String getThreeCheck() {
		return threeCheck;
	}

	public void setThreeCheck(String threeCheck) {
		this.threeCheck = threeCheck;
	}

	public String getFourCheck() {
		return fourCheck;
	}

	public void setFourCheck(String fourCheck) {
		this.fourCheck = fourCheck;
	}

	public String getFiveCheck() {
		return fiveCheck;
	}

	public void setFiveCheck(String fiveCheck) {
		this.fiveCheck = fiveCheck;
	}

	public String getSixCheck() {
		return sixCheck;
	}

	public void setSixCheck(String sixCheck) {
		this.sixCheck = sixCheck;
	}

	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}
