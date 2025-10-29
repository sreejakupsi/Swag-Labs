package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;

import basic.ProjectBasicMethods;

public class LoginPage extends ProjectBasicMethods {

	WebDriver driver;
	
	@FindBy(id="user-name")
	WebElement usernameField;
	
	@FindBy(id="password")
	WebElement passwordField;
	
	@FindBy(id="login-button")
	WebElement loginBtn;
	
	@FindBy(css = "h3[data-test='error']")
	WebElement ErrorMsg;

	
	
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	

	
	public void LoginDetails(String userName,String password) {
		usernameField.sendKeys(userName);
		passwordField.sendKeys(password);
		loginBtn.click();
	}
	
	
	
	public String getValidationMsg() {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ErrorMsg));
		return ErrorMsg.getText();
	}
	
	public void invalidLogin(String testType, String expectedText) {
		if(testType.equalsIgnoreCase("Invalid password")) {
			String actualText=getValidationMsg();
			System.out.println("ActualTest: "+ actualText);
			Assert.assertEquals(actualText,expectedText);
		}
		
		else if(testType.equalsIgnoreCase("Invalid username")) {
			String actualText=getValidationMsg();
			System.out.println("ActualTest: "+ actualText);
			Assert.assertEquals(actualText,expectedText);
		}
		
		else if(testType.equalsIgnoreCase("Invalid password and username")) {
			String actualText=getValidationMsg();
			System.out.println("ActualTest: "+ actualText);
			Assert.assertEquals(actualText,expectedText);
		}
		
	}
}
