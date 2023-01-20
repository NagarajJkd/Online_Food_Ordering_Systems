package com.OFOS.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.OFOS.generic.ExcellUtility;
import com.OFOS.generic.WebDriverUtility;

public class AddMenuPage {

	
	@FindBy(name="d_name")
	private WebElement dishName;
	
	@FindBy(name="about")
	private WebElement descr;
	
	@FindBy(name="price")
	private WebElement price;
	
	@FindBy(id="lastName")
	private WebElement file;
	
	@FindBy(name="res_name")
	private WebElement selectrest;
	
	@FindBy(name="submit")
	private WebElement savebtn;
	
	@FindBy(linkText = "Cancel")
	private WebElement canclebtn;
	
	@FindBy(xpath = "//div[@class=\"alert alert-success alert-dismissible fade show\"]")
	private WebElement successmsg;

	public AddMenuPage(WebDriver driver) {

	PageFactory.initElements(driver, this);
	
	}

	public WebElement getDishName() {
		return dishName;
	}

	public WebElement getDescr() {
		return descr;
	}

	public WebElement getPrice() {
		return price;
	}

	public WebElement getFile() {
		return file;
	}

	public WebElement getSelectrest() {
		return selectrest;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	public WebElement getCanclebtn() {
		return canclebtn;
	}

	public WebElement getSuccessmsg() {
		return successmsg;
	}
	
	public void setvalues(String dishname, String description, String Amount) {
		dishName.sendKeys(dishname);
		descr.sendKeys(description);
		price.sendKeys(Amount);
	}
	
	
	public void setvaluesA(WebDriverUtility wlib, ExcellUtility elib, WebDriver driver) throws Throwable {
		
		dishName.sendKeys(elib.readDataFromExcell("addmenu", 0, 1));
		
	}

}
