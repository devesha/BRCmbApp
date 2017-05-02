package com.mb.brc.modules;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOError;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;


public class MyTransformer  implements IAnnotationTransformer{

	@Override
	public void transform(ITestAnnotation annotation, Class testClass,
			Constructor testConstructor, Method testMethod) {
 
		System.out.println("inside listener");
		
		String automationSuiteFilePath = System.getProperty("user.dir")+"\\DataSheet";
		System.out.println(System.getProperty("user.dir"));
	    String automationSuiteFileName = "automationsuite.xls";
	    
		File file = new File(automationSuiteFilePath +"\\" + automationSuiteFileName);
		File file1 = new File("D:/Development/workspace/brcmbapp/DataSheet/automationsuite.xls");
		try{
		FileInputStream inputStream1 = new FileInputStream(file1);
		Workbook workbook = new HSSFWorkbook(inputStream1);
		Sheet workSheet = workbook.getSheet("Sheet1");
		int noOfTestCases = workSheet.getLastRowNum() - workSheet.getFirstRowNum();
		System.out.println("noOfTestCases : "+noOfTestCases);
		for(int i = 1 ; i<=noOfTestCases ; i++ ){
			String testCaseFlag = workSheet.getRow(i).getCell(1).getStringCellValue();
			String testCaseName = workSheet.getRow(i).getCell(0).getStringCellValue();
			if (testCaseFlag.equalsIgnoreCase("No")){
				System.out.println("testcasename : " + testMethod.getName());
				String methodName = testMethod.getName();
				if(testCaseName.equalsIgnoreCase(methodName)){
					System.out.println("testcasename : " + testMethod.getName());
					annotation.setEnabled(false);
					
				}
				
			}
		}
		
		}
		catch(FileNotFoundException e){
			System.out.println(e);
		}
		catch(IOException e ){
			System.out.println(e);
		}	
	}
	

	
	
	
}
