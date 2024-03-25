package kr.happyjob.study.vo.post;

import java.util.Date;

public class PostModel {

	 
	private int post_no;
	private String post_content;
	private int user_no2;
	private Date post_new_date;
	private Date post_up_date;
	
	public int getPost_no() {
		return post_no;
	}
	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}
	public String getPost_content() {
		return post_content;
	}
	public void setPost_content(String post_content) {
		this.post_content = post_content;
	}
	public int getUser_no2() {
		return user_no2;
	}
	public void setUser_no2(int user_no2) {
		this.user_no2 = user_no2;
	}
	public Date getPost_new_date() {
		return post_new_date;
	}
	public void setPost_new_date(Date post_new_date) {
		this.post_new_date = post_new_date;
	}
	public Date getPost_up_date() {
		return post_up_date;
	}
	public void setPost_up_date(Date post_up_date) {
		this.post_up_date = post_up_date;
	}
}
