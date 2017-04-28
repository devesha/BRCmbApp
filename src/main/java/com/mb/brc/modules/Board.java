package com.mb.brc.modules;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import com.mb.brc.common.UtilFunctions;

import io.appium.java_client.android.AndroidDriver;

public class Board {

	public Board(AndroidDriver driver) {
		super();
		this.driver = driver;
	    }
   
	
	private  AndroidDriver driver;
	UtilFunctions util = new UtilFunctions();
	
	 private String allTab_Name="All";
	   private String callButtonId="call";
	   private String propertiesTab_Name="Properties";
	   private String requirementTab_Name="Requirements";
	   
	   private String menuClass="android.widget.ImageButton";
	   private String boardMenu_Id="icon";
	   
	   private String transTypeId="type";
	   private String companyNameBoardId="company_name";
	 	   private String timeBoardId="time";
	 	   private String timeDetailId="timestamp";
	 	   private String postedBy_Name="Posted By";
	 	   private String companyNameDetailId="company_name";
	 	   
	 	  private static boolean present;
	      private static boolean coachmarkpresent;
	      private static boolean propData;
	      private static boolean reqData;
	
	public void BoardVal() throws InterruptedException
	   {
		   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		   try {
				driver.findElement(By.id(callButtonId));
			    present = true;
			  
			 } catch (NoSuchElementException e) {
			    present = false;
			    System.out.println("Data not present on Board");
			 }
		   
		  if(present == true)
		  {
			 util.swypBoard();
			 util.swypBoard();
			 util.swypBoard();
			 driver.findElement(By.name(propertiesTab_Name)).click();
			   try {
					driver.findElement(By.id(callButtonId));
				//	Assert.assertEquals("Sale",driver.findElement(By.id(transTypeId)).getText(),"Requirement coming on Properties Tab");
					propData = true;
				    util.swypBoard();
				 } catch (NoSuchElementException e) {
					 propData = false;
					 System.out.println("Data not present on properties tab");
				 }
			 
			 driver.findElement(By.name(requirementTab_Name)).click();

			   try {
					driver.findElement(By.id(callButtonId));
				//	Assert.assertEquals("Buy",driver.findElement(By.id(transTypeId)).getText(),"Properties coming on Requirement Tab");
					reqData = true;
					 util.swypBoard();
				 } catch (NoSuchElementException e) {
					 reqData = false;
					 System.out.println("Data not present on requirement tab");
				 }
			  
		  }else{
			  System.out.println("Reload board > menu");
			  driver.findElement(By.className(menuClass)).click();
			  driver.findElement(By.id(boardMenu_Id)).click();
			  
		  }
		   
	   }
	   public void dataValidation()
	   {
		   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    	String CompanyNameboard = driver.findElement(By.id(companyNameBoardId)).getText();
		 	String timeStampboard = driver.findElement(By.id(timeBoardId)).getText();
		 	driver.findElement(By.id(transTypeId)).click();
		 	String timeStampDetail = driver.findElement(By.id(timeDetailId)).getText();
		 	driver.scrollTo(postedBy_Name);
		 	String companyNameDetail = driver.findElement(By.id(companyNameDetailId)).getText();
		 	Assert.assertEquals(CompanyNameboard,companyNameDetail,"Board and SRP data not Matching");
		 	Assert.assertEquals(timeStampboard,timeStampDetail, "Board and SRP data not Matching");	
	   	
	   }
	    
