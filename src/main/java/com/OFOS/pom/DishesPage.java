package com.OFOS.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DishesPage {
	
	public DishesPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="(//div[@class=\"row\"]/child::div[2]/input[@value=\"Add To Cart\"])[1]")
	private WebElement addToCartbtn;
	
	@FindBy(xpath="//a[text()='Checkout']")
	private WebElement checkoutbtn;
	
	@FindBy(xpath="(//input[@value=\"Add To Cart\"])[1]")
	private WebElement addtocardElement;

	public DishesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddToCartbtn() {
		return addToCartbtn;
	}

	public WebElement getCheckoutbtn() {
		return checkoutbtn;
	}

	public WebElement getAddtocardElement() {
		return addtocardElement;
	}
	
	
	
	

}
