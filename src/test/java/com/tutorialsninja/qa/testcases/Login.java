package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.Accountpage;
import com.tutorialsninja.qa.pages.Homepage;
import com.tutorialsninja.qa.pages.Loginpage;

public class Login extends Base {
	WebDriver driver;
	
	public Login() {
		super();
	}
	@BeforeMethod
	public void setup() throws InterruptedException {
		
		
		driver=intilizeBrowserAndOpenApplicationUrl(prop.getProperty("browserName"));
		Homepage homepage= new Homepage(driver);
		homepage.clickmyAccountOption();
		homepage.clickOnLoginOption();


		   
		
		
	}
	@Test
public void verifyLoginWithValidCredentials() {
		Loginpage loginpage= new Loginpage(driver);
		loginpage.enterEmailAddress(prop.getProperty("validemail"));
		loginpage.enterPasswordAddress(prop.getProperty("validpassword"));
		loginpage.clickOnSubmitButton();
	
		 
		Accountpage accountpage =new Accountpage(driver);
		Assert.assertTrue(accountpage.editYourAccountInformation(),"edit your account item is not displayed");

		 
		
		
	}
	@AfterMethod
	public void close() {
		driver.quit();
	}

	

}