	     public void boardContent() throws InterruptedException 
	     {
	    	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    	 	//All tab data validation
	    	    driver.findElement(By.className(menuClass)).click();
	    	 	driver.findElement(By.id(boardMenu_Id)).click();
	    	 	util.swypBoard();
	    	 	util.swypBoard();
	    	 	util.swypBoard();
	    	 	this.dataValidation();
	    	 	driver.findElement(By.className(menuClass)).click();
	    	 	
	    	   //Properties tab data validation
	    	 	driver.findElement(By.className(menuClass)).click();
	    	 	driver.findElement(By.id(boardMenu_Id)).click();
	    	 	driver.findElement(By.name(propertiesTab_Name)).click();
	    	 	  try {
						driver.findElement(By.id(callButtonId));
					//	Assert.assertEquals("Sale",driver.findElement(By.id(transTypeId)).getText(),"Requirement coming on Properties Tab");
						propData = true;
					    //util.swypBoard();
					 } catch (NoSuchElementException e) {
						 propData = false;
						 System.out.println("Content verification: Data not present on properties tab");
					 }
	    	 	if(propData==true)  
	    	 	{
	    	 	util.swypBoard();
	    	 	util.swypBoard();
	    	 	util.swypBoard();
	    	 	this.dataValidation();
	    	 	driver.navigate().back();
	    	 	}
	    	 //	driver.findElement(By.className(menuClass)).click();
	    	 	
	    	 	//Requirement tab data validation
	    	 	driver.findElement(By.className(menuClass)).click();
	    	 	driver.findElement(By.id(boardMenu_Id)).click();
	    	 	driver.findElement(By.name(requirementTab_Name)).click();
	    	 	try {
					driver.findElement(By.id(callButtonId));
				//	Assert.assertEquals("Buy",driver.findElement(By.id(transTypeId)).getText(),"Properties coming on Requirement Tab");
					reqData = true;
					 util.swypBoard();
				 } catch (NoSuchElementException e) {
					 reqData = false;
					 System.out.println("Data not present on requirement tab");
				 }
	    	 	if(reqData==true){
	    	 	util.swypBoard();
	    	 	util.swypBoard();
	    	 	util.swypBoard();
	    	 	this.dataValidation();
	    	 	driver.navigate().back();
	    	 	}
	    	 	//
	    	 //	driver.findElement(By.className(menuClass)).click();
	    	 	
	     }
	
	     private String exclusiveTag_ID="sourceimage";
	     private boolean tagPresent;
	     public void exclusive() throws InterruptedException
	     {
	    	   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    	   try {
	    		   driver.findElement(By.className(menuClass)).click();
		    	 	driver.findElement(By.id(boardMenu_Id)).click();
					driver.findElement(By.id(exclusiveTag_ID));
					tagPresent = true;
				  
				 } catch (NoSuchElementException e) {
					 tagPresent = false;
					 util.swypBoard();
				    System.out.println("Exclusive tag not available");
				 }
			   if(tagPresent == false)
			   { 
				   try {
						driver.findElement(By.id(exclusiveTag_ID));
						tagPresent = true;
					  
					 } catch (NoSuchElementException e) {
						 tagPresent = false;
						 util.swypBoard();
					    System.out.println("Exclusive tag not available");
				}
				   
				   if(tagPresent == false)
				   { 
					   try {
							driver.findElement(By.id(exclusiveTag_ID));
							tagPresent = true;
						  
						 } catch (NoSuchElementException e) {
							 tagPresent = false;
							 util.swypBoard();
						    System.out.println("Exclusive tag not available");
					}
				   
				    
				   
			   }
	    	 
	     }
	     }
	     
	     public void HomeFunc(AndroidDriver driver)
	     {
	    	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    	 driver.findElement(By.className(menuClass)).click();
	  	     driver.findElement(By.id(boardMenu_Id)).click();
	  	     
	     }
	     
	     
	     
	    private String shortlist_ID="short_list";
	    private String shortlistMenu_Name="Shortlists";

	    
	  public void shorlist() throws InterruptedException
	  {
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.findElement(By.className(menuClass)).click();
  	    	driver.findElement(By.id(boardMenu_Id)).click();
		  String timeShort = driver.findElement(By.id(timeBoardId)).getText();
		  driver.findElement(By.id(shortlist_ID)).click();
		  Thread.sleep(3000);
		  driver.findElement(By.className(menuClass)).click();
		  driver.findElement(By.name(shortlistMenu_Name)).click();
		  
		  Assert.assertEquals(timeShort,driver.findElement(By.id(timeBoardId)).getText(),"Shortlist not working");
		  
		  
	  }


}
