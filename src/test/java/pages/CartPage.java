package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import basic.ProjectBasicMethods;

public class CartPage extends ProjectBasicMethods {

    WebDriver driver;



    // Product add buttons
    @FindBy(id = "add-to-cart-test.allthethings()-t-shirt-(red)") WebElement addRedTShirt;
    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt") WebElement addBoltTShirt;
    @FindBy(id = "add-to-cart-sauce-labs-onesie") WebElement addOnesie;
    @FindBy(id = "add-to-cart-sauce-labs-bike-light") WebElement addBikeLight;

    //  Cart and verification elements
    @FindBy(id = "shopping_cart_container") WebElement cartIcon;
    @FindBy(className = "inventory_item_name") WebElement cartProductName;
    @FindBy(className = "inventory_item_price") WebElement cartProductPrice;
    @FindBy(className = "cart_quantity") WebElement cartQuantity;
   

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

 

    // Add product based on expected name
    public void addProductToCart(String expectedName) {
        switch (expectedName.trim()) {
            case "Test.allTheThings() T-Shirt (Red)":
                addRedTShirt.click();
                break;
            case "Sauce Labs Bolt T-Shirt":
                addBoltTShirt.click();
                break;
            case "Sauce Labs Onesie":
                addOnesie.click();
                break;
            case "Sauce Labs Bike Light":
                addBikeLight.click();
                break;
            default:
                System.out.println("Product name not recognized: " + expectedName);
        }
        System.out.println("Added product: " + expectedName);
    }

    // Verify the cart item
    public void cartPageCheck(String expectedName, String expectedPrice, String expectedQuantity) {
        cartIcon.click();
        String actualName = cartProductName.getText();
        String actualPrice = cartProductPrice.getText();
        String actualQuantity = cartQuantity.getText();

        System.out.println("Product in cart: " + actualName + " | " + actualPrice + " | " + actualQuantity);

        Assert.assertEquals(actualName, expectedName, " Product name mismatch");
        Assert.assertEquals(actualPrice, expectedPrice, " Product price mismatch");
        Assert.assertEquals(actualQuantity, expectedQuantity, " Product quantity mismatch");

        System.out.println("Verified: " + expectedName);
    }

 
}

