package com.campusos.pages;

import com.campusos.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {

    // ========================================
    // TOP NAVIGATION
    // ========================================

    private By dashboardMenu =
            By.xpath("//a[normalize-space()='Dashboard']");

    private By learningMenu =
            By.xpath("//*[normalize-space()='Learning']");

    private By assessmentsMenu =
            By.xpath("//*[normalize-space()='Assessments']");

    private By tasksMenu =
            By.xpath("//*[normalize-space()='Tasks']");

    private By careerMenu =
            By.xpath("//*[normalize-space()='Career']");

    private By accountSupportMenu =
            By.xpath("//*[normalize-space()='Account & Support']");


    // ========================================
    // QUICK NAVIGATION
    // ========================================

    private By actionCenter =
            By.xpath("//*[normalize-space()='Action Center']");

    private By myAssessments =
            By.xpath("//*[normalize-space()='My Assessments']");

    private By aiLanguageTutor =
            By.xpath("//*[normalize-space()='AI Language Tutor']");

    private By mockInterview =
            By.xpath("//*[normalize-space()='Mock Interview']");

    private By dailyTasks =
            By.xpath("//*[normalize-space()='Daily Tasks']");

    private By resumeBuilder =
            By.xpath("//*[normalize-space()='Resume Builder']");

    private By leavePortal =
            By.xpath("//*[normalize-space()='Leave Portal']");


    // ========================================
    // CONSTRUCTOR
    // ========================================

    public DashboardPage(WebDriver driver) {
        super(driver);
    }


    // ========================================
    // TOP NAVIGATION METHODS
    // ========================================

    public void clickDashboard() {

        click(dashboardMenu);
    }

    public void clickLearning() {

        click(learningMenu);
    }

    public void clickAssessments() {

        click(assessmentsMenu);
    }

    public void clickTasks() {

        click(tasksMenu);
    }

    public void clickCareer() {

        click(careerMenu);
    }

    public void clickAccountSupport() {

        click(accountSupportMenu);
    }


    // ========================================
    // QUICK NAVIGATION METHODS
    // ========================================

    public void clickActionCenter() {

        click(actionCenter);
    }

    public void clickMyAssessments() {

        click(myAssessments);
    }

    public void clickAILanguageTutor() {

        click(aiLanguageTutor);
    }

    public void clickMockInterview() {

        click(mockInterview);
    }

    public void clickDailyTasks() {

        click(dailyTasks);
    }

    public void clickResumeBuilder() {

        click(resumeBuilder);
    }

    public void clickLeavePortal() {

        click(leavePortal);
    }
}