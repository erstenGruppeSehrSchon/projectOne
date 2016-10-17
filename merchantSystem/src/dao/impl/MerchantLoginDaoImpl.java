package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import consts.Consts;
import dao.MerchantLoginDao;
import dao.MerchantRegisterDao;
import common.po.Shop;
import common.po.MeMerchant;
import util.DBUtil;

public class MerchantLoginDaoImpl implements MerchantLoginDao{
	@Override
	public int checkMerchantExist(String username, String password) {
		String sql = "select mid from m_merchant where username=? and password=?";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs= null;
		int mid = 0;
		
		con = DBUtil.createConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, password);
			
			rs = pst.executeQuery();
			
			if(rs.next()){
				mid = rs.getInt("mid");
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			DBUtil.free(con, pst, rs);
		}
		
		return mid;
	}

	@Override
	public String retrieveMerchantStatus(int mid) {
		String sql = "select status from m_merchant where mid=?";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs= null;
		String status = "";
		
		con = DBUtil.createConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, mid);
			
			rs = pst.executeQuery();
			
			if(rs.next()){
				status = rs.getString("status");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			DBUtil.free(con, pst, rs);
		}
		return status;
	}
	
}
