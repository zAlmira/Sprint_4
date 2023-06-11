package ru.praktikum_services.qa_scooter.pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MakeOrderFormPage {
    private WebDriver driver;
    public MakeOrderFormPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By makeOrderFormHeading = By.xpath(".//div[@class = 'Order_Header__BZXOb']");
    private final By makeOrderFormName = By.xpath(".//input[@placeholder = '* Имя']");
    private final By makeOrderFormSurname = By.xpath(".//input[@placeholder = '* Фамилия']");
    private final By makeOrderFormAddress = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    private final By makeOrderFormMetro = By.xpath(".//input[@placeholder = '* Станция метро']");
    private final By makeOrderFormMetroName = By.xpath(".//button[@value = '2']");
    private final By makeOrderFormTelephone = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");
    private final By buttonNext = By.xpath(".//button[text() = 'Далее']");
    private final By cookieCloseButton = By.xpath(".//button[@id = 'rcc-confirm-button' and text() = 'да все привыкли']");
    private final By deliveryDate = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");
    private final By deliveryAccurateDate = By.xpath(".//div[@aria-label = 'Choose воскресенье, 11-е июня 2023 г.']");

    private final By rentTerm = By.xpath(".//div[text() = '* Срок аренды']");
    private final By rentTermValue = By.xpath(".//div[@class = 'Dropdown-menu']/div[text() = 'сутки']");
    private final By blackCheckbox = By.xpath(".//input[@id = 'black' and @type = 'checkbox']");
    private final By commentField = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");
    private final By orderButton = By.xpath(".//div[@class = 'Order_Buttons__1xGrp']/button[text() = 'Заказать']");
    private final By confirmButtonYes = By.xpath(".//div[@class = 'Order_Buttons__1xGrp']/button[text() = 'Да']");
    private final By messageAboutSuccess = By.xpath(".//div[text() = 'Заказ оформлен']");

    public boolean isMakeOrderFormHeadingDisplayed() {
        return driver.findElement(makeOrderFormHeading).isDisplayed();
    }

    public void makeOrderFormEnterData(String name, String surname, String address, String telephone, String comment) {
        cookieCloseButton();
        driver.findElement(makeOrderFormName).sendKeys(name);
        driver.findElement(makeOrderFormSurname).sendKeys(surname);
        driver.findElement(makeOrderFormAddress).sendKeys(address);
        driver.findElement(makeOrderFormTelephone).sendKeys(telephone);
        driver.findElement(makeOrderFormMetro).click();
        driver.findElement(makeOrderFormMetroName).click();
        driver.findElement(buttonNext).click();
        driver.findElement(deliveryDate).click();
        driver.findElement(deliveryAccurateDate).click();
        driver.findElement(rentTerm).click();
        driver.findElement(rentTermValue).click();
        driver.findElement(blackCheckbox).click();
        driver.findElement(commentField).sendKeys(comment);
        driver.findElement(orderButton).click();
        driver.findElement(confirmButtonYes).click();
    }

    public boolean isMessageAboutSuccessDisplayed() {
        return driver.findElement(messageAboutSuccess).isDisplayed();
    }
    public void cookieCloseButton() {
        driver.findElement(cookieCloseButton).click();
    }

}
