package com.mb.brc.modules;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

import com.mb.brc.common.DatabaseAccessObject;
import com.mb.brc.common.UtilFunctions;

public class loginAndRegistration {
	
	
	 private  AndroidDriver driver;
	 private static String otp=null;
	 DatabaseAccessObject obj1=null;
	 private static boolean present;
     private static boolean coachmarkpresent;
     
     UtilFunctions util = new UtilFunctions();
     
	 //****************Locators******************************************************
		private String enterMobileID = "mobilenumber";
		private String signinButtonId="signinbutton";
		private String RegisterNowID="registernow";
		private String selectEmailXpath="neerajk177@gmail.com";
		private String proceedId="proceed";
		private String enterVerificationCodeID="otpEdittext";
		private String submitOtpID="join";
		
		private String enterNameId="register_edit_name";
		private String enterMobileNumberId="register_edit_number";
		private String emailId="register_edit_email";
		private String companyNameId="register_edit_company";
		private String dealInSaleId="register_cbx_sale";
		private String dealInRentId="register_cbx_rent";
		private String dealInResidential="register_cbx_residential";
		private String dealInCommercial="register_cbx_commercial";
		private String enterCityOnRegistrationId="register_edit_city";
		private String citySelectionOnDialogId="edit_register_dialog_city"; // enter city
		private String selectCity_xpath="Andaman & Nicobar"; //select city
		private String selectCity_Id="row_city_text";
		//private String selectCity_xpath="//EditText[contains(@text,'Andaman & Nicobar')]"; //select city
		private String enterLocationOnRegistrationId="register_edit_location"; // open locality selection
		private String enterLocalityProjectDetailID="autocompletetext";
		//private String selectLocality_xpath="//EditText[contains(@text,'magic city, Long Island, Andaman & Nicobar')]";
		private String doneCitySelection_ID="tv_location_cancel";
		private String selectLocality_xpath="magic city, Long Island, Andaman & Nicobar";
		private String registrationSubmitBtnId="register_button";
		private String reqIcon_id="req_icon";
		private String propIcon_Id="property";
		private String textLoginScrId="message";
		  
	  //********************************************************************************
	
	public loginAndRegistration(AndroidDriver driver) {
			super();
			this.driver = driver;
		    }
		
	public void login(String mobileNumber) throws InterruptedException
{
		 ATUReports.add("Login", LogAs.INFO, new CaptureScreen(
					ScreenshotOf.BROWSER_PAGE));	
	try
	{
	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);		
	 //WebDriverWait wait = new WebDriverWait(driver, 30);
	 //wait.until(ExpectedConditions.presenceOfElementLocated(By.id(enterMobileID)));
	 System.out.println("mobile number" + mobileNumber);
	 ATUReports.add("Enter mobile Number on mobile field", LogAs.INFO, new CaptureScreen(
				ScreenshotOf.BROWSER_PAGE));
	 driver.findElement(By.id(enterMobileID)).sendKeys(mobileNumber);
	 ATUReports.add("Pass Step", LogAs.PASSED, new CaptureScreen(
				ScreenshotOf.DESKTOP));
	 ATUReports.add("hideKeyboard", LogAs.INFO, new CaptureScreen(
				ScreenshotOf.BROWSER_PAGE));
	 driver.hideKeyboard();
	 ATUReports.add("Pass Step", LogAs.PASSED, new CaptureScreen(
				ScreenshotOf.DESKTOP));
	 driver.findElement(By.id(signinButtonId)).click();
	
	 try {
		driver.findElement(By.id(proceedId));
	    present = true;
	 } catch (NoSuchElementException e) {
	    present = false;
	 }
	 if(present == true)
	 {	 
	 driver.findElement(By.name(selectEmailXpath)).click();;
	 driver.findElement(By.id(proceedId)).click();
	 }else
	 {
		System.out.println("Single id mapped"); 
	 }	
		Thread.sleep(3000); 
		 ATUReports.add("Check whether Mobile number contain", LogAs.INFO, new CaptureScreen(
					ScreenshotOf.BROWSER_PAGE));
		String compareText = driver.findElement(By.id(textLoginScrId)).getText();
		if(compareText.contains(mobileNumber))
		{
			ATUReports.add("Pass Step", LogAs.PASSED, new CaptureScreen(
					ScreenshotOf.DESKTOP));
		}else
		{
			ATUReports.add("Check whether Mobile number contain : Fail", LogAs.FAILED, new CaptureScreen(
					ScreenshotOf.DESKTOP));
		}
		obj1=new DatabaseAccessObject();
		otp = obj1.getOtp(mobileNumber);
		System.out.println("OTP:" + otp);
				
	 driver.findElement(By.id(enterVerificationCodeID)).sendKeys(otp);
	 driver.hideKeyboard();
	 driver.findElement(By.id(submitOtpID)).click();
	 
	 } 
	catch (SQLException e) {
	e.printStackTrace();
	}
	
}
	
	public void Registration() 
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id(RegisterNowID)).click();
		driver.findElement(By.id(enterNameId)).sendKeys("Ramesh");
		driver.findElement(By.id(enterMobileNumberId)).sendKeys("2342342341");
		driver.findElement(By.id(emailId)).sendKeys("testsanity1@mailinator.com");
		driver.findElement(By.id(companyNameId)).sendKeys("MB");
		driver.hideKeyboard();
		driver.findElement(By.id(dealInSaleId)).click();
		driver.findElement(By.id(dealInResidential)).click();
		driver.findElement(By.id(enterCityOnRegistrationId)).click();
		driver.findElement(By.id(citySelectionOnDialogId)).sendKeys("Andaman & Nicobar");
		//driver.findElement(By.id(selectCity_Id)).click();
		driver.findElement(By.xpath("//android.widget.TextView[@index='0']")).click();
		driver.hideKeyboard();
		driver.findElement(By.id(enterLocationOnRegistrationId)).click();
		driver.findElement(By.id(enterLocalityProjectDetailID)).sendKeys("Magic city");
		driver.findElement(By.xpath("//android.widget.TextView[@index='0']")).click();
		driver.findElement(By.id(doneCitySelection_ID)).click();
		//driver.hideKeyboard();
		driver.scrollTo("Register");
		//driver.findElement(By.name(selectLocality_xpath)).click();
		driver.findElement(By.id(registrationSubmitBtnId)).click();
				
	}
	
  public void coachmark()
  {
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  try {
			driver.findElement(By.id(reqIcon_id));
			coachmarkpresent = true;
		 } catch (NoSuchElementException e) {
			 coachmarkpresent = false;
		    System.out.println("coachmark not appeared ");
		 }
	    
	  if(coachmarkpresent == true)
	  {
		  driver.findElement(By.id(reqIcon_id)).click();  
	  }
  }

   
     
     

}
