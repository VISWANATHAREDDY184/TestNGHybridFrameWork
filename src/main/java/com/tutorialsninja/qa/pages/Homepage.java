package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	WebDriver driver;
	
	
	
	@FindBy(xpath="//span[contains(text(),'My Account')]")
    private WebElement myAccountOption;
	
	@FindBy(linkText="Login")
    private	WebElement loginOption;
	
	public Homepage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickmyAccountOption() {
		myAccountOption.click();
		
	}
	public void clickOnLoginOption() {
		loginOption.click();
		
	}
	

}
