package com.ezen.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.service.ShopService;

/**
 * Servlet implementation class ShopServlet
 */
@WebServlet("/shop")
public class ShopServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("servlet실행");
		
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		//ShopService 클래스에 요청을 전달후 process() 메소드 호출
		//process() 메소드가 리턴한 값을 view의 경로로 삼아 forward 한다.
		//이용자가 cmd=index를 요청한 경우 (=파라미터를 전달한 경우) shop/index.jsp 페이지가 보여지도록 한다.
		ShopService svc = new ShopService(request,response);
		String view = svc.process();
		if(view!=null) {
			request.getRequestDispatcher(view).forward(request, response);
		}
	}

}
