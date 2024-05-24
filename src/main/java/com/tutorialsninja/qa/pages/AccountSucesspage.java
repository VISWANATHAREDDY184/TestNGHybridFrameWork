package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSucesspage {
	WebDriver driver;
	
	@FindBy(xpath="//div[@id='content']/h1" )
	private WebElement actualText;
	
	public AccountSucesspage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public String actualText() {
		String actualtext = actualText.getText();
		return actualtext;
	}
	
    
		
	
	
	

}
