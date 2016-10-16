package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.MerchantProfileDao;
import po.Dish;
import po.DishImage;
import po.Shop;
import po.ShopContact;
import po.MeMerchant;
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
			
			while(rs.next()){
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
	public Shop retrieveShopBySid(int sid) {
		String sql = "select * from m_shop where sid=?";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs= null;
		Shop shop = null;
		
		con = DBUtil.createConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, sid);
			
			rs = pst.executeQuery();
			
			shop = new Shop();
			
			if(rs.next()){
				shop.setMid(rs.getInt("mid"));
				shop.setSid(rs.getInt("sid"));
				shop.setName(rs.getString("name"));
				shop.setDescr(rs.getString("description"));
				shop.setImagePath(rs.getString("img_path"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			DBUtil.free(con, pst, rs);
		}
		return shop;
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
		String sql = "select distinct d.did, c.mid, c.sid,  d.name, d.type, d.price "
				+ "from (select a.mid, b.sid from m_merchant a ,m_shop b "
				+ "where a.mid = b.mid) c ,M_DISH d where c.sid = d.sid and c.mid=?";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs= null;
		List<Dish> dishes = null;
		
		con = DBUtil.createConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, mid);
			
			rs = pst.executeQuery();
			
			dishes = new ArrayList<Dish>();
			
			while(rs.next()){
				Dish dish = new Dish();
				dish.setDid(rs.getInt("did"));
				dish.setSid(rs.getInt("sid"));
				dish.setName(rs.getString("name"));
				dish.setType(rs.getString("type"));
				dish.setPrice(rs.getDouble("price"));
				dishes.add(dish);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			DBUtil.free(con, pst, rs);
		}
		return dishes;
	}
	
	@Override
	public List<Dish> retrieveDishesBySid(int sid) {
		String sql = "select distinct d.did, c.mid, c.sid,  d.name, d.type, d.price "
				+ "from (select a.mid, b.sid from m_merchant a ,m_shop b "
				+ "where a.mid = b.mid) c ,M_DISH d where c.sid = d.sid and c.sid=?";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs= null;
		List<Dish> dishes = null;
		
		con = DBUtil.createConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, sid);
			
			rs = pst.executeQuery();
			
			dishes = new ArrayList<Dish>();
			
			while(rs.next()){
				Dish dish = new Dish();
				dish.setDid(rs.getInt("did"));
				dish.setSid(rs.getInt("sid"));
				dish.setName(rs.getString("name"));
				dish.setType(rs.getString("type"));
				dish.setPrice(rs.getDouble("price"));
				dishes.add(dish);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			DBUtil.free(con, pst, rs);
		}
		return dishes;
	}
	
	@Override
	public List<DishImage> retrieveDishImagesByDid(int did){
		String sql = "select * from m_dish_img where did=?";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs= null;
		List<DishImage> images = null;
		
		con = DBUtil.createConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, did);
			
			rs = pst.executeQuery();
			
			images = new ArrayList<DishImage>();
			
			while(rs.next()){
				DishImage img = new DishImage();
				img.setDid(rs.getInt("did"));
				img.setImageId(rs.getInt("img_id"));
				img.setImgPath(rs.getString("img_path"));
				images.add(img);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			DBUtil.free(con, pst, rs);
		}
		return images;
	}

	@Override
	public boolean updateMerchantInfo(MeMerchant merchant, String oldPassword) {
		// TODO Auto-generated method stub
		String sql = "update m_merchant set name=?, password=?, brith_date=?, gender=? where mid=? and password=?";
		Connection con = null;
		PreparedStatement pst = null;
		
		con = DBUtil.createConnection();
		try {
			pst = con.prepareStatement(sql);
			
			pst.setString(1, merchant.getName());
			pst.setString(2, merchant.getPassword());
			pst.setDate(3, new java.sql.Date( merchant.getBirth().getTime()));
			pst.setString(4, merchant.getGender());
			pst.setInt(5, merchant.getMid());
			pst.setString(6, oldPassword);
			
			int n = pst.executeUpdate();
			
			// not updating the db
			if(n == 0)
				return false;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally{
			DBUtil.free(con, pst, null);
		}
		return true;
	}

	@Override
	public void updateShopInfo(Shop shop) {
		// TODO Auto-generated method stub
		String sql = "update m_shop set name=?, img_path=? where sid=?";
		Connection con = null;
		PreparedStatement pst = null;
		
		con = DBUtil.createConnection();
		try {
			pst = con.prepareStatement(sql);
			
			pst.setString(1, shop.getName());
			pst.setString(2, shop.getImagePath());
			pst.setInt(3, shop.getSid());
			
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			DBUtil.free(con, pst, null);
		}
	}

	@Override
	public void updateShopContactInfo(ShopContact shopContact) {
		// TODO Auto-generated method stub
		String sql = "update m_shop_contact set info=? where sid=? and type=?";
		Connection con = null;
		PreparedStatement pst = null;
		
		con = DBUtil.createConnection();
		try {
			pst = con.prepareStatement(sql);
			
			pst.setString(1, shopContact.getInfo());
			pst.setInt(2, shopContact.getSid());
			pst.setString(3, shopContact.getType());
			
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			DBUtil.free(con, pst, null);
		}
	}

	@Override
	public void updateMerchantStatus(int mid, String status) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE M_MERCHANT SET STATUS = ? WHERE MID = ?";
		conn = DBUtil.createConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, status);
			pstmt.setInt(2, mid);
			pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.free(conn, pstmt, null);
		}		
	}

}
