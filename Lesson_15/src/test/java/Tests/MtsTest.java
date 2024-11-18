package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MtsTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
        driver.get("https://mts.by");
    }
    @AfterEach
    public void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }
    @Test
    public void testCheckPaymentSectionTitle(){

        try {
            WebElement cookie = driver.findElement(By.xpath("//*[@id='cookie-agree']"));
            cookie.click();
        } catch (Exception e){
            System.out.println("Куки не найден");
        }

        WebElement paymentSection = driver.findElement(By.xpath("//section[@class='pay']//h2[contains(text(), 'Онлайн пополнение') and contains(., 'без комиссии')]"));
                assertTrue(paymentSection.isDisplayed());
    }
    @Test
    public void testPaymentSectionLogos() {

        try {
            WebElement cookie = driver.findElement(By.xpath("//*[@id='cookie-agree']"));
            cookie.click();
        } catch (Exception e){
            System.out.println("Куки не найден");
        }

        WebElement logos = driver.findElement(By.xpath("//div[@class='pay__partners']/ul"));

        String[] expectedLogos = {"Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт"};
        for (String text: expectedLogos){
            WebElement logo = logos.findElement(By.xpath(".//img[@alt='" + text + "']"));
            assertTrue(logo.isDisplayed());
        }
    }

    @Test
    public void checkPaymentSectionMoreDetails(){

        try {
            WebElement cookie = driver.findElement(By.xpath("//*[@id='cookie-agree']"));
            cookie.click();
        } catch (Exception e){
            System.out.println("Куки не найден");
        }

        WebElement moreDetail = driver.findElement(By.xpath("//div[@class='pay__wrapper']/a"));
        moreDetail.click();

        WebElement moreDetailNewPage = driver.findElement(By.xpath("//*[@class='breadcrumbs__link']/span"));
        assertTrue(moreDetailNewPage.isDisplayed());
    }

    @Test
    public void checkPaymentSectionContinueButton(){

        try {
            WebElement cookie = driver.findElement(By.xpath("//*[@id='cookie-agree']"));
            cookie.click();
        } catch (Exception e){
            System.out.println("Куки не найден");
        }

        WebElement phoneNubmerField = driver.findElement(By.xpath("//*[@id=\"connection-phone\"]"));
        phoneNubmerField.sendKeys("297777777");

        WebElement amountOfMoney = driver.findElement(By.xpath("//*[@id=\"connection-sum\"]"));
        amountOfMoney.sendKeys("132");

        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        continueButton.click();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bepaid-iframe']")));

        WebElement confirmationMessage = driver.findElement(By.xpath("//div[@class='pay-description__cost']/span"));
        assertTrue(confirmationMessage.isDisplayed());
    }
}
