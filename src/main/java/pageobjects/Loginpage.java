package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	WebDriver driver;
	@FindBy(xpath="//input[@id='input-email']")
	 private WebElement email;
	@FindBy(xpath="//input[@id='input-password']")
	 private WebElement password;
	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement clicklogin;
	
	public Loginpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public String enteremail(String emailtext) {
		email.sendKeys(emailtext);
		return emailtext;
	}
	public String enterpassword(String passwordtext ) {
		password.sendKeys(passwordtext);
		return passwordtext;
	}
	public void clickonloginbutton() {
		clicklogin.click();
	}

}
