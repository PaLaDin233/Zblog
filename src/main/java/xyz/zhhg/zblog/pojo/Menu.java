package xyz.zhhg.zblog.pojo;

import java.math.BigInteger;

public class Menu {
	private BigInteger id;
	private BigInteger superiorId;
	private String name;
	private String url;
	private int status;
	private int usetype;
	
	
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
		this.usetype = usetype;
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
	public int getUsetype() {
		return usetype;
	}
	public void setUsetype(int usetype) {
		this.usetype = usetype;
	}
	@Override
	public String toString() {
		return "Menu [id=" + id + ", superiorId=" + superiorId + ", name="
				+ name + ", url=" + url + ", status=" + status + ", usetype="
				+ usetype + "]";
	}
	
	
}
