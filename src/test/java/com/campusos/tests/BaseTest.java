package com.campusos.tests;


import com.campusos.pages.DashboardPage;
import com.campusos.pages.LoginPage;
import com.campusos.utils.DriverFactory;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    protected LoginPage loginPage;

    protected DashboardPage dashboardPage;


    @BeforeMethod
    public void setUp() {

        driver = DriverFactory.createDriver();

        driver.get(
                "https://campusos.appteknow.com/login"
        );

        loginPage =
                new LoginPage(driver);
    }


    protected void login() {

        loginPage.login(
                "admin@gmail.com",
                "Demo.Student"
        );

        dashboardPage =
                new DashboardPage(driver);
    }


    @AfterMethod
    public void tearDown() {

        if (driver != null) {

            driver.quit();
        }
    }
}