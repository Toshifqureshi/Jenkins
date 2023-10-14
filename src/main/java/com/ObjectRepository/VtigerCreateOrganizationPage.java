package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtility.WebDriverUtility;

public class VtigerCreateOrganizationPage extends WebDriverUtility{
	@FindBy(xpath="//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	private WebElement OrgLookUpImg;
	
	@FindBy (name="accountname")
	private WebElement OrgNameEdt;
	
	@FindBy (name="industry")
	private WebElement IndustryDropDown;
	
	@FindBy (xpath="//input[@title=\"Save [Alt+S]\"]")
	private WebElement NewOrgSaveBtn;
	
	public VtigerCreateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgLookUpImg() {
		return OrgLookUpImg;
	}

	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getIndustryDropDown() {
		return IndustryDropDown;
	}

	public WebElement getNewOrgSaveBtn() {
		return NewOrgSaveBtn;
	}
	
	// Business Library
	
	public void clickOnOorgLookupImg()
	{
		OrgLookUpImg.click();
	}
	public void newOrgCreation(String OrgName)
	{
		
		OrgNameEdt.sendKeys(OrgName);
		
		NewOrgSaveBtn.click();
		
		
	}
	
	public void newOrgCreation(String OrgName, String Industry)
	{
		
		OrgNameEdt.sendKeys(OrgName);
		
		dropDownByText(IndustryDropDown, Industry);
		NewOrgSaveBtn.click();
		
		
	}

}
