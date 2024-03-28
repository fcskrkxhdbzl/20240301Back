package kr.happyjob.study.vo.comment;

import java.util.Date;

public class CommentLikeModel {
	
	private int commentLikeNo;
	private int userNo;
	private int commentNo;
	private Date commentLikeNewDate;
	private Date commentLikeUpDate;
	
	public int getCommentLikeNo() {
		return commentLikeNo;
	}
	public void setCommentLikeNo(int commentLikeNo) {
		this.commentLikeNo = commentLikeNo;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}
	public Date getCommentLikeNewDate() {
		return commentLikeNewDate;
	}
	public void setCommentLikeNewDate(Date commentLikeNewDate) {
		this.commentLikeNewDate = commentLikeNewDate;
	}
	public Date getCommentLikeUpDate() {
		return commentLikeUpDate;
	}
	public void setCommentLikeUpDate(Date commentLikeUpDate) {
		this.commentLikeUpDate = commentLikeUpDate;
	}
	
	@Override
	public String toString() {
		return "CommentLikeModel [commentLikeNo=" + commentLikeNo + ", userNo=" + userNo + ", commentNo=" + commentNo
				+ ", commentLikeNewDate=" + commentLikeNewDate + ", commentLikeUpDate=" + commentLikeUpDate + "]";
	}

}
