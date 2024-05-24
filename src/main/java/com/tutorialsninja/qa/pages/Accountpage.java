package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Accountpage {
	WebDriver driver;
@FindBy(linkText="Edit your account information")
private WebElement editYourAccountInformation;
@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']/i")
private WebElement warningmessage;
@FindBy(xpath="//h1[text()='Forgot Your Password?']")
private WebElement forgotpassword;

public Accountpage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

public boolean editYourAccountInformation() {
	
	boolean as = editYourAccountInformation.isDisplayed();
	
	 return as;
}
public boolean warningmessagedisplatmessage() {
	boolean wm=warningmessage.isDisplayed();
	return wm;
}
public boolean forgotpasswordpage() {
	boolean fp=forgotpassword.isDisplayed();
	return fp;
}

}
