package kr.happyjob.study.vo.comment;

import java.util.Date;

public class CommentModel {

	private int commentNo;
	private String commentContent;
	private int postNo;
	private int userNo;
	private Date commentNewDate;
	private Date commentUpDate;
	private String userId;
	private int addlike;
	private int commentLikeNo;
	
	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
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
	public Date getCommentNewDate() {
		return commentNewDate;
	}
	public void setCommentNewDate(Date commentNewDate) {
		this.commentNewDate = commentNewDate;
	}
	public Date getCommentUpDate() {
		return commentUpDate;
	}
	public void setCommentUpDate(Date commentUpDate) {
		this.commentUpDate = commentUpDate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getAddlike() {
		return addlike;
	}
	public void setAddlike(int addlike) {
		this.addlike = addlike;
	}
	public int getCommentLikeNo() {
		return commentLikeNo;
	}
	public void setCommentLikeNo(int commentLikeNo) {
		this.commentLikeNo = commentLikeNo;
	}
	
	
	@Override
	public String toString() {
		return "CommentModel [commentNo=" + commentNo + ", commentContent=" + commentContent + ", postNo=" + postNo
				+ ", userNo=" + userNo + ", commentNewDate=" + commentNewDate + ", commentUpDate=" + commentUpDate
				+ ", userId=" + userId + ", addlike=" + addlike + ", commentLikeNo=" + commentLikeNo + "]";
	}
	
	
	

}
