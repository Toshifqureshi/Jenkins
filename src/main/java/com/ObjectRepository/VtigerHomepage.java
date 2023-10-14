package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtility.WebDriverUtility;

public class VtigerHomepage extends WebDriverUtility{
	
	@FindBy(linkText="Organizations")
	private WebElement OrganizationsLnk;
	
	@FindBy(linkText="Contacts")
	private WebElement ContactsLnk;
	
	@FindBy(xpath="//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement AdmistrationImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement SignOutLnk;
	
	public VtigerHomepage(WebDriver driver)
	
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrganizationsLnk() {
		return OrganizationsLnk;
	}

	public WebElement getContactsLnk() {
		return ContactsLnk;
	}

	public WebElement getAdmistrationImg() {
		return AdmistrationImg;
	}

	public WebElement getSignOutLnk() {
		return SignOutLnk;
	}
	
	// Business Library
	
	public void clickOnOrganizationsLnk()
	{
		OrganizationsLnk.click();
	}
	public void clickOnContactsLnk()
	{
		ContactsLnk.click();
	}
	public void clickOnSignOutLnk(WebDriver driver)
	{
		mouseHover(driver, AdmistrationImg);
		SignOutLnk.click();
		
	}

}
