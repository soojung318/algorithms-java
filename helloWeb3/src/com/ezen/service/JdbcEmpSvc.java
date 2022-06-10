package com.ezen.service;

import java.io.*;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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
			Employee emp =dao.getEmp(empno);
			request.setAttribute("emp", emp);
			return "/jdbc/empInfo.jsp";
		}
		else if(cmd.equals("empByDept")) {//부서내 사원 정보만 가져옴
			int deptno = Integer.parseInt(request.getParameter("deptno"));
			EmployeeDAO dao = new EmployeeDAO();
			List<Employee> list = dao.getEmpByDept(deptno);
			request.setAttribute("list", list);
			return "/jdbc/empByDept.jsp";
		}
		else if(cmd.equals("search")) {
			EmployeeDAO dao = new EmployeeDAO();
			String category = request.getParameter("category");
			String key = request.getParameter("key");
			Employee emp = null;
			
			if(category.equals("empno")) {
				int empno = Integer.parseInt(key);
				emp = dao.getEmp(empno);
				request.setAttribute("emp", emp);
			}else if(category.equals("ename")) {
				String ename = key;
				emp = dao.searchByName(ename);
				request.setAttribute("emp", emp);
			}
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
		}else if(cmd.equals("getItemList")) {
			String category = request.getParameter("category");
			EmployeeDAO dao = new EmployeeDAO();
			List<String> list = dao.getItemList(category);
			
			//JSON-Simple
			JSONArray jsArr = new JSONArray();
			for(int i=0; i<list.size(); i++) {
				jsArr.add(list.get(i));
			}
			String items = jsArr.toJSONString();
			/*String items = "[";
			for(int i=0; i<list.size(); i++) {
				items += String.format("\"%s\"", list.get(i));
				if(i<list.size()-1) {
					items += ",";
				}
			}
			items += "]";
			*/
			try {
				PrintWriter out = response.getWriter();
				out.println(items);
				out.flush();
			}catch(IOException ioe) {
				ioe.printStackTrace();
			}
		}
		else if(cmd.equals("getImage")) {
			String empno = request.getParameter("empno");
			String imgPath = empno + ".png";
			JSONObject jsObj = new JSONObject();
			jsObj.put("pic", imgPath);
			try {
				PrintWriter out = response.getWriter();
				out.println(jsObj.toJSONString());
				out.flush();
			}catch(IOException ioe) {
				ioe.printStackTrace();
			}
		}
		else if(cmd.equals("delete")) {	
			int empno = Integer.parseInt(request.getParameter("empno"));
			EmployeeDAO dao = new EmployeeDAO();
			boolean deleted = dao.delete(empno);
			JSONObject jsObj = new JSONObject();
			jsObj.put("deleted", deleted);
			try {
				PrintWriter out = response.getWriter();
				out.println(jsObj.toJSONString());
				out.flush();
			}catch(IOException ioe) {
				ioe.printStackTrace();
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
