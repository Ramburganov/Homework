package org.example.steps;

import io.qameta.allure.Step;
import org.example.pages.MtsHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MtsHomePageSteps {

    private MtsHomePage mtsHomePage;
    private WebDriver driver;

    // Конструктор для инициализации страницы
    public MtsHomePageSteps(MtsHomePage mtsHomePage) {
        this.mtsHomePage = mtsHomePage;
        this.driver = mtsHomePage.getDriver();
    }

    // Шаг для принятия cookies
    @Step("Accept cookies")
    public void acceptCookies() {
        mtsHomePage.acceptCookies();
    }

    // Шаг для прокрутки к стрелке выпадающего списка
    @Step("Scroll to dropdown arrow")
    public void scrollToDropdownArrow() {
        mtsHomePage.scrollToElement(mtsHomePage.dropdownArrow);
    }

    // Шаг для заполнения платежных данных и продолжения
    @Step("Fill payment details and continue with phone number {0} and amount {1}")
    public void fillPaymentDetailsAndContinue(String phoneNumber, String amount) {
        mtsHomePage.enterPhoneNumber(phoneNumber);
        mtsHomePage.enterAmount(amount);
        mtsHomePage.clickContinueButton();
    }

    // Шаг для переключения на iframe с оплатой
    @Step("Switch to payment iframe")
    public void switchToPaymentIframe() {
        mtsHomePage.switchToPaymentIframe();
    }

    // Шаг для переключения на основной контент
    @Step("Switch to default content")
    public void switchToDefaultContent() {
        mtsHomePage.switchToDefaultContent();
    }

    // Шаг для проверки, что введенная сумма верна
    @Step("Check if the amount is correct")
    public String isAmountTrue() {
        return mtsHomePage.isAmountTrue();
    }

    // Шаг для проверки видимости полей для ввода данных карты
    @Step("Check if card fields are visible")
    public boolean isCardFieldsVisible() {
        return mtsHomePage.isCardFieldsVisible();
    }

    // Шаг для проверки видимости иконок карт внутри iframe
    @Step("Check if card icons are visible in iframe")
    public boolean areCardIconsVisibleIframe() {
        return mtsHomePage.areCardIconsVisibleIframe();
    }

    // Шаг для проверки видимости полей для ввода платежных данных
    @Step("Check if payment fields are visible")
    public boolean isPaymentFieldsIsVisible() {
        return mtsHomePage.isPaymentFieldsIsVisible();
    }

    // Шаг для проверки видимости заголовка секции с платежами
    @Step("Check if payment section title is visible")
    public boolean isPaymentSectionTitleVisible() {
        return mtsHomePage.isPaymentSectionTitleVisible();
    }

    // Шаг для открытия деталей оплаты
    @Step("Open payment details")
    public void openPaymentDetails() {
        mtsHomePage.openPaymentDetails();
    }

    // Шаг для проверки видимости хлебных крошек
    @Step("Check if breadcrumbs are visible")
    public boolean isBreadcrumbsVisible() {
        return mtsHomePage.getDriver().findElement(By.xpath("//*[@class='breadcrumbs__link']/span")).isDisplayed();
    }
}
