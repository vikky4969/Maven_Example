package com.datadriven.practice;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.datadriven.base.BaseClass;
import com.pom.logincredentials.FlipkartloginPage;
import com.pom.logincredentials.RedbusLoginPage;

public class RedbusLogin extends BaseClass{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Excel1.ReadExcel();
		launchBrowser("chrome");
		openurl("https://www.redbus.in/ ");
		implicitwait(20);
		maximize();
		RedbusLoginPage lp=new RedbusLoginPage();
		click(lp.getIcon());
		click(lp.getSignin());
		switchframe(lp.getFrame1());
		sendkeys(lp.getUser(), Excel1.al.get(0).get("Username"));
		switchframe(lp.getFrame2());
		lp.getCheckbox().click();
		Switchparentframe();
		elementbeclickable(40, lp.getOtp());
		click(lp.getOtp());
	}

}
