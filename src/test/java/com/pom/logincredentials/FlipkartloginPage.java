package com.pom.logincredentials;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.datadriven.base.BaseClass;

public class FlipkartloginPage extends BaseClass {
public FlipkartloginPage() {
	PageFactory.initElements(driver, this);
}
@FindBy(xpath ="//input[@class='_2IX_2- VJZDxU']")
private WebElement user;

@FindBy(xpath ="//input[@class='_2IX_2- _3mctLh VJZDxU']")
private WebElement pass;

@FindBy(xpath ="//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")
private WebElement login;

@FindBy(xpath="(//div[@class='IiD88i _351hSN undefined']//span)[5]")
private WebElement msg;


public WebElement getMsg() {
	return msg;
}
public WebElement getUser() {
	return user;
}
public WebElement getPass() {
	return pass;
}
public WebElement getLogin() {
	return login;
}
}
