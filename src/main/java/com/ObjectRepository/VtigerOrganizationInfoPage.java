package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerOrganizationInfoPage {
	@FindBy(xpath="//span[@class=\"dvHeaderText\"]")
	private WebElement OrgInfoImg;
	
	public VtigerOrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}

	public WebElement getOrgLookUpInfoImg() {
		return OrgInfoImg;
	}
	
	// Business Library
	
	public String getOrgInfoImgText()
	{
		return OrgInfoImg.getText();
	}

}
