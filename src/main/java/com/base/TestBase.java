package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	

	public TestBase() {
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("/Users/joshwajoy/Documents/Selenium/Installers/Workspace/"
					+ "ImpactAssignment/src/main/java/impact/config/config.properties");
			prop.load(ip);

		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
			}
		}
	
	public static void initialalization() {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get(prop.getProperty("url"));
		
	}

}
