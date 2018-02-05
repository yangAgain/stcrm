package st.crm.model;

import java.util.ArrayList;
import java.util.List;

public class PermissionModel {
	private Integer id;
	private String permissionName;
	private String url;
	private String type;
	private String parentid;
	private List<PermissionModel> children = new ArrayList<>();
	private String checked;

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public List<PermissionModel> getChildren() {
		return children;
	}

	public void setChildren(List<PermissionModel> children) {
		this.children = children;
	}

	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
