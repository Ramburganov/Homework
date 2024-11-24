package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MtsHomePage extends BasePageObject {

    private WebDriverWait wait;

    public MtsHomePage(WebDriver driver) {
        super(driver);
        this.wait = wait;
    }

    public WebDriver getDriver() {
        return driver;
    }


    // 16 пункт два ----------------------------------------------------
    public By continueButton = By.xpath("//*[@id=\"pay-connection\"]/button");//Переход в модальное окно оплаты
    private By iframe = By.xpath("//iframe[@class='bepaid-iframe']");

    private By sumElementSelector = By.xpath("//div[@class='pay-description__cost']/span[contains(text(),'132.00 BYN')]"); // Локатор для просто текста "Оплатить 132"
    private By paymentButton = By.xpath("//*[contains(normalize-space(text()), 'Оплатить 132.00 BYN')]");
    private By phoneNumberLabel = By.xpath("//div[contains(@class, 'pay-description__text')]//span[contains(text(), 'Оплата: Услуги связи') and contains(text(), 'Номер:375297777777')]");

    private By cardNumberLabel = By.xpath("//label[contains(text(),'Номер карты')]");
    private By expirationLabel = By.xpath("//label[contains(text(),'Срок действия')]");
    private By holderNameLabel = By.xpath("//label[contains(text(),'Имя держателя')]");
    private By cvcLabel = By.xpath("//label[contains(text(),'CVC')]");

    private By cardIcons = By.xpath("//div[@class='cards-brands__container']");

    private By visaIcon = By.xpath("//div[contains(@class, 'cards-brands__container')]//img[@src='assets/images/payment-icons/card-types/visa-system.svg']");
    private By mastercardIcon = By.xpath("//div[contains(@class, 'cards-brands__container')]//img[@src='assets/images/payment-icons/card-types/mastercard-system.svg']");
    private By belkartIcon = By.xpath("//div[contains(@class, 'cards-brands__container')]//img[@src='assets/images/payment-icons/card-types/belkart-system.svg']");
    private By maestroIcon = By.xpath("//div[contains(@class, 'cards-brands__random')]//img[@src='assets/images/payment-icons/card-types/maestro-system.svg']");
    private By mirIcon = By.xpath("//div[contains(@class, 'cards-brands__random')]//img[@src='assets/images/payment-icons/card-types/mir-system-ru.svg']");
    private By allCardIcons = By.xpath("//div[@class='cards-brands ng-tns-c46-1']");


    public void enterPhoneNumber(String phoneNumber) {
        driver.findElement(phoneFieldConnection).sendKeys(phoneNumber);//16.2 - ввод номера
    }
    public void enterAmount(String amount) {
        driver.findElement(sumFieldConnection).sendKeys(amount);//16.2 - Ввод суммы
    }
    public void clickContinueButton() {
        driver.findElement(continueButton).click();//16.2 - Клик по кнопке продолжить
    }

    public void switchToPaymentIframe() {
        driver.switchTo().frame(driver.findElement(iframe));//16.2 - переключение на фрейм
    }
    public void switchToDefaultContent() {
        driver.switchTo().defaultContent(); //16.2 -Переключение на дефолтную страницу
    }

    public String isAmountTrue() {// тест суммы и номера
        WebElement sumElement = wait.until(ExpectedConditions.visibilityOfElementLocated(sumElementSelector));
        WebElement paymentButtonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(paymentButton));
        WebElement phoneNumberLabelElement = wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNumberLabel));

        if (!sumElement.isDisplayed()) {
            return "Сумма не отображается на странице";
        }

        if (!paymentButtonElement.isDisplayed()) {
            return "Кнопка 'Оплатить' не отображается на странице";
        }

       if (!phoneNumberLabelElement.isDisplayed()) {
           return "Номер телефона не отображается на странице";
        }

        return "Все элементы отображаются корректно";
    }

    public boolean areCardIconsVisibleIframe() {

        WebElement allCardIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(allCardIcons));

        return allCardIcon.isDisplayed();

    }

    public boolean isCardFieldsVisible() {//проверка полей ввода банк карты
        WebElement cardNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(cardNumberLabel));
        WebElement expirationField = wait.until(ExpectedConditions.visibilityOfElementLocated(expirationLabel));
        WebElement holderNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(holderNameLabel));
        WebElement cvcField = wait.until(ExpectedConditions.visibilityOfElementLocated(cvcLabel));

        return cardNumberField.isDisplayed() && expirationField.isDisplayed()
                && holderNameField.isDisplayed()
                && cvcField.isDisplayed();//проверка полей ввода банк карты
    }



    //-----------------------------------------------------------------


    //16 пункт один ----------------------------------------------------

    // Селекторы для выбора услуги
    public By dropdownArrow = By.xpath("//span[@class='select__arrow']");
    private By serviceConnection = By.xpath("//*[text()='Услуги связи']");
    private By serviceInternet = By.xpath("//*[text()='Домашний интернет']");
    private By serviceInstalment = By.xpath("//*[text()='Рассрочка']");
    private By serviceArrears = By.xpath("//*[text()='Задолженность']");


    // Услуги связи
    public By phoneFieldConnection = By.xpath("//input[@id='connection-phone' and @placeholder='Номер телефона']");
    public By sumFieldConnection = By.xpath("//input[@id='connection-sum' and @placeholder='Сумма']");
    public By emailFieldConnection = By.xpath("//input[@id='connection-email' and @placeholder='E-mail для отправки чека']");

    // Домашний интернет
    public By phoneFieldInternet = By.xpath("//input[@id='internet-phone' and @placeholder='Номер абонента']");
    public By sumFieldInternet = By.xpath("//input[@id='internet-sum' and @placeholder='Сумма']");
    public By emailFieldInternet = By.xpath("//input[@id='internet-email' and @placeholder='E-mail для отправки чека']");

    // Рассрочка
    public By phoneFieldInstalment = By.xpath("//input[@id='instalment-sum' and @placeholder='Сумма']");
    public By sumFieldInstalment = By.xpath("//input[@id='instalment-sum' and @placeholder='Сумма']");
    public By emailFieldInstalment = By.xpath("//input[@id='instalment-sum' and @placeholder='Сумма']");

    // Задолженность
    public By phoneFieldArrears = By.xpath("//input[@id='arrears-sum' and @placeholder='Сумма']");
    public By sumFieldArrears = By.xpath("//input[@id='arrears-sum' and @placeholder='Сумма']");
    public By emailFieldArrears = By.xpath("//input[@id='arrears-email' and @placeholder='E-mail для отправки чека']");

    //----------------------------------------------------

    //------------------------------ 16 предусловие - Локаторы
    private By paymentSectionTitle = By.xpath("//section[@class='pay']//h2[contains(text(), 'Онлайн пополнение') and contains(., 'без комиссии')]");
    private By paymentSectionLogos = By.xpath("//div[@class='pay__partners']/ul");
    private By logoVisa = By.xpath(".//img[@alt='Visa']");
    private By logoVerifiedByVisa = By.xpath(".//img[@alt='Verified By Visa']");
    private By logoMasterCard = By.xpath(".//img[@alt='MasterCard']");
    private By logoMasterCardSecureCode = By.xpath(".//img[@alt='MasterCard Secure Code']");
    private By logoBelkart = By.xpath(".//img[@alt='Белкарт']");

    private By moreDetailsLink = By.xpath("//div[@class='pay__wrapper']/a");

    public boolean isPaymentSectionTitleVisible() {
        return driver.findElement(paymentSectionTitle).isDisplayed();//Проверка заголовока окна оплаты
    }

    public void openPaymentDetails() {
        WebElement moreDetailsLink = driver.findElement(By.xpath("//div[@class='pay__wrapper']/a"));
        moreDetailsLink.click();
    }
    public WebElement getPaymentLogos() {
        return driver.findElement(paymentSectionLogos);//Иконки
    }
    //-------------------------------





    //------------------------------Куки и скролл
    private By cookieAgreeButton = By.xpath("//*[@id='cookie-agree']");
    public void acceptCookies() {
        try {
            WebElement cookieButton = driver.findElement(cookieAgreeButton);
            cookieButton.click();
        } catch (Exception e) {
            System.out.println("Куки не найден");
        }
    }
    public void scrollToElement(By elementLocator) {
        WebElement element = driver.findElement(elementLocator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    //------------------------------
}


