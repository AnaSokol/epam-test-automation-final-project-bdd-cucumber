package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static java.lang.Thread.sleep;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//button[@data-auto-id='saveForLater']")
    private List<WebElement> productWishListIcon;

    @FindBy(xpath = "//div[@data-auto-id='productList']//article[@data-auto-id='productTile']//img")
    private List<WebElement> listOfProducts;

    @FindBy (xpath = "//*[@id='chrome-welcome-mat']/div")
    private WebElement popUp;

    @FindBy (xpath = "//*[@id='chrome-welcome-mat']//button")
    private WebElement popUpCloseButton;

    public WebElement getPopUp() {
        return popUp;
    }

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void clickPopUpCloseButton() {
        popUpCloseButton.click();
    }

    public void clickWishListOnFirstProduct() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", productWishListIcon.get(0));
//        productWishListIcon.get(0).click();
    }

    public void clickOnFirstProduct() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", listOfProducts.get(0));
    }

}
