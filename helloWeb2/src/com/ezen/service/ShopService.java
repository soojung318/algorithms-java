package com.ezen.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.http.*;
import java.util.*;

import com.ezen.dao.ShopDAO;
import com.ezen.util.BookCart;
import com.ezen.vo.ITBook;

public class ShopService {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private BookCart cart;
	
	public ShopService(HttpServletRequest request,HttpServletResponse response) {
		this.request = request;
		this.response = response;
		Object obj = this.request.getSession().getAttribute("cart");
		if(obj==null) {
			this.request.getSession().setAttribute("cart", new BookCart());
		}
	}

	public String process() {
		String cmd = request.getParameter("cmd");
		
		if(cmd==null || cmd.equals("index")) {
			return "/shop/index.jsp";
		}
		else if(cmd.equals("prog")) {
			int pg = Integer.parseInt(request.getParameter("page"));//pg는 page number
			System.out.println(pg);
			return "/shop/page_"+pg+".jsp";
		}
		else if(cmd.equals("order")) {
			
			ITBook book = getBookParam();	//브라우저 파라미터에서 책을 구한다.
			ShopDAO dao = new ShopDAO();
			boolean saved = dao.save(book);
			try {
				PrintWriter out = response.getWriter();
				String jsonStr = "{\"saved\":" + saved+"}";
				out.println(jsonStr);
				out.flush();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}//end of order{}
		else if(cmd.equals("tocart")) {
			
			//장바구니에 해당하는 객체, cart.save(book)	: 장바구니에 책을 담기.
			ITBook book = getBookParam();
			BookCart cart = (BookCart)request.getSession().getAttribute("cart");
			ShopDAO dao = new ShopDAO();
			boolean saved = cart.save(book);
			boolean added = dao.add(book);
			
			try {
				PrintWriter out = response.getWriter();
				String jsonStr = "{\"saved\":" + saved+"}";
				out.println(jsonStr);
				out.flush();
			}catch(IOException e) {
				e.printStackTrace();
			}
			/*List<ITBook> list = cart.getCart();
			for(int i=0; i<list.size(); i++) {
				String title = list.get(i).getTitle();
				int qty = list.get(i).getQty();
				System.out.printf("%s : %d \n", title, qty);
			}*/
			
		
		}
		else if(cmd.equals("showcart")) {
			BookCart cart = (BookCart)request.getSession().getAttribute("cart");
			List<ITBook> list = cart.getCart();
			request.setAttribute("list", list);
			request.setAttribute("total", cart.getTotal());
			return "/shop/showCart.jsp";
		}
		
		else if(cmd.equals("update_qty")) {
			int idx = Integer.parseInt(request.getParameter("idx"));
			int qty = Integer.parseInt(request.getParameter("qty"));
			BookCart cart = (BookCart)request.getSession().getAttribute("cart");
			boolean updated = cart.updateQty(idx,qty);
			int total = cart.getTotal();
			PrintWriter out;
			try {
				out = response.getWriter();
				out.println("{\"updated\":"+updated+", \"total\":"+total+"}");
				out.flush();
			}catch(IOException e) {
				e.printStackTrace();
			}
			
		}
		
		else if(cmd.equals("remove")) {
			int idx = Integer.parseInt(request.getParameter("idx"));
			BookCart cart = (BookCart)request.getSession().getAttribute("cart");
			boolean removed = cart.remove(idx);
			PrintWriter out;
			try {
				out = response.getWriter();
				out.println("{\"removed\":"+removed+"}");
				out.flush();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		else if(cmd.equals("removeAll")) {
			BookCart cart = (BookCart)request.getSession().getAttribute("cart");
			cart.getCart().clear();
			PrintWriter out;
			try {
				out = response.getWriter();
				out.println("{\"empty\":"+true+"}");
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}//end of process()
	
	private ITBook getBookParam() {
		String title = request.getParameter("title");
		String pub = request.getParameter("pub");
		String pubdate = request.getParameter("pubdate");
		String author = request.getParameter("author");
		String _price = request.getParameter("price");
		String _qty = request.getParameter("qty");
		int price = Integer.parseInt(_price);
		int qty = Integer.parseInt(_qty);
		
		ITBook book = new ITBook();
		book.setTitle(title);
		book.setPub(pub);
		book.setPubdate(Date.valueOf(pubdate));
		book.setAuthor(author);
		book.setPrice(price);
		book.setQty(qty);
		return book;
	}

}
