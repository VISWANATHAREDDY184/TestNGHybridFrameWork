package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;

public class Search extends Base {
	
	
WebDriver driver;

public Search() {
	super();
}
@BeforeMethod
public void Setup() {
	driver =intilizeBrowserAndOpenApplicationUrl("firefox");
	
}
@Test
public void VerifySearchAnExistingName() {

	driver.findElement(By.name("search")).sendKeys(dataprop.getProperty("existingproduct"));
	driver.findElement(By.xpath("//div[@id='search']//button[@type='button']")).click();
	Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed(),"product is not displayed");
}


@Test
public void VerifySearchAnNoProductName() {
	
	driver.findElement(By.name("search")).sendKeys(dataprop.getProperty("noproduct"));
	driver.findElement(By.xpath("//div[@id='search']//button[@type='button']")).click();
	String actualText = driver.findElement(By.xpath("//div[@id='content']//p[2]")).getText();
	Assert.assertTrue(actualText.contains("There is no product that matches the search criteria."),"item is displayed");
}






@AfterMethod
public void close() {
	driver.quit();
}

	

}
