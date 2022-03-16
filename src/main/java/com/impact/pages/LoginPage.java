package com.impact.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(id="user-name")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="login-button")
	WebElement loginButton;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public HomePage standard_userLogin(String loginStandardUser, String loginPass) {
		username.sendKeys(loginStandardUser);
		password.sendKeys(loginPass);
		loginButton.click();				
		return new HomePage();
	}
	
	public HomePage locked_out_user(String loginlockedUser, String loginPass) throws InterruptedException {
		username.sendKeys(loginlockedUser);
		password.sendKeys(loginPass);
		loginButton.click();
		String text = driver.getPageSource();
		Assert.assertTrue(text.contains("Epic sadface: Sorry, this user has been locked out."));
		System.out.println("Error message found for Locked_out_user :Epic sadface: Sorry, this user has been locked out.");
		return null;		
	}
	
	public HomePage problem_user(String problem_user, String loginPass) {
		username.sendKeys(problem_user);
		password.sendKeys(loginPass);
		loginButton.click();
		return new HomePage();
	}
	
	public HomePage performance_glitch_user(String performance_glitch_user, String loginPass) {
		username.sendKeys(performance_glitch_user);
		password.sendKeys(loginPass);
		loginButton.click();				
		return new HomePage();
	}
	
}
