package com.OFOS.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(xpath = "//a[text()='Home ']")
	private WebElement homeElement;
	
	@FindBy(xpath = "//a[text()='Restaurants ']")
	private WebElement restaurantElement;
	
	@FindBy(xpath = "//a[text()='Login']")
	private WebElement loginElement;
	
	@FindBy(linkText  = "Register")
	private WebElement registerElement;
	
	@FindBy(xpath="(//a[@href=\"dishes.php?res_id=1\"and@class=\"btn theme-btn-dash pull-right\"])[1]")
	private WebElement orderNow;
	
	@FindBy(xpath="//a[text()='Restaurants ']")
	private WebElement authRestaurant;
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logoutElement;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getHomeElement() {
		return homeElement;
	}

	public WebElement getRestaurantElement() {
		return restaurantElement;
	}

	public WebElement getLoginElement() {
		return loginElement;
	}

	public WebElement getRegisterElement() {
		return registerElement;
	}

	public WebElement getOrderNow() {
		return orderNow;
	}

	public WebElement getAuthRestaurant() {
		return authRestaurant;
	}

	public WebElement getLogoutElement() {
		return logoutElement;
	}
	
	
}
