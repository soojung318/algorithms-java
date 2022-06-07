package com.ezen.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.BBSDAO;
import com.ezen.vo.BBSVO;

public class BBService {

	HttpServletRequest request; 
	HttpServletResponse response;
	
	public BBService(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}
	
	public String process() {
		String cmd =request.getParameter("cmd");
		System.out.println("cmd:"+cmd);
		if(cmd==null || cmd.equals("index")) {
			return "/bbs/index.jsp";
		}
		else if(cmd.equals("add_form")) {
			return "/bbs/add_form.jsp";
		}
		else if(cmd.equals("add")) {
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String uid = (String)request.getSession().getAttribute("uid");
			java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
			BBSDAO dao = new BBSDAO();
			int no = dao.getLastNo() + 1;
			
			BBSVO bbs = new BBSVO();
			bbs.setNo(no);
			bbs.setTitle(title);
			bbs.setContent(content);
			bbs.setWriter(uid);
			bbs.setDate(now);
			
			boolean added = dao.add(bbs);
			try {
				PrintWriter out = response.getWriter();
				out.println(String.format("{\"%s\":%b}", "added",added));
				out.flush();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(cmd.equals("list"))
		{
			BBSDAO dao = new BBSDAO();
			List<BBSVO> list = dao.getList();
			request.setAttribute("list", list);
			return "/bbs/list.jsp";
		}
		else if(cmd.equals("detail"))
		{
			int num = Integer.parseInt(request.getParameter("num"));
			BBSDAO dao = new BBSDAO();
			BBSVO bbs = dao.getBBS(num);
			request.setAttribute("bbs", bbs);
			return "/bbs/detail.jsp";
		}
		
		else if(cmd.equals("edit")) {
			int num = Integer.parseInt(request.getParameter("num"));
			//String uid = (String)request.getSession().getAttribute("uid");
			BBSDAO dao = new BBSDAO();
			BBSVO bbs = dao.getBBS(num);
			request.setAttribute("bbs", bbs);
			return "/bbs/edit_bbs.jsp";
		}
		else if(cmd.equals("update")) {
			int num = Integer.parseInt(request.getParameter("num"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			System.out.println("title:"+title);
			System.out.println("content:"+content);
			BBSVO bbs = new BBSVO();
			bbs.setNo(num);
			bbs.setTitle(title);
			bbs.setContent(content);
	
			
			BBSDAO dao = new BBSDAO();
			boolean updated = dao.update(bbs);
			PrintWriter out;
			try {
				out = response.getWriter();
				out.println(String.format("{\"%s\":%b}","updated", updated));
				out.flush();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	

}
