package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {
    @FindBy(xpath = "//input[@id='emailAddress']")
    private WebElement emailField;

    public WebElement getEmailField() {
        return emailField;
    }

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement addMyEmailButton;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    public void openCheckoutPage(String url) {
        driver.get(url);
    }

    public boolean isEmailFieldVisible(){
        return emailField.isDisplayed();
    }

    public void clickAddMyEmailButton() {
        addMyEmailButton.click();
    }

}