package com.ezen.service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ezen.dao.EmpDAO;
import com.ezen.vo.EmpVO;

public class EmpService {

	private HttpServletRequest request;
	public EmpService(HttpServletRequest request) {
		this.request = request;
	}
	
	
	public String process() {
		//String path = "C:/test/emp2.txt";
		//String path = "C:/Users/fille/OneDrive/바탕 화면/java/emp.txt";
		String cmd = request.getParameter("cmd");
		
		
		if(cmd== null) cmd = "list";	//cmd가 null 이라면 강제로 list넣어버려.
		
		if(cmd.equals("list")) {	//요청하지 않으면 목록을 보여주어라.
			
			EmpDAO empDAO = new EmpDAO();
			List<EmpVO> list = empDAO.getList();
			request.setAttribute("list", list);
			return "/empView.jsp";
		}
		else if(cmd.equals("getEmp")) {		//~emp?cmd=getEmp&num=12
			String sNum = request.getParameter("num");
			EmpVO emp = getEmp(sNum);
			request.setAttribute("emp", emp);
			return "/empInfo.jsp";
		}
		
		else if(cmd.equals("delete")) {	//~emp?cmd=delete&num=13
			String sNum = request.getParameter("num");
			EmpDAO empDAO = new EmpDAO();
			boolean deleted = empDAO.delete(sNum);
			request.setAttribute("deleted", deleted ? "삭제 성공":"삭제 실패");
			return "empDelete.jsp";
		}	
		else if(cmd.equals("edit")) {	//~emp?cmd=edit&num=14	14번 편집하게 해주세요
			String sNum = request.getParameter("num");	//누구를 편집할 것인지 사원번호 받아오기
			EmpVO emp = getEmp(sNum);		//반복되는 코드를 메소드로 만듦
			request.setAttribute("emp", emp);
			return "/empEdit.jsp";
		}
		else if(cmd.equals("update")) {	//폼에서 넘긴 데이터 받기(empEdilt.jsp)
			String sNum = request.getParameter("num");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			
			//위의 세 객체 다 받아줌; emp 객체 한개에 세가지 정보를 넣음.
			EmpVO emp = new EmpVO(Integer.valueOf(sNum));
			emp.setPhone(phone);
			emp.setEmail(email);
			
			EmpDAO empDAO = new EmpDAO();
			boolean updated = empDAO.update(emp);
			request.setAttribute("updated", updated);		//true false가 넘어와서 true false가 반환--> empUpdated.jsp로 고
			return "/empUpdated.jsp";
		}
		
		else if(cmd.equals("add_form")) {
			return "/add_form.jsp";
		
		}
		else if(cmd.equals("add")) {
			//4가지 파라미터 접수(num,name,phone,email)
			String sNum = request.getParameter("num");
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");

			EmpVO emp = new EmpVO(Integer.parseInt(sNum),name,phone,email);
			//System.out.println(emp);//2 2 2 2
			EmpDAO empDAO = new EmpDAO();
			
			boolean saved = empDAO.add(emp);
			request.setAttribute("saved", saved);
			return "/empSaved.jsp";
		}
		return null;

	}
	
	private EmpVO getEmp(String sNum) {
		EmpDAO empDAO = new EmpDAO();
		EmpVO emp = empDAO.getEmp(sNum);
		return emp;
	}
}
