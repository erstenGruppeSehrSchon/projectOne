package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Captcha;

public class ShowCaptchaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L; 

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Captcha captcha = new Captcha();
        String captchaStrting = captcha.getCertPic(0, 0, response.getOutputStream());
        request.getSession().setAttribute("captchaStrting", captchaStrting);   
	}

}
