<%@page import="org.json.simple.JSONArray"%>
<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	JSONObject jobj = new JSONObject();
	jobj.put("key1","val1");
	jobj.put("key2","val2");
	jobj.put("key3","val3");
	
	//String jsStr = jobj.toJSONString();
	JSONArray jsArr = new JSONArray();
	jsArr.add("Smith");
	jsArr.add("Ward");
	jsArr.add("James");
	
	String jsStr = jsArr.toJSONString();
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<%=jsStr %>
</body>
</html>