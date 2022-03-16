package com.impact.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.impact.pages.HomePage;
import com.impact.pages.LoginPage;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialalization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		homePage = loginPage.standard_userLogin(prop.getProperty("loginStandardUser"), prop.getProperty("loginPass"));
	}
	
	@Test
	public void VerifyHomePageLogoTest() {
		homePage.verifyHomePageLogo();
	}
	
	@Test
	public void dropDownLinkTest() {
		homePage.dropDown();
	}
	
	@Test 
	public void openMenuTest() {
		homePage.openMenu();
	}
	
	@Test
	public void BackpackPurchaseTest() {
		homePage.BackpackPurchaseItem();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
