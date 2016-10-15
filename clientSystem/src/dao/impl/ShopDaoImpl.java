package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import java.util.List;

import po.Shop;
import util.DBUtil;
import dao.ShopDao;

public class ShopDaoImpl implements ShopDao{

	@Override
	public Shop findShopById(int id) {
		Shop s =null;
		String sql = "select * from M_SHOP WHERE SID = ?";
		String sql2 = "select * from M_SHOP_CONTACT WHERE SID = ?";
		Connection con=null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		con=DBUtil.createConnection();
		s = new Shop();
		try {
			pst=con.prepareStatement(sql);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			if (rs.next()){
				s.setSid(rs.getInt("SID"));
				s.setMid(rs.getInt("MID"));
				s.setName(rs.getString("NANE"));
				s.setImagePath(rs.getString("IMG_PATH"));
				s.setDescr(rs.getString("DESCRIPTION"));
			}
			
		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBUtil.free(con, pst, rs);
		}
		return s;
	}
	

	@Override
	public ArrayList<Shop> findAllShop() {
		ArrayList<Shop> ShopList = new ArrayList<Shop>();
		Shop s =null;
		String sql = "select * from M_SHOP";
		Connection con=null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		con=DBUtil.createConnection();
		
		try {
			pst=con.prepareStatement(sql);
			rs=pst.executeQuery();
			if (rs.next()){
				s = new Shop();
				s.setSid(rs.getInt("SID"));
				s.setMid(rs.getInt("MID"));
				s.setName(rs.getString("NANE"));
				s.setImagePath(rs.getString("IMG_PATH"));
				s.setDescr(rs.getString("DESCRIPTION"));
				ShopList.add(s);
			}
			
		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBUtil.free(con, pst, rs);
		}
		return ShopList;
	}

}
