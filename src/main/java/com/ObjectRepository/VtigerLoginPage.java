package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerLoginPage {
	
	@FindBy(name="user_name")
	private WebElement UserNameEdt;
	
	@FindBy(name="user_password")
	private WebElement PasswordEdt;
	
	@FindBy(xpath="//input[@type=\"submit\"]")
	private WebElement LoginSubmitBtn;
	
	public VtigerLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUserNameEdt() {
		return UserNameEdt;
	}

	public WebElement getPasswordEdt() {
		return PasswordEdt;
	}

	public WebElement getLoginSubmitBtn() {
		return LoginSubmitBtn;
	}
	// Business Library
	public void clickOnLogin(String USERNAME, String PASSWORD)
	{
		UserNameEdt.sendKeys(USERNAME);
		PasswordEdt.sendKeys(PASSWORD);
		LoginSubmitBtn.click();
	}
	

}
