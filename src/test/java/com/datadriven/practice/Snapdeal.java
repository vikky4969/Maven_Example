package com.datadriven.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.datadriven.base.BaseClass;

public class Snapdeal extends BaseClass{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launchBrowser("chrome");
		openurl("https://www.snapdeal.com/");
		maximize();
		implicitwait(30);
		WebElement womensfashion=driver.findElement(By.xpath("//div[@class='leftNavWrapperRevamp']//ul//li[2]"));
	mousehover(womensfashion);
		WebElement heels=driver.findElement(By.xpath("(//div[@class='colDataInnerBlk'])[4]//p[10]//a"));
	click(heels);
	}

}
