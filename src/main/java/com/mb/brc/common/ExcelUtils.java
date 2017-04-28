package com.mb.brc.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelUtils {

	private static XSSFRow Row = null;
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	static FormulaEvaluator evaluator;
	private static String errorMessage = "", fatalMessage = "        ";

	// This method is to set the File path and to open the Excel file
	// Pass Excel Path and SheetName as Arguments to this method
	public static void setExcelFile(String Path, String SheetName) throws Exception {
		try {
			if (Path.contains("Blank") || SheetName.contains("Blank")) {
				fatalMessage = "File Location/SheetName not found. Please provide File Location or Sheet Name";
				
				IOException e = new IOException();
				throw e;
			}

			FileInputStream ExcelFile;
			ExcelFile = new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			evaluator = ExcelWBook.getCreationHelper().createFormulaEvaluator();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			fatalMessage = "Not able to open File: " + Path + ": " + e.toString();
			
			return;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			fatalMessage = "Error in opening file: " + Path + e.toString();
			
			return;
		} catch (java.lang.NullPointerException e) {
			// TODO Auto-generated catch block
			fatalMessage = "Error in opening file: " + Path + e.toString();
			
			return;
		}
	}

	// This method is to read the test data from the Excel cell
	// In this we are passing parameters/arguments as Row Num and Col Num
	public static String getCellData(int RowNum, int ColNum) throws Exception {
		// CellValue CellValue = null;
		String CellData = "Blank";
		Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
		if (Cell == null) {
			// java.lang.NullPointerException e = null;

		} else {
			if (Cell.getCellType() == org.apache.poi.ss.usermodel.Cell.CELL_TYPE_FORMULA) {
				evaluator.evaluateFormulaCell(Cell);

				if (Cell.getCachedFormulaResultType() == org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC) {
					if (DateUtil.isCellDateFormatted(Cell)) {
						java.util.Date date = Cell.getDateCellValue();
						//SimpleDateFormat sdf = new SimpleDateFormat(Constant.dataformate);
						//CellData = sdf.format(date);
					} else {
						CellData = String.valueOf(Cell.getNumericCellValue());
					}
				} else if (Cell.getCachedFormulaResultType() == org.apache.poi.ss.usermodel.Cell.CELL_TYPE_BOOLEAN) {
					CellData = String.valueOf(Cell.getBooleanCellValue());
					// System.out.println(CellData);
					// System.out.println(Cell.getBooleanCellValue());
				} else {
					CellData = Cell.getStringCellValue();
				}
			} else if (Cell.getCellType() == org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC) {
				CellData = String.valueOf(Cell.getNumericCellValue());

			} else if (Cell.getCellType() == org.apache.poi.ss.usermodel.Cell.CELL_TYPE_BOOLEAN) {
				CellData = String.valueOf(Cell.getBooleanCellValue());
			} else {
				CellData = Cell.getStringCellValue();
			}

		}
		if (CellData.isEmpty()) {
			CellData = "Blank";

		}
		// System.out.println(CellData);
		return CellData;
	}

	// This method is use to write value in the excel sheet
	// This method accepts four arguments (Result, Row Number, Column Number &
	// Sheet Name)

	@SuppressWarnings({ "static-access" })
	public static void setCellData(String Result, int RowNum, int ColNum, String Path, String SheetName)
			throws Exception {
		try {
			FileInputStream ExcelFile = new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			Row = ExcelWSheet.getRow(RowNum);
			Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
			if (Cell == null) {
				Cell = Row.createCell(ColNum);
				// Cell.setCellValue(Result);
				Cell.setCellValue(Result);
			} else {

				Cell.setCellValue(Result);
			}
			// Constant variables Test Data path and Test Data file name
			FileOutputStream fileOut = new FileOutputStream(Path);
			ExcelWBook.write(fileOut);
			// fileOut.flush();
			fileOut.close();
			ExcelFile.close();
			ExcelWBook = new XSSFWorkbook(new FileInputStream(Path));
		} catch (Exception e) {

		}
	}

	
	public static int getRowCount(String sheetName) throws Exception {
		int iNumber = 0;
		try {
			ExcelWSheet = ExcelWBook.getSheet(sheetName);
			iNumber = ExcelWSheet.getLastRowNum() + 1;
		} catch (Exception e) {
			errorMessage = "Class Utils | Method getRowCount | Exception desc : " + e.getMessage();
		
		}
		return iNumber;
	}

	
	public static String[][] getExcelData(String path, String sheetName){
		String [][] arrayExcelData= null;
		int [] Rows;
		int [] Columns;
		
		int totalRows;
		int totalColumns;
		
		try{
			
			FileInputStream ExcelFile;
			ExcelFile = new FileInputStream(path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(sheetName);
			
			
			Columns = ExcelWSheet.getColumnBreaks();
			Rows = ExcelWSheet.getRowBreaks();
			
			
			
		}
		catch(IOException e){
			
		}
		
		
		
		return arrayExcelData;	
		
	}
	

	
	
}
