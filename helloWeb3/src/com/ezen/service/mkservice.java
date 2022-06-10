package com.ezen.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.EmployeeDAO;
import com.ezen.vo.Employee;




public class mkservice {
   private HttpServletRequest request;
   private HttpServletResponse response;

   public mkservice(HttpServletRequest request, HttpServletResponse response) {
      this.request = request;
      this.response = response;
   }
    
   public String process() {
      String cmd = request.getParameter("cmd");
      
      if(cmd==null||cmd.equals("list")) {
         //cmd가 없거나 cmd가 "list"이면
         EmployeeDAO dao = new EmployeeDAO();
         List<Employee> list = dao.getList();
         request.setAttribute("list", list);
         //dao객체를 만들고 dao에있는 getList를 실행
      
         return "/jdbc/jdbcEmpList.jsp";
         //그리고 list.jsp에 가서 뿌려줌
         
      }else if(cmd.equals("detail")) {
         int empno = Integer.parseInt(request.getParameter("num"));
         EmployeeDAO dao = new EmployeeDAO();
         Employee emp = dao.detail(empno);
         request.setAttribute("detail",emp );
         return "/jdbc/empDetail.jsp";   
         
      }else if(cmd.equals("add")) {
         return "/jdbc/insert.jsp";   
         
      }else if(cmd.equals("insert")) {
         int empno = Integer.parseInt(request.getParameter("empno"));
         String ename=request.getParameter("ename");
         int deptno = Integer.parseInt(request.getParameter("deptno"));
         int sal = Integer.parseInt(request.getParameter("sal"));
         Date hiredate = java.sql.Date.valueOf(request.getParameter("hiredate"));
         
         Employee emp = new Employee();
         emp.setEmpno(empno);
         emp.setEname(ename);
         emp.setDeptno(deptno);
         emp.setSal(sal);
         emp.setHiredate(hiredate);
         
         EmployeeDAO dao = new EmployeeDAO();
         boolean insert = dao.insert(emp);
         System.out.println(insert);
         try {
             PrintWriter out= response.getWriter();
            String jsStr = String.format("{\"%s\":%b}","insert",insert);
            System.out.println(jsStr);
             out.println(jsStr);
             out.flush();
            
         } catch (IOException e) {
         
            e.printStackTrace();
         }
         
         
         
      }else if(cmd.equals("edit")) {
         int empno = Integer.parseInt(request.getParameter("num"));
         EmployeeDAO dao = new EmployeeDAO();
         Employee emp = dao.detail(empno);
         request.setAttribute("edit",emp );
         
         return "/jdbc/edit.jsp";
      }else if(cmd.equals("update")) {
         int empno = Integer.parseInt(request.getParameter("num"));
         int deptno = Integer.parseInt(request.getParameter("deptno"));
         int sal = Integer.parseInt(request.getParameter("sal"));
         
         Employee emp = new Employee();
         emp.setEmpno(empno);
         emp.setDeptno(deptno);
         emp.setSal(sal);
   
         EmployeeDAO dao = new EmployeeDAO();
         boolean updated = dao.update(emp);
         
         try {
             PrintWriter out= response.getWriter();
            String jsStr = String.format("{\"%s\":%b}", "updated",updated);
            
             out.println(jsStr);
             out.flush();
            
         } catch (IOException e) {
         
            e.printStackTrace();
         }

      }else if(cmd.equals("getDept")) {
         int deptno = Integer.parseInt(request.getParameter("num"));
         EmployeeDAO dao = new EmployeeDAO();
         List<Employee> list = dao.getDept(deptno);
         request.setAttribute("deptList", list);
         return "/jdbc/getDept.jsp";
         
      }else if(cmd.equals("delete")) {
         int empno = Integer.parseInt(request.getParameter("num"));
         EmployeeDAO dao = new EmployeeDAO();
          dao.deleted(empno);
          return "jdbcemp?cmd=list";
         
      }else if(cmd.equals("search")) {
   
         String category=request.getParameter("category");
         String key=request.getParameter("key");
         Employee emp =null;
         EmployeeDAO dao = new EmployeeDAO();
         
         switch(category) {
         case "ename":emp=dao.searchByName(key); break;
         case "empno":emp=dao.detail(Integer.parseInt(key)); break;
         }
         request.setAttribute("search",emp );
         return "/jdbc/search.jsp";   
         
      }else if(cmd.equals("getItemList")) {
         System.out.println("1111");
         String category = request.getParameter("category");
         EmployeeDAO dao = new EmployeeDAO();
         List<String>list = dao.getItemList(category);
         
         String items = "[";     //   ["11","12","13"]==> 반복문이 만들어 내는 것
            for(int i=0;i<list.size();i++) {
               items += String.format("\"%s\"", list.get(i));
               //문자열을 만들기 때문//\"json이 원하는 문자열
               if(i<list.size()-1) {
                  items += ",";
               }
            }
            items += "]";
            
            try {
             PrintWriter out= response.getWriter();
             out.println(items);
             out.flush();
            } catch (IOException e) {
         
            e.printStackTrace();
         }
         
         
      }
         
    
      return null;
   }

}