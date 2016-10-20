package com.project.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SeleniumDemoTest {

	@Test
	public void testMacys() throws InterruptedException{
		
		WebDriver driver=new FirefoxDriver();
		//System.setProperty("webdriver.chrome.driver", "E:\\downloads\\chromedriver.exe");
		//WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//open macys website
		driver.get("http://www.macys.com/");
		
		
		//close the pop-up
		driver.findElement(By.xpath("//*[@id='closeButton']")).click();
		//search Jeans
		driver.findElement(By.xpath("//*[@id='globalSearchInputField']")).sendKeys("Jeans");
		Thread.sleep(4000);
		//click on search
		driver.findElement(By.xpath("//*[@id='subnavSearchSubmit']")).click();
		//print current page URL & Title
		System.out.println("URL is: "+driver.getCurrentUrl());
		System.out.println("Title is: "+driver.getTitle());
		//select first Jeans item on this page
		
		List<WebElement> allJeansImage= driver.findElements(By.xpath("//*[contains(@id,'image_')]"));
		allJeansImage.get(0).click();
		//select a size for Jeans
		driver.findElement(By.xpath("//*[contains(@id,'sizeList')]/li[1]")).click();
		//add to bag
		
		driver.findElement(By.xpath("//button[contains(@id,'addToBagButton')]")).click();
		//click on checkout
		Thread.sleep(4000);
		driver.findElement(By.xpath("//img[@id='btnCheckout']")).click();
		//click on remove
		driver.findElement(By.xpath("//div[contains(@id,'remove_item')]")).click();
		//print "removed fom bag" message
		Thread.sleep(4000);
		String message=driver.findElement(By.xpath("//div[@id='msg_generalmessage']")).getText();
		System.out.println(message);
		
		
		Thread.sleep(5000);
		driver.close();
	}
}
