package kr.happyjob.study.vo.explore;

import java.util.Date;
import java.util.List;

public class ExploreModel {

	 
	private int postNo;
	private String postContent;
	private int userNo;
	private Date postNewdate;
	private Date postUpdate;
	private List<CommentModel> commentList;
	
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
	public Date getPostNewdate() {
		return postNewdate;
	}
	public void setPostNewdate(Date postNewdate) {
		this.postNewdate = postNewdate;
	}
	public Date getPostUpdate() {
		return postUpdate;
	}
	public void setPostUpdate(Date postUpdate) {
		this.postUpdate = postUpdate;
	}
	public List<CommentModel> getCommentList() {
		return commentList;
	}
	public void setCommentList(List<CommentModel> commentList) {
		this.commentList = commentList;
	}
	
	
	
	
	
}
