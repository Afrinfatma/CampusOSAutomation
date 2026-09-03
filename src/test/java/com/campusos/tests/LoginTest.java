package com.campusos.tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTest {

    private final String DASHBOARD_URL_PART = "/student/dashboard";
    private final String VALID_EMAIL = "admin@gmail.com";
    private final String VALID_PASSWORD = "Demo.Student";


    // ========================================
    // 1. UI VERIFICATION TESTS
    // ========================================

    @Test(priority = 1, description = "Verify that all essential login UI elements are displayed")
    public void verifyLoginPageUIElements() {

        Assert.assertTrue(
                loginPage.isEmailFieldDisplayed(),
                "Email input field should be visible on the login page"
        );

        Assert.assertTrue(
                loginPage.isPasswordFieldDisplayed(),
                "Password input field should be visible on the login page"
        );

        Assert.assertTrue(
                loginPage.isSignInButtonDisplayed(),
                "Sign In button should be visible on the login page"
        );
    }

    @Test(priority = 2, description = "Verify password field input is masked by default")
    public void verifyPasswordMasking() {

        loginPage.enterPassword("SamplePassword123");

        Assert.assertEquals(
                loginPage.getPasswordFieldType(),
                "password",
                "Password field should have type='password' to mask characters"
        );
    }


    // ========================================
    // 2. POSITIVE LOGIN TEST
    // ========================================

    @Test(priority = 3, description = "Verify successful login with valid credentials")
    public void verifySuccessfulLogin() {

        loginPage.login(VALID_EMAIL, VALID_PASSWORD);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        boolean isDashboardLoaded = wait.until(
                ExpectedConditions.urlContains(DASHBOARD_URL_PART)
        );

        Assert.assertTrue(
                isDashboardLoaded,
                "User should be navigated to dashboard after successful login"
        );

        Assert.assertTrue(
                driver.getCurrentUrl().contains(DASHBOARD_URL_PART),
                "Current URL does not contain expected dashboard path: " + DASHBOARD_URL_PART
        );
    }


    // ========================================
    // 3. NEGATIVE LOGIN TESTS
    // ========================================

    @Test(priority = 4, description = "Verify login fails with invalid password")
    public void verifyLoginWithInvalidPassword() {

        loginPage.login(VALID_EMAIL, "WrongPassword@999");

        // User should not be redirected to dashboard
        Assert.assertFalse(
                driver.getCurrentUrl().contains(DASHBOARD_URL_PART),
                "User should not be navigated to dashboard with invalid password"
        );

        Assert.assertTrue(
                loginPage.isLoginPageDisplayed(),
                "User should remain on the login page after failed login"
        );
    }

    @Test(priority = 5, description = "Verify login fails with invalid email")
    public void verifyLoginWithInvalidEmail() {

        loginPage.login("unregistered.user@example.com", VALID_PASSWORD);

        Assert.assertFalse(
                driver.getCurrentUrl().contains(DASHBOARD_URL_PART),
                "User should not be navigated to dashboard with invalid email"
        );

        Assert.assertTrue(
                loginPage.isLoginPageDisplayed(),
                "User should remain on the login page after failed login"
        );
    }

    @Test(priority = 6, description = "Verify login with empty credentials")
    public void verifyLoginWithEmptyCredentials() {

        loginPage.clearFields();
        loginPage.clickSignIn();

        Assert.assertFalse(
                driver.getCurrentUrl().contains(DASHBOARD_URL_PART),
                "User should not be logged in with empty credentials"
        );

        Assert.assertTrue(
                loginPage.isLoginPageDisplayed(),
                "User should remain on the login page when credentials are blank"
        );
    }

    @Test(priority = 7, description = "Verify login with empty email and valid password")
    public void verifyLoginWithEmptyEmail() {

        loginPage.enterPassword(VALID_PASSWORD);
        loginPage.clickSignIn();

        Assert.assertFalse(
                driver.getCurrentUrl().contains(DASHBOARD_URL_PART),
                "User should not be logged in with empty email"
        );

        Assert.assertTrue(
                loginPage.isLoginPageDisplayed(),
                "User should remain on login page when email is missing"
        );
    }

    @Test(priority = 8, description = "Verify login with valid email and empty password")
    public void verifyLoginWithEmptyPassword() {

        loginPage.enterEmail(VALID_EMAIL);
        loginPage.clickSignIn();

        Assert.assertFalse(
                driver.getCurrentUrl().contains(DASHBOARD_URL_PART),
                "User should not be logged in with empty password"
        );

        Assert.assertTrue(
                loginPage.isLoginPageDisplayed(),
                "User should remain on login page when password is missing"
        );
    }


    // ========================================
    // 4. DATA-DRIVEN NEGATIVE TEST
    // ========================================

    @DataProvider(name = "invalidLoginData")
    public Object[][] getInvalidLoginData() {
        return new Object[][]{
                {"invaliduser@test.com", "WrongPass123", "Invalid email and password"},
                {VALID_EMAIL, "IncorrectPass", "Valid email with wrong password"},
                {"notanemail", VALID_PASSWORD, "Malformed email with valid password"},
                {"", "", "Blank email and password"}
        };
    }

    @Test(
            priority = 9,
            dataProvider = "invalidLoginData",
            description = "Data-driven test for various invalid login credential combinations"
    )
    public void verifyInvalidLoginDataDriven(String email, String password, String scenario) {

        loginPage.clearFields();

        if (!email.isEmpty()) {
            loginPage.enterEmail(email);
        }

        if (!password.isEmpty()) {
            loginPage.enterPassword(password);
        }

        loginPage.clickSignIn();

        Assert.assertFalse(
                driver.getCurrentUrl().contains(DASHBOARD_URL_PART),
                "Failed scenario [" + scenario + "]: User should not reach dashboard"
        );
    }
}