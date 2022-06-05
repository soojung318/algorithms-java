package com.ezen.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.service.UserService;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		// 요청을 서비스 객체로 전달한다.
		UserService svc = new UserService(request,response);
		// 서비스가 처리한 결과를 리턴값(View의 경로)를 받는다.
		String view = svc.process();
		// View에게 forward 한다.
		if(view != null) {
			request.getRequestDispatcher(view).forward(request, response);
		}
	}

}
