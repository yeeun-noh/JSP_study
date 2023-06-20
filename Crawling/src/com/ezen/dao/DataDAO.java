package com.ezen.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DataDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "scott";
	private String pwd = "tiger";
	private String sql = "insert into seoulHotel values(?,?,?,?,?,?)";
	
	public void seoulHotelInsert(SeoulHotelVO vo) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, id, pwd);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getNo());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getAddress());
			pstmt.setString(4, vo.getPoster());
			pstmt.setString(5, vo.getImages());
			pstmt.setInt(6, vo.getScore());
			
			pstmt.executeUpdate();
			
			
			
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
	}

}
