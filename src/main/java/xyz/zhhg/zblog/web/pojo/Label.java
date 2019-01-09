package xyz.zhhg.zblog.web.pojo;

import java.math.BigInteger;

/**
 * @author 清居
 *
 */
public class Label {
	private BigInteger id;
	private BigInteger superid;
	private String name;
	
	
	public Label() {
		super();
	}
	public Label(BigInteger id, BigInteger superid, String name) {
		super();
		this.id = id;
		this.superid = superid;
		this.name = name;
	}
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public BigInteger getSuperid() {
		return superid;
	}
	public void setSuperid(BigInteger superid) {
		this.superid = superid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
