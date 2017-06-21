package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import extent.ExtentManager;


public class RegTest {
	
	ExtentReports rep=ExtentManager.getInstance();
	ExtentTest test;
	
	SoftAssert softassert=new SoftAssert();
	@Test
	public void doRegisterTest(){
		
		test=rep.startTest("Reg Test");
		test.log(LogStatus.INFO,"start the test" );
		String exptectedTitle="jdjfg";
		String atualTitle="fhdj";
		System.out.println("A");
		test.log(LogStatus.INFO,"Executing Asssertions/validation" );
		//Assert.assertEquals(atualTitle, exptectedTitle);
		//Assert.fail("Error Message"); //if we want directly fail the test case
		softassert.assertEquals(atualTitle, exptectedTitle);
		softassert.assertEquals("A","B");
		System.out.println("B");
		
		//Assert.assertTrue(2>1, "Error Message");
	//	Assert.assertTrue(isElementPresent("locator"), "Element not found");
		
		//if critical error ---- stop/report failure     here we use Assert class
		// if not critical error ---- report failure  -- and continue        here we use SoftAssert class
		try{
			softassert.assertAll();
		}catch (Throwable t) {
			test.log(LogStatus.FAIL,"The Test fail"+t.getMessage());
			Assert.fail(t.getMessage());
		}
		
		//test.log(LogStatus.PASS,"The Test passed" );
		
		//mandatory below two lines
		
	}
	
	@AfterMethod
	public void Quit(){
		rep.endTest(test);
		rep.flush();
	}
}
