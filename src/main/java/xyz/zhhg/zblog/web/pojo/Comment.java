package xyz.zhhg.zblog.web.pojo;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**
 * 评论
 * @author 清居
 *
 */
public class Comment {

	private BigInteger id;
	private BigInteger uid;
	private String uname;
	private BigInteger superior;
	private String details;
	private String uemail;
	private BigInteger ancestor;
	private Date cdate;
	@Override
	public String toString() {
		return "Comment [id=" + id + ", uid=" + uid + ", uname=" + uname
				+ ", superior=" + superior + ", details=" + details
				+ ", uemail=" + uemail + ", childCommentList="
				+ childCommentList + "]";
	}
	/**
	 * 子评论列表
	 */
	private List<Comment> childCommentList;
	
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
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	public List<Comment> getChildCommentList() {
		return childCommentList;
	}
	public void setChildCommentList(List<Comment> childCommentList) {
		this.childCommentList = childCommentList;
	}
	
	
	public BigInteger getUid() {
		return uid;
	}
	public void setUid(BigInteger uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public BigInteger getAncestor() {
		return ancestor;
	}
	public void setAncestor(BigInteger ancestor) {
		this.ancestor = ancestor;
	}
	public Date getCdate() {
		return cdate;
	}
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
}
