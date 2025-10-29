package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basic.ProjectBasicMethods;
import pages.LoginPage;

public class TC_001ValidLoginTest extends ProjectBasicMethods{

	@BeforeTest
	public void setup(){
		sheetname="ValidLogin";
	}
	
	@Test(dataProvider="readData")
	public void validLogin(String username,String password) {
		LoginPage loginpage=new LoginPage(driver);
		loginpage.LoginDetails(username, password);
	}

}

