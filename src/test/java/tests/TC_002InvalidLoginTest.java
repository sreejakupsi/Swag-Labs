package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basic.ProjectBasicMethods;
import pages.LoginPage;

public class TC_002InvalidLoginTest extends ProjectBasicMethods {

	@BeforeTest
	public void setup(){
		sheetname="InvalidLogin";
	}
	
	@Test(dataProvider="readData")
	
	public void inValidLogin(String username,String password,String testType,String expectedText) {
		LoginPage loginpage= new LoginPage(driver);
		loginpage.LoginDetails(username, password);
		loginpage.invalidLogin(testType, expectedText);
	}
}
