package com.datadriven.practice;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.datadriven.base.BaseClass;
import com.pom.logincredentials.FlipkartloginPage;

public class Flipkart extends BaseClass {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		Excel1.ReadExcel();
		launchBrowser("chrome");
		openurl("https://www.flipkart.com/ ");
		implicitwait(10);
		maximize();
		FlipkartloginPage lp=new FlipkartloginPage();
		sendkeys(lp.getUser(), Excel1.al.get(0).get("Username"));
		sendkeys(lp.getPass(), Excel1.al.get(0).get("password"));
		lp.getLogin().click();
		Actions ac=new Actions(driver);
		WebElement home1=driver.findElement(By.xpath("(//div[@class='_1mkliO'])[6]"));
		Thread.sleep(6000);
		ac.moveToElement(home1).perform();
		//mousehover(home);
		//WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		//WebElement furniture=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='_3XS_gI _7qr1OC']//a[3]")));
		WebElement furniture1=driver.findElement(By.xpath("//div[@class='_2IjXr8']//div[1]//a[3]"));
		Thread.sleep(6000);
		ac.moveToElement(furniture1).perform();
		//mousehover(furniture);
	}

}
