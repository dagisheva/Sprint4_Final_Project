package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class OrderFirstPage extends HomePageSamokat {
    //поле "Имя"
    private final By nameField = By.xpath
            (".//input[@placeholder='* Имя']");
    //поле "Фамилия"
    private final By surnameField = By.xpath
            (".//input[@placeholder='* Фамилия']");
    //поле "Адрес"
    private final By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //список "Станции метро"
    private final By metroStationSelectField = By.xpath(".//input[@placeholder='* Станция метро']");
    //поле "Номер телефона"
    private final By phoneNumberField = By.xpath
            (".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //кнопка "Далее"
    private final By continueButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM'" +
            "and text()='Далее']");

    public OrderFirstPage(WebDriver driver) {
        HomePageSamokat.driver = driver;
    }

    public void setData(By element, String name) {
        clickOnElement(element);
        driver.findElement(element).sendKeys(name);
    }

    public void setMetroStation() {
        clickOnElement(metroStationSelectField);
        driver.findElement(By.xpath(".//div[@class='select-search__select']")).click();
    }

    public void fillFirstFormAndContinue(String name, String surname, String address, String phoneNumber) {
        waitForElement(nameField);
        setData(nameField, name);
        setData(surnameField, surname);
        setData(addressField, address);
        setMetroStation();
        setData(phoneNumberField, phoneNumber);
        clickContinueButton();
    }

    public void clickContinueButton() {
        clickOnElement(continueButton);
    }

}
