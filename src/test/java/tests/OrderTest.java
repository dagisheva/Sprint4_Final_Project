package tests;

import POM.HomePageSamokat;
import POM.OrderFirstPage;
import POM.OrderSecondPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static constants.TestDataOrderTest.*;

public class OrderTest {
    private WebDriver driver;

    @Before
    public void startUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void placeOrderTest() {
        HomePageSamokat homePage = new HomePageSamokat(driver);
        homePage.clickCookieButton();
        homePage.clicUpperOrderButton();
        OrderFirstPage oFPage = new OrderFirstPage(driver);
        oFPage.fillOrderFormAndCheck(NAME, SURNAME, ADDRESS, PHONENUMBER);

        Assert.assertTrue("Имя должно совпадать с введённым",
                oFPage.checkNameFieldEqualsExpected(NAME));
        Assert.assertTrue("Фамилия должна совпадать с введённой",
                oFPage.checkSurnameFieldEqualsExpected(SURNAME));
        Assert.assertTrue("Адрес должен совпадать с введённым",
                oFPage.checkAddressFieldEqualsExpected(ADDRESS));
        Assert.assertTrue("Поле Станция метро не должно быть пустым",
                oFPage.checkMetroFieldIsNotEmpty());
        Assert.assertTrue("Номер телефона должен совпадать с введённым",
                oFPage.checkPhoneEqualsExpected(PHONENUMBER));

        oFPage.clickContinueButton();

        OrderSecondPage oSPage = new OrderSecondPage(driver);
        oSPage.setData(RENTDATE, DAYSNUMBER);
        Assert.assertTrue("Дата должна совпадать с выбранной",
                oSPage.checkDateIsAsChosen(RENTDATEASDATE));
        Assert.assertTrue("Количество дней должно совпадать с выбранным",
                oSPage.checkDaysNumber(DAYSNUMBER));

        oSPage.clickOrderButton();
    }

    @Test
    public void checkLowerOrderButton() {
        HomePageSamokat homePage = new HomePageSamokat(driver);
        homePage.clickLowerOrderButton();
        homePage.waitForRentPage();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
