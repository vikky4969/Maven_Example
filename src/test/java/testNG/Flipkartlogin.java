package testNG;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
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

import com.datadriven.base.BaseClass;
import com.pom.logincredentials.FlipkartloginPage;

public class Flipkartlogin extends BaseClass{
	
	FlipkartloginPage fp;
	
	@DataProvider(name="data")
	public Object[][] data() {
		return new Object[][] {{"8667550570","Vikky24740"}};
	}
	@BeforeClass
	@Parameters("browser")
	public void beforeclass(String browser) {
		launchBrowser(browser);
		 fp=new FlipkartloginPage();
	}
	@BeforeMethod
	@Parameters("url")
	public void beforemethod(String url) {
		openurl(url);
		maximize();
		implicitwait(10);
	}
	@Test(dataProvider="data")
public void login1(String username,String password) throws InterruptedException {
	sendkeys(fp.getUser(), username);
	sendkeys(fp.getPass(), password);
	click(fp.getLogin());
	Thread.sleep(10000);
}

	@AfterMethod
	public void aftermethod() {
		String expected="Your username or password is incorrect";
		String actual=fp.getMsg().getText(); 
		System.out.println(actual);
		Assert.assertEquals(actual, expected);
	}
	@AfterClass
	public void afterclass() {
		closeBrowser();
	}

}
