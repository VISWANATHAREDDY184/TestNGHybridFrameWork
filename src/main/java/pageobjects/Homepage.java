package pageobjects;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage  {
	WebDriver driver;
	@FindBy(xpath="//span[@class='caret']")
	 WebElement myaccountdropdown;
	@FindBy(xpath="//a[text()='Login']")
	WebElement loginoption;
	
	
	public Homepage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	public void clickonmyaccountdropdown() {
		myaccountdropdown.click();
		
	}
	public void clickonloginoption() {
		loginoption.click();
	}
	 
	

}
