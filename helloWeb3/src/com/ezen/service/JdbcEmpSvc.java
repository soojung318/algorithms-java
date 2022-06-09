package com.ezen.service;

import java.io.*;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.EmployeeDAO;
import com.ezen.vo.Employee;

public class JdbcEmpSvc {
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	
	public JdbcEmpSvc(HttpServletResponse response, HttpServletRequest request) {
		this.response = response;
		this.request = request;
	}

	public String process() {
		String cmd = request.getParameter("cmd");
		
		if(cmd==null) cmd="list";
		
		if(cmd.equals("list")) {
			EmployeeDAO dao = new EmployeeDAO();
			List<Employee> list = dao.getList();
			request.setAttribute("list", list);
			return "/jdbc/jdbcEmpList.jsp";
		}
		else if(cmd.equals("getEmp")) {	//한 사원만 가져옴,사번으로 검색
			int empno = Integer.parseInt(request.getParameter("empno"));
			EmployeeDAO dao = new EmployeeDAO();
			Employee emp = getEmp(empno);
			request.setAttribute("emp", emp);
			return "/jdbc/empInfo.jsp";
		}
		else if(cmd.equals("empByDeptno")) {//부서내 사원 정보만 가져옴
			int deptno = Integer.parseInt(request.getParameter("deptno"));
			EmployeeDAO dao = new EmployeeDAO();
			List<Employee> list = dao.getEmpByDept(deptno);
			request.setAttribute("list", list);
			return "/jdbc/empByDept.jsp";
		}
		else if(cmd.equals("empByename")) {	//이름으로 검색
			String ename = request.getParameter("ename");
			EmployeeDAO dao = new EmployeeDAO();
			Employee emp = dao.searchByName(ename);
			request.setAttribute("emp", emp);
			return "/jdbc/empInfo.jsp";
		}
		else if(cmd.equals("edit")) {
			int empno = Integer.parseInt(request.getParameter("empno"));
			EmployeeDAO dao = new EmployeeDAO();
			Employee emp = dao.getEmp(empno);
			request.setAttribute("emp", emp);
			return "/jdbc/empEdit.jsp";
		}
		else if(cmd.equals("update")) {
			int empno = Integer.parseInt(request.getParameter("empno"));
			int deptno = Integer.parseInt(request.getParameter("deptno"));
			int sal = Integer.parseInt(request.getParameter("sal"));
			
			Employee emp = new Employee();
			emp.setEmpno(empno);
			emp.setDeptno(deptno);
			emp.setSal(sal);
			
			EmployeeDAO dao = new EmployeeDAO();
			boolean updated = dao.update(emp);	//update에 성공하면 T/F로 보내줘
			
			try {
				PrintWriter out = response.getWriter();
				String jsonStr = String.format("{\"%s\":%b}","updated", updated);
				out.println(jsonStr);	//json문자열
				out.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
			  	e.printStackTrace();
			}
		}

		return null;
	}


	private Employee getEmp(int empno) {
		EmployeeDAO dao = new EmployeeDAO();
		Employee emp = dao.getEmp(empno);
		return emp;
	}

}
