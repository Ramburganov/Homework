package Tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.Step;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.example.steps.DriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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

    // Тест 1: Проверка видимости секции платежей
    @Test
    @Feature("Payment Section Tests")
    @Story("Verify visibility of payment section")
    @Severity(SeverityLevel.CRITICAL)  // Уровень серьезности
    @DisplayName("Test visibility of the payment section and its logos")
    @Step("Test payment section visibility")
    public void testPaymentSection() {
        // Проверка видимости заголовка секции платежей
        assertTrue(mtsHomePageSteps.isPaymentSectionTitleVisible());

        // Проверка отображения логотипов в секции платежей
        assertTrue(mtsHomePage.getPaymentLogos().isDisplayed());

        // Открытие деталей платежа и проверка видимости хлебных крошек
        mtsHomePageSteps.openPaymentDetails();
        assertTrue(mtsHomePageSteps.isBreadcrumbsVisible());
    }

    // Тест 2: Проверка функциональности кнопки "Продолжить" в секции платежей
    @Test
    @Feature("Payment Section Tests")
    @Story("Check the continue button functionality")
    @Severity(SeverityLevel.NORMAL)  // Уровень серьезности
    @DisplayName("Test continue button functionality in payment section")
    @Step("Test continue button in payment section")
    public void checkPaymentSectionContinueButton() {
        // Заполнение платежных данных и продолжение
        mtsHomePageSteps.fillPaymentDetailsAndContinue("297777777", "132");

        // Переключение на iframe с оплатой
        mtsHomePageSteps.switchToPaymentIframe();

        // Проверка полей карты и иконок банков
        mtsHomePageSteps.isCardFieldsVisible();
        mtsHomePageSteps.areCardIconsVisibleIframe();

        // Проверка правильности суммы и номера
        mtsHomePageSteps.isAmountTrue();

        // Возвращение на основную страницу
        mtsHomePageSteps.switchToDefaultContent();
    }

    // Тест 3: Проверка видимости полей для ввода платежных данных
    @Test
    @Feature("Payment Section Tests")
    @Story("Check if payment fields are visible")
    @Severity(SeverityLevel.MINOR)  // Уровень серьезности
    @DisplayName("Test visibility of payment fields")
    public void checkIsPaymentFieldsIsVisible1() {
        assertTrue(mtsHomePageSteps.isPaymentFieldsIsVisible());
    }
}
