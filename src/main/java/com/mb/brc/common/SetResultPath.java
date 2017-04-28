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
	File fsrikantaConfig,fsrikantaReportConfig;
	Properties objProf_1, objProf_2;
	
	public void setResultsPath(String sPaths) throws IOException
	{
		objProf_1 = new Properties();
		fsrikantaConfig = new File(System.getProperty("user.dir")+"\\config\\srikanta.properties");
		System.out.println(fsrikantaConfig);
		proFile_1 = new FileInputStream(fsrikantaConfig.getPath());
		objProf_1.load(proFile_1);
		
		if(objProf_1.getProperty("srikanta.recording.dir").equals(""))
		{
			objProf_1.setProperty("srikanta.recording.dir","\\Reports\\Video\\"+sPaths+"\\");
			
		}
		else
		{
			objProf_1.setProperty("srikanta.recording.dir","");
			objProf_1.setProperty("srikanta.recording.dir","\\Reports\\Video\\"+sPaths+"\\");
			
		}
		if(objProf_1.getProperty("srikanta.ScreenShot.dir").equals(""))
		{
			objProf_1.setProperty("srikanta.ScreenShot.dir","\\Reports\\Images\\"+sPaths+"\\");
		}
		else
		{
			objProf_1.setProperty("srikanta.ScreenShot.dir","");
			objProf_1.setProperty("srikanta.ScreenShot.dir","\\Reports\\Images\\"+sPaths+"\\");
			
		}
		if(objProf_1.getProperty("srikanta.Reports").equals(""))
		{
			objProf_1.setProperty("srikanta.Reports","\\Reports\\Html\\"+sPaths+"\\");
		}
		else
		{
			objProf_1.setProperty("srikanta.Reports","");
			objProf_1.setProperty("srikanta.Reports","\\Reports\\Html\\"+sPaths+"\\");
			
		}
		objProf_1.store(new FileOutputStream(fsrikantaConfig), null);
		
		objProf_2 = new Properties();
		
		fsrikantaReportConfig = new File(System.getProperty("user.dir")+"\\config\\atu.properties"); 
		proFile_2 = new FileInputStream(fsrikantaReportConfig.getPath());
		
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
		
		objProf_2.store(new FileOutputStream(fsrikantaReportConfig), null);
	}
	public static void main(String []args) throws IOException
	{
		SetResultPath objsetPath = new SetResultPath();
		objsetPath.setResultsPath(args[0]);
		
		
	}

}
