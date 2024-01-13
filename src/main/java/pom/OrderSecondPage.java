package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class OrderSecondPage extends HomePageSamokat {
    //дата
    private final By startDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //срок аренды
    private final By rentTime = By.xpath(".//div[text()='* Срок аренды']");
    private final String daysNumberTag = "text()";
    //кнопка "Заказать"
    private final By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");
    //форма подтверждения заказа
    private final By confirmationForm = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");
    //подтвердить заказ
    private final By yesButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' " +
            "and text()='Да']");
    //заказ оформлен
    private final By orderApprovedForm = By.xpath(".//div[@class='Order_Modal__YZ-d3']");
    private final By orderApprovedHeader = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");
    //
    private final By viewOrderButton = By.xpath(".//button[text()='Посмотреть статус']");
    //текст подтверждения заказа
    private final By confirmationText = By.xpath(".//div[@class='Order_Text__2broi']");

    public OrderSecondPage(WebDriver driver) {
        OrderSecondPage.driver = driver;
    }

    public void waitForOrderConfirmationForm() {
        waitForElement(confirmationForm);
    }

    //ожидание формы "Заказ оформлен"
    public void waitForOrderApprovedForm() {
        waitForElement(orderApprovedForm);
    }

    public void setRentDate(String date) {
        WebElement element = driver.findElement(startDate);
        element.clear();
        element.sendKeys(date);
        element.sendKeys(Keys.RETURN);
    }

    public void setDaysNumber(String daysNumber) {
        clickToSetData(daysNumberTag, rentTime, daysNumber);
    }

    public void setData(String date, String daysNumber) {
        setRentDate(date);
        setDaysNumber(daysNumber);
    }

    public void clickViewOrderButton() {
        clickOnElement(viewOrderButton);
    }

    public void clickOrderButton() {
        clickOnElement(orderButton);
        waitForOrderConfirmationForm();
        clickOnElement(yesButton);
        waitForOrderApprovedForm();
    }

    public void fillSecondFormAndConfirmOrder(String rentDate, String daysNumber) {
        setData(rentDate, daysNumber);
        clickOrderButton();
    }

    public String getConfirmationApprovedText() {
        return getFilledElementText(orderApprovedHeader);
    }

    public boolean checkTextIsIasExpected(String expectedText) {
        return checkContains(getConfirmationApprovedText(), expectedText);
    }

}