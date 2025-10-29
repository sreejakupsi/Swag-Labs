
package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import basic.ProjectBasicMethods;
import pages.CartPage;
import pages.HomePage;

public class TC_003CartPageCheck extends ProjectBasicMethods {

    @BeforeTest
    public void setup() {
        sheetname = "CartItems";
    }

    @Test(dataProvider = "readData")
    public void verifyEachProductIndividually(String username, String password, String expectedName, String expectedPrice, String expectedQuantity) {


        // Create object
        CartPage cartPage = new CartPage(driver);
        HomePage homepage= new HomePage(driver);

        // Login
        homepage.login(username, password);
        homepage.sortPriceLowToHigh();

        // Add that product only
        cartPage.addProductToCart(expectedName);

        // Verify product details
        cartPage.cartPageCheck(expectedName, expectedPrice, expectedQuantity);

    }
}

