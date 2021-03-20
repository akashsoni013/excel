package com.excel.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.excel.read.ExcelUtility;

public class ExcelTest {
	@Test
	public void readData() throws IOException {
//	  System.out.println(ReadExcel.readExcelData("C:\\Users\\akash\\Desktop\\Book1.xlsx","Sheet1", "Test1"));
		System.out.println(ExcelUtility.readDataMap("./Book1.xlsx", "Sheet1", "Test2"));
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		list = ExcelUtility.readDataMap("./Book1.xlsx", "Sheet1", "Test2");
		for (Map<String, String> data : list) {
			System.out.println(data.get("TestName"));
			System.out.println(data.get("FirstName"));
			System.out.println(data.get("LastName"));
			System.out.println(data.get("RollNo."));
			System.out.println(data.get("Marks"));
			System.out.println(data.get("Status"));
		}
	}
}
