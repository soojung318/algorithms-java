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
@WebServlet("/hello")	// ~/hello? : 물음표 뒤에 나오는 것은 주소가 아니고 데이터로 해석이 된다. ex ~/hello?dan=5 :5단 구구단을 보여줘.
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 * 												요청							응답
	 */
	@Override		// 컴파일러에게 문법을 검사해달라.
	//백엔드 개발자 할일: 요청을 통해 service를 만들어서 응답보내는거.
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청한 클라이언트에게 응답하려면?
		response.setContentType("text/html; charset=utf-8");	//text인데 html문법으로 보낼거야. 
		PrintWriter out = response.getWriter();	//문자열을 쓸거야
		/* 아래 예제 실행시키기 위해 잠시 주석처리
		out.print("This is Hello Servlet<br>");
		out.print("<html><head><body><span style='color:red'>한글도 OK</span><br/></body></head></html>");
		out.flush();//메모리에 남아 있는 모든 데이터들을 내보내라.
		//System.out.println("Hello 서블릿 실행됨");
		out.println("<p>");
		request.setCharacterEncoding("utf-8");
		String sDan = request.getParameter("dan"); 
		System.out.println(sDan+"단"); //브라우저에서 요청한 데이터가 서버 건너 잘 갔는지 확인하는 출력문		
		//System.out.println("dan="+sDan);
		int dan = 0;
		try {
			dan = Integer.parseInt(sDan);
		}catch(NumberFormatException nfe) {
			dan = 2;	//dan이 파라미터 값으로 전달되지 않았을 경우
		}
		for(int i=1; i<10; i++) {
			out.println(String.format("%d * %d = %d<br/>", dan, i, dan*i));
		}			
		//<p> 문단의 약자: 여기선 한 문단의 공백이 생김
		out.println("<p>");
		for(int i=2; i<10; i++) {
			out.printf("<a href='hello?dan=%d'>%d</a>",i,i);	//<a> 이용자가 직접 클릭할수 있게 커서가 손가락 모양으로 변경함.
			
		}
		*/
		//Controller 부분
		HelloService svc = new HelloService(request);
		String msg = svc.getGugu();
		//System.out.println(msg);  제대로 서블릿에서 받아오는지 확인하는 코드
		request.setAttribute("msg", msg);//request 객체의 일부분에 이 메세지를 넣어 보내겠다. request 객체 자체를 보내기 때문. msg란 이름의 메시지를 보내겠다.
		//                    key  value
		request.getRequestDispatcher("/ggView.jsp").forward(request, response);	//jsp로 요청을 보내겠다.
		
	}
	

}
