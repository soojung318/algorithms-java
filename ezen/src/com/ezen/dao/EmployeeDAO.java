package com.ezen.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.ezen.vo.Employee;

public class EmployeeDAO 
{//업로드 됨cc
   private Connection conn;
   private PreparedStatement pstmt;
   private ResultSet rs;
   
   private Connection getConn()
   {
      try 
      {
         Class.forName("oracle.jdbc.driver.OracleDriver");  //ojdbc8.jar
         Connection conn = DriverManager.getConnection(
                   "jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
         return conn;
      }
      catch(Exception e) {
         e.printStackTrace();
      }
      return null;
   }
   
   public List<Employee> getList()
   {
      conn = getConn();
      try {
         String sql = "SELECT * FROM employee";
         pstmt = conn.prepareStatement(sql);
         rs = pstmt.executeQuery();
         List<Employee> list = new ArrayList<>();
         
         while(rs.next()) {
            int empno = rs.getInt("EMPNO");
            String ename = rs.getString("ENAME");
            int deptno = rs.getInt("DEPTNO");
            int sal = rs.getInt("SAL");
            java.sql.Date hiredate = rs.getDate("HIREDATE");
            
            Employee emp = new Employee();
            emp.setEmpno(empno);
            emp.setEname(ename);
            emp.setDeptno(deptno);
            emp.setSal(sal);
            emp.setHiredate(hiredate);
            
            list.add(emp);
         }
         return list;
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         closeAll();
      }
      return null;
   }
   
   private void closeAll()
   {
      try {
         if(rs != null) rs.close();
         if(pstmt != null) pstmt.close();
         if(conn != null) conn.close();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   public Employee getEmp(int empno) 
   {
      conn = getConn();
      try {
         String sql = "SELECT * FROM employee WHERE empno=?";
         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, empno);
         rs = pstmt.executeQuery();
         if(rs.next()) {
            int eno = rs.getInt("EMPNO");
            String ename = rs.getString("ENAME");
            int deptno = rs.getInt("DEPTNO");
            int sal = rs.getInt("SAL");
            java.sql.Date hiredate = rs.getDate("HIREDATE");
          
            
            Employee emp = new Employee();
            emp.setEmpno(eno);
            emp.setEname(ename);
            emp.setDeptno(deptno);
            emp.setSal(sal);
            emp.setHiredate(hiredate);
            
            return emp;
         }
      }catch(Exception e) {
         e.printStackTrace();
      }finally {
         closeAll();
      }
      return null;
   }

   public boolean update(Employee emp) 
   {
      conn = getConn();
      try {
         String sql = "UPDATE employee SET deptno=?, sal=? WHERE empno=?";
         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, emp.getDeptno());
         pstmt.setInt(2, emp.getSal());
         pstmt.setInt(3, emp.getEmpno());

         int n = pstmt.executeUpdate();
         return n>0;
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         closeAll();
      }
      return false;
   }
   
   public List<Employee> getEmpByDept(int dno)
   {
      conn = getConn();
      try {
         String sql = "SELECT * FROM employee WHERE deptno=?";
         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, dno);
         rs = pstmt.executeQuery();
         List<Employee> list = new ArrayList<>();
         
         while(rs.next()) {
            int empno = rs.getInt("EMPNO");
            String ename = rs.getString("ENAME");
            int deptno = rs.getInt("DEPTNO");
            int sal = rs.getInt("SAL");
            java.sql.Date hiredate = rs.getDate("HIREDATE");
            
            Employee emp = new Employee();
            emp.setEmpno(empno);
            emp.setEname(ename);
            emp.setDeptno(deptno);
            emp.setSal(sal);
            emp.setHiredate(hiredate);
            
            list.add(emp);
         }
         return list;
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         closeAll();
      }
      return null;
   }

   public Employee searchByName(String ename2) {
	   conn = getConn();
	      try {
	         String sql = "SELECT * FROM employee WHERE ename=?";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, ename2);
	         rs = pstmt.executeQuery();
	         if(rs.next()) {
	            int eno = rs.getInt("EMPNO");
	            String ename = rs.getString("ENAME");
	            int deptno = rs.getInt("DEPTNO");
	            int sal = rs.getInt("SAL");
	            java.sql.Date hiredate = rs.getDate("HIREDATE");
	          
	            
	            Employee emp = new Employee();
	            emp.setEmpno(eno);
	            emp.setEname(ename);
	            emp.setDeptno(deptno);
	            emp.setSal(sal);
	            emp.setHiredate(hiredate);
	            
	            return emp;
	         }
	      }catch(Exception e) {
	         e.printStackTrace();
	      }finally {
	         closeAll();
	      }
	      return null;

	
	}
}