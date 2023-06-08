package com.saeyan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.saeyan.dto.MemberVO;


public class MemberDAO {
	
	private static MemberDAO instance = new MemberDAO();
	
	private MemberDAO() {}
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	public Connection getConnection() throws Exception {
		Context initContext = new InitialContext();
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
		Connection conn = ds.getConnection();
		return conn;
	}
	
	//userid, pwd가 DB에 있는지 (여부) 체크:
	public int userCheck(String userid, String pwd) {
			int result = -1;
			String sql = "select pwd from member where userid=?";
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				//DB 연결:
				conn = getConnection();
				
				//DB 선행으로 문장 실행:
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, userid);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					String getpwd = rs.getString("pwd");
					if(getpwd != null && getpwd.equals(pwd)) {
						return 1;	//아이디, 비번 일치
					} else {
						return 0;	//비번 불일치
					}
				} else {	
					result = -1;	//존재하지 않는 아이디
				}
			
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return result;
	}
	
	public MemberVO getMember(String userid) {
		MemberVO vo = null;
		
		String sql = "select * from member where userid=?";		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new MemberVO();

				//MemberVO에 Setter를 이미 정의해놈 그래서 사용 가능해짐(setName, ...) :
				vo.setName(rs.getString("name"));
				vo.setUserid(rs.getString("userid"));
				vo.setPwd(rs.getString("pwd"));
				vo.setEmail(rs.getString("email"));
				vo.setPhone(rs.getString("phone"));
				vo.setAdmin(rs.getInt("admin"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return vo;
	}

	public int updateMember(MemberVO vo) {
		int result = -1;
		String sql = "update member set pwd=?, email=?, phone=?, admin=? where userid=?";
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getPwd());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getPhone());
			pstmt.setInt(4, vo.getAdmin());
			pstmt.setString(5, vo.getUserid());
			
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

	public int confirmID(String userid) {
		int result = -1;
		String sql = "select userid from member where userid=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = 1;
			} else {
				result = -1;
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

	public int insertMember(MemberVO vo) {
		int result = -1;
		String sql = "insert into member(name, userid, pwd, email, phone, admin) values(?, ?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getUserid());
			pstmt.setString(3, vo.getPwd());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getPhone());
			pstmt.setInt(6, vo.getAdmin());
			
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
}
