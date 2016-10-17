package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import po.ShopContact;
import common.util.DBUtil;
import dao.ShopContactDao;

public class ShopContactImpl implements ShopContactDao {

	@Override
	public ShopContact getShopContactsByCID(int cid) {
		
		ShopContact shopContact = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		String sql = "SELECT CID, SIP, TYPE, INFO FROM M_SHOP_CONTACT WHERE CID = ?";

		try {
			conn  = DBUtil.createConnection();
			pstmt = conn .prepareStatement(sql);
			pstmt.setInt(1, cid);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				shopContact = new ShopContact();
				shopContact.setCid(rs.getInt("CID"));
				shopContact.setSid(rs.getInt("SID"));
				shopContact.setType(rs.getString("TYPE"));
				shopContact.setInfo(rs.getString("INFO"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.free(conn , pstmt, rs);
		}
		
		return shopContact;
	}

	@Override
	public ArrayList<ShopContact> getShopContactsBySID(int sid) {
		ArrayList<ShopContact> shopContacts = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		String sql = "SELECT CID, SID, TYPE, INFO FROM M_SHOP_CONTACT WHERE SID = ?";

		try {
			conn  = DBUtil.createConnection();
			pstmt = conn .prepareStatement(sql);
			pstmt.setInt(1, sid);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				ShopContact shopContact = new ShopContact();
				shopContact = new ShopContact();
				shopContact.setCid(rs.getInt("CID"));
				shopContact.setSid(rs.getInt("SID"));
				shopContact.setType(rs.getString("TYPE"));
				shopContact.setInfo(rs.getString("INFO"));
				shopContacts.add(shopContact);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.free(conn , pstmt, rs);
		}
		
		return shopContacts;
	}

}
