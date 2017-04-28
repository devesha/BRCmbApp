package com.mb.brc.modules;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;

import com.mb.brc.common.UtilFunctions;

public class MyPost
{
	
	public MyPost(AndroidDriver driver) {
		super();
		this.driver = driver;
	    }
	
	private  AndroidDriver driver;
	UtilFunctions util = new UtilFunctions();
	 private static boolean present;
     private static boolean coachmarkpresent;
     private static boolean propData;
     private static boolean reqData;
     
	private String menuClass="android.widget.ImageButton";
	private String myPostMenu_Name="My Posts";
	private String allTab_Name="All";
	private String refreshbtnId="push_top";
	private String propertiesTab_Name="Properties";	
	private String requirementTab_Name="Requirements";
   
	
	   private String boardMenu_Id="icon";
	   private String transTypeId="type";
	   private String companyNameBoardId="company_name";
	 	   private String timePostId="time";
	 	   private String timeDetailId="timestamp";
	 	   private String postedBy_Name="Posted By";
	 	   private String companyNameDetailId="company_name";  
	 	   private String property_Name="Property";
	 
	public void myPost() throws InterruptedException
	{
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
	driver.findElement(By.className(menuClass)).click();
	Thread.sleep(1000);
	driver.findElement(By.name(myPostMenu_Name)).click();
	Thread.sleep(4000);
	try {
		driver.findElement(By.id(refreshbtnId));
	    present = true;
	  
	 } catch (NoSuchElementException e) {
	    present = false;
	    System.out.println("Data not present on My Post");
	 }
   
  if(present == true)
  {
	  
	 util.swypBoard();
	 util.swypBoard();
	 util.swypBoard();
	 driver.findElement(By.name(propertiesTab_Name)).click();
	   try {
			driver.findElement(By.id(refreshbtnId));
			Assert.assertEquals("Sale",driver.findElement(By.id(transTypeId)).getText(),"Requirement coming on Properties Tab");
			propData = true;
		    util.swypBoard();
		 } catch (NoSuchElementException e) {
			 propData = false;
			 System.out.println("Data not present on properties tab");
		 }
	 
	 driver.findElement(By.name(requirementTab_Name)).click();

	   try {
			driver.findElement(By.id(refreshbtnId));
			Assert.assertEquals("Buy",driver.findElement(By.id(transTypeId)).getText(),"Properties coming on Requirement Tab");
			reqData = true;
			 util.swypBoard();
			 driver.findElement(By.name("All")).click();
		 } catch (NoSuchElementException e) {
			 reqData = false;
			 System.out.println("Data not present on requirement tab");
		 }	
		}
	}
	
	
	
	
	public void dataValidation() throws InterruptedException
	   {
		   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    //	String CompanyNameboard = driver.findElement(By.id(companyNameBoardId)).getText();
		 	String timeStampboard = driver.findElement(By.id(timePostId)).getText();
		 	System.out.println(timeStampboard);
		 	driver.findElement(By.id(transTypeId)).click();
		 //	driver.scrollTo("Property");
		 	driver.scrollToExact("Budget");
		 	//util.swypUp();
		 	Thread.sleep(2000);
		 	String timeStampDetail = driver.findElement(By.id(timeDetailId)).getText();
		 	System.out.println(timeStampDetail);
		 //	String companyNameDetail = driver.findElement(By.id(companyNameDetailId)).getText();
		 //	Assert.assertEquals(CompanyNameboard,companyNameDetail,"Mypost and detail data not Matching");
		 	Assert.assertEquals(timeStampboard,timeStampDetail, "Mypost and detail data not Matching");	
	   	
	   }
	    
	     public void MyPostContent() throws InterruptedException 
	     {
	    	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    	 	//All tab data validation
	    	    driver.navigate().back();
	    	 	driver.findElement(By.className(menuClass)).click();
	    	    Thread.sleep(5000);
	    	    driver.findElement(By.name(myPostMenu_Name)).click();
	    		 Thread.sleep(4000);
	    	 	util.swypBoard();
	    	 	util.swypBoard();
	    	 	//util.swypBoard();
	    	 	this.dataValidation();
	    	 	driver.navigate().back();
	    	 //	driver.findElement(By.className(menuClass)).click();
	    	 	
	    	   //Properties tab data validation
	    	 	//driver.findElement(By.className(menuClass)).click();
	    	 	//driver.findElement(By.name(myPostMenu_Name)).click();
	    	 	driver.findElement(By.name(propertiesTab_Name)).click();
	    	 	util.swypBoard();
	    	 	util.swypBoard();
	    	 	util.swypBoard();
	    	 	this.dataValidation();
	    	 	driver.navigate().back();
	    	 //	driver.findElement(By.className(menuClass)).click();
	    	 	
	    	 	//Requirement tab data validation
	    	 	//driver.findElement(By.className(menuClass)).click();
	    	 	//driver.findElement(By.name(myPostMenu_Name)).click();
	    	 	driver.findElement(By.name(requirementTab_Name)).click();
	    	 	util.swypBoard();
	    	 	util.swypBoard();
	    	 	util.swypBoard();
	    	 	this.dataValidation();
	    	 	driver.navigate().back();
	    	 //	driver.findElement(By.className(menuClass)).click();
	    	 	
	     }
	
	
	
}
