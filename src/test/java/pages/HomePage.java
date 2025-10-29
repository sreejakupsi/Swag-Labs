package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import basic.ProjectBasicMethods;

public class HomePage extends ProjectBasicMethods {

	WebDriver driver;
	
	
	@FindBy(id="react-burger-menu-btn") WebElement menuIcon;

	@FindBy(className = "header_label") WebElement heading;
	
	@FindBy(id="shopping_cart_container") WebElement cartIcon;
	
	@FindBy(className = "product_sort_container") WebElement filterIcon;
	
	@FindBy(className = "inventory_item_img") WebElement productImage;
	
	@FindBy(className = "inventory_item_name") WebElement productName;
	
	@FindBy(className = "inventory_item_price") WebElement productPrice;
	
	@FindBy(id="add-to-cart-sauce-labs-backpack") WebElement cartBtn;
	
	@FindBy(id = "user-name") WebElement usernameField;
	
    @FindBy(id = "password") WebElement passwordField;
    
    @FindBy(id = "login-button") WebElement loginBtn;
    
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void sortPriceLowToHigh() {
		Select select= new Select(filterIcon);
		select.selectByValue("lohi");
		System.out.println("Sorted by price low to high");
	}
	
	
	
	  public void login(String username, String password) {
	        usernameField.sendKeys(username);
	        passwordField.sendKeys(password);
	        loginBtn.click();
	    }
	  
	public void checkproductPage() {
		if(menuIcon.isDisplayed()) {
			System.out.println("The menu icon is displayed in the product page");
		}
		if(heading.isDisplayed()) {
			System.out.println("The heading is displayed in the product page");
		}
		if(cartIcon.isDisplayed()) {
			System.out.println("The cart icon is displayed in the product page");
		}
		if(filterIcon.isDisplayed()) {
			System.out.println("The filter icon is displayed in the product page");
		}
		if(productImage.isDisplayed()) {
			System.out.println("The product image is displayed in the product page");
		}
		if(productName.isDisplayed()) {
			System.out.println("The product name is displayed in the product page");
		}
		if(productPrice.isDisplayed()) {
			System.out.println("The product price is displayed in the product page");
		}
		if(cartBtn.isDisplayed()) {
			System.out.println("The cart button is displayed in the product page");
		}
	}
	
	public void sortZtoA() {
		Select select= new Select(filterIcon);
		select.selectByValue("za");
		System.out.println("Sorted by Z to A");
		
		
		
		 List<WebElement> productNames = driver.findElements(By.className("inventory_item_name"));
	        List<WebElement> productPrices = driver.findElements(By.className("inventory_item_price"));

	        System.out.println("First 3 product titles after sorting:");
		for(int i=0;i<3 && i<productNames.size();i++) {
			String name = productNames.get(i).getText();
            String price = productPrices.get(i).getText();
            System.out.println((i + 1) + ". " + name + " — " + price);
		}
	}
	
	
	
}
