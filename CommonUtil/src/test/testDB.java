package test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.Assert;
import org.junit.Test;

import util.DBUtil;

public class testDB {

	@Test
	public void testConnection() {
		Connection con = null;
//		String sql = "insert into user1(id,uname,age) values (user_seq01.nextVal,?,?)";
		PreparedStatement pst = null;
		
		con=DBUtil.createConnection();
		Assert.assertTrue((con !=null));
		
	}

}
