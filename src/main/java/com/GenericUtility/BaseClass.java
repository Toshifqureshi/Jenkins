package com.GenericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.ObjectRepository.VtigerHomepage;
import com.ObjectRepository.VtigerLoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriverUtility webutil= new WebDriverUtility();
	public JavaUtility jutil=new JavaUtility();
	public ExcelUtility eutil=new ExcelUtility();
	public PropertyFileUtility putil=new PropertyFileUtility();
	
	public static WebDriver sDriver;// listner
	
	public WebDriver driver;
	
	@BeforeSuite(groups={"SmokeSuite", "RegressionSuite"})
	public void bsConfig()
	{
		System.out.println("DataBase Connected Sucessfully");
	}
	//@Parameters("browser")
	//@BeforeTest
	
	
	@BeforeClass(groups={"SmokeSuite", "RegressionSuite"})
	public void bcConfig() throws IOException
	{
		String BROWSER = putil.propertyFile("browser");
		String URL = putil.propertyFile("url");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			System.out.println("----launched "+ BROWSER+" ---");
		}
		 else if (BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			System.out.println("-----launched "+BROWSER+"-----");
		}
		 else if (BROWSER.equalsIgnoreCase("edge"))
			{
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
				System.out.println("-----launched "+BROWSER+"-----");
			}
		else
		{
			System.out.println("invalid Browser");
		}
		sDriver=driver;// listner
		webutil.maximize(driver);
		webutil.implicitWait(driver);
		driver.get(URL);
			
				
	}
	@BeforeMethod(groups={"SmokeSuite", "RegressionSuite"})
	public void bmConfig() throws IOException
	{
		String USERNAME = putil.propertyFile("username");
		String PASSWORD = putil.propertyFile("password");
		VtigerLoginPage lp = new VtigerLoginPage(driver);
		lp.clickOnLogin(USERNAME, PASSWORD);
		System.out.println("login success");
		
	}
	@AfterMethod(groups={"SmokeSuite", "RegressionSuite"})
	public void amConfig()
	{
		VtigerHomepage hp = new VtigerHomepage(driver);
		hp.clickOnSignOutLnk(driver);
		System.out.println("logout sucsess");
	}
	@AfterClass(groups={"SmokeSuite", "RegressionSuite"})
	public void acConfig()
	{
		driver.quit();
		System.out.println("browser closed");
	}
	@AfterSuite(groups={"SmokeSuite", "RegressionSuite"})
	public void asConfig()
	{
		System.out.println("DataBase disConnected Sucessfully");
	}

}
