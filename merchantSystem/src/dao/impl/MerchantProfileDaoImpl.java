package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.MerchantProfileDao;
import object.Dish;
import object.Shop;
import object.ShopContact;
import object.merchant.MeMerchant;
import util.DBUtil;

public class MerchantProfileDaoImpl implements MerchantProfileDao {

	@Override
	public MeMerchant retrieveMerchantByMid(int mid) {
		String sql = "select * from m_merchant where mid=?";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs= null;
		MeMerchant merchant = null;
		
		con = DBUtil.createConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, mid);
			
			rs = pst.executeQuery();
			
			if(rs.next()){
				merchant = new MeMerchant();
				merchant.setMid(rs.getInt("mid"));
				merchant.setUserName(rs.getString("username"));
				merchant.setName(rs.getString("name"));
				merchant.setBirth(rs.getDate("brith_date"));
				merchant.setGender(rs.getString("gender"));
				merchant.setStatus(rs.getString("status"));
				merchant.setRegDate(rs.getDate("reg_date"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			DBUtil.free(con, pst, rs);
		}
		return merchant;
	}

	@Override
	public List<Shop> retrieveShopInfoByMid(int mid) {
//		join table to retrieve shop & shop contact
//		String sql = "select a.sid, a.mid, a.name, a.description, a.img_path, "
//				+ "b.cid, b.type, b.info from m_shop a left join m_shop_contact b "
//				+ "on a.SID = b.SID where a.mid=?";
		
		String sql = "select * from m_shop where mid=?";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs= null;
		List<Shop> shops = null;
		
		con = DBUtil.createConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, mid);
			
			rs = pst.executeQuery();
			
			shops = new ArrayList<Shop>();
			
			if(rs.next()){
				Shop shop = new Shop();
				shop.setMid(rs.getInt("mid"));
				shop.setSid(rs.getInt("sid"));
				shop.setName(rs.getString("name"));
				shop.setDescr(rs.getString("description"));
				shop.setImagePath(rs.getString("img_path"));
				shops.add(shop);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			DBUtil.free(con, pst, rs);
		}
		return shops;
	}
	
	@Override
	public List<ShopContact> retrieveShopContactBySid(int sid){
		String sql = "select * from m_shop_contact where sid=?";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs= null;
		List<ShopContact> contacts = null;
		
		con = DBUtil.createConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, sid);
			
			rs = pst.executeQuery();
			
			contacts = new ArrayList<ShopContact>();
			
			while(rs.next()){
				ShopContact contact = new ShopContact();
				contact.setCid(rs.getInt("cid"));
				contact.setSid(rs.getInt("sid"));
				contact.setType(rs.getString("type"));
				contact.setInfo(rs.getString("info"));
				contacts.add(contact);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			DBUtil.free(con, pst, rs);
		}
		return contacts;
	}

	@Override
	public List<Dish> retrieveDishesByMid(int mid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateMerchantInfo(MeMerchant merchant) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateShopInfo(Shop shop) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateShopContactInfo(ShopContact shopContact) {
		// TODO Auto-generated method stub

	}

}
