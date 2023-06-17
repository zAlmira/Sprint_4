import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum_services.qa_scooter.pages.MainPage;
import ru.praktikum_services.qa_scooter.pages.MakeOrderFormPage;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class MakeOrderFormTests {
    private final String name;
    private final String surname;
    private final String address;
    private final String telephone;
    private final String comment;
    WebDriver driver;

    public MakeOrderFormTests(String name, String surname, String address, String telephone, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.telephone = telephone;
        this.comment = comment;
    }

    @Parameterized.Parameters(name = "Оформление заказа. Тестовые данные: {0} {1} {2} {3} {4}")
    public static Object[][] dataForMakingOrder() {
        return new Object[][]{
                {"Влад", "Владов", "ул.Камская,д.7", "89375555555", "Комментарий"},
                {"Игорь", "Игорев", "ул.Думская,д.1", "89376754356", "Другой комментарий"},
        };
    }

    @Before
    public void init() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void makeCorrectOrderWithCorrectData() {
        MainPage mainPage = new MainPage(driver);
        MakeOrderFormPage makeOrderFormPage = new MakeOrderFormPage(driver);
        mainPage.orderButtonInHeaderClick();
        makeOrderFormPage.makeOrderFormEnterData(name, surname, address, telephone, comment);
        assertTrue(makeOrderFormPage.isMessageAboutSuccessDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
