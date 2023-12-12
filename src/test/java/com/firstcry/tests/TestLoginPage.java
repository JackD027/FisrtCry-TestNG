package com.firstcry.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.firstcry.base.Base;
import com.firstcry.pages.HomePage;
import com.firstcry.pages.LoggedInPage;
import com.firstcry.pages.LoginPage;

import org.junit.Assert;

public class TestLoginPage extends Base{
	
	HomePage homePage;
	LoginPage loginPage;
	LoggedInPage loggedInPage;
	
	@BeforeMethod
    public void setUp() {
        homePage = new HomePage(Base.driver);
        loginPage = new LoginPage(Base.driver);
        loggedInPage = new LoggedInPage(Base.driver);
    }
	
	@Test
	public void Login() throws InterruptedException {
		homePage.openHome();
        homePage.clickOnLogin();
        loginPage.email.sendKeys("shubhendu027@gmail.com");
        loginPage.continueBtn.click();
        Thread.sleep(30000);
        loginPage.verifyOtpBtn.click();
	}
	
	@Test
	public void verifyLogin() throws InterruptedException {
		loggedInPage.goToProfile();
		System.out.println(loggedInPage.getProfileEmail());
		Assert.assertEquals("shubhendu027@gmail.com",loggedInPage.getProfileEmail());
	}
}
