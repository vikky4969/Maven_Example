package com.datadriven.practice;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.datadriven.base.BaseClass;

public class ToolsSqa extends BaseClass{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launchBrowser("chrome");
		openurl("https://demoqa.com/alerts");
		implicitwait(10);
		maximize();
		WebElement alert=driver.findElement(By.id("alertButton"));
		click(alert);
		alertAccept();
		WebElement waitalert=driver.findElement(By.xpath("//button[@id='timerAlertButton']"));
		click(waitalert);
		waitalertPresent(5);
		alertDismiss();
		WebElement confirm=driver.findElement(By.id("confirmButton"));
		click(confirm);
		alertDismiss();
		WebElement prompt=driver.findElement(By.xpath("//button[@id='promtButton']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", prompt);
		alertSendkeys("vignesh");
	}

}
