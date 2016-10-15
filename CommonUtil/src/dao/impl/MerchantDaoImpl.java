package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.MerchantDao;
import object.merchant.AdminMerchant;
import object.merchant.MeMerchant;
import util.DBUtil;

public class MerchantDaoImpl implements MerchantDao {
	public MeMerchant findMeMerchantById(int id){
		MeMerchant m =null;
		String sql = "select * from M_MERCHANT WHERE MID = ?";
		Connection con=null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		con=DBUtil.createConnection();
		try {
			pst=con.prepareStatement(sql);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			if (rs.next()){
				m = new MeMerchant();
				m.setMid(rs.getInt("MID"));
				m.setName(rs.getString("NAME"));
				m.setBirth(rs.getDate("BRITH_DATE"));
				m.setGender(rs.getString("GENDER"));
				m.setStatus(rs.getString("STATUS"));
				m.setRegDate(rs.getDate("REG_DATE"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBUtil.free(con, pst, rs);
		}
		return m;
	}

	@Override
	public void setAdminMerchant(AdminMerchant adminMerchant) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO A_MERCHANT VALUES (?, ?, ?, ?, ?, ?)";
		Connection con=null;
		PreparedStatement pst = null;
		con=DBUtil.createConnection();
		try {
			pst=con.prepareStatement(sql);
			pst.setInt(1, adminMerchant.getMid());
			pst.setString(2, adminMerchant.getName());
			pst.setDate(3, new java.sql.Date(adminMerchant.getBirth().getTime()));
			pst.setString(4, adminMerchant.getGender());
			pst.setString(5, adminMerchant.getStatus());
			pst.setDate(6, new java.sql.Date(adminMerchant.getRegDate().getTime()));
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtil.free(con, pst, null);
		}
	}
}
