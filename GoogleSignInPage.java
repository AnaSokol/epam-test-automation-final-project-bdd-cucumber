package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleSignInPage extends BasePage{
    public GoogleSignInPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getAsosLoginButton() {
        return asosLoginButton;
    }

    @FindBy(xpath = "//*[@id='headingSubtext']//button[contains(text(),'ASOS')]")
    private WebElement asosLoginButton;

    public WebElement getContinueButton() {
        return continueButton;
    }

    @FindBy(xpath = "//*[@id='identifierNext']")
    private WebElement continueButton;

    public WebElement getEmailField() {
        return emailField;
    }

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailField;

    public boolean isEmailFieldVisible(){
        return emailField.isDisplayed();
    }
}
