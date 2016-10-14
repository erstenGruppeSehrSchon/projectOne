package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import object.Admin;
import object.merchant.AdminMerchant;

import org.apache.commons.lang3.StringUtils;

import util.DBUtil;
import util.Utility;
import dao.AdminDao;

public class AdminDaoImpl implements AdminDao {
	
	Utility util = new Utility();
	
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

	@Override
	public List<AdminMerchant> findAllMerchants() {
		
		List<AdminMerchant> ams = new ArrayList<AdminMerchant>();
		
		String sql = "select MID, NAME, BIRTH_DATE, GENDER, STATUS, REG_DATE from A_MERCHANT";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		con = DBUtil.createConnection();
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				AdminMerchant am = new AdminMerchant();
				am.setId(rs.getInt("MID"));
				am.setName(rs.getString("NAME"));
				Date birthDate = rs.getDate("BIRTH_DATE");
				if (birthDate != null) {
					am.setAge(util.getAge(birthDate.getYear(), birthDate.getMonth(), birthDate.getDay()));
				}
				am.setGender(rs.getString("GENDER"));
				am.setStatus(rs.getString("STATUS"));
				am.setReg_date(rs.getDate("REG_DATE"));
				ams.add(am);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.free(con, pst, rs);
		}
		
		return ams;
	}

}
