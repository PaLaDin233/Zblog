package xyz.zhhg.zblog.web.pojo;

import java.math.BigInteger;
import java.util.List;

public class Classcify {
	private BigInteger id;
	private BigInteger superior;
	private String name;
	private int status;
	private List<Classcify> childClasscify;
	
	
	public Classcify() {
		super();
	}
	public Classcify(BigInteger id) {
		super();
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Classcify [id=" + id + ", superior=" + superior + ", name="
				+ name + ", childClasscify=" + childClasscify + "]";
	}
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public BigInteger getSuperior() {
		return superior;
	}
	public void setSuperior(BigInteger superior) {
		this.superior = superior;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Classcify> getChildClasscify() {
		return childClasscify;
	}
	public void setChildClasscify(List<Classcify> childClasscify) {
		this.childClasscify = childClasscify;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
