package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import common.util.DBUtil;
import dao.DishImageDao;

public class DishImageDaoImpl implements DishImageDao {

	@Override
	public void addDishImage(int did, String url) {
		
		String sql = "Insert into M_DISH_IMG (IMG_ID, DID, IMG_PATH) values (M_DISH_IMG_SEQ.NEXTVAL, ?, ?)";
		Connection con = null;
		PreparedStatement pst =null;
		
		
		try {
			con = DBUtil.createConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, did);
			pst.setString(2, url);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.free(con, pst, null);
		}
	}


	
}
