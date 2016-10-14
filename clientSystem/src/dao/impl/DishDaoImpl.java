package dao.impl;

import object.Dish;
import object.DishImage;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DishDao;
import util.DBUtil;

public class DishDaoImpl implements DishDao{

	@Override
	public void addDish(Dish d) {
		
		Connection con=null;
		String sql = "insert into M_DISH(DID,NAME,TYPE,PRICE,SID,IS_ACTIVE)values(M_DISH_SEQ,?,?,?,?,?)";
		PreparedStatement pst =null;
		
		
		try {
			con = DBUtil.createConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1,d.getName());
			pst.setString(2, d.getType());
			pst.setDouble(3, d.getPrice());
			pst.setInt(4, d.getMid());
			pst.setInt(5, d.getActive());
			
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.free(con, pst, null);
		}
		
	}

	@Override
	public void updateDish(Dish d) {
		Connection con=null;
		String sql = "update M_DISH set NAME = ?,TYPE = ?,PRICE = ?,SID = ?,IS_ACTIVE = ? where DID = ? ";
		PreparedStatement pst =null;
		
		
		try {
			con = DBUtil.createConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1,d.getName());
			pst.setString(2, d.getType());
			pst.setDouble(3, d.getPrice());
			pst.setInt(4, d.getMid());
			pst.setInt(5, d.getActive());
			pst.setInt(6, d.getId());
			
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.free(con, pst, null);
		}
		
		
	}

	@Override
	public void deleteDish(int id) {
		
		Connection con=null;
		String sql = "delete from M_DISH where DID =?";
		PreparedStatement pst =null;
		
		
		try {
			con = DBUtil.createConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.free(con, pst, null);
		}

		
	}

	@Override
	public Dish loadDish(int id) {
		Connection con=null;
		String sql = "Select * from M_DISH where DID = ?";
		PreparedStatement pst =null;
		ResultSet rs = null;
		Dish d = new Dish();
		
		
		try {
			con = DBUtil.createConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			
			while(rs.next()){
				d.setActive(rs.getInt("IS_ACTIVE"));
			    d.setName(rs.getString("NAME"));
			    d.setType(rs.getString("TYPE"));
			    d.setPrice(rs.getDouble("Price"));
			    d.setMid(rs.getInt("SID"));
			    d.setId(rs.getInt("DID"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.free(con, pst, null);
		}
		return d;
	}

	@Override
	public List<Dish> findAllDish() {
		Connection con=null;
		String sql = "Select * from M_DISH";
		PreparedStatement pst =null;
		ResultSet rs = null;
		List<Dish> DishList = new ArrayList();
		
		
		try {
			con = DBUtil.createConnection();
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while(rs.next()){
				Dish d = new Dish();
				d.setActive(rs.getInt("IS_ACTIVE"));
			    d.setName(rs.getString("NAME"));
			    d.setType(rs.getString("TYPE"));
			    d.setPrice(rs.getDouble("Price"));
			    d.setMid(rs.getInt("SID"));
			    d.setId(rs.getInt("DID"));
			    DishList.add(d);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.free(con, pst, null);
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.free(con, pst, null);
		}
		
	}

	@Override
	public void updateDishImg(DishImage di) {
		Connection con=null;
		String sql = "update M_DISH_IMG set DID = ? , IMG_PATH = ? where IMG_ID = ? ";
		PreparedStatement pst =null;
		
		
		try {
			con = DBUtil.createConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1,di.getDid());
			pst.setString(2, di.getPath());
			pst.setInt(3, di.getImageId());
			
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.free(con, pst, null);
		}
		
	}

	@Override
	public void deleteDishImg(int imgid) {
		Connection con=null;
		String sql = "delete from M_DISH where IMG_ID =?";
		PreparedStatement pst =null;
		
		
		try {
			con = DBUtil.createConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1,di.getDid());
			
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
		String sql = "Select * from M_DISH where IMG_ID = ?";
		PreparedStatement pst =null;
		pst.setInt(1,id);
		ResultSet rs = null;
		DishImage di = new DishImage();
		
		
		try {
			con = DBUtil.createConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			
			while(rs.next()){
				di.setImageId(rs.getInt("IMG_ID"));
			    di.setDid(rs.getString("DID"));
			    di.setPath(rs.getString("IMG_PATH"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.free(con, pst, null);
		}
		return di;
	}

	@Override
	public List<DishImage> findAllDishImage() {
		Connection con=null;
		String sql = "Select * from M_DISH_IMG";
		PreparedStatement pst =null;
		ResultSet rs = null;
		List<DishImage> DishImageList = new ArrayList();
		
		
		try {
			con = DBUtil.createConnection();
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while(rs.next()){
				DishImage di = new DishImage();
				di.setImageId(rs.getInt("IMG_ID"));
			    di.setDid(rs.getString("DID"));
			    di.setPath(rs.getString("IMG_PATH"));
			    DishImageList.add(di);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.free(con, pst, null);
		}
		return DishImageList;
	}

	
	


}