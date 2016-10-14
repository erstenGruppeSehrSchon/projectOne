package test;

import static org.junit.Assert.*;

import org.junit.Test;

import util.SendJMSRequestUtil;

public class SendJMSTest {

	@Test
	public void test() {
		try {
			SendJMSRequestUtil.sendRegisterRequest(3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
