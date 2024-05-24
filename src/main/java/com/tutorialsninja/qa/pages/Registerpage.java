package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registerpage {
	WebDriver driver;
	@FindBy(id="input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id="input-lastname")
	private WebElement lastNamefield;
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(id="input-confirm")
	private WebElement confirmPasswordField;
	
	@FindBy(name="agree")
	private WebElement policyField;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
    @FindBy(xpath="//div[contains(text(),'Password confirmation does not match password!')]")
	private WebElement confirmPasswrodDoesNotMatchPassword;
	
	@FindBy(xpath="//h1[contains(text(),'Register Account')]")
	private WebElement actualRegisterAccount;
	
	@FindBy(xpath="//div[contains(@class,\"alert-dismissible\")]")
	private WebElement actualPrivacyPolicyWarningMessege;
			
	
	public Registerpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	public void enterFirstName(String fristname) {
		firstNameField.sendKeys(fristname);
		
		
	}
	public void enterLastName(String lastname) {
		lastNamefield.sendKeys(lastname);
	}
	public void enterEmail(String email) {
		emailField.sendKeys(email);
	}
	public void enterTelephoneNumber(String telephone) {
		telephoneField.sendKeys(telephone);
		
	}
	public void enterPassword(String password) {
		passwordField.sendKeys(password);
		
	}
	public void enterConfirmPassword(String confirm) {
		confirmPasswordField.sendKeys(confirm);
		

	}
	public void selectPolicyButton() {
		policyField.click();
		
	}
	public void clickCOntinueButton() {
		continueButton.click();
		
	}
	
	
	public String acutualRegisterAccountText() {
		String actualRegisterAccountText = actualRegisterAccount.getText();
		return actualRegisterAccountText;
		
	}
	public String warningMessageactualconfirmPasswrodDoesNotMatchPassword() {
		
		String acutalinvalid = confirmPasswrodDoesNotMatchPassword.getText();
		return acutalinvalid;
		
	}
	
	public  String actualWarningMessegePrivacyPolicy() {
		String actualWarning = actualPrivacyPolicyWarningMessege.getText();
		return actualWarning;
	}

	
	

}
