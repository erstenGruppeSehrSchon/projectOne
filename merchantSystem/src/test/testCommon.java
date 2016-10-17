package test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.junit.Assert;
import org.junit.Test;
import consts.Consts;
import dao.impl.MerchantLoginDaoImpl;
import dao.impl.MerchantRegisterDaoImpl;
import common.po.Shop;
import common.po.MeMerchant;
import util.DBUtil;

public class testCommon {

	@Test
	public void test() {
		Connection con = null;
//		String sql = "insert into user1(id,uname,age) values (user_seq01.nextVal,?,?)";
		PreparedStatement pst = null;
		
		con=DBUtil.createConnection();
		Assert.assertTrue((con !=null));
	}
}
