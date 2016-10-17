package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import po.DishImage;
import common.util.DBUtil;
import dao.DishImageDao;

public class DishImageDaoImpl implements DishImageDao {

	@Override
	public ArrayList<DishImage> getDishImageByDid(int did) {
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;

		ArrayList<DishImage> dishImages = new ArrayList<>();
		
		String sql = "SELECT * FROM M_DISH_IMG WHERE DID = ?";

		try {
			conn = DBUtil.createConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, did);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				DishImage dishImage = new DishImage();
				dishImage.setImageId(rs.getInt("IMG_ID"));
				dishImage.setDid(Integer.parseInt(rs.getString("DID")));
				dishImage.setImgPath(rs.getString("IMG_PATH"));
				dishImages.add(dishImage);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.free(conn, pstmt, rs);
		}
		
		return dishImages;
	}

	
	@Override
	public ArrayList<DishImage> findAllDishImage() {
		Connection conn = null;
		PreparedStatement pst =null;
		ResultSet rs = null;
		
		ArrayList<DishImage> DishImageList = new ArrayList<DishImage>();
		
		String sql = "SELECT * FROM M_DISH_IMG";

		try {
			conn = DBUtil.createConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while(rs.next()){
				DishImage dishImage = new DishImage();
				dishImage.setImageId(rs.getInt("IMG_ID"));
			    dishImage.setDid(Integer.parseInt(rs.getString("DID")));
			    dishImage.setImgPath(rs.getString("IMG_PATH"));
			    DishImageList.add(dishImage);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.free(conn, pst, rs);
		}
		
		return DishImageList;
	}


}
