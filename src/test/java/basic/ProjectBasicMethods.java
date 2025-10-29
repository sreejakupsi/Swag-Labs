package basic;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import utils.Utility;

public class ProjectBasicMethods extends Utility {

	@BeforeMethod
	public void launchBrowser() {
		browserLaunch();
	}
	
	@AfterMethod
	public void browserClose() {
		closeBrowser();
	}
	
	@DataProvider(name="readData")
	public String[][]readData() throws IOException{
		System.out.println("Reading data from sheet: "+sheetname);
		return readExcel(sheetname);
	}
	
}
