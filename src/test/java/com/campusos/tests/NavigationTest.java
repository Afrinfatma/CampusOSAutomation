package com.campusos.tests;

import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {


    @Test
    public void verifyDashboardNavigation() {

        login();

        dashboardPage.clickDashboard();

        System.out.println(
                "Dashboard navigation clicked successfully"
        );
    }


    @Test
    public void verifyLearningNavigation() {

        login();

        dashboardPage.clickLearning();

        System.out.println(
                "Learning navigation clicked successfully"
        );
    }


    @Test
    public void verifyAssessmentsNavigation() {

        login();

        dashboardPage.clickAssessments();

        System.out.println(
                "Assessments navigation clicked successfully"
        );
    }


    @Test
    public void verifyTasksNavigation() {

        login();

        dashboardPage.clickTasks();

        System.out.println(
                "Tasks navigation clicked successfully"
        );
    }


    @Test
    public void verifyCareerNavigation() {

        login();

        dashboardPage.clickCareer();

        System.out.println(
                "Career navigation clicked successfully"
        );
    }


    @Test
    public void verifyAccountSupportNavigation() {

        login();

        dashboardPage.clickAccountSupport();

        System.out.println(
                "Account & Support navigation clicked successfully"
        );
    }
}