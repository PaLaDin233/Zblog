package xyz.zhhg.zblog.web.pojo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public class Article implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6193926749324625368L;
	private BigInteger id;
	private BigInteger userId;
	private String userName;
	private String title;
	private Date createTime;
	private Date modifiedDate;
	private int status;
	private String details;
	private int likes;
	private int views;
	private int commentNum;
	private String img;
	public List<Comment> comments;//文章的评论
	private List<Classcify> classcifys;
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public Article() {
	}
	public Article(BigInteger id, BigInteger userId, String title,
			Date createTime, Date modifiedDate, int status, String details,
			int likes, int views, int commentNum) {
		super();
		this.id = id;
		this.userId = userId;
		this.title = title;
		this.createTime = createTime;
		this.modifiedDate = modifiedDate;
		this.status = status;
		this.details = details;
		this.likes = likes;
		this.views = views;
		this.commentNum = commentNum;
	}
	public Article(BigInteger articleId) {
		this.id=articleId;
	}
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public BigInteger getUserId() {
		return userId;
	}
	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public void setDetails(String[] details){
		StringBuilder builder=new StringBuilder();
		for (String string : details) {
			builder.append(string);
		}
		this.details=builder.toString();
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public int getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}
	
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public void setModifiedDate() {
		this.modifiedDate=new Date(System.currentTimeMillis());
		
	}
	
	public List<Classcify> getClasscify() {
		return classcifys;
	}
	public void setClasscify(List<Classcify> classcifys) {
		this.classcifys = classcifys;
	}
	@Override
	public String toString() {
		return "Article [id=" + id + ", userId=" + userId + ", title=" + title
				+ ", createTime=" + createTime + ", modifiedDate="
				+ modifiedDate + ", status=" + status + ", details=" + details
				+ ", likes=" + likes + ", views=" + views + ", commentNum="
				+ commentNum + ", img=" + img + ", comments=" + comments
				+ ", classcifys=" + classcifys + "]";
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
	
}
