package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutLoginPage extends BasePage {
    @FindBy(xpath = "//*[@id='new-to-asos-tab']")
    private WebElement joinButton;

    @FindBy(xpath = "//div[@id='main']//input[@type='submit']")
    private WebElement continueToCheckoutButton;

    public WebElement getContinueToCheckoutButton() {
        return continueToCheckoutButton;
    }

    public CheckoutLoginPage(WebDriver driver) {
        super(driver);
    }
    public WebElement getJoinButton() {
        return joinButton;
    }
    public void clickJoinButton() {
        joinButton.click();
    }
    public void clickContinueToCheckoutButton() {
        continueToCheckoutButton.click();
    }
}
