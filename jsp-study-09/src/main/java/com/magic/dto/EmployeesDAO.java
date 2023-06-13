package com.magic.dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.magic.dto.EmployeesVO;

public class EmployeesDAO {

   private static EmployeesDAO instance = new EmployeesDAO();

   private EmployeesDAO() {}

   public static EmployeesDAO getInstance() { // 값을 read only property 로 만들기 위해서 setter X, getter만 만듬
      return instance;

   }

   //커넥션 풀
   public Connection getConnection() throws Exception {
      Context initContext = new InitialContext();
      Context envContext = (Context) initContext.lookup("java:/comp/env");
      DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
      Connection conn = ds.getConnection();

      return conn;
   }

   //입력한 정보가 db에 존재하는지 체크
   public int userCheck(String id, String pwd, String lev) {
	   Connection conn = null;
	   PreparedStatement pstmt = null;
	   ResultSet rs = null;
	   
	   String sql = "select * from employees where id=?";
	   
	   int result = -1;
	   
	   try {
		   conn = getConnection();
		   pstmt = conn.prepareStatement(sql);
		   pstmt.setString(1, id);
		   rs = pstmt.executeQuery();
		   
		   if(rs.next()) {
			   if(pwd.equals(rs.getString("pass")))  {
				   if(lev.equals(rs.getString("lev")))  {
					   result = 3;		//일반회원
					   
					   if (lev.equals("A"))
						   result = 2;	//관리자
					   
				   } else {
					   result = 1;	//아이디 비번 일치, lev 불일치
				   }
			   } else {
				   result = 0;		//아이디는 일치, 비번 불일치
			   }
		   } else {
			   result = -1;			//존재하지 않는 아이디
		   }
		   
	   } catch(Exception e) {
		   e.printStackTrace();
	   } finally {
		   try {
			   if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
		   } catch(Exception e) {
			   e.printStackTrace();
		   }
	   }
	   
	   return result;
   }
   
   public EmployeesVO getMember(String id) {
	   EmployeesVO vo = new EmployeesVO();
	   
	   Connection conn = null;
	   PreparedStatement pstmt = null;
	   ResultSet rs = null;

	   String sql = "select * from employees where id=?";
	   
	   try {
		   conn = getConnection();
		   pstmt = conn.prepareStatement(sql);
		   pstmt.setString(1, id);
		   rs = pstmt.executeQuery();
		   
		   if(rs.next()) {
			   vo.setId(rs.getString("id"));
			   vo.setPass(rs.getString("pass"));
			   vo.setName(rs.getString("name"));
			   vo.setLev(rs.getString("lev"));
			   vo.setEnter(rs.getString("enter"));
			   vo.setGender(rs.getString("gender"));
			   vo.setPhone(rs.getString("phone"));
		   }
		   
	   } catch(Exception e) {
		   e.printStackTrace();
	   } finally {
		   try {
			   if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
		   } catch(Exception e) {
			   e.printStackTrace();
		   }
	   }

	   return vo;
   }
   
   public int updateMember(EmployeesVO vo) {
	   int result = 0;
	   
	   Connection conn = null;
	   PreparedStatement pstmt = null;

	   String sql = "update employees set pass=?, name=?, lev=?, gender=?, phone=? where id=?";
	   
	   try {
		   conn = getConnection();
		   pstmt = conn.prepareStatement(sql);		   
		   pstmt.setString(1, vo.getPass());
		   pstmt.setString(2, vo.getName());
		   pstmt.setString(3, vo.getLev());
		   pstmt.setString(4, vo.getGender());
		   pstmt.setString(5, vo.getPhone());
		   pstmt.setString(6, vo.getId());
		   result = pstmt.executeUpdate();
		   
	   } catch(Exception e) {
		   e.printStackTrace();
	   } finally {
		   try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
		   } catch(Exception e) {
			   e.printStackTrace();
		   }
	   }

	   return result;
   }
   
   public int insertMember(EmployeesVO vo) {
	   int result = -1;
	   String sql = "insert into employees values (?,?,?,?,sysdate,?,?)";
	   
	   Connection conn = null;
	   PreparedStatement pstmt = null;
	   
	   try {
		   conn = getConnection();
		   pstmt = conn.prepareStatement(sql);
		   
		   pstmt.setString(1, vo.getId());
		   pstmt.setString(2, vo.getPass());
		   pstmt.setString(3, vo.getName());
		   pstmt.setString(4, vo.getLev());
		   pstmt.setString(5, vo.getGender());
		   pstmt.setString(6, vo.getPhone());
		   
		   result = pstmt.executeUpdate();
		   
	   } catch (Exception e) {
		   e.printStackTrace();
	   } finally {
		   try {
			   if(pstmt != null) pstmt.close();
			   if(conn != null) conn.close();
		   } catch (Exception e) {
			   e.printStackTrace();
		   }
	   }
	   return result; 
   }   
}