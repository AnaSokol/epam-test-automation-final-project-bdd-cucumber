package stepdefinitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {
    private static final long DEFAULT_TIMEOUT = 30;

    WebDriver driver;
    HomePage homePage;
    ShoppingBagPage shoppingBagPage;
    SearchResultsPage searchResultsPage;
    ProductPage productPage;
    CheckoutPage checkoutPage;
    PageFactoryManager pageFactoryManager;
    SavedListPage savedListPage;
    LoginPage loginPage;
    CheckoutLoginPage checkoutLoginPage;
    MyAccountPage myAccountPage;
    GoogleSignInPage googleSignInPage;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @And("User opens {string} page")
    public void openPage(final String url) {
        String homePageUrl = "https://www.asos.com";
        String loginPageUrl = "https://my.asos.com";
        String checkoutPageUrl = "https://secure.asos.com";
        String myAccountPageUrl = "https://my.asos.com/my-account";
        if (url.equals(homePageUrl)) {
            homePage = pageFactoryManager.getHomePage();
            homePage.openHomePage(url);
        }
        else if (url.equals(checkoutPageUrl)){
            checkoutPage = pageFactoryManager.getCheckoutPage();
            checkoutPage.openCheckoutPage(url);
        }
        else if (url.equals(loginPageUrl)){
            loginPage = pageFactoryManager.getLoginPage();
            loginPage.openLoginPage(url);
        }
        else if (url.equals(myAccountPageUrl)){
            myAccountPage = pageFactoryManager.getMyAccountPage();
            myAccountPage.openMyAccountPage(url);
        }
    }

    @And("User closes cookies popup")
    public void userClosesCookiesPopup() {
        homePage.clickCookiesAcceptButton();
    }

    @And("User checks search field visibility")
    public void checkSearchVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.isSearchFieldVisible();
    }

    @When("User makes search by keyword {string}")
    public void enterKeywordToSearchField(final String keyword) {
        homePage.enterTextToSearchField(keyword);
    }

    @And("User clicks search button")
    public void clickSearchButton() {
        homePage.clickSearchButton();
    }

    @And("User clicks wish list on first product")
    public void clickWishList() throws NoSuchElementException {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.clickWishListOnFirstProduct();
    }

    @And("User clicks wish list button")
    public void userClicksWishListButton() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getWishListIcon());
        homePage.clickWishListIcon();
    }

    @Then("User checks that amount of products in wish list are {int}")
    public void checkAmountOfProductsInWishList(final int amountOfProducts) {
        savedListPage = pageFactoryManager.getSavedListPage();
        savedListPage.waitVisibilityOfAllElements(DEFAULT_TIMEOUT, savedListPage.getProductsInSavedList());
        assertEquals(amountOfProducts, savedListPage.getAmountOfProductsInSavedList());
    }

    @And("User checks header visibility")
    public void checkHeaderVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        homePage.isHeaderVisible();
    }

    @And("User checks footer visibility")
    public void checkFooterVisibility() {
        homePage.isFooterVisible();
    }

    @And("User checks shopping bag icon visibility")
    public void checkBagIconVisibility() {
        homePage.isShoppingBagIconVisible();
    }

    @And("User checks logo visibility")
    public void logoVisibility() {
        homePage.isLogoVisible();
    }

    @And("User checks account icon visibility")
    public void accountIconVisibility() {
        homePage.isMyAccountButtonVisible();
    }

    @And("User checks join button visibility")
    public void checkJoinButtonVisibility() {
        homePage.moveToMyAccountButton();
        homePage.isJoinButtonVisible();
    }

    @And("User checks sign in button visibility")
    public void checkSignInButtonVisibility() {
        homePage.moveToMyAccountButton();
        homePage.isSignInButtonVisible();
    }

    @When("User clicks 'Sign In' button")
    public void clickSignInButton() {
        homePage.moveToMyAccountButton();
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getMyAccountDropdown());
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getSignInButton());
        homePage.clickSignInButton();
    }

    @Then("User checks email and password fields visibility on login page")
    public void checkEmailVisibility() {
        loginPage = pageFactoryManager.getLoginPage();
        loginPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(loginPage.isEmailFieldVisible());
        assertTrue(loginPage.isPasswordFieldVisible());
    }

    @And("User opens shopping bag")
    public void openShoppingBag() {
        homePage.clickMiniBagIcon();
        shoppingBagPage = pageFactoryManager.getShoppingBagPage();
        shoppingBagPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        shoppingBagPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        shoppingBagPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, shoppingBagPage.getEmptyBagTitle());
    }




    @And("User checks dropdown 'View Bag' button visibility")
    public void checkViewBagButtonVisibilityInDropdown() {
        productPage.checkViewBagButtonVisibility();
    }

    @And("User checks dropdown 'Checkout' button visibility")
    public void checkCheckoutButtonVisibility() {
        assertTrue(productPage.isCheckoutButtonVisible());
    }

    @And("User checks that add to bag dropdown header is {string}")
    public void checkAddToBagDropdownHeader(final String expectedText) {
        assertEquals(expectedText, productPage.getAddToBagDropdownHeaderText());
    }

    @And("User clicks dropdown 'View Bag' button")
    public void clickViewBagButton() {
        productPage.waitVisibilityOfElement(3, productPage.getDropdownViewBagButton());
        productPage.clickViewBagButton();
    }


    @And("User checks that add to bag dropdown is visible")
    public void checkAddToBagDropdownVisibility() {
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getAddToBagDropdown());
        assertTrue(productPage.isAddToBagDropdownVisible());
    }

    @And("User clicks on first product")
    public void userClicksOnFirstProduct() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        searchResultsPage.clickOnFirstProduct();
    }

    @And("User checks 'Size dropdown' visibility")
    public void checkSizeFieldVisibility() {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.waitForAjaxToCompletePdp(DEFAULT_TIMEOUT);
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getSizeDropdown());
        assertTrue(productPage.isSizeDropdownVisible());
    }

    @And("User clicks on size dropdown menu")
    public void clickOnSizeDropdownMenu() {
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        productPage.waitForAjaxToCompletePdp(DEFAULT_TIMEOUT);
        productPage.clickSizeDropdown();
        productPage.waitVisibilityOfAllElements(DEFAULT_TIMEOUT, productPage.getSizeOptions());
    }

    @And("User selects first size option")
    public void selectFirstSizeOption() {
        productPage.selectFirstSizeOption();
    }

    @And("User clicks 'Add to Bag' button on product")
    public void clickAddToBag() {
        productPage.clickAddToBagButton();
    }

    @And("User checks selected size visibility")
    public void checkSizeVisibility() {
        productPage.isSelectedSizeVisible();
    }

    @And("User checks that shopping bag title is visible")
    public void checkShoppingBagTitleVisibility() {
        assertTrue(shoppingBagPage.getEmptyBagTitle().isDisplayed());
    }

    @Then("User checks that shopping bag page title is {string}")
    public void checkShoppingBagTitle(String expectedResult) {
        shoppingBagPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        shoppingBagPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        assertTrue(shoppingBagPage.isShoppingBagTitleVisible());
        assertTrue(shoppingBagPage.getShoppingBagTitleText().equalsIgnoreCase(expectedResult));
    }

    @And("User checks that product item is visible")
    public void checkProductItemVisibilityInShoppingBag() {
        shoppingBagPage = pageFactoryManager.getShoppingBagPage();
        shoppingBagPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        shoppingBagPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        assertTrue(shoppingBagPage.isShoppingBagItemVisible());
    }

    @And("User checks that checkout button is visible")
    public void userChecksThatCheckoutButtonIsVisible() {
        assertTrue(shoppingBagPage.isCheckoutButtonVisible());
    }

    @And("User clicks dropdown 'Checkout' button")
    public void userClicksCheckoutButton() {
        productPage.waitForAjaxToCompletePdp(DEFAULT_TIMEOUT);
        productPage.clickCheckoutButton();
    }

    @And("User clicks 'Join' button")
    public void clickJoin() {
        checkoutLoginPage = pageFactoryManager.getCheckoutLoginPage();
        checkoutLoginPage.clickJoinButton();
    }

    @And("User clicks 'Continue to checkout' button")
    public void clickContinueToCheckout() {
        checkoutLoginPage.clickContinueToCheckoutButton();
    }

    @And("User checks email field visibility")
    public void checkEmailFieldVisibility() {
        loginPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, loginPage.getEmailField());
        assertTrue(loginPage.isEmailFieldVisible());
    }

    @And("User clicks 'Add my email' button")
    public void clickAddMyEmailButton() {
        checkoutPage.clickAddMyEmailButton();
    }

    @Then("User checks 'Continue to checkout' button is visible")
    public void checkContinueToCheckoutButtonIsVisible() {
        assertTrue(checkoutLoginPage.getContinueToCheckoutButton().isDisplayed());
    }

    @When("User clicks 'Remove' button on the product")
    public void clickRemoveButton() {
        shoppingBagPage.clickRemoveProductButton();
    }

    @And("Shopping bag page is opened")
    public void shoppingBagPageIsOpen() {
        shoppingBagPage = pageFactoryManager.getShoppingBagPage();
    }

    @Then("User checks that title is visible")
    public void checkEmptyBagTitleIsVisible() {
        shoppingBagPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, shoppingBagPage.getEmptyBagTitle());
        assertTrue(shoppingBagPage.getEmptyBagTitle().isDisplayed());
    }

    @And("Product page is opened")
    public void productPageIsOpen() {
        productPage = pageFactoryManager.getProductPage();
    }

    @And("User checks that title is {string}")
    public void checkEmptyBagTitle(String expectedResult) {
        assertTrue(shoppingBagPage.getEmptyBagTitleText().equalsIgnoreCase(expectedResult));
    }

    @And("User checks wish list icon visibility")
    public void checkWishListIconVisibility() {
        assertTrue(homePage.isWishListIconVisible());
    }

    @And("User clicks 'Checkout' button")
    public void clickCheckoutButton() {
        shoppingBagPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, shoppingBagPage.getCheckoutButton());
        shoppingBagPage.clickCheckoutButton();
    }

    @And("User clicks join button")
    public void clickJoinButton() {
        loginPage.clickJoinButton();
    }

    @And("User checks 'Sign in' button visibility")
    public void userChecksSignInButtonVisibility() {
        assertTrue(loginPage.isSignInButtonVisible());
    }

    @And("User checks sign in header visibility")
    public void checkSignInHeaderVisibility() {
        loginPage = pageFactoryManager.getLoginPage();
        loginPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        loginPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        String expectedResult = "sign in";
        assertTrue(loginPage.isSignInHeaderVisible());
        assertTrue(expectedResult.equalsIgnoreCase(loginPage.getSignInHeaderText()));
    }

    @And("User checks join header visibility")
    public void checkJoinHeaderVisibility() {
        String expectedResult = "join";
        loginPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(loginPage.isJoinHeaderVisible());
        assertTrue(expectedResult.equalsIgnoreCase(loginPage.getJoinHeaderText()));
    }

    @And("User checks password field visibility")
    public void checkPasswordFieldVisibility() {
        loginPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, loginPage.getPasswordField());
        assertTrue(loginPage.isPasswordFieldVisible());
    }


    @And("User checks first name field visibility")
    public void checkFirstNameFieldVisibility() {
        loginPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        loginPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(loginPage.isFirstNameFieldVisible());
    }

    @And("User checks last name field visibility")
    public void checkLastNameFieldVisibility() {
        assertTrue(loginPage.isLastNameFieldVisible());
    }

    @And("User checks 'Join asos' button visibility")
    public void userChecksJoinAsosButtonVisibility() {
        assertTrue(loginPage.isJoinButtonVisible());
    }

    @When("User clicks 'Sign in' button")
    public void clickOnSignInButton() throws InterruptedException {
        loginPage.clickSignInButton();
        sleep (5000);
    }

    @Then("User checks warning above email field is {string}")
    public void checkEmailWarningMessage(final String msg) {
        loginPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, loginPage.getEmailWarning());
        assertTrue(msg.equalsIgnoreCase(loginPage.getEmailWarningText()));
    }

    @And("User checks warning above password field is {string}")
    public void checkPasswordWarningMessage(final String msg) {
        loginPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, loginPage.getPasswordWarning());
        assertTrue(msg.equalsIgnoreCase(loginPage.getPasswordWarningText()));
    }


    @And("User enters {string} to email field")
    public void enterTextToEmailField(final String email) {
        loginPage.enterTextToEmailField(email);
    }

    @And("User enters {string} to password field")
    public void enterTextToPasswordField(final String password) {
        loginPage.enterTextToPasswordField(password);
    }

    @And("'My account' page opens")
    public void myAccountPageOpens() {
        myAccountPage = pageFactoryManager.getMyAccountPage();
        myAccountPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @Then("User checks that 'My account' page title is {string}")
    public void userChecksThatMyAccountPageTitleIsTitle(final String title) {
        myAccountPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        myAccountPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, myAccountPage.getHeader());
        assertTrue(title.equalsIgnoreCase(myAccountPage.getHeaderText()));
    }

    @And("User checks that page url contains {string}")
    public void checkPageUrlContains(final String text) {
        assertTrue(driver.getCurrentUrl().contains(text));
    }

    @And("User checks Google button visibility")
    public void userChecksGoogleButtonVisibility() {
        loginPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(loginPage.isGoogleButtonVisible());
    }

    @When("User clicks Google button")
    public void userClicksGoogleButton() {
        loginPage.clickGoogleButton();
    }

    @Then("User checks that email field is visible")
    public void checkForEmailFieldVisibility() {
        googleSignInPage = pageFactoryManager.getGoogleSignInPage();
        googleSignInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        googleSignInPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        googleSignInPage.waitForAjaxToCompletePdp(DEFAULT_TIMEOUT);
        googleSignInPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, googleSignInPage.getEmailField());
        assertTrue(googleSignInPage.isEmailFieldVisible());
    }

    @Then("User checks that continue button is visible")
    public void checkContinueButtonIsVisible() {
        googleSignInPage = pageFactoryManager.getGoogleSignInPage();
        googleSignInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        googleSignInPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, googleSignInPage.getContinueButton());
    }
}
