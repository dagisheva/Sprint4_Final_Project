package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePageSamokat {
    protected static WebDriver driver;
    //верхняя кнопка "Заказать"
    private final By upperOrderButton = By.xpath(".//button[@class='Button_Button__ra12g']");
    private final By cookieButton = By.id("rcc-confirm-button");
    private final By rentPageIdentifier = By.xpath(".//div[text()='Для кого самокат']");
    //нижняя кнопка "Заказать"
    private final By lowerOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    public HomePageSamokat() {
    }

    public HomePageSamokat(WebDriver driver) {
        HomePageSamokat.driver = driver;
    }

    public void clickCookieButton() {
        clickOnElement(cookieButton);
    }

    public void clicUpperOrderButton() {
        clickOnElement(upperOrderButton);
    }

    public void clickLowerOrderButton() {
        WebElement element = driver.findElement(lowerOrderButton);
        clickWithJS(element);
    }

    public void waitForRentPage() {
        waitForElement(rentPageIdentifier);
    }

    public void scrollTableQuestionsToView(int index) {
        WebElement element = driver.findElement(By.id("accordion__heading-" + index + ""));
        clickWithJS(element);
    }

    public String returnActualText(int index) {
        scrollTableQuestionsToView(index);
        By element = By.id("accordion__panel-" + index + "");
        waitForElement(element);
        return driver.findElement(element).getText();
    }

    public boolean compareTexts(int index, String expected) {
        return checkEquality(returnActualText(index), expected);
    }

    public void waitForElement(By element) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void clickToSetData(String path, By element, String data) {
        clickOnElement(element);
        driver.findElement(By.xpath(".//div[" + path + "='" + data + "']")).click();
    }

    public String getFilledElement(By element) {
        waitForElement(element);
        return driver.findElement(element).getAttribute("value");
    }

    public String getFilledElementText(By element) {
        return driver.findElement(element).getText();
    }

    public void clickOnElement(By element) {
        driver.findElement(element).click();
    }

    public void clickWithJS(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public boolean checkEquality(String actual, String expected) {
        return actual.equals(expected);
    }

    public boolean checkContains(String actual, String expected) {
        return actual.contains(expected);
    }
}
