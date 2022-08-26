package testNG;

import org.testng.Assert;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.datadriven.base.BaseClass;
import com.pom.logincredentials.AdactinLoginPage;
import com.pom.logincredentials.AdactinSearchPage;

public class HotelAdactin extends BaseClass{
	AdactinLoginPage hl;
	 AdactinSearchPage hs;
	 SoftAssert sa=new SoftAssert();

	@DataProvider(name="data")
	public Object[][] data() {
		return new Object[][] {{"Vignesh9694","WW40NP"}};
	}

	@BeforeClass
	@Parameters("browser")
	public void beforeclass(String browser) {
	launchBrowser(browser);
	 hl=new AdactinLoginPage();
	 hs=new AdactinSearchPage();
	}
	
	@BeforeMethod
	@Parameters("url")
	public void beforemethod(String url) {
		openurl(url);
		maximize();
		implicitwait(10);
	}
	
	@Test(dataProvider = "data")
public void login(String username,String password) throws InterruptedException {
		sendkeys(hl.getUser(), username);
		sendkeys(hl.getPass(), password);
		click(hl.getLogin());
}
	@AfterMethod
	public void aftermethod() {
		String expected="Logout";
		String actual=hs.getGetMsg().getText();
		boolean equals=	actual.equals(expected);
		Assert.assertTrue(equals);
		dropdown(hs.getLocation(), 2);
		dropdown(hs.getHotel(), 2);
		dropdown(hs.getRoom(), 2);
		dropdown(hs.getRoomno(), 2);
		dropdown(hs.getAdults(), 2);
		dropdown(hs.getChildren(), 2);
		click(hs.getSearchbtn());
	}
	@AfterClass
	public void afterclass() {
		click(hs.getSelectHotel());
		click(hs.getContbtn());
		sendkeys(hs.getFirstname(), "Vignesh");
		sendkeys(hs.getLastname(), "Kumar");
		sendkeys(hs.getAddress(), "jdngjsngjnsknlnglsn");
		sendkeys(hs.getCardno(), "4569956212165262");
		dropdown(hs.getCardtype(), 2);
		dropdown(hs.getExpdate(), 12);
		dropdown(hs.getExpyear(), 12);
		sendkeys(hs.getCvvno(), "135");
		click(hs.getBookbtn());
	}
	@AfterTest
	public void aftertest() {
		elementbeclickable(10, hs.getMyItenary());
		click(hs.getMyItenary());
		getAttribute(hs.getOrder(), "value");
		closeBrowser();
	}

	}
