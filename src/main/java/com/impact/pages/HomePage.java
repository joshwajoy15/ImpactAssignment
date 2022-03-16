package com.impact.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.base.TestBase;

public class HomePage extends TestBase{
	
		@FindBy(xpath="//div[@class='app_logo']")
		WebElement HomePageLogo;
		
		@FindBy(xpath="//select[@class='product_sort_container']")
		WebElement DropDown;
		
		@FindBy(xpath="//option[@value='lohi']")
		WebElement PriceLowHigh;
	
		//Initializing the Page Objects
		public HomePage() {
			PageFactory.initElements(driver, this);
		}
		
		public boolean verifyHomePageLogo() {
			return HomePageLogo.isDisplayed();
		}
		
		public void dropDown() {
			WebElement down = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
			Select select = new Select(down);
			select.selectByValue("lohi");
		}
		
		public void openMenu() {
			WebElement menu = driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']"));
			menu.click();
		}
		
		public void BackpackPurchaseItem() {
			driver.findElement(By.xpath("//a[@id='item_4_title_link']")).click();
			driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
			driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).click();
			driver.findElement(By.xpath("//button[@name='checkout']")).click();
			driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Joshwa");
			driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Joy");
			driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys("77459");
			driver.findElement(By.xpath("//input[@name='continue']")).click();
			driver.findElement(By.xpath("//button[@name='finish']")).click();
		}
	
}
