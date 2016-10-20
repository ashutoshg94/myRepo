package com.project.selenium;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AutomateGmail {

	char k;
	String firstWind;
	String secondWind;
	
	@Test
	public void testGmailLogin() throws InterruptedException{
		
			WebDriver driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("https://www.gmail.com");
			driver.findElement(By.xpath("//*[@id='Email']")).sendKeys("ashgkp1994");
			driver.findElement(By.xpath("//*[@id='next']")).click();
			driver.findElement(By.xpath("//*[@id='Passwd']")).sendKeys("20041994");
			driver.findElement(By.xpath("//*[@id='signIn']")).click();
			
			//verifying login in succesfully by Name
			
			driver.findElement(By.xpath("//a[contains(@title,'Google Account:')]/span")).click();
			String ActualLoginName=driver.findElement(By.xpath("//*[@class='gb_ub']")).getText();
			
			System.out.println(ActualLoginName);
			
			Assert.assertEquals(ActualLoginName.trim(), "Ashutosh Gupta");
			
/*			driver.findElement(By.xpath("//*[@id=':j4']/div/div")).click();
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//*[@role='combobox' and @aria-label='To' ]")).sendKeys("ashgkp1994@gmail.com");
			
			System.out.println("email iD");
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("Test Email Sending");
			
			System.out.println("Subject");
			driver.findElement(By.xpath("//*[@role='button' and @data-tooltip-delay='800']")).click();;
			
			driver.findElement(By.linkText("Sent Mail")).click();
			
			Thread.sleep(2000);
			String verifyingSentMessage= driver.findElement(By.xpath("html/body/div[7]/div[3]/div/div[1]/div[5]/div[1]/div[2]/div[3]/div/div/div[2]")).getText();
			
			System.out.println(verifyingSentMessage);
			
			
			String ActualrecieverEmailId= driver.findElement(By.xpath("//span[@class='yP']")).getAttribute("email");
			
			String expectedrecieverEmailId="ashgkp1994@gmail.com";
			Assert.assertEquals(ActualrecieverEmailId, expectedrecieverEmailId);*/
			
			/*String firstWind=driver.getWindowHandle();
			
			Set<String> allWindow=driver.getWindowHandles();
			for(String s:allWindow){
				driver.switchTo().window(s);
				secondWind =s;
				if(driver.getTitle().equals("Yahoo - login")){
					break;
				}
			}*/
			

			driver.findElement(By.xpath("//a[ text()='Sent Mail']")).sendKeys(Keys.CONTROL+"/t");
			driver.navigate().to("https://login.yahoo.com/");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id='login-username']")).sendKeys("ashgkp1994");
			driver.findElement(By.xpath("//*[@id='login-signin']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id='login-passwd']")).sendKeys("9838408771");
			driver.findElement(By.xpath("//*[@id='login-signin']")).click();
			Thread.sleep(3000);
			Actions actions=new Actions(driver);
//			actions.keyDown(Keys.CONTROL).keyDown(Keys.getKeyFromUnicode(k));
//			driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL);
			actions.keyDown(Keys.CONTROL).keyDown(Keys.ALT).keyUp(Keys.ALT).keyUp(Keys.CONTROL);
            /*driver.findElement(By.xpath("//*[@id='yucs-top-mail']/a")).click();
            driver.findElement(By.xpath("//*[@id='Compose']/button")).click();
            */
			
			

			/*Thread.sleep(3000);
          
			driver.navigate().back();
			driver.navigate().back();
			*/
			
			Thread.sleep(3000);
			//driver.close();
	
	
}
}