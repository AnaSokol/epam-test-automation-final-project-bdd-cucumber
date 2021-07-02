package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(xpath = ".//input[@type='email']")
    private WebElement emailField;

    @FindBy(xpath = ".//input[@type='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@name='FirstName']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@name='LastName']")
    private WebElement lastNameField;

    @FindBy(xpath = ".//input[@type='submit']")
    private WebElement signInButton;

    @FindBy(xpath = "//input[@id='register']")
    private WebElement joinButton;

    @FindBy(xpath = "//div[@class='qa-header'][contains(.,'Sign in')]")
    private WebElement signInHeader;

    @FindBy(xpath = "//div[@class='qa-header'][contains(.,'Join')]")
    private WebElement joinHeader;

    @FindBy(xpath = "//*[@id='signup-google']")
    private WebElement googleButton;

    @FindBy(xpath = "//div[@class='input-wrapper']//*[@id='EmailAddress-error']")
    private WebElement emailWarning;

    @FindBy(xpath = "//div[@class='input-wrapper']//*[@id='Password-error']")
    private WebElement passwordWarning;

    public WebElement getEmailWarning() {
        return emailWarning;
    }

    public WebElement getPasswordWarning() {
        return passwordWarning;
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openLoginPage(String url) {
        driver.get(url);
    }

    public WebElement getLastNameField() {
        return lastNameField;
    }

    public WebElement getFirstNameField() {
        return firstNameField;
    }

    public WebElement getSignInButton() {
        return signInButton;
    }

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }
    public boolean isEmailFieldVisible() {
        return emailField.isDisplayed();
    }

    public boolean isPasswordFieldVisible() {
        return passwordField.isDisplayed();
    }
    public boolean isFirstNameFieldVisible() {
        return firstNameField.isDisplayed();
    }

    public boolean isLastNameFieldVisible() {
        return lastNameField.isDisplayed();
    }

    public boolean isSignInHeaderVisible() {
        return signInHeader.isDisplayed();
    }

    public boolean isJoinHeaderVisible() {
        return joinHeader.isDisplayed();
    }

    public String getSignInHeaderText(){
        return signInHeader.getText();
    }
    public String getJoinHeaderText(){
        return joinHeader.getText();
    }

    public boolean isSignInButtonVisible() {
        return signInButton.isDisplayed();
    }

    public boolean isJoinButtonVisible() {
        return joinButton.isDisplayed();
    }

    public boolean isGoogleButtonVisible() {
        return googleButton.isDisplayed();
    }

    public void clickJoinButton(){
        joinHeader.click();
    }

    public void clickSignInButton(){
        signInButton.click();
    }
    public void clickGoogleButton(){
        googleButton.click();
    }

    public String getEmailWarningText(){
        return emailWarning.getText();
    }

    public String getPasswordWarningText(){
        return passwordWarning.getText();
    }

    public void enterTextToEmailField (final String emailText){
        emailField.clear();
        emailField.sendKeys(emailText);
    }

    public void enterTextToPasswordField (final String passwordText){
        passwordField.clear();
        passwordField.sendKeys(passwordText);
    }

}
