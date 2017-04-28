package com.mb.brc.tests;

import java.net.MalformedURLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.reports.utils.Utils;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

import com.mb.brc.common.DatabaseAccessObject;
import com.mb.brc.common.UtilFunctions;
import com.mb.brc.modules.PostPropertyRequirement;
import com.mb.brc.modules.loginAndRegistration;
import com.mb.brc.modules.Board;
import com.mb.brc.modules.MyPost;

import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;


@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
	  MethodListener.class })
public class LoginAndRegistrationTest extends launch{
	
	
	public static String funcToExcecute;
	public static boolean testStatus;
	 launch launch = new launch();
	 loginAndRegistration login=null;
	 PostPropertyRequirement ppr=null;
	 Board brd=null;
	 MyPost mp=null;
	 UtilFunctions util = new UtilFunctions();
	 Properties prop = new Properties();
	 DatabaseAccessObject dbObj = new DatabaseAccessObject(); 
	 String mobileNumber ="9891699692";
	
	//****************Test cases*********************************************************
	  // Step 1: Login
	  // Step 2: Enter OTP
	  
	  // Step 1: Registration
	  // Step 2: Enter OTP
	  
	//***********************************************************************************
	 
	@BeforeMethod
	public void launcha() throws MalformedURLException
	{
		ATUReports.setWebDriver(driver);
		ATUReports.indexPageDescription = "Testing";
	 // launch.LaunchApp();
	//  launch.interstialScreen();
	}
	
	@AfterMethod
	public void aftermethod()
	{
		
		System.out.println("func Executed : " + funcToExcecute);
	}
	
