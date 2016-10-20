package com.project.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CountAllLinksTest {

	@Test
	public void testLinkCount(){
		
			WebDriver driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get("https://www.paypal.com");
		    List<WebElement> allLink=driver.findElements(By.tagName("a"));
		    System.out.println(allLink.size());
		    
		    System.out.println(allLink.get(0).getText());
		    
//		    for(int i=0;i<allLink.size();i++){
//		    	System.out.println(allLink.get(i).getText());
//		    }
		    for(WebElement i:allLink){
		    	
		    	System.out.println(i.getText());
		    	System.out.println(i.getAttribute("href"));
		    }
		    
		    
		    driver.close();
	}
}
