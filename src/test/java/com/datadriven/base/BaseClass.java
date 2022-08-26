package com.datadriven.base;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
public static void launchBrowser(String browser) {
	if(browser.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
}
	else if(browser.equalsIgnoreCase("edge")) {
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		}
	else if(browser.equalsIgnoreCase("firefox")){
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}
	}
public static void openurl(String url) {
	driver.get(url);
}
public static void maximize() {
	driver.manage().window().maximize();
}
public static void implicitwait(int time) {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
}
public static void sendkeys(WebElement element,String value) {
	element.sendKeys(value);
	}
public static void click(WebElement element) {
	element.click();
}
public static void closeBrowser() {
	driver.close();
}
public static void quitBrowser() {
	driver.quit();
}
public static void alertAccept() {
	Alert alert=driver.switchTo().alert();
	String text=alert.getText();
	alert.accept();
	System.out.println(text);
}
public static void alertDismiss() {
	Alert alert=driver.switchTo().alert();
	String text=alert.getText();
	alert.dismiss();
	System.out.println(text);
}
public static void alertSendkeys(String value) {
	Alert alert=driver.switchTo().alert();
	alert.sendKeys(value);
	String text=alert.getText();
	alert.accept();
	System.out.println(text);
}
public static String getText(WebElement element) {
	String value=element.getText();
	System.out.println(value);
	return value;
}
public static String getAttribute(WebElement element,String value) {
	String value1=element.getAttribute(value);
	System.out.println(value1);
	return value1;
}
public static void mousehover(WebElement element) {
	Actions ac=new Actions(driver);
	ac.moveToElement(element).perform();
}
public static void DragandDrop(WebElement src,WebElement dstn) {
	Actions ac=new Actions(driver);
	ac.dragAndDrop(src, dstn).perform();
}
public static String getWindowhandle() {
	String value=driver.getWindowHandle();
	return value;
}
public static Set<String> getWindowhandles() {
	Set<String>	 value=driver.getWindowHandles();
	return value;
}
public static void switchWindow(Set<String> windows,String parent) {
	for (String x : windows) {
		if(!x.equals(parent)) {
			driver.switchTo().window(x);
		}
	}
}
public static void switchframe(int index) {
	driver.switchTo().frame(index);
}
public static void switchframe(String name) {
	driver.switchTo().frame(name);
}
public static void switchframe(WebElement element) {
	driver.switchTo().frame(element);
}
public static void Switchparentframe() {
	driver.switchTo().parentFrame();
}
public static void waitalertPresent(int time) {
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
	wait.until(ExpectedConditions.alertIsPresent());
}
public static void elementbeclickable(int time,WebElement element) {
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
	wait.until(ExpectedConditions.elementToBeClickable(element));
}
public static void dropdown(WebElement element,int index) {
	Select dd=new Select(element);
	dd.selectByIndex(index);
}
}
