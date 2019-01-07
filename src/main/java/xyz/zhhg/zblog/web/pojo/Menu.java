package xyz.zhhg.zblog.web.pojo;

import java.math.BigInteger;
import java.util.List;

public class Menu {
	private BigInteger id;
	private BigInteger superiorId;
	private String name;
	private String url;
	private int status;
	private int usertype;
	private List<Menu> childList;
	
	
	public Menu() {
		super();
	}

	public Menu(BigInteger id, BigInteger superiorId, String name, String url,
			int status, int usetype) {
		super();
		this.id = id;
		this.superiorId = superiorId;
		this.name = name;
		this.url = url;
		this.status = status;
		this.usertype = usetype;
	}
	
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public BigInteger getSuperiorId() {
		return superiorId;
	}
	public void setSuperiorId(BigInteger superiorId) {
		this.superiorId = superiorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		if(url==null)return "";
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getUsertype() {
		return usertype;
	}
	public void setUsertype(int usetype) {
		this.usertype = usetype;
	}
	/*@Override
	public String toString() {
		StringBuilder builder=new StringBuilder();
		builder.append("Menu [id=" + id + ", superiorId=" + superiorId + ", name="
				+ name + ", url=" + url + ", status=" + status + ", usetype="
				+ usertype + "]");
		for (Menu menu : childList) {
			builder.append(menu+"\n");
		}
				
				
		return builder.toString();
	}*/

	public List<Menu> getChildList() {
		return childList;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", superiorId=" + superiorId + ", name="
				+ name + ", url=" + url + ", status=" + status + ", usertype="
				+ usertype + ", childList=" + childList + "]";
	}

	public void setChildList(List<Menu> childList) {
		this.childList = childList;
	}
	
	
}
