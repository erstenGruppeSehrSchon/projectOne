package test;

import static org.junit.Assert.*;

import org.junit.Test;

import util.sendJMSRequestUtil;

public class SendJMSTest {

	@Test
	public void test() {
		try {
			sendJMSRequestUtil.sendRegisterRequest(3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
