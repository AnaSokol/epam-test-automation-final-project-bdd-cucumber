package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingBagPage extends BasePage {

    @FindBy(xpath = "//h2[@class='bag-title bag-title--items']")
    private WebElement shoppingBagTitle;

    @FindBy(xpath = "//h2[@class='empty-bag-title']")
    private WebElement emptyBagTitle;

    @FindBy(xpath = "//div[@class='bag-secondary-content-wrapper']//a[contains(@class,'button--checkout')]")
    private WebElement checkoutButton;

    @FindBy(xpath = "//button[@class='bag-item-remove']")
    private WebElement removeProductButton;

    @FindBy(xpath = "//*[@id='bagApp']//bag-item-product")
    private WebElement shoppingBagItem;

    public ShoppingBagPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getShoppingBagItem() {
        return shoppingBagItem;
    }

    public WebElement getCheckoutButton() {
        return checkoutButton;
    }
    public WebElement getEmptyBagTitle() {
        return emptyBagTitle;
    }
    public String getEmptyBagTitleText() {
        return emptyBagTitle.getText();
    }

    public WebElement getShoppingBagTitle() {
        return shoppingBagTitle;
    }

    public String getShoppingBagTitleText() {
        return shoppingBagTitle.getText();
    }

    public boolean isShoppingBagTitleVisible() {
        return shoppingBagTitle.isDisplayed();
    }

    public boolean isCheckoutButtonVisible() {
        return checkoutButton.isDisplayed();
    }

    public boolean isShoppingBagItemVisible() {
        return shoppingBagItem.isDisplayed();
    }

    public void clickCheckoutButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkoutButton);
    }

    public void clickRemoveProductButton() {
        removeProductButton.click();
    }
}
