package com.Organization;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.GenericUtility.BaseClass;
import com.ObjectRepository.VtigerCreateOrganizationPage;
import com.ObjectRepository.VtigerHomepage;
import com.ObjectRepository.VtigerOrganizationInfoPage;
@Listeners(com.GenericUtility.ListnersImplementation.class)
public class CreateOrganizationTest  extends BaseClass{
	
	@Test(groups="SmokeSuite")
	public void orgPageCreation() throws InterruptedException, EncryptedDocumentException, IOException 
	{
		
		VtigerHomepage hp = new VtigerHomepage(driver);
		
		hp.clickOnOrganizationsLnk();
		VtigerCreateOrganizationPage cop = new VtigerCreateOrganizationPage(driver);
		cop.clickOnOorgLookupImg();
		Thread.sleep(3000);
		String OrgName = eutil.excelRead("Sheet1", 4, 2)+jutil.randomNum();
		cop.newOrgCreation(OrgName);
		
		
		VtigerOrganizationInfoPage oip = new VtigerOrganizationInfoPage(driver);
		
		
		String OIPText = oip.getOrgInfoImgText();
		Assert.assertTrue(OIPText.contains(OIPText));
		
		
		
		
	}
	@Test
	public void regional()
	{
		System.out.println("regional");
		Assert.fail();
	}
	

}
