package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import po.Dish;
import po.DishImage;
import util.DBUtil;
import dao.DishImageDao;
import dao.MerchantDishDao;

public class MerchantDishDaoImpl implements MerchantDishDao{

	@Override
	public void updatedish(Dish dish) {
		String sql = "Update M_DISH set DID = ?, NAME = ?, TYPE = ?, PRICE = ?, SID = ?, IS_ACTIVE = ? ";
		Connection con = null;
		PreparedStatement pst =null;
		
		
		try {
			con = DBUtil.createConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, dish.getDid());
			pst.setString(2, dish.getName());
			pst.setString(3, dish.getType());
			pst.setDouble(4, dish.getPrice());
			pst.setInt(5, dish.getSid());
			pst.setInt(6, dish.getActive());
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.free(con, pst, null);
		}
		
	}
	

	@Override
	public void adddish(Dish dish) {
		String sql = "Insert into M_DISH(DID,NAME,TYPE,PRICE,SID,IS_ACTIVE)values(M_DISH_SEQ,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement pst =null;
		
		
		try {
			con = DBUtil.createConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, dish.getName());
			pst.setString(2, dish.getType());
			pst.setDouble(3, dish.getPrice());
			pst.setInt(4, dish.getSid());
			pst.setInt(5, dish.getActive());
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.free(con, pst, null);
		}
		
	}

	@Override
	public void deletedish(int did) {
		
		String sql = "DELETE FROM M_DISH WHERE DID = ? ";
		Connection con = null;
		PreparedStatement pst =null;
		
		
		try {
			con = DBUtil.createConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, did);


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.free(con, pst, null);
		}
		
		
	}

	@Override
	public Dish getDishByDid(int id) {
		String sql = "SELECT * FROM M_DISH WHERE DID = ?";

		Connection con = null;
		PreparedStatement pst =null;
		ResultSet rs = null;
		Dish dish = null;
		
		try {
			con = DBUtil.createConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			
			if (rs.next()){
				dish = new Dish();
				dish.setActive(rs.getInt("IS_ACTIVE"));
			    dish.setName(rs.getString("NAME"));
			    dish.setType(rs.getString("TYPE"));
			    dish.setPrice(rs.getDouble("Price"));
			    dish.setSid(rs.getInt("SID"));
			    dish.setDid(rs.getInt("DID"));
			    
			    // Get dish images
			    DishImageDao di = new DishImageDaoImpl();
			    ArrayList<DishImage> dishImages = di.getDishImageByDid(dish.getDid());
			    dish.setDishImages(dishImages);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.free(con, pst, rs);
		}
		
		return dish;
	}

	@Override
	public ArrayList<Dish> getDishBySid(int sid) {

		Connection con=null;
		PreparedStatement pst =null;
		ResultSet rs = null;
		
		ArrayList<Dish> dishList = new ArrayList<Dish>();

		String sql = "SELECT * FROM M_DISH WHERE SID = ?";
		
		try {
			con = DBUtil.createConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, sid);
			rs = pst.executeQuery();
			
			while (rs.next()) {
				Dish dish = new Dish();
				dish.setActive(rs.getInt("IS_ACTIVE"));
			    dish.setName(rs.getString("NAME"));
			    dish.setType(rs.getString("TYPE"));
			    dish.setPrice(rs.getDouble("Price"));
			    dish.setSid(rs.getInt("SID"));
			    dish.setDid(rs.getInt("DID"));
			    
			    // Get dish images
			    DishImageDao di = new DishImageDaoImpl();
			    ArrayList<DishImage> dishImages = di.getDishImageByDid(dish.getDid());
			    dish.setDishImages(dishImages);
			    
			    // Add to list
			    dishList.add(dish);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.free(con, pst, rs);
		}
		
		return dishList;	
	}
	
	@Override
	public ArrayList<Dish> findAllDish() {
		
		Connection con=null;

		String sql = "SELECT * FROM M_DISH";
		PreparedStatement pst =null;
		ResultSet rs = null;
		ArrayList<Dish> dishList = new ArrayList<Dish>();
		
		try {
			con = DBUtil.createConnection();
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while(rs.next()){
				Dish dish = new Dish();
				dish.setActive(rs.getInt("IS_ACTIVE"));
			    dish.setName(rs.getString("NAME"));
			    dish.setType(rs.getString("TYPE"));
			    dish.setPrice(rs.getDouble("Price"));
			    dish.setSid(rs.getInt("SID"));
			    dish.setDid(rs.getInt("DID"));
			    
			    // Get dish images
			    DishImageDao di = new DishImageDaoImpl();
			    ArrayList<DishImage> dishImages = di.getDishImageByDid(dish.getDid());
			    dish.setDishImages(dishImages);
			    
			    // Add to list
			    dishList.add(dish);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.free(con, pst, rs);
		}
		
		return dishList;
	}

}
