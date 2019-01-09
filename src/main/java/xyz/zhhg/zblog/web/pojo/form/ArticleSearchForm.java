package xyz.zhhg.zblog.web.pojo.form;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * @author 清居
 *
 */
/**
 * @author 清居
 *
 */
public class ArticleSearchForm {
	private BigInteger id;
	private String title;
	private Date createTime;
	private Date modifiedDate;
	private BigInteger userId;
	private String username;
	private List<String> labels;
	private String type;
	private Date beginDate;
	private Date endDate;
	private int status;
	private boolean commentNumOrder;
	private boolean viewsNumOrder;
	private boolean likesNumOrder;
	private BigInteger classcifyId;
	@Override
	public String toString() {
		return "ArticleSearchForm [id=" + id + ", title=" + title
				+ ", createTime=" + createTime + ", modifiedDate="
				+ modifiedDate + ", userId=" + userId + ", username="
				+ username + ", labels=" + labels + ", type=" + type
				+ ", beginDate=" + beginDate + ", endDate=" + endDate
				+ ", status=" + status + ", commentNumOrder=" + commentNumOrder
				+ ", viewsNumOrder=" + viewsNumOrder + ", likesNumOrder="
				+ likesNumOrder + "]";
	}
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		if(title!=null){
			if(title.trim().length()==0)title=null;
		}
		this.title = title;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public void setCreateTime(String createTime) {
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		try{
			this.createTime =format.parse(createTime) ;			
		}catch(Exception e){
			e.printStackTrace();
			this.createTime =null;
		}
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public BigInteger getUserId() {
		return userId;
	}
	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<String> getLabels() {
		return labels;
	}
	public void setLabels(List<String> labels) {
		this.labels = labels;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public boolean isCommentNumOrder() {
		return commentNumOrder;
	}
	public void setCommentNumOrder(boolean commentNumOrder) {
		this.commentNumOrder = commentNumOrder;
	}
	public boolean isViewsNumOrder() {
		return viewsNumOrder;
	}
	public void setViewsNumOrder(boolean viewsNumOrder) {
		this.viewsNumOrder = viewsNumOrder;
	}
	public boolean isLikesNumOrder() {
		return likesNumOrder;
	}
	public void setLikesNumOrder(boolean likesNumOrder) {
		this.likesNumOrder = likesNumOrder;
	}
	public BigInteger getClasscifyId() {
		return classcifyId;
	}
	public void setClasscifyId(BigInteger classcifyId) {
		this.classcifyId = classcifyId;
	}
	
	
	


	
	
	
}
