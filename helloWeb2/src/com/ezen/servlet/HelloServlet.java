package com.ezen.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.service.HelloService;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/math")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		HelloService svc = new HelloService(request);
		String msg = svc.getCalculate();
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("/mathView.jsp").forward(request, response);
	
		
	}

}
