package com.pom.logincredentials;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.datadriven.base.BaseClass;

public class AdactinLoginPage extends BaseClass{
public AdactinLoginPage() {
	PageFactory.initElements(driver, this);
}
@FindBy(id="username")
public WebElement user;
@FindBy(id="password")
public WebElement pass;
@FindBy(id="login")
public WebElement login;
@FindBy(xpath="(//table[@class='content']//tbody)[4]//tr[5]//b")
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
