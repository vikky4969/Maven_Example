package com.datadriven.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class HotelLogFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<LinkedHashMap<String, String>>al=new ArrayList<LinkedHashMap<String, String>>();
		FileInputStream file=new FileInputStream("C:\\Users\\SATHISH\\eclipse-workspace\\mavenExample\\src\\test\\resources\\Data\\HotelLogs.xlsx");
		Workbook excel=new XSSFWorkbook(file);
		Sheet sheet=excel.getSheet("Sheet1");
		Row row1=sheet.getRow(0);
		ArrayList<String> header=new ArrayList<String>();
		for (int i = 0; i<row1.getPhysicalNumberOfCells(); i++) {
			String cells=row1.getCell(i).toString();
			header.add(cells);
		}
		//System.out.println(header);
		for (int i = 1; i <sheet.getPhysicalNumberOfRows(); i++) {
			Row row=sheet.getRow(i);
			LinkedHashMap<String, String> hm=new LinkedHashMap<String,String>();
			for (int j = 0; j <row.getPhysicalNumberOfCells(); j++) {
				Cell cell=row.getCell(j);
				String type=cell.getCellType().toString();
				if(type.equals("STRING")) {
					String value=cell.getStringCellValue();
					hm.put(header.get(j), value);
				}
				else if(type.equals("NUMERIC")) {
					if(DateUtil.isCellDateFormatted(cell)) {
						Date date=cell.getDateCellValue();
						SimpleDateFormat form=new SimpleDateFormat("dd-MM-yyyy");
						String value=form.format(date);
						hm.put(header.get(j), value);
					}
				else {
					double mobile=cell.getNumericCellValue();
					long value=(long) mobile;
					hm.put(header.get(j),String.valueOf(value));
					}
				}
			}
			al.add(hm);
		}
		System.out.println(al);
	}

}
