package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountSucesspage;
import com.tutorialsninja.qa.pages.Homepage;
import com.tutorialsninja.qa.pages.Loginpage;
import com.tutorialsninja.qa.pages.Registerpage;
import com.tutorialsninja.qa.utils.Utilities;

public class Register extends Base {
	WebDriver driver;
	Registerpage rp;
	
	public Register() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		
		driver=intilizeBrowserAndOpenApplicationUrl(prop.getProperty("browserName"));
		Homepage homepage= new Homepage(driver);
		homepage.clickmyAccountOption();
	    rp = homepage.ClickOnRegisterOption();
		
	}
	
	@Test(priority =1)
	public void verifyRegisterAccountByProvindManditoryFields() {
		
		 
		rp.enterFirstName(dataprop.getProperty("firstname"));
		rp.enterLastName(dataprop.getProperty("lastname"));
		 rp.enterEmail(Utilities.genaratemailwithTimeStamps());
		 rp.enterTelephoneNumber( dataprop.getProperty("telephone"));
		 rp.enterPassword(dataprop.getProperty("password"));
		 rp.enterConfirmPassword(dataprop.getProperty("confirmpassword"));
		 rp.selectPolicyButton();
		 rp.clickCOntinueButton();
		 AccountSucesspage as= new AccountSucesspage(driver);
		 
		Assert.assertEquals(as.actualText(),dataprop.get("expectedtext"));
		 
		
		
	}
	@Test(priority=2)
	public void verifyDifferentWaysOfNavigatingRegisterPage() {
		
		Homepage homepage= new Homepage(driver);
		homepage.clickmyAccountOption();
		homepage.clickOnLoginOption();
		
	
		Loginpage loginpage= new Loginpage(driver);
		loginpage.clickOnNewCustumerButton();
		 
		Assert.assertEquals(rp.acutualRegisterAccountText(),dataprop.get("expectedRegisterAccoutText"));
		
		homepage.clickmyAccountOption();
		homepage.clickOnLoginOption();
		
		loginpage.clickOnRegister();
		Assert.assertEquals(rp.acutualRegisterAccountText(),dataprop.get("expectedRegisterAccoutText"));
		

		
		
	}
	@Test(priority=3)
	public void VerifyRegisterAccountDifferentPassword() {
		
		 
		rp.enterFirstName(dataprop.getProperty("firstname"));
		rp.enterLastName(dataprop.getProperty("lastname"));
		 rp.enterEmail(Utilities.genaratemailwithTimeStamps());
		 rp.enterTelephoneNumber( dataprop.getProperty("telephone"));
		 rp.enterPassword(dataprop.getProperty("password"));
		 rp.enterConfirmPassword(dataprop.getProperty("differentconfirmpassword"));
		 rp.selectPolicyButton();
		 rp.clickCOntinueButton();
		 Assert.assertEquals(rp.warningMessageactualconfirmPasswrodDoesNotMatchPassword(),dataprop.getProperty("warningMessageExpectedconfirmPasswrodDoesNotMatchPassword"));
		
		 
		
		
	}
	@Test(priority=4)
	public void VerifyRegisterWithoutSelectingPrivacypolicyButton() {
		
		 
		rp.enterFirstName(dataprop.getProperty("firstname"));
		rp.enterLastName(dataprop.getProperty("lastname"));
		 rp.enterEmail(Utilities.genaratemailwithTimeStamps());
		 rp.enterTelephoneNumber( dataprop.getProperty("telephone"));
		 rp.enterPassword(dataprop.getProperty("password"));
		 rp.enterConfirmPassword(dataprop.getProperty("confirmpassword"));
		 rp.clickCOntinueButton();
		 
		 Assert.assertEquals(rp.actualWarningMessegePrivacyPolicy(),dataprop.getProperty("ExpectedWarningmessengePrivacyPolicy"));
		
		
		
	}


	
	
	
	@AfterMethod
	public void close() {
		
		driver.quit();
		
		
	}
	

}
