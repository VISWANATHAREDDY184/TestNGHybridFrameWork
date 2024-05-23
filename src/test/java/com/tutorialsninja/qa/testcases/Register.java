package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.utils.Utilities;

public class Register extends Base {
	WebDriver driver;
	public Register() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		
		driver=intilizeBrowserAndOpenApplicationUrl(prop.getProperty("browserName"));
		driver.findElement(By.xpath("//span[contains(text(),'My Account')]")).click();
		driver.findElement(By.linkText("Register")).click();
		
	}
	
	@Test
	public void verifyRegisterAccountByProvindManditoryFields() {
		driver.findElement(By.id("input-firstname")).sendKeys(dataprop.getProperty("firstname"));
		driver.findElement(By.id("input-lastname")).sendKeys(dataprop.getProperty("lastname"));
		driver.findElement(By.id("input-email")).sendKeys(Utilities.genaratemailwithTimeStamps());
		driver.findElement(By.id("input-telephone")).sendKeys(dataprop.getProperty("telephone"));
		driver.findElement(By.id("input-password")).sendKeys(dataprop.getProperty("password"));
		driver.findElement(By.id("input-confirm")).sendKeys(dataprop.getProperty("confirmpassword"));
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		String actualtext = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		String Expectedtext = "Your Account Has Been Created!";
		Assert.assertTrue(actualtext.contains(Expectedtext),"your account created is not displaed");
		
		
	}
	@AfterMethod
	public void close() {
		driver.quit();
	}
	

}
