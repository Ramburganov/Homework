package Tests;

import org.example.steps.DriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.example.pages.MtsHomePage;
import org.example.steps.MtsHomePageSteps;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class MtsTestSuite {

    private WebDriver driver;
    private MtsHomePage mtsHomePage;
    private MtsHomePageSteps mtsHomePageSteps;

    @BeforeEach
    public void setUp() {
        driver = DriverFactory.createDriver();
        mtsHomePage = new MtsHomePage(driver);
        mtsHomePageSteps = new MtsHomePageSteps(mtsHomePage);
        driver.get("https://mts.by");
        mtsHomePageSteps.acceptCookies();
        mtsHomePageSteps.scrollToDropdownArrow();


    }
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


    // 16 задание перевод старых тестов на модель Page Object
    @Test
    public void testPaymentSection() {
        // Проверка видимости заголовка секции платежей
        assertTrue(mtsHomePageSteps.isPaymentSectionTitleVisible());

        // Проверка отображения логотипов в секции платежей
        assertTrue(mtsHomePage.getPaymentLogos().isDisplayed());

        // Открытие деталей платежа и проверка видимости хлебных крошек
        mtsHomePageSteps.openPaymentDetails();
        assertTrue(mtsHomePageSteps.isBreadcrumbsVisible());
    }



    // 16 задание второй пункт тест модального окна
    @Test
    public void checkPaymentSectionContinueButton() {
        mtsHomePageSteps.fillPaymentDetailsAndContinue("297777777", "132");

        mtsHomePageSteps.switchToPaymentIframe();

        mtsHomePageSteps.areCardIconsVisibleIframe();//проверка иконок банков

        mtsHomePageSteps.isAmountTrue();//проверка верности суммы и номера

        mtsHomePageSteps.isCardFieldsVisible();//проверка полей карты

        // Возвращение на основную страницу
        mtsHomePageSteps.switchToDefaultContent();
    }



    // 16 задание первый пункт доп тесты


}


