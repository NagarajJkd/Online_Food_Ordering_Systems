package com.OFOS.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddRestaurantPage {

	@FindBy(name = "res_name")
	private WebElement restaurantname;
	
	@FindBy(name = "email")
	private WebElement bussinessemail;
	
	@FindBy(name = "phone")
	private WebElement restPhone;
	
	@FindBy(name = "url")
	private WebElement url;
	
	@FindBy(name = "address")
	private WebElement address;
	
	@FindBy(name = "o_hr")
	private WebElement openHours;

	@FindBy(name = "c_hr")
	private WebElement closeHours;
	
	@FindBy(name = "o_days")
	private WebElement opendays;
	
	@FindBy(name = "c_name")
	private WebElement categoryName;
	
	@FindBy(name = "file")
	private WebElement uploadfile;
	
	@FindBy(name = "submit")
	private WebElement savebtn;
	
	@FindBy(xpath = "//a[text()='Cancel']")
	private WebElement cancelbtn;

	public AddRestaurantPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}
	
	public void credentials(String restaurantName, String email, String phonenum, String resturl) {
		restaurantname.sendKeys(restaurantName);
		bussinessemail.sendKeys(email);
		restPhone.sendKeys(phonenum);
		url.sendKeys(resturl);
	}

	public WebElement getRestaurantname() {
		return restaurantname;
	}

	public WebElement getBussinessemail() {
		return bussinessemail;
	}

	public WebElement getRestPhone() {
		return restPhone;
	}

	public WebElement getUrl() {
		return url;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getOpenHours() {
		return openHours;
	}

	public WebElement getCloseHours() {
		return closeHours;
	}

	public WebElement getOpendays() {
		return opendays;
	}

	public WebElement getCategoryName() {
		return categoryName;
	}

	public WebElement getUploadfile() {
		return uploadfile;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	public WebElement getCancelbtn() {
		return cancelbtn;
	}
	
	
}
