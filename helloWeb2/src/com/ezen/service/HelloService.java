package com.ezen.service;

import javax.servlet.http.HttpServletRequest;

public class HelloService {

	private HttpServletRequest request;
	
	public HelloService(HttpServletRequest request) {
		this.request = request;
		//int dan = Integer.parseInt(request.getParameter("dan"));
	}
	
	
	public String getCalculate() {
		
		String cmd = request.getParameter("cmd");
		if(cmd == null) return "계산 요청이 없습니다.";
		
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		int n1 = 0;
		int n2 = 0;
		
		try {
			n1 = Integer.parseInt(num1);
			n2 = Integer.parseInt(num2);
		}catch(NumberFormatException nfe) {
			n1 = 2;
			n2 = 2;
		}
		
		String gStr = "";
		
		if(cmd.equals("add")) {
			gStr += String.format("%d + %d = %d<br>", n1, n2, n1+n2);
		}
		
		else if(cmd.equals("sub")) {
			gStr += String.format("%d - %d = %d<br>", n1, n2, n1-n2);
		}
		else if(cmd.equals("mul")) {
			gStr += String.format("%d * %d = %d<br>", n1, n2, n1*n2);
		}
		else if(cmd.equals("div")) {
			gStr += String.format("%d / %d = %d<br>", n1, n2, n1/n2);
			
		}
		else gStr = "잘못된 요청이 전달되었습니다.";
		return gStr;
		
	}
}
