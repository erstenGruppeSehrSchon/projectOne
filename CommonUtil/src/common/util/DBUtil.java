package common.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtil {
	
	private final static String userName = "ken";
	private final static String pw = "smallwhite";
	private final static String db_url = "jdbc:oracle:thin:@CHEUNAN-W7.corp.oocl.com:1521:xe";
	private final static String driver_classname = "oracle.jdbc.OracleDriver";
	
	private static BasicDataSource ds;
	static{
		try {
			Class.forName(driver_classname);
			ds = new BasicDataSource();
			ds.setUrl(db_url);
			ds.setDriverClassName(driver_classname);
			ds.setUsername(userName);
			ds.setPassword(pw);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static Connection createConnection(){
		Connection con = null;
		//Request Driver
//		BasicDataSource ds = new BasicDataSource();
		con = null;
		try {
			con= ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static void free(Connection con,PreparedStatement pst, ResultSet rs){
		try {
			if (rs!=null){
				rs.close();
			}
			if (pst!=null){
				pst.close();
			}
			if (con!=null){
				con.close();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
