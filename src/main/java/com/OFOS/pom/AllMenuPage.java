package com.OFOS.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllMenuPage {
	
	@FindBy(xpath = "//a[@href=\"delete_menu.php?menu_del=75\"]")
	private WebElement deletIcon;
	
	@FindBy(xpath = "//a[@href=\"update_menu.php?menu_upd=75\"]")
	private WebElement editIcon;
	
	@FindBy(xpath = "//tr[@role='row']/child::td[2]")
	private WebElement dish;

	public AllMenuPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	
	}

	public WebElement getDeletIcon() {
		return deletIcon;
	}

	public WebElement getEditIcon() {
		return editIcon;
	}

	public WebElement getDish() {
		return dish;
	}

	
}
