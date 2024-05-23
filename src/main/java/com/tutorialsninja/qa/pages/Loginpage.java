package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	WebDriver driver;
	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	@FindBy(xpath="//input[@type='submit']")
	private WebElement submitButton;
	
	public Loginpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
		
	}

	public void enterEmailAddress(String emailtext) {
		emailField.sendKeys(emailtext);
		
	}
	public void enterPasswordAddress(String passwordText) {
		passwordField.sendKeys(passwordText);
		
	}
	public void clickOnSubmitButton() {
		submitButton.click();
		
	}
}
