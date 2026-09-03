package com.campusos.pages;

import com.campusos.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    // ========================================
    // LOCATORS
    // ========================================

    private By emailField =
            By.cssSelector("input[type='email']");

    private By passwordField =
            By.cssSelector("input[type='password'], input[name='password']");

    private By signInButton =
            By.xpath("//button[normalize-space()='Sign in' or @type='submit']");

    private By showPasswordButton =
            By.cssSelector("button.toggle-btn, button[aria-label*='password'], button svg, .password-toggle");

    private By forgotPasswordLink =
            By.xpath("//a[contains(text(),'Forgot') or contains(@href,'forgot')]");

    private By errorMessage =
            By.cssSelector(".error-message, .alert, [role='alert'], .text-danger, .toast, .text-red-500, p.text-danger");


    // ========================================
    // CONSTRUCTOR
    // ========================================

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    // ========================================
    // ACTIONS / INTERACTION METHODS
    // ========================================

    public void enterEmail(String emailAddress) {
        enterText(emailField, emailAddress);
    }

    public void enterPassword(String passwordValue) {
        enterText(passwordField, passwordValue);
    }

    public void clickSignIn() {
        click(signInButton);
    }

    public void clickShowPassword() {
        click(showPasswordButton);
    }

    public void clickForgotPassword() {
        click(forgotPasswordLink);
    }

    public void clearEmail() {
        clearText(emailField);
    }

    public void clearPassword() {
        clearText(passwordField);
    }

    public void clearFields() {
        clearEmail();
        clearPassword();
    }

    public void login(String emailAddress, String passwordValue) {
        enterEmail(emailAddress);
        enterPassword(passwordValue);
        clickSignIn();
    }


    // ========================================
    // VERIFICATION / HELPER METHODS
    // ========================================

    public boolean isLoginPageDisplayed() {
        return isDisplayed(emailField) && isDisplayed(signInButton);
    }

    public boolean isEmailFieldDisplayed() {
        return isDisplayed(emailField);
    }

    public boolean isPasswordFieldDisplayed() {
        return isDisplayed(passwordField);
    }

    public boolean isSignInButtonDisplayed() {
        return isDisplayed(signInButton);
    }

    public boolean isForgotPasswordLinkDisplayed() {
        return isDisplayed(forgotPasswordLink);
    }

    public boolean isErrorMessageDisplayed() {
        return isDisplayed(errorMessage);
    }

    public String getErrorMessage() {
        return getText(errorMessage);
    }

    public String getPasswordFieldType() {
        return getAttribute(passwordField, "type");
    }
}