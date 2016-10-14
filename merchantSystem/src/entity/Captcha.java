package entity;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

public class Captcha {
	
	private char[] mapTable = "0123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM".toCharArray(); 
       
	public String getCertPic(int width, int height, OutputStream os) {
	   
		// Set image size
	    if(width <= 0) {
	        width = 90;            
	    }
	    if(height <= 0) {
	        height = 30;            
	    }
	    
	    // Create background
	    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	    Graphics g = image.getGraphics();
	    g.setColor(new Color(0xDCDCDC));
	    g.fillRect(0, 0, width, height);
	    g.setColor(Color.black);
	    g.drawRect(0, 0, width-1, height-1);
	
	    String outputString = "";
		for(int i=0; i<6; i++) {
		    outputString += mapTable[(int)(mapTable.length * Math.random())];
		} 
	
		// Draw string to image
		g.setColor(Color.black);
		g.setFont(new Font("Atlantic Inline", Font.PLAIN, 18));
		String str = outputString.substring(0, 1);
		g.drawString(str, 8, 17);
		str = outputString.substring(1, 2);
		g.drawString(str, 20, 15);
		str = outputString.substring(2, 3);
		g.drawString(str, 35, 18);  
		str = outputString.substring(3, 4);
		g.drawString(str, 45, 15);
		str = outputString.substring(4, 5);
		g.drawString(str, 55, 14);
		str = outputString.substring(5, 6);
		g.drawString(str, 70, 20);
	
		// Create obstacle
		Random rand = new Random();
		for (int i=0; i<10; i++) {
		    int x = rand.nextInt(width);
		    int y = rand.nextInt(height);
		    g.drawOval(x, y, 1, 1);
		}
		
		g.dispose();  
		try {
		    ImageIO.write(image, "JPEG", os);
		} catch (IOException e) {
			return "";
	    } 
		
	    return outputString;
	}
}
