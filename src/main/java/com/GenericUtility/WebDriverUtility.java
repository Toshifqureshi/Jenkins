package com.GenericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {
	/**
	 * This Method will Maximize the window
	 * @param driver
	 */
	public void maximize(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * This Method will Minimize the Window
	 * @param driver
	 */
	public void minimize (WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	/**
	 * This Method will wait until page gets implicitly loaded
	 * @param driver
	 */
	public void implicitWait(WebDriver driver )
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	/**
	 * This Method will explicitly wait until expected condition met(elementToBeClicked)
	 * @param driver
	 * @param element
	 */
	public void elementToBeClickable(WebDriver driver, WebElement element)
	{
		 WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		 wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	/**
	 * This Method will explicitly wait until expected condition met(elementToBeSelected)
	 * @param driver
	 * @param element
	 */
	public void elementToBeSelectable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	/**
	 * This Method will TakeScreen Shot
	 * @param driver
	 * @param Sc
	 * @return
	 * @throws IOException
	 */
	public String screenShot(WebDriver driver, String Sc) throws IOException
	{
		TakesScreenshot ts= (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\ScreenShot\\"+ Sc +".png");
		Files.copy(src, dst);
		return dst.getAbsolutePath();
		
	}
	/**
	 * This Method will perform MouseHover action
	 * @param driver
	 * @param element
	 */
	public void mouseHover(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		
	}
	/**
	 * This Method will perform Right click on Page
	 * @param driver
	 */
	public void rightClickOnPage(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}
	/**
	 * This Method will Perform Right Click on specific element
	 * @param driver
	 * @param element
	 */
	public void rightClickOnElement(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	/**
	 * This Method will select dropDown by index
	 * @param element
	 * @param index
	 */
	public void dropDownByIndex(WebElement element, int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	/**
	 * This Method will select dropDown by Value
	 * @param element
	 * @param Value
	 */
	public void dropDownByValue(WebElement element, String Value)
	{
		Select sel = new Select(element);
		sel.selectByValue(Value);
	}
	/**
	 * This Method will select dropDown by Text
	 * @param element
	 * @param Text
	 */
	public void dropDownByText(WebElement element, String Text)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(Text);
	}
	/**
	 * This Method will switch to window
	 * @param driver
	 * @param ParTitle
	 */
	public void windowSwitch(WebDriver driver, String ParTitle)
	{
		Set<String> allWin = driver.getWindowHandles();
		for (String Cwin:allWin)
		{
			String actTitle = driver.switchTo().window(Cwin).getTitle();
			if (actTitle.contains(ParTitle))
			{
				break;
			}
		}
	}

}
