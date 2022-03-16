package com.impact.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.impact.pages.LoginPage;
import com.impact.pages.HomePage;


public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	//Git test
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialalization();
	    loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Swag Labs");
	}
	
	@Test(priority=2)
	public void standard_userloginTest() {
		homePage = loginPage.standard_userLogin(prop.getProperty("loginStandardUser"), prop.getProperty("loginPass"));
	}
	
	@Test(priority=3)
	public void locked_out_userTest() throws InterruptedException {
		homePage = loginPage.locked_out_user(prop.getProperty("loginlockedUser"), prop.getProperty("loginPass"));
	}
	
	@Test(priority=4)
	public void problem_userTest() {
		homePage = loginPage.problem_user(prop.getProperty("loginProblemUser"), prop.getProperty("loginPass"));
	}
	
	@Test(priority=5)
	public void performance_glitch_userTest() {
		homePage = loginPage.performance_glitch_user(prop.getProperty("loginPerformanceUser"), prop.getProperty("loginPass"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
