package org.example.steps;

import org.example.pages.MtsHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class MtsHomePageSteps {

    private MtsHomePage mtsHomePage;
    private WebDriver driver;

    //Куки и скроллинг
    public void acceptCookies() {
        mtsHomePage.acceptCookies();
    }

    public void scrollToDropdownArrow() {
        mtsHomePage.scrollToElement(mtsHomePage.dropdownArrow);
    }

    // 16 пункт два
    public void fillPaymentDetailsAndContinue(String phoneNumber, String amount) {
        mtsHomePage.enterPhoneNumber(phoneNumber);
        mtsHomePage.enterAmount(amount);
        mtsHomePage.clickContinueButton();
    }

    public void switchToPaymentIframe() {
        mtsHomePage.switchToPaymentIframe();
    }
    public void switchToDefaultContent() {
        mtsHomePage.switchToDefaultContent();
    }

    public String isAmountTrue() {
        return mtsHomePage.isAmountTrue();
    }

    public boolean isCardFieldsVisible() {
        return mtsHomePage.isCardFieldsVisible();
    }
    public boolean areCardIconsVisibleIframe() {
        return mtsHomePage.areCardIconsVisibleIframe();
    }
    // 16 пункт первый

    // Проверка placeholder в поле Номер телефона для Услуг связи
    // Открытие выпадающего списка


    // 16 пункт предусловие


    public MtsHomePageSteps(MtsHomePage mtsHomePage) {
        this.mtsHomePage = mtsHomePage;
        this.driver = mtsHomePage.getDriver();
    }

    public boolean isPaymentSectionTitleVisible() {
        return mtsHomePage.isPaymentSectionTitleVisible();
    }

    public void openPaymentDetails() {
        mtsHomePage.openPaymentDetails();
    }

    public boolean isBreadcrumbsVisible() {
        return mtsHomePage.getDriver().findElement(By.xpath("//*[@class='breadcrumbs__link']/span")).isDisplayed();
    }





}