	@Test(priority=1,enabled=true)
	public void interstialScreen()
	{
		ATUReports.setAuthorInfo("Devesh", Utils.getCurrentTime(), "1.0");
		 ATUReports.add("walkthroughNext", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		String nextButtonId = "walkthroughNext";
		
		String getStartedId = "walkthroughGetStarted";
		 ATUReports.add("Pass Step", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
		System.out.println("Test Script Start");
	try {
		Thread.sleep(6000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
		//	WebDriverWait wait = new WebDriverWait(driver, 30);
	  //  wait.until(ExpectedConditions.presenceOfElementLocated(By.id(nextButtonId)));
		driver.findElementById(nextButtonId).click();
		driver.findElementById(nextButtonId).click();
		driver.findElementById(getStartedId).click();
	}	
	
	@Test(priority=2,enabled=true)
	public void login() throws InterruptedException
	{
		
		funcToExcecute="DO login";	
		 ATUReports.add(funcToExcecute, LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	//	prop = util.loadPropertiesFile();
	//	login.login(prop.getProperty("contactNumber"));
		login = new loginAndRegistration(driver);
	    login.login(mobileNumber);
	    ATUReports.add("Pass Step" + funcToExcecute , LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
	    
	}
	
	@Test(priority=3,enabled=false)
	public void  Registration()
	{
		funcToExcecute="DO Registration";
		 ATUReports.add(funcToExcecute, LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		login = new loginAndRegistration(driver);
	    login.Registration();
	    ATUReports.add("Pass Step" + funcToExcecute , LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
	}
	
	@Test(priority=4,enabled=true)
	public void  coachMark()
	{
		funcToExcecute="coachMark";
		 ATUReports.add(funcToExcecute, LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		login = new loginAndRegistration(driver);
	    login.coachmark();
	    ATUReports.add("Pass Step" + funcToExcecute , LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
	}

	@Test(priority=5,enabled=true)
	public void  Board() throws InterruptedException
	{
		funcToExcecute="Board";
		 ATUReports.add(funcToExcecute, LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		brd = new Board(driver);
	    brd.BoardVal();
	    ATUReports.add("Pass Step" + funcToExcecute , LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
	}
	
	@Test(priority=6,enabled=true)
	public void  BoardContent() throws InterruptedException
	{
		funcToExcecute="BoardContent";
		 ATUReports.add(funcToExcecute, LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		brd = new Board(driver);
	    brd.boardContent();
	    ATUReports.add("Pass Step" + funcToExcecute , LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
	}
	@Test(priority=7,enabled=true)
	public void  exclusive() throws InterruptedException
	{
		funcToExcecute="verify exclusive Tag";
		 ATUReports.add(funcToExcecute, LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		brd = new Board(driver);
	    brd.exclusive();
	    ATUReports.add("Pass Step" + funcToExcecute , LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
	}
	@Test(priority=8,enabled=true)
	public void  shorlist() throws InterruptedException
	{
		funcToExcecute="Verify shorlist";
		 ATUReports.add(funcToExcecute, LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		brd = new Board(driver);
	    brd.shorlist();
	    ATUReports.add("Pass Step" + funcToExcecute , LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
	}
	
	
	@Test(priority=9,enabled=true)
	public void  PostPropertyRequirement() throws InterruptedException
	{
		funcToExcecute="post property";
		 ATUReports.add(funcToExcecute, LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		ppr = new PostPropertyRequirement(driver);
		ppr.postProperty();
		ATUReports.add("Pass Step" + funcToExcecute , LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
	    
	}
	
	@Test(priority=10,enabled=true)
	public void  postRequirement() throws InterruptedException
	{
		funcToExcecute="Post Requirment";
		 ATUReports.add(funcToExcecute, LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		ppr = new PostPropertyRequirement(driver);
		ppr.postRequirement();
		ATUReports.add("Pass Step" + funcToExcecute , LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
	    
	}
	
	@Test(priority=11,enabled=true)
	public void  postUpdate() throws InterruptedException
	{
		funcToExcecute="postUpdate";
		 ATUReports.add(funcToExcecute, LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		ppr = new PostPropertyRequirement(driver);
		ppr.postUpdate();
		ATUReports.add("Pass Step" + funcToExcecute , LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
	    
	}
	
	@Test(priority=12,enabled=true)
	public void  MyPost() throws InterruptedException
	{

//		 ATUReports.add("walkthroughNext", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		funcToExcecute="MyPost";
		 ATUReports.add(funcToExcecute, LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		mp = new MyPost(driver);
		mp.myPost();
		 ATUReports.add("Pass Step" + funcToExcecute, LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
	    
	}
	
	@Test(priority=13,enabled=true)
	public void  MyPostContent() throws InterruptedException
	{
		funcToExcecute="MyPostContent";
		 ATUReports.add(funcToExcecute, LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		mp = new MyPost(driver);
		mp.MyPostContent();
		ATUReports.add("Pass Step" + funcToExcecute , LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
	    
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 //Step 9: Check the IsActive value in Database.
/*	  DatabaseAccessObject obj1 = new DatabaseAccessObject(); 
	  Map contactResult = new HashMap();
	  
		try {
			funcToExcecute = "Getting data from database";
			contactResult = obj1.verifyContact(prop.getProperty("userEmailSale"));
			 
			if(contactResult.size()==0){
				Assert.fail("Zero contacts showing in database");
			}
			
			Reporter.log("Number of contacts = "+contactResult.size());
			 // Get a set of the entries
		      Set set = contactResult.entrySet();
		      // Get an iterator
		      Iterator i = set.iterator();
		      // Display elements
		      while(i.hasNext()) {
		         Map.Entry me = (Map.Entry)i.next();
		         int propertyRFNUM = (Integer)me.getKey();
		         String isActive = (String)me.getValue();
		         Reporter.log("Contact RFNUM: "+propertyRFNUM+", ");
		         System.out.println("");
		         Reporter.log("Contact active or not: "+isActive+", ");
		         
		         
		         if(isActive.equalsIgnoreCase("n")){
		        	 Assert.fail("Contact is seen inactive in following property: "+propertyRFNUM);
		         }
		      }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	 }catch(Exception e){
		 testStatus = true;
		 Assert.asserttrue(testStatus, "propertyContactSale test failed in: " +funcToExcecute);
		 
	 }
	finally{
		driver.close();
	}
	*/
	  
 	  
}



