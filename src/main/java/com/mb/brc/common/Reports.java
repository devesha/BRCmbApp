package com.mb.brc.common;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;




import atu.testng.reports.ATUReports;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;


public class Reports {
	
	
	DataReader objProp = new DataReader();
	ATUTestRecorder recorder;
	public static WebDriver driver;
	Date currentDate = new Date(System.currentTimeMillis());
	
	 {
		 try {
			 File fATUPath = new File(objProp.getProperty("srikanta.ATU.Properties.Path"));
			 
			 String replaceString =(fATUPath.getAbsolutePath().replace("runner", ""));
			 String stempPath = StringEscapeUtils.escapeJava(replaceString.replace("\\\\", "\\"));
			 System.setProperty("atu.reporter.config",stempPath); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void takeScreenShot(WebDriver driver, String snapshotName)
	{
		File objScreenCaptureFile;
		SimpleDateFormat formater;
		File copyFile;
		objProp = new DataReader();
		objScreenCaptureFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		//Storing the image in the local system.
		try {
			formater = new
					SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
			copyFile = new File(objProp.getProperty("srikanta.ScreenShot.dir")+snapshotName+"_"+formater.format(Calendar.getInstance().getTime())+".png");
			String sFilePath = copyFile.getAbsolutePath();
			FileUtils.copyFile(objScreenCaptureFile ,copyFile);
			Reporter.log("<a href=" + sFilePath + " target='_blank' >" + snapshotName + "</a>");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public void writeTestReports(WebDriver driver)
	{
		ATUReports.setWebDriver(driver);
		//ATUReports.setAuthorInfo("srikanta", Utils.getCurrentTime(),"1.0");
		ATUReports.indexPageDescription = "<h3>E.On</h3><br><b>RelianceJio Automation Report</b>";
		
	}
	public ATUTestRecorder setVideoRecorder()
	{
		
		try {
			try {
				createDirectoryIfNotExists(objProp.getProperty("srikanta.recording.dir"));
				recorder = new ATUTestRecorder(objProp.getProperty("srikanta.recording.dir"),objProp.getProperty("srikanta.recording.fileName"),false);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ATUTestRecorderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return recorder;
	}
	
	public ATUTestRecorder startRecorder()
	{
		try {
				recorder = setVideoRecorder();
				recorder.start();
		} catch (ATUTestRecorderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return recorder;
	}
	
	public void stopRecorder()
	{
		try {
				recorder.stop();
		} catch (ATUTestRecorderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createDirectoryIfNotExists(String fDirectoryName)
	{
		File fDirectory = new File(fDirectoryName);
		
		if(!fDirectory.exists())
		{
			fDirectory.mkdirs();
		}
	}

public static void main (String args[]){
	Reports a =new Reports();
	a.writeTestReports(driver);
}

}
