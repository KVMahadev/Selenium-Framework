package com.learnautomation.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Reporter;

public class ExcelReader {
	
	public static Object[][] getExcelData (String sheet) throws IOException {

		XSSFWorkbook WB = null;
		try {
			WB = new XSSFWorkbook(
					new FileInputStream(new File("D:/Mukesh Selenium_July_2023/SeleniumFramework/Test Data/Test Data.xlsx")));
		} catch (FileNotFoundException e) {
			Reporter.log("LOG INFO : file not found" + e.getMessage());
			// TODO Auto-generated catch block
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Reporter.log("Could not load the file" + e.getMessage());
		}
		int Row = WB.getSheet(sheet).getPhysicalNumberOfRows();
		int Column = WB.getSheet(sheet).getRow(0).getPhysicalNumberOfCells();
		Object arr[][] = new Object[Row][Column];

		for (int i = 0; i < Row; i++) {
			System.out.println("The value of Row "+ i + " is");
			for (int j = 0; j < Column; j++) {
				String Valuestring = null;
				CellType Type = WB.getSheet(sheet).getRow(i).getCell(j).getCellType();
				if (Type == CellType.STRING)
				{
					Valuestring = WB.getSheet(sheet).getRow(i).getCell(j).getStringCellValue();
				} else if (Type == CellType.NUMERIC) 
				{
					Double doubevlaue = WB.getSheet(sheet).getRow(i).getCell(j).getNumericCellValue();
					Valuestring = String.valueOf(doubevlaue);

				} else if (Type == CellType.BOOLEAN)
				{
					Boolean booleanvalue = WB.getSheet(sheet).getRow(i).getCell(j).getBooleanCellValue();
					Valuestring = String.valueOf(booleanvalue);
				} else if (Type == CellType.BLANK)
				{
					Valuestring = "";
				}
				System.out.println("The value of string is " + Valuestring);
				arr[i][j] = Valuestring;
			}
		}
		return arr;
		
	}
}

