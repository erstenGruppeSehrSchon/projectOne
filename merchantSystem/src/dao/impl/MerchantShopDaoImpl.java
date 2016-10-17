package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.po.Shop;
import util.DBUtil;
import dao.MerchantShopDao;

public class MerchantShopDaoImpl implements MerchantShopDao {

	@Override
	public int addShop(Shop shop) {
		String sql = "insert into M_SHOP(SID, MID, NAME, DESCRIPTION, IMG_PATH) values (M_SHOP_SEQ.nextval, ?, ?, ?, ?)";
		String sqlQuery = "select sid from M_SHOP where rowid=(select max(rowid) from M_SHOP)";
		Connection con = null;
		PreparedStatement pstShop = null;
		PreparedStatement pstQuery = null;
		List<PreparedStatement> pst = new ArrayList<>();
		ResultSet rs= null;
		int sid = 0;
		
		con = DBUtil.createConnection();
		
		try {
			con.setAutoCommit(false);
					
			pstShop = con.prepareStatement(sql);
			pst.add(pstShop);
			pstQuery = con.prepareStatement(sqlQuery);
		    pst.add(pstQuery);
		    
			pstShop.setInt(1, shop.getMid());
			pstShop.setString(2, shop.getName());
			pstShop.setString(3, shop.getDescr());
			pstShop.setString(4, shop.getImagePath());
			sid = pstShop.executeUpdate();
			
			rs = pstQuery.executeQuery();
			if(rs.next()){
				sid = rs.getInt("sid");
			}
			
			// commit when both is executed
            con.commit();

		} catch (SQLException e) {
			e.printStackTrace();
	        System.err.println(e.getMessage());
	        if (con != null) {
	            try {
	                System.err.print("Transaction is being rolled back");
	                con.rollback();
	            } catch(SQLException excep) {
	            	System.err.println(e.getMessage());
	            }
	        }
		} finally {
			 try {
				con.setAutoCommit(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        // free all connection
	        DBUtil.free(con, pst, rs);
	        
	        return sid;
		}
	}

}
