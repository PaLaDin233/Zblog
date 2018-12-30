package xyz.zhhg.zblog.web.pojo;

import java.math.BigInteger;

public class User {
	private BigInteger id;
	private String name;
	private String pwd;
	private String type;
	private String ip;
	private int status;
	private String email;
	private String phone;
	
	
	public User(){}
	
	public User(BigInteger id, String name, String pwd, String type, String ip,
			int status, String email, String phone) {
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.type = type;
		this.ip = ip;
		this.status = status;
		this.email = email;
		this.phone = phone;
	}
	
	public User(String name, String pwd) {
		this.name = name;
		this.pwd = pwd;
	}

	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pwd=" + pwd + ", type="
				+ type + ", ip=" + ip + ", status=" + status + ", email="
				+ email + ", phone=" + phone + "]";
	}
	
	
}
