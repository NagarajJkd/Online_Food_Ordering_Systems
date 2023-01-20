package com.OFOS.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllOrders {

	@FindBy(xpath="//tr/child::td[text()='raj']")
	private WebElement username;
	
	@FindBy(xpath = "//a[@href=\"delete_orders.php?order_del=2\"]")
	private WebElement deletIcon;
	
	@FindBy(xpath = "//a[@href=\"view_order.php?user_upd=2\"]")
	private WebElement editIcon;

	public AllOrders(WebDriver driver) {
		PageFactory.initElements(driver, this);
	
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getDeletIcon() {
		return deletIcon;
	}

	public WebElement getEditIcon() {
		return editIcon;
	}
	
	
}
