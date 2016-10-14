package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import consts.Consts;
import dao.MerchantRegisterDao;
import object.merchant.MeMerchant;
import object.merchant.Merchant;
import util.DBUtil;

public class MerchantRegisterDaoImpl implements MerchantRegisterDao{
	
	@Override
	public int addMerchant(MeMerchant merchant){
		// user_seq01.nextval
//		String sqlMerchant = "insert into M_MERCHANT(MID,USERNAME,PASSWORD,NAME,BRITH_DATE,GENDER,STATUS,REG_DATE)"
//				+ " values (xxxxxxxxxx,?,?,?,?,?,?,?,?)";
//		String sqlShop = "insert into M_SHOP(SID,MID,NAME,DESCRIPTION,IMG_PATH) values (xxxxxxxxxx,xxxxxxxxxxxx,?,?,?)";
//		Connection con = null;
//		PreparedStatement pstMerchant = null;
//		PreparedStatement pstShop = null;
//		
//		// create connection
//		con = DBUtil.createConnection();
//		
//		// insert record to multiple table, rollback if fail
//		try {
//	        con.setAutoCommit(false);
//	        pstMerchant = con.prepareStatement(sqlMerchant);
//	        pstShop = con.prepareStatement(sqlShop);
//
//	        // insert to m_merchant table
//	        												// mid
//	        pstMerchant.setString(1, merchant.getUserName()); // username
//	        pstMerchant.setString(2, merchant.getPassword()); // password
//	        pstMerchant.setString(3, merchant.getName()); // name
//	        pstMerchant.setDate(4, new java.sql.Date(merchant.getBirth_date().getTime())); // birth_date
//	        pstMerchant.setString(5, merchant.getGender()); // gender
//	        pstMerchant.setInt(6, Consts.PENDING); // status
//	        pstMerchant.setDate(7, new java.sql.Date(merchant.getReg_date().getTime())); // reg_date
//	        pstMerchant.executeUpdate();
//	        
//	        //insert to m_shop table
//	        List<Shop> shops = merchant.getShop();
//	        for(Shop shop: shops ){
//												        	// sid
//												        	// mid
//		        pstShop.setString(1, shop.getName()); // name
//		        pstShop.setString(2, shop.getDescription()); // description
//		        pstShop.setString(3, shop.getImg_path()); // img_path
//		        pstShop.executeUpdate();
//	        }
//	        
//            // commit when both is executed
//            con.commit();
//	        
//	    } catch (SQLException e ) {
//	        System.err.println(e.getMessage());
//	        if (con != null) {
//	            try {
//	                System.err.print("Transaction is being rolled back");
//	                con.rollback();
//	            } catch(SQLException excep) {
//	            	System.err.println(e.getMessage());
//	            }
//	        }
//	    } finally {
//	        if (pstMerchant != null) {
//	        	pstMerchant.close();
//	        }
//	        if (pstShop != null) {
//	        	pstShop.close();
//	        }
//	        
//	        con.setAutoCommit(true);
//	        
//	        // free all connection
//	        DBUtil.free(con, pst, null);
//	    }
		
		return 0;

	}
}
