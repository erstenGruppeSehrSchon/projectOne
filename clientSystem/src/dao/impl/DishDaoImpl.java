package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import object.Dish;
import object.DishImage;
import dao.DishDao;
import dao.DishImageDao;
import util.DBUtil;

public class DishDaoImpl implements DishDao{

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
<<<<<<< HEAD
		}finally{
=======
		} finally{
>>>>>>> Client_clientIndex
			DBUtil.free(con, pst, rs);
		}
		
		return dish;
	}

	@Override
	public ArrayList<Dish> getDishByMid(int mid) {

		Connection con=null;
		PreparedStatement pst =null;
		ResultSet rs = null;
		
		ArrayList<Dish> dishList = new ArrayList<Dish>();

		String sql = "SELECT * FROM M_DISH WHERE MID = ?";
		
		
		try {
			con = DBUtil.createConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, mid);
			rs = pst.executeQuery();
			
<<<<<<< HEAD
			while(rs.next()){
				System.out.print("HERE");
				Dish d = new Dish();
				d.setActive(rs.getInt("IS_ACTIVE"));
			    d.setName(rs.getString("NAME"));
			    d.setType(rs.getString("TYPE"));
			    d.setPrice(rs.getDouble("PRICE"));
			    d.setMid(rs.getInt("SID"));
			    d.setId(rs.getInt("DID"));
			    DishList.add(d);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.free(con, pst, rs);
		}
		return DishList;
	}



	@Override
	public void addDishImg(DishImage di) {
		
		Connection con=null;
		String sql = "insert into M_DISH_IMG(IMG_ID,DID,IMG_PATH)values(M_DISH_IMG_SEQ,?,?)";
		PreparedStatement pst =null;
		
		
		try {
			con = DBUtil.createConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1,di.getImageId());
			pst.setString(2, di.getPath());
			
			pst.executeUpdate();
=======
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
>>>>>>> Client_clientIndex
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
<<<<<<< HEAD
		String sql = "delete from M_DISH_IMG where IMG_ID =?";
		PreparedStatement pst =null;
		
		
		try {
			con = DBUtil.createConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1,imgid);
			
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.free(con, pst, null);
		}
		
	}

	@Override
	public DishImage loadDishImage(int id) {
		Connection con=null;
		String sql = "Select * from M_DISH_IMG where IMG_ID = ?";
		PreparedStatement pst =null;
=======
		String sql = "SELECT * FROM M_DISH";
		PreparedStatement pst =null;
>>>>>>> Client_clientIndex
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