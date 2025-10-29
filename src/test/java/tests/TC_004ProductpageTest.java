package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basic.ProjectBasicMethods;
import pages.CartPage;
import pages.HomePage;

public class TC_004ProductpageTest extends ProjectBasicMethods{

	@BeforeTest
	public void setup(){
		sheetname="SingleLogin";
	}
	
	@Test(dataProvider="readData")
	public void checkProductPage(String username,String password) {
		HomePage homepage=new HomePage(driver);
		homepage.login(username, password);	
		homepage.checkproductPage();
		homepage.sortZtoA();
	}
}
