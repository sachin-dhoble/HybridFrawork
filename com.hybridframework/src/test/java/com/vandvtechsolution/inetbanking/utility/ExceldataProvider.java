package com.vandvtechsolution.inetbanking.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExceldataProvider {

	static XSSFWorkbook wb;

	public ExceldataProvider(String fname) {

		try {
			File fs = new File(fname);
			FileInputStream fins = new FileInputStream(fs);
			wb = new XSSFWorkbook(fins);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getStringCellValue(String sheetname, int row, int cols) {

		return wb.getSheet(sheetname).getRow(1).getCell(0).getStringCellValue();

	}

	public String getStringCellValue(int sheetindex, int row, int cols) {
		return wb.getSheetAt(sheetindex).getRow(1).getCell(0).getStringCellValue();
	}

	public int getNumericCellVelue(String sheetname, int row, int cols) {
		return (int) wb.getSheet(sheetname).getRow(1).getCell(0).getNumericCellValue();
	}

	public int getNumericCellVelue(int sheetindex, int row, int cols) {
		return (int) wb.getSheetAt(sheetindex).getRow(1).getCell(0).getNumericCellValue();
	}

	public Object[][] getExcelTestData(String Sheetname) {

		XSSFSheet sheet = wb.getSheet(Sheetname);
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[rowcount][colcount];

		for (int i = 0; i < rowcount; i++) {
			for (int j = 0; j < colcount; j++)

				data[i][j] = sheet.getRow(j).getCell(j).toString();

		}
		return data;
	}
	

}
