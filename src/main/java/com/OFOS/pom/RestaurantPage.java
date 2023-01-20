package com.OFOS.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RestaurantPage {

	@FindBy(xpath="//a[text()='North Street Tavern']")
	private WebElement restaurantname;

	public RestaurantPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getRestaurantname() {
		return restaurantname;
	}
	
	
	
}
