package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SavedListPage extends BasePage {
    @FindBy(xpath = "//*[@id='saved-lists-app']//div[contains(@class, 'itemCount')]")
    private WebElement savedListProductsCount;

    @FindBy (xpath = "//section[contains(@class, 'productTiles')]//li")
    private List <WebElement> productsInSavedList;

    @FindBy (xpath = "//section[contains(@class, 'productTiles')]//li")
    private WebElement productInSavedList;

    public SavedListPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getSavedListProductsCount() {
        return savedListProductsCount;
    }
    public String getAmountOfProductsInWishList() {
        return savedListProductsCount.getText();
    }
    public WebElement getProductInSavedList() {
        return productInSavedList;
    }

    public List<WebElement> getProductsInSavedList() {
        return productsInSavedList;
    }

    public int getAmountOfProductsInSavedList() {
        return productsInSavedList.size();
    }
}
