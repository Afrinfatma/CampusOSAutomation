//package com.campusos.tests;
//
//import org.testng.annotations.Test;
//
//public class NavigationTest extends BaseTest {
//
//
//    @Test
//    public void verifyDashboardNavigation() {
//
//        login();
//
//        dashboardPage.clickDashboard();
//
//        System.out.println(
//                "Dashboard navigation clicked successfully"
//        );
//    }
//
//
//    @Test
//    public void verifyLearningNavigation() {
//
//        login();
//
//        dashboardPage.clickLearning();
//
//        System.out.println(
//                "Learning navigation clicked successfully"
//        );
//    }
//
//
//    @Test
//    public void verifyAssessmentsNavigation() {
//
//        login();
//
//        dashboardPage.clickAssessments();
//
//        System.out.println(
//                "Assessments navigation clicked successfully"
//        );
//    }
//
//
//    @Test
//    public void verifyTasksNavigation() {
//
//        login();
//
//        dashboardPage.clickTasks();
//
//        System.out.println(
//                "Tasks navigation clicked successfully"
//        );
//    }
//
//
//    @Test
//    public void verifyCareerNavigation() {
//
//        login();
//
//        dashboardPage.clickCareer();
//
//        System.out.println(
//                "Career navigation clicked successfully"
//        );
//    }
//
//
//    @Test
//    public void verifyAccountSupportNavigation() {
//
//        login();
//
//        dashboardPage.clickAccountSupport();
//
//        System.out.println(
//                "Account & Support navigation clicked successfully"
//        );
//    }
//}

package com.campusos.tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class NavigationTest extends BaseTest {

    private void verifyNavigation(Runnable clickAction, String expectedUrlFraction, String pageName) {
        login();
        clickAction.run();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean urlMatched = wait.until(ExpectedConditions.urlContains(expectedUrlFraction));

        Assert.assertTrue(urlMatched, "Failed navigation to " + pageName + ". Current URL: " + driver.getCurrentUrl());
    }

    @Test(priority = 1)
    public void verifyDashboardNavigation() {
        verifyNavigation(() -> dashboardPage.clickDashboard(), "/dashboard", "Dashboard");
    }

    @Test(priority = 2)
    public void verifyLearningNavigation() {
        verifyNavigation(() -> dashboardPage.clickLearning(), "/learning", "Learning");
    }

    @Test(priority = 3)
    public void verifyAssessmentsNavigation() {
        verifyNavigation(() -> dashboardPage.clickAssessments(), "/assessments", "Assessments");
    }

    @Test(priority = 4)
    public void verifyTasksNavigation() {
        verifyNavigation(() -> dashboardPage.clickTasks(), "/tasks", "Tasks");
    }

    @Test(priority = 5)
    public void verifyCareerNavigation() {
        verifyNavigation(() -> dashboardPage.clickCareer(), "/career", "Career");
    }

    @Test(priority = 6)
    public void verifyAccountSupportNavigation() {
        verifyNavigation(() -> dashboardPage.clickAccountSupport(), "/support", "Account & Support");
    }
}
