package com.mb.brc.tests;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class launch {
	
	 public static AndroidDriver driver;
	
	@BeforeSuite
	public void LaunchApp() throws MalformedURLException
	
	{
		
		try
		{
		File appDir = new File( "D:\\Development\\Build");
        File app = new File( appDir, "BRC_debug_live.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities .setCapability(CapabilityType. BROWSER_NAME, "");
        capabilities .setCapability("platformName" , "Android" );
        capabilities .setCapability("deviceName" ,"Sparkle V" );
        capabilities .setCapability("platformVersion" , "6.0.1" );
        capabilities .setCapability("app" , app .getAbsolutePath());
        capabilities .setCapability("appPackage" , "com.timesgroup.brokerconnectmagicbricks" );
        capabilities .setCapability("appActivity" ,"com.timesgroup.brokerconnectmagicbricks.Activities.SplashScreen" );
        driver = new AndroidDriver( new URL( "http://127.0.0.1:4723/wd/hub" ),capabilities );	
        System.setProperty("atu.reporter.config", System.getProperty("user.dir")+"\\config\\atu.properties");
		}
		
		catch(Exception e)
		{
	    e.printStackTrace();
		}
	}	
			
}



