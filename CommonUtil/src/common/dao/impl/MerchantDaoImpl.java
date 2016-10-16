package common.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.dao.MerchantDao;
import common.po.MeMerchant;
import common.po.Merchant;
import common.util.DBUtil;


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
			e.printStackTrace();
		}
		finally{
			DBUtil.free(con, pst, rs);
		}
		return m;
	}

	@Override
	public void setMerchant(Merchant merchant) {
		String sql = "INSERT INTO A_MERCHANT VALUES (?, ?, ?, ?, ?, ?)";
		
		Connection con=null;
		PreparedStatement pst = null;
		con=DBUtil.createConnection();
		
		try {
			pst=con.prepareStatement(sql);
			pst.setInt(1, merchant.getMid());
			pst.setString(2, merchant.getName());
			pst.setDate(3, new java.sql.Date(merchant.getBirth().getTime()));
			pst.setString(4, merchant.getGender());
			pst.setString(5, merchant.getStatus());
			pst.setDate(6, new java.sql.Date(merchant.getRegDate().getTime()));
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.free(con, pst, null);
		}
	}
}
