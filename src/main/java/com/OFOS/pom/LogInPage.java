package com.OFOS.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
	
	@FindBy(name="username")
	private WebElement usernamElement;
	
	@FindBy(name="password")
	private WebElement passwordElement;
	
	@FindBy(name="submit")
	private WebElement loginbtnElement;

	public LogInPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void setlogin(String username, String password) {
		usernamElement.sendKeys(username);
		passwordElement.sendKeys(password);
		loginbtnElement.click();
	}

}
