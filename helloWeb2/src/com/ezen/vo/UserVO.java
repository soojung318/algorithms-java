package com.ezen.vo;

public class UserVO {

	private String uid;
	private String upw;
	
	
	public UserVO(String uid, String upw) {
		this.uid = uid;
		this.upw = upw;
	}
	
	public UserVO(String[] userInfo) {
		this(userInfo[0],userInfo[1]);
	}

	@Override
	public String toString() {
		return String.format("%s %s", uid, upw);
	}
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUpw() {
		return upw;
	}
	public void setUpw(String upw) {
		this.upw = upw;
	}
}
