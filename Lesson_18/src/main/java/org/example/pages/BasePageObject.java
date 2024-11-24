package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePageObject {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public BasePageObject(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        this.actions = new Actions(driver);
    }
}