package com.project.selenium;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ScreenShotTest {
 
	String firstWind;
	String secondWind;
	@Test(enabled=false)
	public void testScreenShot() throws IOException, InterruptedException{
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.get("https://www.google.co.in/");
		//hell git repo
		//hi
		driver.findElement(By.xpath("//div[@id='sb_ifc0']")).sendKeys("selenium");
		driver.findElement(By.xpath("//button[@name='btnG']")).click();
		Thread.sleep(500);
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("E:/Assigmts/shot1.png"));
		
		Thread.sleep(500);
		driver.close();
		
	}
	
	@Test
	public void testScreenShotIrctc() throws InterruptedException, IOException{
		
		//WebDriver driver=new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "E:\\downloads\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.irctc.co.in/");
		
		String firstWind=driver.getWindowHandle();
		System.out.println(firstWind);
		driver.findElement(By.linkText("Flight Tickets")).click();
		//driver.findElement(By.xpath("//a[text()='Flight Tickets']")).click();
		Set<String> allWindow=driver.getWindowHandles();
		for(String s:allWindow){
			driver.switchTo().window(s);
			secondWind =s;
			if(driver.getTitle().equals("IRCTC, Flight Ticket, Air Ticket, Cheap Flight, Low Fare Flight, Online Booking, Flight,Hotel")){
				break;
			}
		}
		System.out.println(secondWind);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='where']/div[@class='containerfld']/input[@id='origin']")).sendKeys("Delhi");
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//*[@id='destination']")).sendKeys(Keys.TAB);
		driver.findElement(By.xpath("//div[@id='where']/div[@class='containerfld']/input[@id='origin']")).sendKeys(Keys.TAB);
		
		//driver.findElement(By.id("ui-active-menuitem")).sendKeys(Keys.TAB);
		driver.findElement(By.xpath("//*[@id='destination']")).sendKeys("Jaipur");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='ui-active-menuitem']")).click();
		
		driver.findElement(By.xpath("//input[@name='departDate']/following-sibling::img")).click();
		driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/div[1]//a[text()='23']")).click();

		Select select = new Select(driver.findElement(By.xpath("//*[@id='noOfAdult']")));
		select.selectByIndex(1);
		select = new Select(driver.findElement(By.xpath("//*[@id='noOfChild']")));
		select.selectByIndex(1);
		driver.findElement(By.xpath("//input[@name='submitVal']/following-sibling::div")).click();
		
		Thread.sleep(5000);
		File screenshotFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(screenshotFile, new File("E:\\Assigmts\\Screenshot\\IRCTC_Screen_Shot.png"));
		
		List<WebElement> fltList=driver.findElements(By.xpath("//div[contains(@id,'flight_')]"));
		System.out.println("Total no of flights available="+fltList.size());
		
		Thread.sleep(3000);
		driver.close();
		driver.switchTo().window(firstWind);
		driver.close();
	}
}
