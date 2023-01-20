package com.OFOS.generic;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.Action;
import javax.swing.text.Element;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.google.common.io.Files;

/**
 * This is generic Class
 * @author JORAPUR
 *
 */
public class WebDriverUtility {

	/**
	 * This method is used to synchronize the findelement and findelements method for clicking the webelements
	 * @param driver
	 * @param timeout
	 */
	public void waitForPageToLoad(WebDriver driver, int timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}
	
	/**
	 * This method is used to used to wait the particular method for setted script time duration
	 * @param driver
	 * @param timeout
	 */
	public void waitForPageToLoadForJSElement(WebDriver driver, long timeout) {
		driver.manage().timeouts().setScriptTimeout(timeout, TimeUnit.SECONDS);
	}
	
	/**
	 * This method is used to wait the particular method operation for specified time
	 * @param driver
	 * @param timeout
	 * @param element
	 */
	public void wiatForElementToBeClickAble(WebDriver driver, int timeout, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method is used for waiting particular method operation for user enter time 
	 * @param driver
	 * @param timeout
	 * @param element
	 * @throws Throwable
	 */
	public void wiatForElementWithCustomTimeOut(WebDriver driver, int timeout, WebElement element) throws Throwable {
		FluentWait wait=new FluentWait(driver);
		wait.pollingEvery(timeout, TimeUnit.SECONDS);
		wait.wait(timeout);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method is used to switching the one window to the another window
	 * @param driver
	 * @param expectedwindowtitle
	 */
	public void switchToWindow(WebDriver driver, String expectedwindowtitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it=set.iterator();
		while (it.hasNext()) {
			String win = it.next();
			driver.switchTo().window(win);
			String currentwindowtitle = driver.getTitle();
			if (currentwindowtitle.contains(expectedwindowtitle)) {
				break;
			}
			
		}	
	}

	/**
	 * This method is used to handle the alert and confirmation popup to press the ok button
	 * @param driver
	 */
	public void switchToAlertWindowAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method is used to handle the cancel button of the confirmation popup
	 * @param driver
	 */
	public void switchToAlertWindowAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method is used to switch the one frame to another frame by using index of that frame
	 * @param driver
	 * @param index
	 */
	public void switchToFrameByIndex(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method is used to switch the one frame to another frame by using attribute value of that frame
	 * @param driver
	 * @param String_value
	 */
	public void switchToFrameByString(WebDriver driver, String String_value) {
		driver.switchTo().frame(String_value);
	}
	
	/**
	 * This method is used to switch the one frame to another frame by using webelement of that frame
	 * @param driver
	 * @param Element
	 */
	public void switchToFrameByWE(WebDriver driver, WebElement Element) {
		driver.switchTo().frame(Element);
	}
	
	/**
	 * This method is used to handle the list box by using index of webelement
	 * @param element
	 * @param index
	 */
	public void select(WebElement element, int index) {
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	
	/**
	 * This method is used to handle the list box by using attribute value of webelement
	 * @param element
	 * @param Value
	 */
	public void select(WebElement element, String Value) {
		Select s=new Select(element);
		s.selectByValue(Value);
	}
	
	/**
	 * This method is used to handle the list box by using attribute value of webelement
	 * @param element
	 * @param Value
	 * @param VisibleValue 
	 */
	public void selectt(WebElement element, String VisibleValue) {
		Select s=new Select(element);
		s.selectByVisibleText(VisibleValue);
	}
	
	/**
	 * This method is used to move the mouse courser on specific web element 
	 * @param driver
	 * @param target
	 */
	public void mouseOverOnElement(WebDriver driver, WebElement target) {
		Actions a=new Actions(driver);
		a.moveToElement(target).perform();
	}
	
	/**
	 * This method is used to right click on webelment
	 * @param driver
	 * @param target
	 */
	public void rightClickOnElement(WebDriver driver, WebElement target) {
		Actions a=new Actions(driver);
		a.contextClick(target).perform();
	}
	
	/**
	 * This method is used to double click on the webelement
	 * @param driver
	 * @param target
	 */
	public void doubleClickOnElement(WebDriver driver, WebElement target) {
		Actions a=new Actions(driver);
		a.doubleClick(target).perform();
	}
	
	/**
	 * This method is used to Drag and drop the web elements from one position to other position
	 * @param driver
	 * @param src
	 * @param dest
	 */
	public void dragAndDropElements(WebDriver driver, WebElement src, WebElement dest) {
		Actions a=new Actions(driver);
		a.dragAndDrop(src, dest);
	}
	
	/**
	 * This method is used to handle the disable elements of the web page
	 * @param driver
	 * @param javascript
	 */
	public void executeJavaScript(WebDriver driver, String javascript) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript(javascript);
	}
	
	/**
	 * This method is used to wait And Click On WebElement
	 * @param Element
	 * @throws Throwable
	 */
	public void waitAndClickOnElement(WebElement Element) throws Throwable {
		int count=0;
		while (count<20) {
			try {
				Element.click();
				break;
			} catch (Exception e) {
				Thread.sleep(1000);
				count++;
			}
		}
	}
	
	/**
	 * This method is used to take the screen shot
	 * @param driver
	 * @param path
	 * @throws Throwable
	 */
	public void takeScreenShot(WebDriver driver, String path) throws Throwable {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(path);
		Files.copy(src, dest);
	}
	
	/**
	 * This method is used to pass enter key appertain into browser
	 * @param driver
	 */
	public void pressEnterKey(WebDriver driver) {
		Actions a=new Actions(driver);
		a.sendKeys(Keys.ENTER).perform();
	}
}
