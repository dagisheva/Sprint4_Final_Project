package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class OrderSecondPage extends HomePageSamokat{
    public OrderSecondPage(WebDriver driver) {
        super.driver = driver;
    }

    //дата
    private By startDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    //срок аренды
    private By rentTime = By.xpath(".//div[text()='* Срок аренды']");

    //Выбрать цвет самоката
    //private By colour = By.xpath(".//div[@class='Order_Title__3EKne' and text() = 'Цвет самоката']");

    //Комментарий для курьера
    //private By comment = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN'" +
           // "and text()='Комментарий для курьера']");

    //кнопка "Назад"
    private By returnButton = By.xpath
            (".//button[@placeholder='Назад']");
    private String rentDateTag = "@aria-label";
    private String daysNumberTag = "text()";

    //кнопка "Заказать"
    private By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");

    //форма подтверждения заказа
    private By confirmationForm = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");
    public void waitForOrderConfirmationForm() {
        waitForElement(confirmationForm);
    }
    //подтвердить заказ
    private By noButton = By.xpath("");
    //отказаться
    private By yesButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' " +
            "and text()='Да']");
    //заказ оформлен
    private By orderApprovedForm = By.xpath(".//div[@class='Order_Modal__YZ-d3']");
    private By selectedDaysNumber = By.xpath(".//div[@class='Dropdown-placeholder is-selected']");

    //ожидание формы "Заказ оформлен"
    public void waitForOrderApprovedForm() {
        waitForElement(orderApprovedForm);
    }

    //текст подтверждения заказа
    private By confirmationText = By.xpath(".//div[@class='Order_Text__2broi']");

    public void setRentDate(String date) {
        clickToSetData(rentDateTag, startDate, date);
    }

    public void setDaysNumber(String daysNumber) {
       clickToSetData(daysNumberTag, rentTime, daysNumber);
    }

    public String getDate() {
        return getFilledElement(startDate);
    }

    public String getDaysNumber() {
        return getFilledElementText(selectedDaysNumber);
    }

    public boolean checkDateIsAsChosen(String expectedDate){
        return checkEquality(getDate(), expectedDate);
    }

    public boolean checkDaysNumber(String daysNumber) {
        return checkEquality(getDaysNumber(), daysNumber);
    }

    public void setData(String date, String daysNumber){
       setRentDate(date);
       setDaysNumber(daysNumber);
    }

    public void clickOrderButton(){
        clickOnElement(orderButton);
        waitForOrderConfirmationForm();
        clickOnElement(yesButton);
        waitForOrderApprovedForm();
    }
}