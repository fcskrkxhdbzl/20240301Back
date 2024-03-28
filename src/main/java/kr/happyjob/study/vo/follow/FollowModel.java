package kr.happyjob.study.vo.follow;

public class FollowModel {
		
	private int follow_no;
	private int follower_user_no;
	private int follow_user_no;
	private String follow_new_date;
	private String follow_up_date;
	
	private int user_no;
	private String user_id;
	
	public int getFollow_no() {
		return follow_no;
	}
	public void setFollow_no(int follow_no) {
		this.follow_no = follow_no;
	}
	public int getFollower_user_no() {
		return follower_user_no;
	}
	public void setFollower_user_no(int follower_user_no) {
		this.follower_user_no = follower_user_no;
	}
	public int getFollow_user_no() {
		return follow_user_no;
	}
	public void setFollow_user_no(int follow_user_no) {
		this.follow_user_no = follow_user_no;
	}
	public String getFollow_new_date() {
		return follow_new_date;
	}
	public void setFollow_new_date(String follow_new_date) {
		this.follow_new_date = follow_new_date;
	}
	public String getFollow_up_date() {
		return follow_up_date;
	}
	public void setFollow_up_date(String follow_up_date) {
		this.follow_up_date = follow_up_date;
	}	
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	@Override
	public String toString() {
		return "FollowModel [follow_no=" + follow_no + ", follower_user_no=" + follower_user_no + ", follow_user_no="
				+ follow_user_no + ", follow_new_date=" + follow_new_date + ", follow_up_date=" + follow_up_date
				+ ", user_no=" + user_no + ", user_id=" + user_id + "]";
	}
	
}
