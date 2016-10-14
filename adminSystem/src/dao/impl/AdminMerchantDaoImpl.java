package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.AdminMerchantDao;
import object.merchant.MeMerchant;
import util.DBUtil;

public class AdminMerchantDaoImpl implements AdminMerchantDao{
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
		return m;
	}
}
