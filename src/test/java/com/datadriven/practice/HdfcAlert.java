package com.datadriven.practice;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.datadriven.base.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HdfcAlert extends BaseClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launchBrowser("chrome");
		openurl("https://netbanking.hdfcbank.com/netbanking/?_ga=2.176378149.1819882415.1533883212-608727520.1532670997");
		implicitwait(10);
		maximize();
		switchframe("login_page");
		WebElement button=driver.findElement(By.linkText("CONTINUE"));
		click(button);
		alertAccept();
	}

}
