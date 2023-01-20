package com.OFOS.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	@FindBy(name="username")
	private WebElement untxb;
	
	@FindBy(name="firstname")
	private WebElement firstnametxb;
	
	@FindBy(name = "lastname")
	private WebElement lastnametxb;
	
	@FindBy(name = "email")
	private WebElement emailtxb;
	
	@FindBy(name = "phone")
	private WebElement phonenumbertxb;
	
	@FindBy(name = "password")
	private WebElement passwordtxb;
	
	@FindBy(name = "cpassword")
	private WebElement confPasswordtxb;
	
	@FindBy(name = "address")
	private WebElement descriptiontxb;
	
	@FindBy(name = "submit")
	private WebElement registerbtn;
	
	public RegisterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	
	}
	
	public void setCredentials(String username, String firstname, String lastname, String email, String phonenum, String password, String confmpassword, String description) {
		untxb.sendKeys(username);
		firstnametxb.sendKeys(firstname);
		lastnametxb.sendKeys(lastname);
		emailtxb.sendKeys(email);
		phonenumbertxb.sendKeys(phonenum);
		passwordtxb.sendKeys(password);
		confPasswordtxb.sendKeys(confmpassword);
		descriptiontxb.sendKeys(description);
		registerbtn.click();
	}
	
	

}
