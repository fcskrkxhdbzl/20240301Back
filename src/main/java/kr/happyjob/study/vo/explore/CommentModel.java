package kr.happyjob.study.vo.explore;

import java.util.Date;

public class CommentModel {

	private int commentNo;
	private int postNo;
	private int userNo;
	private String userId;
	private String commentContent;
	private Date commentNewdate;
	private Date commentUpdate;
	
	
	
	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}
	public int getPostNo() {
		return postNo;
	}
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	
	public Date getCommentNewdate() {
		return commentNewdate;
	}
	public void setCommentNewdate(Date commentNewdate) {
		this.commentNewdate = commentNewdate;
	}
	public Date getCommentUpdate() {
		return commentUpdate;
	}
	public void setCommentUpdate(Date commentUpdate) {
		this.commentUpdate = commentUpdate;
	}
	
	
	
	
	
}
