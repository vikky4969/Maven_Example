package com.pom.logincredentials;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.datadriven.base.BaseClass;

public class RedbusLoginPage extends BaseClass{
public RedbusLoginPage() {
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//i[@id='i-icon-profile']")
private WebElement icon;
@FindBy(xpath="//li[@id='signInLink']")
private WebElement signin;
@FindBy(xpath="//iframe[@class='modalIframe']")
private WebElement frame1;
@FindBy(xpath="//div[@class='mobileInput clearfix']//input")
private WebElement user;
@FindBy(xpath="//div[@id='recaptchaElement']//div//div//iframe")
private WebElement frame2;
@FindBy(xpath="(//div[@class='recaptcha-checkbox-border'])[1]")
private WebElement checkbox;
@FindBy(xpath="//div[@class='otpContainer clearfix border-r-3 otp-margin-fix']")
private WebElement otp;

public WebElement getIcon() {
	return icon;
}
public WebElement getSignin() {
	return signin;
}
public WebElement getFrame1() {
	return frame1;
}
public WebElement getUser() {
	return user;
}
public WebElement getFrame2() {
	return frame2;
}
public WebElement getCheckbox() {
	return checkbox;
}
public WebElement getOtp() {
	return otp;
}
}
