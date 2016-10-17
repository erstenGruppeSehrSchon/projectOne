package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.commons.dbcp.BasicDataSource;

public class DBUtil {

	public static final String USERNAME = "ANGUS";
	public static final String PASSWORD = "123";
	public static final String DB_URL = "jdbc:oracle:thin:@ITA-031-W7.corp.oocl.com:1521:xe";
	public static final String DRIVER = "oracle.jdbc.OracleDriver";
	public static BasicDataSource ds; 
	
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		ds = new BasicDataSource();
		ds.setMaxActive(2); // Max connection number
		ds.setDriverClassName(DRIVER);
		ds.setUrl(DB_URL);
		ds.setUsername(USERNAME);
		ds.setPassword(PASSWORD);
	}
	
	public static Connection createConnection() {
		Connection conn = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void free(Connection conn, PreparedStatement pstmt) {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void free(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//System.out.println(DBUtil.createConnection());
	}
}
