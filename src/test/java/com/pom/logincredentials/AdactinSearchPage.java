package com.pom.logincredentials;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.datadriven.base.BaseClass;

public class AdactinSearchPage extends BaseClass{
	public AdactinSearchPage() {
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath="//select[@name='location']")
	private WebElement location;

@FindBy(xpath="//select[@id='hotels']")
private WebElement hotel;

@FindBy(xpath="//select[@id='room_type']")
private WebElement room;

@FindBy(xpath="//select[@id='room_nos']")
private WebElement roomno;

@FindBy(xpath="//select[@id='adult_room']")
private WebElement adults;

@FindBy(xpath="//select[@id='child_room']")
private WebElement children;

@FindBy(xpath="//input[@id='Submit']")
private WebElement searchbtn;

@FindBy(xpath="//input[@id='radiobutton_0']")
private WebElement selectHotel;

@FindBy(xpath="//input[@id='continue']")
private WebElement contbtn;

@FindBy(xpath="//input[@id='first_name']")
private WebElement firstname;

@FindBy(xpath="//input[@id='last_name']")
private WebElement lastname;

@FindBy(xpath="//textarea[@id='address']")
private WebElement address;

@FindBy(xpath="//input[@id='cc_num']")
private WebElement cardno;

@FindBy(xpath="//select[@id='cc_type']")
private WebElement cardtype;

@FindBy(xpath="//select[@id='cc_exp_month']")
private WebElement expdate;

@FindBy(xpath="//select[@id='cc_exp_year']")
private WebElement expyear;

@FindBy(xpath="//input[@id='cc_cvv']")
private WebElement cvvno;

@FindBy(xpath="//input[@id='book_now']")
private WebElement bookbtn;

@FindBy(id="my_itinerary")
private WebElement MyItenary;

@FindBy(xpath="(//input[@class='select_text'])[1]")
private WebElement Order;

@FindBy(xpath="//a[text()='Logout']")
private WebElement getMsg;

public WebElement getGetMsg() {
	return getMsg;
}

public WebElement getMyItenary() {
	return MyItenary;
}

public WebElement getOrder() {
	return Order;
}

public WebElement getFirstname() {
	return firstname;
}

public WebElement getLastname() {
	return lastname;
}

public WebElement getAddress() {
	return address;
}

public WebElement getCardno() {
	return cardno;
}

public WebElement getCardtype() {
	return cardtype;
}

public WebElement getExpdate() {
	return expdate;
}

public WebElement getExpyear() {
	return expyear;
}

public WebElement getCvvno() {
	return cvvno;
}

public WebElement getBookbtn() {
	return bookbtn;
}

public WebElement getSelectHotel() {
	return selectHotel;
}

public WebElement getContbtn() {
	return contbtn;
}

public WebElement getLocation() {
	return location;
}

public WebElement getHotel() {
	return hotel;
}

public WebElement getRoom() {
	return room;
}

public WebElement getRoomno() {
	return roomno;
}

public WebElement getAdults() {
	return adults;
}

public WebElement getChildren() {
	return children;
}

public WebElement getSearchbtn() {
	return searchbtn;
}
}