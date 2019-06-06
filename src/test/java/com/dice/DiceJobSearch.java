package com.dice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DiceJobSearch {
	WebDriver dice;
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\HPS\\Documents\\selenium dependencies\\drivers\\chromedriver.exe");
		@BeforeTest
		public void setUpWebDriver(){
			WebDriverManager.chromedriver().setup();
		
		
		}

		@Test
		public void test1(){
			dice = new ChromeDriver();
		dice.get("https://dice.com");
		dice.manage().window().maximize();
	//	dice.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		dice.findElement(By.id("search-field-keyword")).sendKeys("SDET");
		dice.findElement(By.id("search-field-location")).clear();
		dice.findElement(By.id("search-field-location")).sendKeys("Chicaog, IL");
		dice.findElement(By.id("findTechJobs")).click();
		dice.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println(dice.getTitle());
		String count=dice.findElement(By.id("posiCountId")).getText();
		int countResult= Integer.parseInt(count.replace(",", ""));
		
		String posiLocation = dice.findElement(By.id("salTitle")).getText();
		System.out.println("Searched positions for "+posiLocation);
		System.out.println("There are/is: "+countResult+" position/s in "+posiLocation);
		
		
		

		}

		@AfterClass
		public void tearDown(){
			dice.close();
			dice.quit();
		}
		



}
