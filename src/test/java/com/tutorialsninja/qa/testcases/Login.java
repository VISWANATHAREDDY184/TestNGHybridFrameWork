package com.tutorialsninja.qa.testcases;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	public void setup()  {
		driver=intilizeBrowserAndOpenApplicationUrl(prop.getProperty("browserName"));
		Homepage homepage= new Homepage(driver);
		homepage.clickmyAccountOption();
		homepage.clickOnLoginOption();
}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
    

	
	
    @Test(priority=1)
	
	public void verifyLoginWithValidCredentials() {
		Loginpage loginpage= new Loginpage(driver);
		loginpage.enterEmailAddress(prop.getProperty("validemail"));
		loginpage.enterPasswordAddress(prop.getProperty("validpassword"));
		loginpage.clickOnSubmitButton();
        Accountpage accountpage =new Accountpage(driver);
		Assert.assertTrue(accountpage.editYourAccountInformation(),"edit your account item is not displayed");
}
	@Test
	public void userloginwithinvalidcredentials() {
		Loginpage loginpage= new Loginpage(driver);
		loginpage.enterEmailAddress(prop.getProperty("invalidemail"));
		loginpage.enterPasswordAddress(prop.getProperty("invalidpassword"));
		loginpage.clickOnSubmitButton();
		Accountpage accountpage =new Accountpage(driver);
 
 Assert.assertTrue(accountpage.warningmessagedisplatmessage(), "Warning: No match for E-Mail Address and/or Password.");
		
	}
	@Test
	public void loginwithinvalidemailandvalidpassword() {
		Loginpage loginpage= new Loginpage(driver);
		loginpage.enterEmailAddress(prop.getProperty("invalidemail"));
		loginpage.enterPasswordAddress(prop.getProperty("validpassword"));
		loginpage.clickOnSubmitButton();
		Accountpage accountpage =new Accountpage(driver);
		Assert.assertTrue(accountpage.warningmessagedisplatmessage(), "Warning: No match for E-Mail Address and/or Password.");
	}
	@Test
	public void loginwithvalidemailandinvalidpassword() {
		Loginpage loginpage= new Loginpage(driver);
		loginpage.enterEmailAddress(prop.getProperty("validemail"));
		loginpage.enterPasswordAddress(prop.getProperty("invalidpassword"));
		loginpage.clickOnSubmitButton();
		Accountpage accountpage =new Accountpage(driver);
		 
		Assert.assertTrue(accountpage.warningmessagedisplatmessage(), "Warning: No match for E-Mail Address and/or Password.");

}
	@Test
	public void loginwithoutprovidingcredentials() {
		Loginpage loginpage= new Loginpage(driver);
		loginpage.clickOnSubmitButton();
		Accountpage accountpage =new Accountpage(driver);
		 
		Assert.assertTrue(accountpage.warningmessagedisplatmessage(), "Warning: No match for E-Mail Address and/or Password.");

	}
	@Test
	public void forgotpasswordlinkisavailableintheloginpage() {
		Loginpage loginpage= new Loginpage(driver);
		loginpage.forgottenlinkisavailableintheloginpage();
		Accountpage accountpage =new Accountpage(driver);
		Assert.assertTrue(accountpage.forgotpasswordpage(),"Forgot Your Password?" );
		
	}
	
}
	
