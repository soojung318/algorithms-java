package jspbook.ch17;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitialMember implements ServletContextListener{
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();
		ArrayList<Member> datas = new ArrayList<Member>();
		
		//JSTL 예제를 위해 0~7까지의 샘플 데이터를 생성
		for(int i=0; i<8; i++) {
			Member data = new Member("신수정"+i,"text"+i+"@test.net");
			datas.add(data);
		}
		
		//email이 빠진 2개의 샘플 데이터 추가
		datas.add(new Member("홍길동",null));
		datas.add(new Member("김길동",null));
		
		//application scope 에 members 및 member 객체 저장
		//application은 javax.servlet.ServletContext
		context.setAttribute("members", datas);
		context.setAttribute("member", new Member());
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {}
}
