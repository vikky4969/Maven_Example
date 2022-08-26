package testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pom.logincredentials.AdactinLoginPage;

public class TestNgProgram {
	@BeforeClass
	public void beforeclass() {
System.out.println("Before class is executed");
	}
	
	@BeforeMethod
	public void beforemethod() {
		System.out.println("Before method is executed");
	}
	
	@Test
public void def() {
		System.out.println("test case 1 is executed");
}
	@Test
public void abc() {
		System.out.println("test case 2 is executed");

}
	@Test
public void xyz() {
		System.out.println("test case 3 is executed");

}

	@AfterMethod
	public void aftermethod() {
		System.out.println("After method is executed");

	}
	
	@AfterClass
	public void afterclass() {
		System.out.println("After class is executed");
	}
}
