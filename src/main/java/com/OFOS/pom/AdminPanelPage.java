package com.OFOS.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPanelPage {
	@FindBy(xpath="//span[text()='Menu']")
	private WebElement menu;
	
	@FindBy(xpath="//a[text()='Add Menu']")
	private WebElement addMenu;
	
	@FindBy(xpath = "//a[text()='All Menues']")
	private WebElement allMenu;
	
	@FindBy(xpath="//span[text()='Orders']")
	private WebElement ordersElement;
	
	@FindBy(xpath = "//img[@class=\"profile-pic\"]")
	private WebElement profileIcon;
	
	@FindBy(xpath = "//ul[@class=\"dropdown-user\"]")
	private WebElement logoutBtn;
	
	@FindBy(xpath = "//span[text()='Restaurant']")
	private WebElement restaurantbtn;
	
	@FindBy(xpath = "//a[text()='Add Restaurant']")
	private  WebElement addRestaurantbtn;
	
	@FindBy(linkText = "Add Category")
	private WebElement addCategory;
	
	@FindBy(xpath = "//a[.='All Restaurants']")
	private WebElement allRestaurant;

	public AdminPanelPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getMenu() {
		return menu;
	}

	public WebElement getAllMenu() {
		return allMenu;
	}

	public WebElement getAddMenu() {
		return addMenu;
	}

	public WebElement getOrdersElement() {
		return ordersElement;
	}
	
	public void setlogout() {
		profileIcon.click();
		logoutBtn.click();
	}

	public WebElement getProfileIcon() {
		return profileIcon;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	public WebElement getRetaurantbtn() {
		return restaurantbtn;
	}

	public WebElement getRestaurantbtn() {
		return restaurantbtn;
	}

	public WebElement getAddRestaurantbtn() {
		return addRestaurantbtn;
	}

	public WebElement getAddCategory() {
		return addCategory;
	}

	public WebElement getAllRestaurant() {
		return allRestaurant;
	}
	
	public void allrest() {
		allRestaurant.click();
	}
	
}
