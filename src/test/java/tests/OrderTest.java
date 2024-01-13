package tests;

import helpers.TestData;
import org.junit.Assert;
import org.junit.Test;
import pom.HomePageSamokat;
import pom.OrderFirstPage;
import pom.OrderSecondPage;

public class OrderTest extends BaseTest {
    private final String firstName = TestData.generateFirstName();
    private final String lastName = TestData.generateLastName();
    private final String address = TestData.generateAddress();
    private final String phoneNumber = TestData.generatePhoneNumber();
    private final String strDate = TestData.generateDate();
    private final String daysNumber = TestData.chooseDaysNumber();

    @Test
    public void placeOrderTest() {
        HomePageSamokat homePage = new HomePageSamokat(webDriver);
        homePage.clickCookieButton();
        homePage.clicUpperOrderButton();
        OrderFirstPage oFPage = new OrderFirstPage(webDriver);
        oFPage.fillFirstFormAndContinue(firstName, lastName, address, phoneNumber);
        OrderSecondPage oSPage = new OrderSecondPage(webDriver);
        oSPage.fillSecondFormAndConfirmOrder(strDate, daysNumber);

        Assert.assertTrue("Текст должен содержать фразу 'Заказ оформлен'",
                oSPage.checkTextIsIasExpected("Заказ оформлен"));
    }

    @Test
    public void checkLowerOrderButton() {
        HomePageSamokat homePage = new HomePageSamokat(webDriver);
        homePage.clickLowerOrderButton();
        homePage.waitForRentPage();
    }
}
