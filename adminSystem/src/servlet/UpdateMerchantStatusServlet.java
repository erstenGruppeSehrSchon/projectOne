package servlet;

import java.io.IOException;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

import com.fasterxml.jackson.databind.ObjectMapper;
import common.po.MeMerchant;

import service.MerchantManager;
import service.impl.MerchantManagerImpl;

public class UpdateMerchantStatusServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private final static String PREFIX = "failover://tcp://";
	private final static String HOSTNAME = "cheunan-w7";
	private final static String PORT = "16161";
	private final static String CONNECTION_STR = PREFIX +HOSTNAME + ":" + PORT;
	private final static String QUEUE = "MER_STAT_UPD_Q001";

	private MerchantManager mm = new MerchantManagerImpl();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String status = request.getParameter("status");
		System.out.println("Update id = " + id);
		System.out.println("Update status = " + status);
		if (mm.updateMerchantStatus(status, id)) {
			request.setAttribute("message", "Update successful!");
			sendJMSMerchantStatusUpdate(id, status);
		} else {
			request.setAttribute("message", "Fail to update, pls try again!");
		}
		
		// Forward to ShowOutstanding servlet for getting outstanding merchant list
		request.getRequestDispatcher("ShowOutstanding").forward(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}	

	// Send Merchant Update JMS to Merchant System
	private void sendJMSMerchantStatusUpdate(int id, String status) {
		Connection conn = null;
		Session session = null;
		MessageProducer producer = null;
		
		try {
			ConnectionFactory factory = new ActiveMQConnectionFactory(CONNECTION_STR);
			Destination queue = new ActiveMQQueue(QUEUE);
			conn = factory.createConnection();
			conn.start();
			
			//Message ack mode
			session = conn.createSession(false, Session.CLIENT_ACKNOWLEDGE);
			producer = session.createProducer(queue);
			ObjectMapper mapper = new ObjectMapper();
			MeMerchant m = new MeMerchant();
			m.setMid(id);
			m.setStatus(status);
			String msgStr = mapper.writeValueAsString(m);
			TextMessage msg = session.createTextMessage(msgStr);
			producer.send(msg);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (producer != null) {
					producer.close();
				}
				if (session != null) {
					session.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
