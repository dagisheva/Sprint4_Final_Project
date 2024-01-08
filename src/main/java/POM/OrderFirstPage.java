package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class OrderFirstPage extends HomePageSamokat{
    public OrderFirstPage(WebDriver driver){
        super.driver = driver;
    }

    //поле "Имя"
    private By nameField = By.xpath
                    (".//input[@placeholder='* Имя']");
    //поле "Фамилия"
    private By surnameField = By.xpath
            (".//input[@placeholder='* Фамилия']");

    //поле "Адрес"
    private By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    //список "Станции метро"
    private By metroStationSelectField = By.xpath(".//input[@placeholder='* Станция метро']");

    //поле "Номер телефона"
    private By phoneNumberField = By.xpath
            (".//input[@placeholder='* Телефон: на него позвонит курьер']");

    //кнопка "Далее"
    private By continueButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM'" +
            "and text()='Далее']");

    public void setData(By element, String name){
        clickOnElement(element);
        driver.findElement(element).sendKeys(name);
    }

    public void setMetroStation(){
        clickOnElement(metroStationSelectField);
        driver.findElement(By.xpath(".//div[@class='select-search__select']")).click();
    }

    public String getFilledName() {
        return getFilledElement(nameField);
    }

    public String getFilledSurname() {
        return getFilledElement(surnameField);
    }

    public String getFilledAddress() {
        return getFilledElement(addressField);
    }

    public String getFilledPhoneNumber() {
        return getFilledElement(phoneNumberField);
    }

    public String getFilledMetro() {
        return getFilledElement(metroStationSelectField);
    }

    public boolean checkNameFieldEqualsExpected(String name) {
        return checkEquality(name, getFilledName());
    }

    public boolean checkSurnameFieldEqualsExpected(String surname) {
        return checkEquality(surname, getFilledSurname());
    }

    public boolean checkAddressFieldEqualsExpected(String address) {
        return checkEquality(address, getFilledAddress());
    }

    public boolean checkMetroFieldIsNotEmpty() {
        return checkNotEmpty(getFilledMetro());
    }

    public boolean checkPhoneEqualsExpected(String phoneNumber) {
        return checkEquality(phoneNumber, getFilledPhoneNumber());
    }

    public void fillOrderFormAndCheck(String name, String surname, String address, String phoneNumber) {
        waitForElement(nameField);
        setData(nameField, name);
        setData(surnameField, surname);
        setData(addressField, address);
        setMetroStation();
        setData(phoneNumberField, phoneNumber);
    }

    public void clickContinueButton(){
        clickOnElement(continueButton);
    }

}
