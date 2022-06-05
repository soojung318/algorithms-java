<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="addrbook_error.jsp" import="command.*,java.util.*"%>
<!DOCTYPE html>
<%request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="ab" scope ="page" class="addrBook.AddrBean"/>
<jsp:useBean id="addrbook" class = "addrBook.AddrBook"/>
<jsp:setProperty  name="addrbook" property='*'/>

<jsp:useBean id="arraylist" scope="request" class="java.util.ArrayList"/>
<%
	
	//컨트롤러 요청 파라미터
	String action = request.getParameter("action");
	//파라미터에 따른 요청 처리
	//주소록 목록 요청인 경우
	
	if(action.equals("list")){
		ArrayList<AddrBook> addrlist = ab.selectDB();
		request.setAttribute("addrlist",addrlist);
		pageContext.forward("addrbook_list.jsp");
	}
	
	//주소록 등록 요청인 경우
	
	if(action.equals("insert")){
		if(ab.insertDB(addrbook)){
			response.sendRedirect("addrbook_control.jsp?action=list");
		}
		else{
			throw new Exception("DB 입력오류");
		}
	}
	else if(action.equals("update")){
		if(ab.updateDB(addrbook)){
			response.sendRedirect("addrbook_control.jsp?action=list");
		}
		else{
			throw new Exception("DB 업뎃오류");
		}
		
	}
	else if(action.equals("delete")){
		//AddrBook adrbk = ab.deleteDB(addrbook.getAb_id());
		
	}
	else if(action.equals("edit")){
		AddrBook adrbook = ab.selectDB01(addrbook.getAb_id());
		request.setAttribute("addrbook", adrbook);
		pageContext.forward("addrbook_edit_form.jsp");
	}
%>