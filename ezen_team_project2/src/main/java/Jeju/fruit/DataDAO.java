package Jeju.fruit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Jeju.user.dao.MemberDAO;
import util.DBManager;

public class DataDAO {
	private static DataDAO instance = new DataDAO();
	
	private DataDAO() {}
	
	public static DataDAO getInstance() {
		return instance;					
	}
	
	
	private Connection conn = null;
	private PreparedStatement pstmt= null;
	ResultSet rs=null;

	private String url="jdbc:oracle:thin:@localhost:1521:xe";
	private String id ="scott";
	private String pwd ="tiger";
	private String sql= "insert into TBL_Fruit values(?,?,?,?)";

	public void JejuFrultSelect(JejuFruitVO vo) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn =DriverManager.getConnection(url,id,pwd);
			pstmt = conn.prepareStatement(sql);   
			pstmt.setInt(1, vo.getNo());
			pstmt.setString(2, vo.getPoster());   
			pstmt.setString(3, vo.getDescription());
			pstmt.setString(4, vo.getPrice());

			pstmt.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null)pstmt.close();
				if(conn!= null)conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<JejuFruitVO> JejuFrultselectAll() {
		List<JejuFruitVO> list = new ArrayList<JejuFruitVO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from TBL_Fruit order by no desc";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				JejuFruitVO vo = new JejuFruitVO();
				vo.setNo(rs.getInt("no"));
				vo.setPoster(rs.getString("poster"));
				vo.setDescription(rs.getString("description"));
				vo.setPrice(rs.getString("price"));

				list.add(vo);
			}

		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return list;
	}

	public int insertBoard(JejuFruitVO vo) {
		int result = -1; 

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into TBL_Fruit values(?,?,?,?)";;

		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, vo.getNo());
			pstmt.setString(2, vo.getPoster());
			pstmt.setString(3, vo.getDescription());
			pstmt.setString(4, vo.getPrice());

			result = pstmt.executeUpdate();

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}
	
	
}