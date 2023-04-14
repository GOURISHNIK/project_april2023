package com.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.base.BaseClass;

public class HomePageClass extends BaseClass {
	public static WebDriver driver;
	
	public HomePageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "wishlist-total")
	private WebElement desktopsButton;
	
	public void clickdesktopsButton(WebDriver driver) throws InterruptedException {
		//desktopsButton.click();
		Thread.sleep(5000);
		//driver.findElement(By.id("wishlist-total"));
		System.out.println("insode page class method");
		//Action.javaScriptClick(driver, desktopsButton);
		desktopsButton.click();
		
		System.out.println("page class > HomePageClass desktopsButton clicked");

	}
}
