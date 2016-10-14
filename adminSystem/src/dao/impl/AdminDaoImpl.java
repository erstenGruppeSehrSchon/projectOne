package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import object.Admin;
import org.apache.commons.lang3.StringUtils;
import util.DBUtil;
import util.Utility;
import dao.AdminDao;

public class AdminDaoImpl implements AdminDao {
	
	Utility util = new Utility();
	
	@Override
	public Admin getAdmin(String id, String password) {
		
		// assume these are mandatory fields
		if (StringUtils.isBlank(id) || StringUtils.isBlank(password)) {
			return null;
		}
		
		Admin admin = null;
		String sql = "select AID, PASSWORD from A_ADMIN where AID = ? and PASSWORD = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		conn = DBUtil.createConnection();

		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				admin = new Admin();
				admin.setAid(rs.getString("AID"));
				// password cannot be disclose
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.free(conn, pstmt, rs);
		}
		
		return admin;
	}

}
