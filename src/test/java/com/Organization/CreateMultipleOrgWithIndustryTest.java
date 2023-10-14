package com.Organization;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.GenericUtility.BaseClass;
import com.ObjectRepository.VtigerCreateOrganizationPage;
import com.ObjectRepository.VtigerHomepage;
import com.ObjectRepository.VtigerLoginPage;
import com.ObjectRepository.VtigerOrganizationInfoPage;

public class CreateMultipleOrgWithIndustryTest extends BaseClass  {
	@Test(dataProvider="getData")
	public void createMultipleOrgTest(String Org, String INDUSTRY)
	{
		
		
		String ORGNAME = Org+jutil.randomNum();
		VtigerHomepage hp=new VtigerHomepage(driver);
		hp.clickOnOrganizationsLnk();
		
		VtigerCreateOrganizationPage cop= new VtigerCreateOrganizationPage(driver);
		
		cop.clickOnOorgLookupImg();
		cop.newOrgCreation(ORGNAME, INDUSTRY);
		
		VtigerOrganizationInfoPage oip= new VtigerOrganizationInfoPage(driver);
		String orgText = oip.getOrgInfoImgText();
		Assert.assertTrue(orgText.contains(ORGNAME));
		
	}
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		Object[][] data = eutil.dataprovider("Multiple");
		return data;
	}

}
