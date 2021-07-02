package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
    public WebElement getHeader() {
        return header;
    }

    @FindBy(xpath = "//header//span[@class='WkTCjySeTZVCmsExD5tWL']")
    private WebElement header;

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }
    public void openMyAccountPage(String url) {
        driver.get(url);
    }

    public boolean isHeaderVisible(){
        return header.isDisplayed();
    }
    public String getHeaderText(){
        return header.getText();
    }

}
