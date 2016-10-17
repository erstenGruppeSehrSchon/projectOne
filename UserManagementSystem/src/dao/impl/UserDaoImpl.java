package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import po.User;
import util.DBUtil;
import dao.UserDao;

public class UserDaoImpl implements UserDao {

	@Override
	public boolean addUser(User user) {
		boolean successful = false;
		String sql = "INSERT INTO USER1 (ID, UNAME, AGE) VALUES (USER_SEQ01.NEXTVAL, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		conn = DBUtil.createConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUname());
			pstmt.setInt(2, user.getAge());
			pstmt.executeUpdate();
			successful = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.free(conn, pstmt);
		}
		return successful;
	}

	@Override
	public boolean updateUser(User user) {
		boolean successful = false;

		String sql = "UPDATE USER1 SET UNAME = ? , AGE = ? WHERE ID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		conn = DBUtil.createConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUname());
			pstmt.setInt(2, user.getAge());
			pstmt.setInt(3, user.getId());
			pstmt.executeUpdate();
			successful = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.free(conn, pstmt);
		}
		return successful;
	}

	@Override
	public boolean deleteUser(int id) {
		boolean successful = false;

		String sql = "DELETE FROM USER1 WHERE ID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		conn = DBUtil.createConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.free(conn, pstmt);
		}
		
		return successful;
	}

	@Override
	public ArrayList<User> getAllUsers() {
		ArrayList<User> users = new ArrayList<>();

		String sql = "SELECT ID, UNAME, AGE FROM USER1";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		conn = DBUtil.createConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt(1));
				user.setUname(rs.getString(2));
				user.setAge(rs.getInt(3));
				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.free(conn, pstmt, rs);
		}
		
		return users;
	}

	@Override
	public User getUser(int id) {
		String sql = "SELECT ID, UNAME, AGE FROM USER1 WHERE ID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		conn = DBUtil.createConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				User user = new User();
				user.setId(rs.getInt(1));
				user.setUname(rs.getString(2));
				user.setAge(rs.getInt(3));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.free(conn, pstmt, rs);
		}
		
		return null;
	}

}
