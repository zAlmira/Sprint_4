package ru.praktikum_services.qa_scooter.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    private WebDriver driver;

   //Локаторы для кнопок в блоке "Вопросы о важном"
    private final By scooterPriceButton = By.xpath(".//div[text() = 'Сколько это стоит? И как оплатить?']");
    private final By scooterAmountButton = By.xpath(".//div[text() = 'Хочу сразу несколько самокатов! Так можно?']");
    private final By scooterTimeButton = By.xpath(".//div[text() = 'Как рассчитывается время аренды?']");
    private final By scooterTimeTodayButton = By.xpath(".//div[text() = 'Можно ли заказать самокат прямо на сегодня?']");
    private final By scooterProlongButton = By.xpath(".//div[text() = 'Можно ли продлить заказ или вернуть самокат раньше?']");
    private final By scooterChargeButton = By.xpath(".//div[text() = 'Вы привозите зарядку вместе с самокатом?']");
    private final By scooterCancelOrderButton = By.xpath(".//div[text() = 'Можно ли отменить заказ?']");
    private final By scooterMkadButton = By.xpath(".//div[text() = 'Я жизу за МКАДом, привезёте?']");


   //Локаторы для ответов в блоке "Вопросы о важном"
    private final By scooterPriceAnswer = By.xpath(".//p[text() = 'Сутки — 400 рублей. Оплата курьеру — наличными или картой.']");

    private final By scooterAmountAnswer = By.xpath(".//p[text() = 'Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.']");
    private final By scooterTimeAnswer = By.xpath(".//p[text() = 'Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.']");
    private final By scooterTimeTodayAnswer = By.xpath(".//p[text() = 'Только начиная с завтрашнего дня. Но скоро станем расторопнее.']");
    private final By scooterProlongAnswer = By.xpath(".//p[text() = 'Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.']");
    private final By scooterChargeAnswer = By.xpath(".//p[text() = 'Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.']");
    private final By scooterCancelOrderAnswer = By.xpath(".//p[text() = 'Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.']");
    private final By scooterMkadAnswer = By.xpath(".//p[text() = 'Да, обязательно. Всем самокатов! И Москве, и Московской области.'");

    //Локатор для кнопки закрытия куки
    private final By cookieCloseButton = By.id("rcc-confirm-button");
    //Локатор для кнопки Заказать вверху страницы
    private final By orderButtonInHeader = By.xpath(".//div[@class = 'Header_Nav__AGCXC']/button[@class = 'Button_Button__ra12g']");
   //Локатор для кнопки Заказать в центре страницы
    private final By orderButtonInMiddle = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

   //Методы нажатия на кнопки в блоке "Вопросы о важном"
    public void scooterPriceButtonClick() {
        driver.findElement(scooterPriceButton).click();
    }
    public void scooterAmountButtonClick() {
        driver.findElement(scooterAmountButton).click();
    }

    public void scooterTimeButtonClick() {
        driver.findElement(scooterTimeButton).click();
    }

    public void scooterTimeTodayButtonClick() {
        driver.findElement(scooterTimeTodayButton).click();
    }

    public void scooterProlongButtonClick() {
        driver.findElement(scooterProlongButton).click();
    }

    public void scooterChargeButtonClick() {
        driver.findElement(scooterChargeButton).click();
    }
    public void scooterCancelOrderButtonClick() {
        driver.findElement(scooterCancelOrderButton).click();
    }
    public void scooterMkadButtonClick() {
        driver.findElement(scooterMkadButton).click();
    }


    //Методы для получения текстов ответов в блоке "Вопросы о важном"
    public String scooterPriceAnswerGetText() {
       return driver.findElement(scooterPriceAnswer).getText();
    }
    public String scooterAmountAnswerGetText() {
        return driver.findElement(scooterAmountAnswer).getText();
    }
    public String scooterTimeAnswerGetText() {
        return driver.findElement(scooterTimeAnswer).getText();
    }
    public String scooterTimeTodayAnswerGetText() {
        return driver.findElement(scooterTimeTodayAnswer).getText();
    }

    public String scooterProlongAnswerGetText() {
        return driver.findElement(scooterProlongAnswer).getText();
    }
    public String scooterChargeAnswerGetText() {
        return driver.findElement(scooterChargeAnswer).getText();
    }

    public String scooterCancelOrderAnswerGetText() {
        return driver.findElement(scooterCancelOrderAnswer).getText();
    }

    public String scooterMkadAnswerGetText() {
        return driver.findElement(scooterMkadAnswer).getText();
    }

   //Метод для скролла страницы
    public void MainPageScroll() {
        WebElement element = driver.findElement(scooterMkadButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    //Метод для закрытия куки
    public void cookieClose() {
        driver.findElement(cookieCloseButton).click();
    }

    public void orderButtonInHeaderClick() {
        driver.findElement(orderButtonInHeader).click();
    }

    public void orderButtonInMiddleClick() {
        driver.findElement(orderButtonInMiddle).click();
    }

}
