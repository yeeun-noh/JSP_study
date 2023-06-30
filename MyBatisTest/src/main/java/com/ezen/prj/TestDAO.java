package com.ezen.prj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TestDAO {
	private static TestDAO instance = new TestDAO();

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	//String oracle = "oracle.jdbc.driver.OracleDriver";
	
	String mysql = "com.mysql.cj.jdbc.Driver";
	
	//String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String myUrl = "jdbc:mysql://localhost:3306/scottdb?serverTimezone=UTC";
	String username = "scott";
	String pass = "tiger";

	private TestDAO() {}

	public static TestDAO getInstance() {
		return instance;
	}

	public List<TestVO> selectAllTest()  {
		List<TestVO> list = new ArrayList<>();

		try {
			String sql = "select * from test";
			Class.forName(mysql);
			conn = DriverManager.getConnection(myUrl, username, pass);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()){
				TestVO vo = new TestVO();
				vo.setId(rs.getInt("id"));
				vo.setName(rs.getString("name"));
				vo.setPhone(rs.getString("phone"));
				vo.setAddress(rs.getString("address"));
				list.add(vo);
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
		return list;
	}

	public int insertTest(TestVO vo)  {
		int result = 0;
		try {
			String sql = "insert into test(name, phone, address) values(? , ?, ?)";
			Class.forName(mysql);
			conn = DriverManager.getConnection(myUrl, username, pass);
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPhone());
			pstmt.setString(3, vo.getAddress());
			
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
