package com.ezen.vo;

import java.sql.Date;
import java.util.Objects;

public class Employee {
	private int empno;
	private String ename;
	private int deptno;
	private int sal;
	private Date hiredate;
	
	//생성자
	
	
	
	@Override
	public boolean equals(Object obj) {
		Employee emp = (Employee) obj;
		return this.empno==emp.empno;
	}
	@Override
	public int hashCode() {
		return Objects.hash(this.empno);
	}
	@Override
	public String toString() {
		return String.format("%d\t%s\t%d\t%d", empno,ename,deptno,sal,hiredate);
	}
	
	
	//getter/setter
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String name) {
		this.ename = name;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	
	
}
