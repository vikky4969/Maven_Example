package com.datadriven.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//File data=new File(");
		FileInputStream file=new FileInputStream("C:\\Users\\SATHISH\\eclipse-workspace\\mavenExample\\src\\test\\resources\\Data\\testdata.xlsx");
		Workbook excel=new XSSFWorkbook(file);
		Sheet sheet=excel.getSheet("Sheet1");
		int noofRows=sheet.getPhysicalNumberOfRows();
		System.out.println("No.of.rows: "+noofRows);
		Row row=sheet.getRow(0);
		Cell  cell=row.getCell(0);
		//System.out.println(cell);
		int noofcells=row.getPhysicalNumberOfCells();
		System.out.println("No.of.columns: "+noofcells);
		ArrayList<String> name= new ArrayList<String>();
		ArrayList<String> DOB= new ArrayList<String>();
		ArrayList<Long> Mobile= new ArrayList<Long>();
		for (int i = 0; i <sheet.getPhysicalNumberOfRows(); i++) {
			Row rows=sheet.getRow(i);
			for (int j = 0; j <rows.getPhysicalNumberOfCells();j++) {
				Cell cells=rows.getCell(j); 
				String type=  cells.getCellType().toString();
				if(type.equals("STRING")) {
					name.add(cells.getStringCellValue());
				//	System.out.println(name);
				}
				else if(type.equals("NUMERIC")){
					if(DateUtil.isCellDateFormatted(cells)) {
						Date date1=cells.getDateCellValue();
						SimpleDateFormat form=new SimpleDateFormat("dd-MM-yyyy");
						String date=form.format(date1);
					DOB.add(date);
					}
					else {
						double value=cells.getNumericCellValue();
						long number=(long) (value);
						Mobile.add(number);
					}

				}
			} 
		}
System.out.println(name);
System.out.println(DOB);
System.out.println(Mobile);
	}

}
