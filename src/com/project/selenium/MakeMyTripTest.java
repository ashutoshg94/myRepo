package com.project.selenium;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class MakeMyTripTest {
	
	String firstWindow;
	String secondWindow;
	String thirdWindow;

	@Test
	public void testBookDomesticHolidays() throws InterruptedException{
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		
//->Cannot be used		
//		Select sel=new Select(driver.findElement(By.xpath("//*[@id='widget_row']/div[1]/div[1]/div[2]/ul/li[1]/a")));
//		sel.selectByVisibleText("Domestic Holidays");
		driver.findElement(By.xpath("//*[@id='widget_row']/descendant::a[@class='all_menuitem alC']")).click();
		String firstWindow=driver.getWindowHandle();
		System.out.println(firstWindow);
		driver.findElement(By.linkText("Domestic Holidays")).click();
		Set<String> allWindow=driver.getWindowHandles();
		for(String s:allWindow){
			driver.switchTo().window(s);
			secondWindow =s;
			if(driver.getTitle().equals("Holiday Packages, Indian Holidays, Honeymoon Packages, India Tourism, Holidays India, Vacation Package : MakeMyTrip")){
				break;
			}
		}
		System.out.println(secondWindow);
		driver.findElement(By.xpath("//input[@placeholder='Type Departure City']")).sendKeys("Jaipur");
		//driver.findElement(By.xpath("//*[@id='widget_row']/div[1]/div/div[3]/div/div[4]/div[1]/div[1]/div/span[2]/span/div/span/div[31]/p")).click();
		driver.findElement(By.id("submit-btn-holiday")).click();
		//->not required suggestion driver.findElement(By.xpath("//*[@id='suggest_Filter_TT']/p/a[2]/span[1]")).click();
		Thread.sleep(8000);
		List<WebElement> Allexplore=driver.findElements(By.linkText("Explore"));
		Allexplore.get(0).click();
		
		
		/*List<WebElement> explore=driver.findElements(By.xpath("//a[contains(@href,'javascript:void(0);')]"));
		System.out.println(explore.size());
		
		for(WebElement x : explore){
			System.out.println(x.getText());
		}*/
		
		
		
		
		driver.findElement(By.linkText("View Details")).click();
		
		allWindow=driver.getWindowHandles();
		for(String s:allWindow){
			driver.switchTo().window(s);
			thirdWindow =s;
			if(driver.getTitle().equals("Rishikesh Darshan - Book Rishikesh Darshan Tour Package at Lowest Prices : MakeMyTrip India")){
				break;
			}
			
			
		}
		System.out.println(thirdWindow);
		driver.findElement(By.linkText("Book Online")).click();
		driver.findElement(By.xpath("//*[@rel='rateDate_overlay' and @style]")).click();
		//driver.findElement(By.xpath("//*[@id='rateDate_overlay']/a[1]")).click();
		driver.close();
		driver.switchTo().window(secondWindow);
		driver.close();
		driver.switchTo().window(firstWindow);
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		
	Thread.sleep(5000);
	driver.close();
		
	}
	
	@Test
	public void testScreenShot() throws IOException, InterruptedException{
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.google.co.in/");
		
		driver.findElement(By.xpath("//div[@id='sb_ifc0']")).sendKeys("selenium");
		driver.findElement(By.xpath("//button[@name='btnG']")).click();
		Thread.sleep(500);
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("E:/Assigmts/shot1.png"));
		
		Thread.sleep(500);
		driver.close();
		
	}
	
}
