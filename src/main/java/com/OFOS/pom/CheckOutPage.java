package com.OFOS.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {

	@FindBy(name="submit")
	private WebElement orderNowBtn;

	public CheckOutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrderNowBtn() {
		return orderNowBtn;
	}
	
	
}
