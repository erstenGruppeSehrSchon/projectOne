package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang3.StringUtils;

import object.Admin;
import util.DBUtil;
import dao.AdminDao;

public class AdminDaoImpl implements AdminDao {
	
	@Override
	public Admin loadUser(String id, String password) {
		
		// assume these are mandatory fields
		if (StringUtils.isBlank(id) || StringUtils.isBlank(password)) {
			return null;
		}
		
		Admin a = null;
		String sql = "select AID, PASSWORD from A_ADMIN where AID = ? and PASSWORD = ?";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		con = DBUtil.createConnection();
		System.out.println("*****" + con);
		try {
			
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			pst.setString(2, password);
			
			rs = pst.executeQuery();
			if (rs.next()) {
				a = new Admin();
				a.setAid(rs.getString("AID"));
				// password cannot be disclose
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.free(con, pst, rs);
		}
		
		System.out.println("YEAH!!!");
		return a;
	}

}
