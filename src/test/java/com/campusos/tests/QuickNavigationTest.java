package com.campusos.tests;

import org.testng.annotations.Test;

public class QuickNavigationTest extends BaseTest {


    @Test
    public void verifyActionCenterNavigation() {

        login();

        dashboardPage.clickActionCenter();

        System.out.println(
                "Action Center clicked successfully"
        );
    }


    @Test
    public void verifyMyAssessmentsNavigation() {

        login();

        dashboardPage.clickMyAssessments();

        System.out.println(
                "My Assessments clicked successfully"
        );
    }


    @Test
    public void verifyAILanguageTutorNavigation() {

        login();

        dashboardPage.clickAILanguageTutor();

        System.out.println(
                "AI Language Tutor clicked successfully"
        );
    }


    @Test
    public void verifyMockInterviewNavigation() {

        login();

        dashboardPage.clickMockInterview();

        System.out.println(
                "Mock Interview clicked successfully"
        );
    }


    @Test
    public void verifyDailyTasksNavigation() {

        login();

        dashboardPage.clickDailyTasks();

        System.out.println(
                "Daily Tasks clicked successfully"
        );
    }


    @Test
    public void verifyResumeBuilderNavigation() {

        login();

        dashboardPage.clickResumeBuilder();

        System.out.println(
                "Resume Builder clicked successfully"
        );
    }


    @Test
    public void verifyLeavePortalNavigation() {

        login();

        dashboardPage.clickLeavePortal();

        System.out.println(
                "Leave Portal clicked successfully"
        );
    }
}