package com.jenkins;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginApp_Test {
	WebDriver driver;

	@Test(priority = 1, alwaysRun = true)
	public void testlogin() {
		driver.findElement(By.id("Email")).sendKeys("atheeq.khan@mass.com");
		driver.findElement(By.id("Password")).sendKeys("@Thiqcruz97");
		driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();
		String loginlink = driver.findElement(By.linkText("atheeq.khan@mass.com")).getText();
		System.out.println(loginlink);
		String expected = "atheeq.khan@mass.com";
		Assert.assertEquals(loginlink, expected);
	}

	@Test(priority = 2, dependsOnMethods = "testlogin", alwaysRun = true)
	public void testlogout() {
		driver.findElement(By.linkText("Log out")).click();
	}

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("http://demowebshop.tricentis.com/login");
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
