package common.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.dao.DishDao;
import common.dao.ShopContactDao;
import common.dao.ShopDao;
import common.po.Dish;
import common.po.Shop;
import common.po.ShopContact;
import common.util.DBUtil;


public class ShopDaoImpl implements ShopDao{
	
	@Override
	public Shop findShopById(int id) {
		Shop shop = null;
		
		String sql = "select * from M_SHOP WHERE SID = ?";
		
		Connection con=null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		con=DBUtil.createConnection();
		
		try {
			pst=con.prepareStatement(sql);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			
			if (rs.next()){
				shop = new Shop();
				shop.setSid(rs.getInt("SID"));
				shop.setMid(rs.getInt("MID"));
				shop.setName(rs.getString("NANE"));
				shop.setImagePath(rs.getString("IMG_PATH"));
				shop.setDescr(rs.getString("DESCRIPTION"));
				
				// Get Shop Contact
				ShopContactDao scd = new ShopContactImpl();
				ArrayList<ShopContact> shopContacts = scd.getShopContactsBySID(shop.getSid());
				shop.setShopContactList(shopContacts);
				
				// Get Shop Dish
				DishDao dd = new DishDaoImpl();
				ArrayList<Dish> dishList = dd.getDishBySid(shop.getSid());
				shop.setDishList(dishList);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.free(con, pst, rs);
		}
		
		return shop;
	}

	@Override
	public ArrayList<Shop> findAllShop() {
		Shop shop =null;
		
		Connection con=null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		ArrayList<Shop> ShopList = new ArrayList<>();
		
		String sql = "select * from M_SHOP";
		con=DBUtil.createConnection();
		
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			if (rs.next()){
				shop = new Shop();
				shop.setSid(rs.getInt("SID"));
				shop.setMid(rs.getInt("MID"));
				shop.setName(rs.getString("NANE"));
				shop.setImagePath(rs.getString("IMG_PATH"));
				shop.setDescr(rs.getString("DESCRIPTION"));
				
				// Add to list
				ShopList.add(shop);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.free(con, pst, rs);
		}
		
		return ShopList;
	}

}
