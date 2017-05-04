package com.mb.brc.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Listeners;

import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;



public class SetResultPath {
	
	FileInputStream proFile_1,proFile_2;
	File fdeveshConfig,fdeveshReportConfig;
	Properties objProf_1, objProf_2;
	
	public void setResultsPath(String sPaths) throws IOException
	{
		objProf_1 = new Properties();
		fdeveshConfig = new File(System.getProperty("user.dir")+"\\config\\devesh.properties");
		System.out.println(fdeveshConfig);
		proFile_1 = new FileInputStream(fdeveshConfig.getPath());
		objProf_1.load(proFile_1);
		
		if(objProf_1.getProperty("devesh.recording.dir").equals(""))
		{
			objProf_1.setProperty("devesh.recording.dir","\\Reports\\Video\\"+sPaths+"\\");
			
		}
		else
		{
			objProf_1.setProperty("devesh.recording.dir","");
			objProf_1.setProperty("devesh.recording.dir","\\Reports\\Video\\"+sPaths+"\\");
			
		}
		if(objProf_1.getProperty("devesh.ScreenShot.dir").equals(""))
		{
			objProf_1.setProperty("devesh.ScreenShot.dir","\\Reports\\Images\\"+sPaths+"\\");
		}
		else
		{
			objProf_1.setProperty("devesh.ScreenShot.dir","");
			objProf_1.setProperty("devesh.ScreenShot.dir","\\Reports\\Images\\"+sPaths+"\\");
			
		}
		if(objProf_1.getProperty("devesh.Reports").equals(""))
		{
			objProf_1.setProperty("devesh.Reports","\\Reports\\Html\\"+sPaths+"\\");
		}
		else
		{
			objProf_1.setProperty("devesh.Reports","");
			objProf_1.setProperty("devesh.Reports","\\Reports\\Html\\"+sPaths+"\\");
			
		}
		objProf_1.store(new FileOutputStream(fdeveshConfig), null);
		
		objProf_2 = new Properties();
		
		fdeveshReportConfig = new File(System.getProperty("user.dir")+"\\config\\atu.properties"); 
		proFile_2 = new FileInputStream(fdeveshReportConfig.getPath());
		
		objProf_2.load(proFile_2);
		
		if(objProf_2.getProperty("atu.reports.dir").equals(""))
		{
			objProf_2.setProperty("atu.reports.dir","\\Reports\\ATUReports\\"+sPaths+"\\");
		}
		else
		{
			objProf_2.setProperty("atu.reports.dir","");
			objProf_2.setProperty("atu.reports.dir","\\Reports\\ATUReports\\"+sPaths+"\\");
		}
		
		objProf_2.store(new FileOutputStream(fdeveshReportConfig), null);
	}
	public static void main(String []args) throws IOException
	{
		SetResultPath objsetPath = new SetResultPath();
		objsetPath.setResultsPath(args[0]);
		
		
	}

}
