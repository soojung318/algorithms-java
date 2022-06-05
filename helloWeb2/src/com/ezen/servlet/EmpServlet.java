package com.ezen.servlet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.service.EmpService;
import com.ezen.vo.EmpVO;

/**
 * Servlet implementation class EmpServlet
 */
@WebServlet("/emp")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		//String path = "C:/Users/fille/OneDrive/바탕 화면/java/emp.txt";
		
		EmpVO e1 = new EmpVO(11);
		EmpVO e2 = new EmpVO(11);
		System.out.println(e1.equals(e2));		//equals()로 비교하여 동일한 경우
		System.out.println("e1:"+e1.hashCode());
		System.out.println("e2:"+e2.hashCode());
		
		EmpService svc = new EmpService(request);
		String view = svc.process();
		
		System.out.println("view="+view);
		//List<EmpVO> list = svc.process();
		
		/*String cmd = request.getParameter("cmd");
		if(cmd== null) cmd = "list";	//cmd가 null 이라면 강제로 list넣어라.
		
		
		if(cmd.equals("list")) {	//요청하지 않으면 목록을 보여주어라.
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line = null;	//한 행씩 저장하는 문자열
			
			List<EmpVO> list = new ArrayList<>();
			
			while((line=br.readLine())!= null) {
				String[] info = line.split(" ");
				
				//한 사원의 객체
				EmpVO emp = new EmpVO(Integer.valueOf(info[0]),info[1],info[2],info[3]);
				//String str = String.format("%s\t%s\t%s\t%s", info[0],info[1],info[2],info[3]);
				//System.out.println(str);
				list.add(emp);
			}*/
			//request.setAttribute("list", list);
			request.getRequestDispatcher(view).forward(request, response);
		}
	}


