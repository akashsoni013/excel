package com.excel.read;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static List<Map<String, String>> readDataMap(String filePath, String sheetName, String testName)
			throws IOException {

		List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
		Workbook workbook;
		Sheet sheet;
		Row keyRow, row;
		Cell cell, keyCell, valueCell;
		String curTestName, key, value;
		int lastRowNumber, lastColNumber;
		try {
			FileInputStream fileInputStream = new FileInputStream(filePath);

			workbook = new XSSFWorkbook(fileInputStream);
			sheet = workbook.getSheet(sheetName);
			lastRowNumber = sheet.getLastRowNum();

			for (int rows = 0; rows < lastRowNumber; rows++) {
				keyRow = sheet.getRow(0);
				row = sheet.getRow(rows + 1);
				cell = row.getCell(0);
				curTestName = cell.getStringCellValue().trim();
				lastColNumber = keyRow.getLastCellNum();

				if (curTestName.equals(testName)) {
					Map<String, String> data = new HashMap<String, String>();
					for (int i = 0; i < lastColNumber; i++) {
						keyCell = keyRow.getCell(i);
						key = keyCell.getStringCellValue().trim();
						valueCell = row.getCell(i);

						// This will take all data as String
						DataFormatter dataFormatter = new DataFormatter();
						value = dataFormatter.formatCellValue(valueCell);
						data.put(key, value);
					}
					dataList.add(data);
				}
			}
			workbook.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataList;
	}

	public static List<Map<String, Object>> readExcelData(String filePath, String sheetName, String testName)
			throws IOException {

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Workbook workbook;
		Sheet sheet;
		int lastRowNumber, lastColNumber;
		Row row, keyRow;
		Cell cell, keyCell, valueCell;
		String curTestName;
		CellType cellType;

		workbook = new XSSFWorkbook(filePath);
		sheet = workbook.getSheet(sheetName);
		lastRowNumber = sheet.getLastRowNum();

		for (int rows = 0; rows < lastRowNumber; rows++) {
			keyRow = sheet.getRow(0);
			row = sheet.getRow(rows + 1);
			lastColNumber = keyRow.getPhysicalNumberOfCells();
			cell = row.getCell(0);
			curTestName = cell.getStringCellValue().trim();

			if (curTestName.equals(testName)) {
				Map<String, Object> data = new HashMap<String, Object>();

				for (int i = 0; i < lastColNumber; i++) {
					keyCell = keyRow.getCell(i);
					valueCell = row.getCell(i);

					cellType = valueCell.getCellType();
//					switch (Cell.CELL) {
//					case NUMERIC:
//						double value = valueCell.getNumericCellValue();

				}

			}
		}
//		workbook.close();
		return list;
	}

	public static Map<String, String> readDataMap() throws IOException {
		Map<String, String> data = new HashMap<String, String>();
		try {
			FileInputStream fileInputStream = new FileInputStream("./Book1.xlsx");
			Workbook workbook = new XSSFWorkbook(fileInputStream);
			Sheet sheet = workbook.getSheetAt(0);
			int lastRowNumber = sheet.getLastRowNum();
			for (int i = 0; i <= lastRowNumber; i++) {
				Row row = sheet.getRow(i);
				Cell keyCell = row.getCell(0);
				String key = keyCell.getStringCellValue().trim();
				Cell valueCell = row.getCell(1);
				String value = valueCell.getStringCellValue().trim();
				data.put(key, value);
			}
			workbook.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
}
