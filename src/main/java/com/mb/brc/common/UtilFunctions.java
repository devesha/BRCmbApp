package com.mb.brc.common;



import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.Dimension;

import com.mb.brc.tests.launch;

public class UtilFunctions extends launch {
	
	
	public Properties loadPropertiesFile(){
		
		
		 Properties prop = new Properties();
		 InputStream input = null;
		 try {
			input = new FileInputStream("TestData.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	  
		 try {
			prop.load(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return prop;
	}

	public void uploadImage(String filePath) throws AWTException, InterruptedException{
		  Thread.sleep(3000);
		  StringSelection ss= new StringSelection(filePath);
		  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);

		  Robot robot = new Robot();

		  robot.keyPress(KeyEvent.VK_CONTROL);
		  robot.keyPress(KeyEvent.VK_V);
		  robot.keyRelease(KeyEvent.VK_V);
		  robot.keyRelease(KeyEvent.VK_CONTROL);
		  robot.keyPress(KeyEvent.VK_ENTER);
		  robot.keyRelease(KeyEvent.VK_ENTER);
		  
		  Thread.sleep(3000);
	}
	
	    public void swypBoard() throws InterruptedException {
        Dimension size;
        size = driver.manage().window().getSize();
        int starty = (int) (size.height * 0.75);
        int endy = (int) (size.height * 0.25);
        int startx = size.width / 2;
        Thread.sleep(1000);
        driver.swipe(startx, starty, startx, endy, 3000);
        Thread.sleep(1000);
  }

	    public void swypUp() throws InterruptedException {
	        Dimension size;
	        size = driver.manage().window().getSize();
	        int starty = (int) (size.height * 0.20);
	        int endy = (int) (size.height * 0.80);
	        int startx = size.width / 2;
	        Thread.sleep(1000);
	        driver.swipe(startx, starty, startx, endy, 3000);  
	        Thread.sleep(1000);
	  }
	
}
