package testcases;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;

import extent.ExtentManager;

public class ApplicationTest {
	
	ExtentReports rep=ExtentManager.getInstance();
	
	SoftAssert softassert;

	@BeforeSuite
	public void beforesuite(){
		System.out.println("Before Suite");
	}
	
	@AfterSuite
	public void aftersuite(){		
			System.out.println("After Suite");
		
	}
	
	@BeforeTest
	public void beforeTest(){
		System.out.println("before executing test cases");
	}
	
	@AfterTest
	public void afterTest(){
		System.out.println("after executing test cases");
	}
	
	@Test(priority=1)
	public void doLogin(){
		//webdriver code
		//throw new SkipException("any reason");
		softassert=new SoftAssert();
		softassert.fail("Error Message");
		System.out.println("Login Test Execution");
		softassert.assertAll();
	}
	
	@BeforeMethod
	public void beforemethod(){
		System.out.println("-------Before Method-------");
	}
	
	@AfterMethod
	public void AfterMethod(){
		System.out.println("-------After Method--------");
	}
	
	@Test(priority=2, dependsOnMethods={"doLogin"})
	public void doPasswordChange(){
		//webdriver code
		softassert=new SoftAssert();
		softassert.assertEquals("A", "A");
		System.out.println("Changing password");
		softassert.assertAll();
	}
	
	@Test(priority=3,  dependsOnMethods={"doLogin", "doPasswordChange"})
	public void doLogout(){
		//webdriver code
		System.out.println("logging out");
	}
}
