import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum_services.qa_scooter.pages.MainPage;
import ru.praktikum_services.qa_scooter.pages.MakeOrderFormPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MainPageTests {

    WebDriver driver;

    @Before
    public void init() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage mainPage = new MainPage(driver);
        mainPage.cookieClose();
    }

    @Test
    public void shouldBeRightTextAboutScooterPrice() {
        MainPage mainPage = new MainPage(driver);
        mainPage.MainPageScroll();
        mainPage.scooterPriceButtonClick();
        String actualText = mainPage.scooterPriceAnswerGetText();
        assertEquals("Сутки — 400 рублей. Оплата курьеру — наличными или картой.", actualText);
    }

    @Test
    public void shouldBeRightTextAboutScooterAmount() {
        MainPage mainPage = new MainPage(driver);
        mainPage.MainPageScroll();
        mainPage.scooterAmountButtonClick();
        String actualText = mainPage.scooterAmountAnswerGetText();
        assertEquals("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", actualText);
    }

    @Test
    public void shouldBeRightTextAboutScooterTime() {
        MainPage mainPage = new MainPage(driver);
        mainPage.MainPageScroll();
        mainPage.scooterTimeButtonClick();
        String actualText = mainPage.scooterTimeAnswerGetText();
        assertEquals("Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", actualText);
    }

    @Test
    public void shouldBeRightTextAboutScooterTimeToday() {
        MainPage mainPage = new MainPage(driver);
        mainPage.MainPageScroll();
        mainPage.scooterTimeTodayButtonClick();
        String actualText = mainPage.scooterTimeTodayAnswerGetText();
        assertEquals("Только начиная с завтрашнего дня. Но скоро станем расторопнее.", actualText);
    }

    @Test
    public void shouldBeRightTextAboutScooterProlong() {
        MainPage mainPage = new MainPage(driver);
        mainPage.MainPageScroll();
        mainPage.scooterProlongButtonClick();
        String actualText = mainPage.scooterProlongAnswerGetText();
        assertEquals("Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", actualText);
    }

    @Test
    public void shouldBeRightTextAboutScooterCharge() {
        MainPage mainPage = new MainPage(driver);
        mainPage.MainPageScroll();
        mainPage.scooterChargeButtonClick();
        String actualText = mainPage.scooterChargeAnswerGetText();
        assertEquals("Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", actualText);
    }

    @Test
    public void shouldBeRightTextAboutScooterCancelOrder() {
        MainPage mainPage = new MainPage(driver);
        mainPage.MainPageScroll();
        mainPage.scooterCancelOrderButtonClick();
        String actualText = mainPage.scooterCancelOrderAnswerGetText();
        assertEquals("Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", actualText);
    }

    @Test
    public void shouldBeRightTextAboutScooterMkad() {
        MainPage mainPage = new MainPage(driver);
        mainPage.MainPageScroll();
        mainPage.scooterMkadButtonClick();
        String actualText = mainPage.scooterMkadAnswerGetText();
        assertEquals("Да, обязательно. Всем самокатов! И Москве, и Московской области.", actualText);
    }


    @Test
    public void transitToMakeOrderFormFromHeader() {
        MainPage mainPage = new MainPage(driver);
        MakeOrderFormPage makeOrderFormPage = new MakeOrderFormPage(driver);
        mainPage.orderButtonInHeaderClick();
        assertTrue(makeOrderFormPage.isMakeOrderFormHeadingDisplayed());
    }

    @Test
    public void transitToMakeOrderFormFromMiddle() {
        MainPage mainPage = new MainPage(driver);
        MakeOrderFormPage makeOrderFormPage = new MakeOrderFormPage(driver);
        mainPage.orderButtonInMiddleClick();
        assertTrue(makeOrderFormPage.isMakeOrderFormHeadingDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }


}
