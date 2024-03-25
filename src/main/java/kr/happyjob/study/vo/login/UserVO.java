package kr.happyjob.study.vo.login;

public class UserVO {
	private String loginId;
	private String userType;
	private String name;
	private String password;
	private String sex;
	private String hp;
	private String email;
//	private String regdate
	private String addr;

//	private String birthday
	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "UserVO [loginId=" + loginId + ", userType=" + userType + ", name=" + name + ", password=" + password
				+ ", sex=" + sex + ", hp=" + hp + ", email=" + email + ", addr=" + addr + "]";
	}
}
