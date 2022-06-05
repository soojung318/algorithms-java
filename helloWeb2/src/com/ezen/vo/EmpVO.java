package com.ezen.vo;

import java.util.Objects;

public class EmpVO {
	private int num;
	private String name;
	private String phone;
	private String email;
	
	//생성자 오버로딩
	public EmpVO() {}	//객체가 필요없을때 사용
	
	public EmpVO(int num) {	//사번만 가지고 객체를 만들떄 사용
		this.num = num;
	}
	
	public EmpVO(int num, String name, String phone, String email) {
		super();
		this.num = num;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}
	
	public EmpVO(String[] empInfo) {
		this(Integer.parseInt(empInfo[0]),empInfo[1],empInfo[2],empInfo[3]);
	}

	@Override
	public boolean equals(Object obj) {	
		//System.out.println((EmpVO)obj);
		EmpVO other = (EmpVO)obj;
		return this.num==other.num ? true : false;	//번호만 같으면 같은 사람이다. true이면 
	}

	@Override
	public String toString() {
		return String.format("%d %s %s %s", num, name,phone, email);
	}

	//해쉬 코드를 상속받았기 때문에 이미 해쉬코드가 있으므로 오버라이드 코드 작성해주기.
	@Override
	public int hashCode() {
		return Objects.hash(this.num);		//번호만가지고 해시코드를 계산해내라.
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
