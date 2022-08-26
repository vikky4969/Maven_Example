package com.datadriven.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginCredentials {
	
static	List<String> username=new ArrayList<String>();
static	List<String> password=new ArrayList<String>();


	public void raedExcel() throws IOException {
		FileInputStream file=new FileInputStream("C:\\Users\\SATHISH\\eclipse-workspace\\mavenExample\\src\\test\\resources\\Data\\logindata.xlsx");
		Workbook excel=new XSSFWorkbook(file);
		Sheet sheet=excel.getSheet("Sheet1");
		Iterator<Row> rows=sheet.iterator();
		while(rows.hasNext()) {
			Row row=rows.next();
			Iterator<Cell> columns=row.iterator();
			int i=2;
			while(columns.hasNext()) {
				if(i%2==0) {
					username.add(columns.next().getStringCellValue());
				}
				else {
					password.add(columns.next().getStringCellValue());
				}
				i++;
			}
		}
	}

	public void login(String uName,String pwd) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SATHISH\\eclipse-workspace\\SeleniumPractice\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		WebElement username=driver.findElement(By.id("txtUsername"));
		username.sendKeys(uName);
		WebElement password=driver.findElement(By.id("txtPassword"));
		password.sendKeys(pwd);
		WebElement login=driver.findElement(By.id("btnLogin"));
		login.click();
	}
	public void executeTest() {
		for (int i = 0; i <username.size(); i++) {
			login(username.get(i),password.get(i));
		}
	}
	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
		LoginCredentials login=new LoginCredentials();

		login.raedExcel();
		System.out.println(username);
		System.out.println(password);

		login.executeTest();
	}

}
