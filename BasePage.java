package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForPageLoadComplete(long timeToWait) {
        new WebDriverWait(driver, timeToWait).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public void waitForAjaxToComplete(long timeToWait) {
        new WebDriverWait(driver, timeToWait).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return window.jQuery != undefined && jQuery.active == 0;"));
    }

    public void waitForAjaxToCompletePdp(long timeToWait) {
        new WebDriverWait(driver, timeToWait).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return window.jQuery != undefined && jQuery.active <=2;"));
    }

    public void waitVisibilityOfElement(long timeToWait, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeToWait);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitVisibilityOfAllElements(long timeToWait, List<WebElement> elements) {
        WebDriverWait wait = new WebDriverWait(driver, timeToWait);
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public void waitFluent (long timeToWait){
        WebDriverWait wait = new WebDriverWait(driver, timeToWait);
        wait.withTimeout(Duration.ofSeconds(timeToWait)).pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
    }

    public void waitImplicitly (long timeToWait){
        driver.manage().timeouts().implicitlyWait(timeToWait, TimeUnit.SECONDS);
    }

    public void selectFromDropdownByIndex(WebElement element, int optionIndex) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));
        Select dropDown = new Select(element);
        dropDown.selectByIndex(optionIndex);
    }

}
