package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import consts.Consts;
import dao.MerchantRegisterDao;
import po.Shop;
import po.MeMerchant;
import util.DBUtil;

public class MerchantRegisterDaoImpl implements MerchantRegisterDao{
	
	@Override
	public int addMerchant(MeMerchant merchant){
		// user_seq01.nextval
		String sqlMerchant = "insert into M_MERCHANT(MID, USERNAME,PASSWORD,NAME,BRITH_DATE,GENDER,STATUS,REG_DATE)"
				+ " values (M_MERCHANT_SEQ.nextval,?,?,?,?,?,?,?)";
		String sqlQuery = "select mid from M_MERCHANT where rowid=(select max(rowid) from M_MERCHANT)";
		String sqlShop = "insert into M_SHOP(SID,MID,NAME,DESCRIPTION,IMG_PATH) values (M_SHOP_SEQ.nextval,?,?,?,?)";
		Connection con = null;
		PreparedStatement pstMerchant = null;
		PreparedStatement pstQuery = null;
		PreparedStatement pstShop = null;
		List<PreparedStatement> pst = new ArrayList<>();
		ResultSet rs= null;
        int mid = -1;
		
		// create connection
		con = DBUtil.createConnection();
		
		// insert record to multiple table, rollback if fail
		try {
	        con.setAutoCommit(false);
	        pstMerchant = con.prepareStatement(sqlMerchant);
	        pst.add(pstMerchant);
	        pstQuery = con.prepareStatement(sqlQuery);
	        pst.add(pstQuery);
	        pstShop = con.prepareStatement(sqlShop);
	        pst.add(pstShop);

	        // insert to m_merchant table
	        pstMerchant.setString(1, merchant.getUserName()); // username
	        pstMerchant.setString(2, merchant.getPassword()); // password
	        pstMerchant.setString(3, merchant.getName()); // name
	        pstMerchant.setDate(4, new java.sql.Date( merchant.getBirth().getTime())); // birth_date
	        pstMerchant.setString(5, merchant.getGender()); // gender
	        pstMerchant.setString(6, merchant.getStatus()); // status
	        pstMerchant.setDate(7, new java.sql.Date(merchant.getRegDate().getTime())); // reg_date
	        pstMerchant.executeUpdate();
	        
			rs = pstQuery.executeQuery();
			if(rs.next()){
				mid = rs.getInt("mid");
			}
	        
	        //insert to m_shop table
	        List<Shop> shops = merchant.getShopList();
	        for(Shop shop: shops ){
	        	pstShop.setInt(1, mid); // mid
		        pstShop.setString(2, shop.getName()); // name
		        pstShop.setString(3, shop.getDescr()); // description
		        pstShop.setString(4, shop.getImagePath()); // img_path
		        pstShop.executeUpdate();
	        }
	        
            // commit when both is executed
            con.commit();
	        
	    } catch (SQLException e ) {
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
	        
	        return mid;
	    }
	}
	
	@Override
	public int addMerchantWithoutShop(MeMerchant merchant){
		// user_seq01.nextval
		String sqlMerchant = "insert into M_MERCHANT(MID, USERNAME,PASSWORD,NAME,BRITH_DATE,GENDER,STATUS,REG_DATE)"
				+ " values (M_MERCHANT_SEQ.nextval,?,?,?,TO_DATE(?, 'YYYY-MM-DD'),?,?,?)";
		String sqlQuery = "select mid from M_MERCHANT where rowid=(select max(rowid) from M_MERCHANT)";
		Connection con = null;
		PreparedStatement pstMerchant = null;
		PreparedStatement pstQuery = null;
		List<PreparedStatement> pst = new ArrayList<>();
		ResultSet rs= null;
		
		int mid = -1;
				
		// create connection
		con = DBUtil.createConnection();
				
		// insert record to multiple table, rollback if fail
		try {
	        con.setAutoCommit(false);
	        pstMerchant = con.prepareStatement(sqlMerchant);
	        pst.add(pstMerchant);
	        pstQuery = con.prepareStatement(sqlQuery);
	        pst.add(pstQuery);
			

			// insert to m_merchant table
	        pstMerchant.setString(1, merchant.getUserName()); // username
	        pstMerchant.setString(2, merchant.getPassword()); // password
	        pstMerchant.setString(3, merchant.getName()); // name
			pstMerchant.setDate(4, new java.sql.Date( merchant.getBirth().getTime())); // birth_date
			pstMerchant.setString(5, merchant.getGender()); // gender
			pstMerchant.setString(6, merchant.getStatus()); // status
			pstMerchant.setDate(7, new java.sql.Date(merchant.getRegDate().getTime())); // reg_date
			pstMerchant.executeUpdate();
			        
			rs = pstQuery.executeQuery();
			if(rs.next()){
				mid = rs.getInt("mid");
			}
			        
		    // commit when both is executed
		    con.commit();
			        
		} catch (SQLException e ) {
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
			return mid;
		}
	}

	@Override
	public MeMerchant searchMerchant(int mid) {
		String sql = "select * from m_merchant where mid =?";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs= null;
		MeMerchant u= null;
		
		con = DBUtil.createConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, mid);
			
			rs = pst.executeQuery();
			
			if(rs.next()){
				u = new MeMerchant();
				u.setMid(rs.getInt("mid"));
				u.setUserName(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setName(rs.getString("name"));
				u.setBirth(rs.getDate("brith_date"));
				u.setGender(rs.getString("gender"));
				u.setStatus(rs.getString("status"));
				u.setRegDate(rs.getDate("reg_date"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			DBUtil.free(con, pst, rs);
		}
		return u;

	}

	
}
