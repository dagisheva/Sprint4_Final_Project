package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
    protected static WebDriver webDriver;

    @Before
    public void startUp() {
        WebDriverManager.firefoxdriver().setup();
        webDriver = new FirefoxDriver();
        webDriver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}
