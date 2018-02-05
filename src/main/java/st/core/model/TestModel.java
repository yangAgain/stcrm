package st.core.model;

public class TestModel {

	private Integer num;
	private String score;
	private String name;
	private double sco;

	public double getSco() {
		return sco;
	}

	public void setSco(double sco) {
		this.sco = sco;
	}

	public TestModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TestModel(Integer num, String score) {
		super();
		this.num = num;
		this.score = score;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
