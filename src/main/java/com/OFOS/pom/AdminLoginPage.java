package com.OFOS.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.OFOS.generic.FileUtility;

public class AdminLoginPage {

	@FindBy(xpath = "//input[@name='username']")
	private WebElement adusername;
	
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement adpassword;
	
	@FindBy(xpath="//input[@name='submit']")
	private WebElement adloginBtn;

	public AdminLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	public WebElement getAdusername() {
		return adusername;
	}



	public WebElement getAdpassword() {
		return adpassword;
	}



	public WebElement getAdloginBtn() {
		return adloginBtn;
	}


	public void setLogIn(String url, String password) {
		adusername.sendKeys(url);
		adpassword.sendKeys(password);
		adloginBtn.click();
	}
	
	
}
