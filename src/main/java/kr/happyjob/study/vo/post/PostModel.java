package kr.happyjob.study.vo.post;

import java.util.Date;

public class PostModel {

	 
	private int postNo;
	private String postContent;
	private int userNo;
	private Date postNewDate;
	private Date postUpDate;
	private String userId;
	
	public int getPostNo() {
		return postNo;
	}
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public Date getPostNewDate() {
		return postNewDate;
	}
	public void setPostNewDate(Date postNewDate) {
		this.postNewDate = postNewDate;
	}
	public Date getPostUpDate() {
		return postUpDate;
	}
	public void setPostUpDate(Date postUpDate) {
		this.postUpDate = postUpDate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "PostModel [postNo=" + postNo + ", postContent=" + postContent + ", userNo=" + userNo + ", postNewDate="
				+ postNewDate + ", postUpDate=" + postUpDate + ", userId=" + userId + "]";
	}
	
	
	
	
}
