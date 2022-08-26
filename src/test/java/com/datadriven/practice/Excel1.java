package com.datadriven.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel1 {
	public static ArrayList<LinkedHashMap<String, String>> al;

	public static void ReadExcel() throws IOException {
		// TODO Auto-generated method stub
		al=new ArrayList<LinkedHashMap<String, String>>();
		FileInputStream file=new FileInputStream("C:\\Users\\SATHISH\\eclipse-workspace\\mavenExample\\src\\test\\resources\\Data\\testdata.xlsx");
		Workbook excel=new XSSFWorkbook(file);
		Sheet sheet=excel.getSheet("Sheet3");
		Row row1=sheet.getRow(0);
		ArrayList<String> header=new ArrayList<String>();
		for (int i = 0; i < row1.getPhysicalNumberOfCells(); i++) {
			header.add(row1.getCell(i).toString());
		}
		for (int i = 1; i <sheet.getPhysicalNumberOfRows(); i++) {
			Row rows=sheet.getRow(i);
			LinkedHashMap<String, String> hm=new LinkedHashMap<String,String>();
			for (int j = 0; j <rows.getPhysicalNumberOfCells(); j++) {
				Cell cells=rows.getCell(j);
				String type=cells.getCellType().toString();
				if(type.equals("STRING")) {
					String value=cells.getStringCellValue();
					hm.put(header.get(j), value);
				}
				else if (DateUtil.isCellDateFormatted(cells)) {
					Date form=	cells.getDateCellValue();
					SimpleDateFormat date=new SimpleDateFormat("dd-MM-yyyy");
					String value=date.format(form);
					hm.put(header.get(j), value);
				}
				else {
					double mobile=cells.getNumericCellValue();
					long value=(long) mobile;
					hm.put(header.get(j), String.valueOf(value));
				}
			}
			al.add(hm);
		}
		System.out.println(al);
		//System.out.println(al.get(0).get("LastName"));
	}

}
