package com.ezen.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.service.BBService;

/**
 * Servlet implementation class DBSServlet
 */
@WebServlet("/bbs")
public class DBSServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		System.out.println("BBS Servlet Starting...");
		
		BBService svc = new BBService(request,response);
		String view = svc.process();
		System.out.println("view:"+view);
		if(view!=null) {
			request.getRequestDispatcher(view).forward(request, response);
		}
	}

}
