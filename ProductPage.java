package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//*[@id='product-add']//button")
    private WebElement addToBagButton;

    @FindBy(xpath = "//div[@class='size-section']//select[@data-id='sizeSelect']")
    private WebElement sizeDropdown;

    @FindBy(xpath = "//div[@class='size-section']//select/option")
    private List<WebElement> sizeOptions;

    @FindBy(xpath = "//div[@class='size-section']//select/option[2]")
    private WebElement firstSizeOption;

    @FindBy(xpath = "//*[@id='minibag-dropdown']//div[@data-test-id = 'miniBagHeader']")
    private WebElement addToBagDropdown;

    public WebElement getAddToBagDropdown() {
        return addToBagDropdown;
    }

    @FindBy(xpath = "//*[@id='minibag-dropdown']//span[@data-test-id='miniBagItemCount']")
    private WebElement addToBagDropdownHeader;

    @FindBy(xpath = "//div[@id='minibag-dropdown']//a[@type='button'][@data-test-id='bag-link']")
    private WebElement dropdownViewBagButton;

    @FindBy(xpath = "//div[@id='minibag-dropdown']//a[@type='button'][@data-test-id='checkout-link']")
    private WebElement dropdownCheckoutButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getSizeDropdown() {
        return sizeDropdown;
    }

    public List<WebElement> getSizeOptions() {
        return sizeOptions;
    }

    public WebElement getAddToBagDropdownHeader() {
        return addToBagDropdownHeader;
    }

    public WebElement getDropdownViewBagButton() {
        return dropdownViewBagButton;
    }

    public boolean isSizeDropdownVisible() {
        return sizeDropdown.isDisplayed();
    }

    public void isSelectedSizeVisible() {
        sizeOptions.get(1).isDisplayed();
    }

    public void selectFirstSizeOption() {
        selectFromDropdownByIndex(sizeDropdown, 1);
    }

    public void clickSizeDropdown() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sizeDropdown);
    }

    public void clickAddToBagButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToBagButton);
    }

    public boolean isAddToBagDropdownVisible() {
        return addToBagDropdown.isDisplayed();
    }

    public boolean checkViewBagButtonVisibility() {
        return dropdownViewBagButton.isDisplayed();
    }

    public String getAddToBagDropdownHeaderText() {
        return addToBagDropdownHeader.getText();
    }

    public boolean isCheckoutButtonVisible() {
        return dropdownCheckoutButton.isDisplayed();
    }

    public void clickViewBagButton() {
        dropdownViewBagButton.click();
    }
    public void clickCheckoutButton() {
        dropdownCheckoutButton.click();
    }
}
