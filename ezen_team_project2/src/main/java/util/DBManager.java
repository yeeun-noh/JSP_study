package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBManager {

	public static Connection getConnection() {
		Connection conn = null;

		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void close(Connection c, Statement s, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (s != null)
				s.close();
			if (c != null)
				c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void close(Connection c, Statement s) {
		try {
			if (s != null)
				s.close();
			if (c != null)
				c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}