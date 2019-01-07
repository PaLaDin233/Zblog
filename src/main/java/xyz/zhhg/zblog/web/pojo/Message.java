package xyz.zhhg.zblog.web.pojo;

import java.math.BigInteger;

public class Message {
	private BigInteger id;
	private BigInteger uid;
	private BigInteger mid;
	private String uname;
	private String detail;
	
	public Message() {
	}
	public Message(BigInteger uid, BigInteger mid, String detail) {
		super();
		this.uid = uid;
		this.mid = mid;
		this.detail = detail;
	}
	@Override
	public String toString() {
		return "Message [uid=" + uid + ", mid=" + mid + ", detail=" + detail
				+ "]";
	}
	public BigInteger getUid() {
		return uid;
	}
	public void setUid(BigInteger uid) {
		this.uid = uid;
	}
	public BigInteger getMid() {
		return mid;
	}
	public void setMid(BigInteger mid) {
		this.mid = mid;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
}
