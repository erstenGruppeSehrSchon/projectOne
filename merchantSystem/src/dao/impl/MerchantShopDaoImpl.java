package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.po.Shop;
import common.po.ShopContact;
import util.DBUtil;
import dao.MerchantShopDao;

public class MerchantShopDaoImpl implements MerchantShopDao {

	@Override
	public int addShop(Shop shop) {
		String sql = "insert into M_SHOP(SID, MID, NAME, DESCRIPTION, IMG_PATH) values (M_SHOP_SEQ.nextval, ?, ?, ?, ?)";
		String sqlQuery = "select sid from M_SHOP where rowid=(select max(rowid) from M_SHOP)";
		String sqlContact = "insert into m_shop_contact(cid,sid, type, info) values(m_shop_contact_seq.nextval,?,?,?)";
		Connection con = null;
		PreparedStatement pstShop = null;
		PreparedStatement pstQuery = null;
		PreparedStatement pstContact = null;
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
		    pstContact = con.prepareStatement(sqlContact);
		    pst.add(pstContact);
		    
			pstShop.setInt(1, shop.getMid());
			pstShop.setString(2, shop.getName());
			pstShop.setString(3, shop.getDescr());
			
			// set wrong value first, update after image upload
			pstShop.setString(4, "/ergtfre");
			sid = pstShop.executeUpdate();
			
			rs = pstQuery.executeQuery();
			if(rs.next()){
				sid = rs.getInt("sid");
			}
			
			for(ShopContact contact: shop.getShopContactList()){
				pstContact.setInt(1, sid);
				pstContact.setString(2, contact.getType());
				pstContact.setString(3, contact.getInfo());
				pstContact.executeUpdate();
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
	
	@Override
	public boolean updateShopImage(String s, int sid, int mid){
		String sql = "update m_shop set img_path=? where sid=? and mid=?";
		Connection con = null;
		PreparedStatement pst = null;
		
		con = DBUtil.createConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, s);
			pst.setInt(2, sid);
			pst.setInt(3, mid);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally{
			DBUtil.free(con, pst, null);
			return true;
		}
	}

}
