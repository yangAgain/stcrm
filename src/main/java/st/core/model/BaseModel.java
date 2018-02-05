package st.core.model;

public class BaseModel extends PagerModel {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String createTime; 
	private String updateTime;
	private Integer createBy; 
	private Integer updateBy; 
	private Double orderBy;
	private String isdelete;
	private Integer iseffect;
	private String descr; 
	private Integer status;
	private String remark;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}

	public Integer getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Integer updateBy) {
		this.updateBy = updateBy;
	}

	public Double getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(Double orderBy) {
		this.orderBy = orderBy;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(String isdelete) {
		this.isdelete = isdelete;
	}

	public Integer getIseffect() {
		return iseffect;
	}

	public void setIseffect(Integer iseffect) {
		this.iseffect = iseffect;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
