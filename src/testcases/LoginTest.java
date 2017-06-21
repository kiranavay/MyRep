package testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import extent.ExtentManager;

public class LoginTest {

	ExtentReports rep=ExtentManager.getInstance();
	ExtentTest test;
	
	@AfterMethod
	public void aftermethod(){
		System.out.println("XXXXXX");
		rep.endTest(test);
		rep.flush();
		
	}
	@Test(dataProvider="getData")
	public void doLoginTest(String username, String password, String expRes, String browser){
		
		test=rep.startTest("Login Test");
		test.log(LogStatus.INFO, "Start login test "+username);
		
		System.out.println(username+" "+password);
		
		test.log(LogStatus.INFO, "End login test");
	}
	
	@DataProvider//(parallel=true)
	public Object[][] getData(){
		Object[][] data=new Object[3][4];
		
		//1st row
		data[0][0]="U1";
		data[0][1]="P1";
		data[0][2]="pass";
		data[0][3]="FireFox";
		
		//2nd row
		data[1][0]="U2";
		data[1][1]="P2";
		data[1][2]="pass";
		data[1][3]="chrome";
		
		//3rd row
		data[2][0]="U3";
		data[2][1]="P3";
		data[2][2]="fail";
		data[2][3]="safar";
		
		return data; 
	}
}
