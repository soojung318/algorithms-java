package com.ezen.service;

import javax.servlet.http.HttpServletRequest;

public class HelloService {

	private HttpServletRequest request;
	
	public HelloService(HttpServletRequest request) {
		this.request = request;
		//int dan = Integer.parseInt(request.getParameter("dan"));
	}
	public String getGugu() {
		
		String sDan = request.getParameter("dan");
		int dan = 0;
		
		try {
			dan = Integer.parseInt(sDan);
		}catch(NumberFormatException nfe) {
			dan = 2;
		}
		
		String gStr = "";
		for(int i=1; i<10; i++) {
			gStr += String.format("%d * %d = %d<br>", dan, i, dan*i);
		}
		return gStr;
	}
}
