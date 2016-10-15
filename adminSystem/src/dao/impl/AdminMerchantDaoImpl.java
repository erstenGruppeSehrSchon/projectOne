package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dao.AdminMerchantDao;
import object.merchant.AdminMerchant;
import util.DBUtil;

public class AdminMerchantDaoImpl implements AdminMerchantDao{
	
	private static String SQL_SELECT = "SELECT MID, NAME, ROUND((CURRENT_DATE - BIRTH_DATE)/365) AS AGE, GENDER, STATUS, REG_DATE FROM A_MERCHANT";
	private static int[][] AGE_RANGE = new int[][]{
		{0, 0},
		{0, 20},
		{20, 40},
		{40, 60},
		{60, 80},
		{80, 100}
	};
	
	public AdminMerchant getMerchantById(int id) {
		AdminMerchant aMerchant = null;
		String sql = SQL_SELECT + " WHERE MID = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = DBUtil.createConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()){
				aMerchant = new AdminMerchant();
				aMerchant.setMid(rs.getInt("MID"));
				aMerchant.setName(rs.getString("NAME"));
				aMerchant.setAge(rs.getInt("AGE"));
				aMerchant.setGender(rs.getString("GENDER"));
				aMerchant.setStatus(rs.getString("STATUS"));
				aMerchant.setRegDate(rs.getDate("REG_DATE"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return aMerchant;
	}
	
	@Override
	public ArrayList<AdminMerchant> getMerchantByCriteria(Integer id, String name, Integer ageIndex, String gender, String regDate) {
	
		ArrayList<AdminMerchant> aMerchants = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		conn = DBUtil.createConnection();
		try {
			String sql = SQL_SELECT + " WHERE " +
					 	 "MID LIKE ? AND " +
					 	 "NAME LIKE ? AND " +
					 	 "(((CURRENT_DATE - BIRTH_DATE)/365 >= ? AND (CURRENT_DATE - BIRTH_DATE)/365 < ?) OR 1 = ?) AND " +
					 	 "GENDER LIKE ? AND " +
					 	 "(TRUNC(REG_DATE, 'DD') = TO_DATE(?, 'YYYY-MM-DD') OR 1 = ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id == null ? "%" : String.valueOf(id));
			pstmt.setString(2, name == null ? "%" : "%" + name + "%");
			pstmt.setInt(3, AGE_RANGE[ageIndex][0]);
			pstmt.setInt(4, AGE_RANGE[ageIndex][1]);
			pstmt.setInt(5, ageIndex == 0 ? 1 : 0 );	// Bypass age check if 0
			pstmt.setString(6, gender);
			pstmt.setString(7, regDate == null ? "1111-11-11" : regDate);
			pstmt.setInt(8, regDate == null ? 1 : 0);	// Bypass registration date check if null
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				AdminMerchant aMerchant = new AdminMerchant();
				aMerchant.setMid(rs.getInt("MID"));
				aMerchant.setName(rs.getString("Name"));
				aMerchant.setAge(rs.getInt("AGE"));
				aMerchant.setGender(rs.getString("GENDER"));
				aMerchant.setStatus(rs.getString("STATUS"));
				aMerchant.setRegDate(rs.getDate("REG_DATE"));
				aMerchants.add(aMerchant);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.free(conn, pstmt, rs);
		}
		
		return aMerchants;
	}

	@Override
	public ArrayList<AdminMerchant> getAllMerchants() {
		
		ArrayList<AdminMerchant> aMerchants = new ArrayList<>();
		
		String sql = SQL_SELECT;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		conn = DBUtil.createConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				AdminMerchant aMerchant = new AdminMerchant();
				aMerchant.setMid(rs.getInt("MID"));
				aMerchant.setName(rs.getString("NAME"));
				aMerchant.setAge(rs.getInt("AGE"));
				aMerchant.setGender(rs.getString("GENDER"));
				aMerchant.setStatus(rs.getString("STATUS"));
				aMerchant.setRegDate(rs.getDate("REG_DATE"));
				aMerchants.add(aMerchant);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.free(conn, pstmt, rs);
		}
		
		return aMerchants;
	}

	@Override
	public ArrayList<AdminMerchant> getMerchantByStatus(String status) {
		
		ArrayList<AdminMerchant> aMerchants = new ArrayList<>();
		
		String sql = SQL_SELECT + " WHERE STATUS = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		conn = DBUtil.createConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, status);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				AdminMerchant aMerchant = new AdminMerchant();
				aMerchant.setMid(rs.getInt("MID"));
				aMerchant.setName(rs.getString("NAME"));
				aMerchant.setAge(rs.getInt("AGE"));
				aMerchant.setGender(rs.getString("GENDER"));
				aMerchant.setStatus(rs.getString("STATUS"));
				aMerchant.setRegDate(rs.getDate("REG_DATE"));
				aMerchants.add(aMerchant);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.free(conn, pstmt, rs);
		}
		
		return aMerchants;
	}

	@Override
	public boolean updateMerchantStatus(String status, int id) {
		String sql = "update A_MERCHANT set STATUS = ? where MID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		conn = DBUtil.createConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, status);
			pstmt.setInt(2, id);
			result = pstmt.executeUpdate();
			if (result == 0) {
				return false;
			} else {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.free(conn, pstmt, null);
		}
		
		return false;
	}

}
