package com.campusos.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(15)
        );
    }

    protected void click(By locator) {

        wait.until(
                ExpectedConditions.elementToBeClickable(locator)
        ).click();
    }

//    protected void enterText(By locator, String text) {
//
//        wait.until(
//                ExpectedConditions.visibilityOfElementLocated(locator)
//        ).clear();
//
//        driver.findElement(locator).sendKeys(text);
//    }

    protected void enterText(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
}

    protected boolean isDisplayed(By locator) {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(locator)
            ).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    protected String getText(By locator) {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(locator)
            ).getText();

        } catch (Exception e) {

            return "";
        }
    }

//    protected String getAttribute(By locator, String attributeName) {
//
//        try {
//
//            return wait.until(
//                    ExpectedConditions.presenceOfElementLocated(locator)
//            ).getAttribute(attributeName);
//
//        } catch (Exception e) {
//
//            return "";
//        }
//    }
    protected String getAttribute(By locator, String attributeName) {
        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(locator)).getAttribute(attributeName);
        } catch (Exception e) {
            return "";
        }
}

    protected void clearText(By locator) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        ).clear();
    }
}