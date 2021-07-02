package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//header//div[@id='chrome-sticky-header']")
    private WebElement header;

    @FindBy(xpath = "//footer")
    private WebElement footer;

    @FindBy(xpath = ".//a[@data-testid='miniBagIcon']")
    private WebElement miniBagIcon;

    @FindBy(xpath = "//*[@id='chrome-sticky-header']//span[@type='heartPrideFilled']")
    private WebElement wishListIconFilled;

    @FindBy(xpath = "//*[@id='chrome-sticky-header']//span[@type='heartUnfilled']")
    private WebElement wishListIcon;

    @FindBy(xpath = ".//button[@data-testid='myAccountIcon']")
    private WebElement myAccountButton;

    @FindBy(xpath = "//div[@id='myaccount-dropdown']")
    private WebElement myAccountDropdown;

    @FindBy(xpath = ".//a[@data-testid='signin-link']")
    private WebElement signInButton;

    @FindBy(xpath = ".//a[@data-testid='signup-link']")
    private WebElement joinButton;

    @FindBy(xpath = "//a[@data-testid='asoslogo']")
    private WebElement storeLogo;

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchField;

    @FindBy(xpath = "//button[@data-testid='search-button-inline']")
    private WebElement searchButton;

    @FindBy (xpath = "//button[contains(text(), 'Accept')]")
    private WebElement cookiesAcceptButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public WebElement getWishListIcon() {
        return wishListIcon;
    }

    public WebElement getSignInButton() {
        return signInButton;
    }

    public WebElement getMyAccountDropdown() {
        return myAccountDropdown;
    }

    public void isHeaderVisible() {
        header.isDisplayed();
    }

    public void isFooterVisible() {
        footer.isDisplayed();
    }

    public void isLogoVisible() {
        storeLogo.isDisplayed();
    }

    public void isShoppingBagIconVisible() {
        miniBagIcon.isDisplayed();
    }

    public boolean isWishListIconVisible() {
        return wishListIcon.isDisplayed();
    }

    public void isMyAccountButtonVisible() {
        myAccountButton.isDisplayed();
    }

    public void moveToMyAccountButton() {
        Actions actions = new Actions (driver);
        actions.moveToElement(myAccountButton);
    }

    public void isJoinButtonVisible() {
        joinButton.isDisplayed();
    }

    public void isSignInButtonVisible() {
        signInButton.isDisplayed();
    }

    public void clickSignInButton() {
        Actions actions = new Actions (driver);
        actions.moveToElement(myAccountButton);
        signInButton.click();
    }

    public void isSearchFieldVisible() {
        searchField.isDisplayed();
    }

    public void clickCookiesAcceptButton () {
        cookiesAcceptButton.click();
    }

    public void clickMiniBagIcon() {
        miniBagIcon.click();
    }

    public void enterTextToSearchField(final String searchText) {
        searchField.clear();
        searchField.sendKeys(searchText);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void clickWishListIcon() {
        wishListIcon.click();
    }

}
