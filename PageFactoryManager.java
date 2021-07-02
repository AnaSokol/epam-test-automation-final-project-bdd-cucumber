package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public ShoppingBagPage getShoppingBagPage() {
        return new ShoppingBagPage(driver);
    }

    public SearchResultsPage getSearchResultsPage() {
        return new SearchResultsPage(driver);
    }

    public ProductPage getProductPage() {
        return new ProductPage(driver);
    }

    public CheckoutPage getCheckoutPage() {
        return new CheckoutPage(driver);
    }

    public SavedListPage getSavedListPage() { return new SavedListPage(driver); }

    public LoginPage getLoginPage() { return new LoginPage(driver); }

    public CheckoutLoginPage getCheckoutLoginPage() {
        return new CheckoutLoginPage(driver);
    }

    public MyAccountPage getMyAccountPage() { return new MyAccountPage(driver); }

    public GoogleSignInPage getGoogleSignInPage() { return new GoogleSignInPage(driver); }
}
