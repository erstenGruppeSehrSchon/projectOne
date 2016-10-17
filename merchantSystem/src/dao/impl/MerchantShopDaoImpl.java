package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import po.Shop;
import util.DBUtil;
import dao.MerchantShopDao;

public class MerchantShopDaoImpl implements MerchantShopDao {

	@Override
	public boolean addShop(Shop shop) {
//		String sql = "insert into M_SHOP(SID, MID, NAME, DESCRIPTION, IMG_PATH) values (M_SHOP_SEQ.nextval, ?, ?, ?, ?)";
//		String sqlQuery = "select mid from M_MERCHANT where rowid=(select max(rowid) from M_MERCHANT)";
//		Connection con = null;
//		PreparedStatement pst =null;
//		int result1 = 0;
//		
//		try {
//			con = DBUtil.createConnection();
//			pst = con.prepareStatement(sql);
//			pst.setInt(1, shop.getMid());
//			pst.setString(2, shop.getName());
//			pst.setString(3, shop.getDescr());
//			pst.setString(4, shop.getImagePath());
//			result1 = pst.executeUpdate();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBUtil.free(con, pst, null);
//		}
		return true;
	}

}
