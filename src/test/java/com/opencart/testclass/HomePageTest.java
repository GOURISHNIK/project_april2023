package com.opencart.testclass;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.opencart.base.BaseClass;
import com.opencart.dataprovider.dataProviderExcel;
import com.opencart.pageobjects.HomePageClass;

public class HomePageTest extends BaseClass {
	
	public static WebDriver driver;
	public static HomePageClass homePageClass;
	
	@Test
	public void clickOnDesktopButton() throws InterruptedException {
		logger().error("TestMethod statrted log");
		Assert.fail("tc1 failed");
		//logger.info("info log test class");
		//LogClass.startTestCase("this is in test class");
		//homePageClass.clickdesktopsButton(driver);
		System.out.println("HomePageTest class");
	}
	
	@Test(dataProvider = "testDataInput", dataProviderClass = dataProviderExcel.class)
	public void clickOnDesktopButtonithDatarodvider(String Gender,String FirstName,String LastName,
			String	SetPassword,String	Day,String	Month,String	Year,String	Company,String	Address,
			String	City,String	State,String	Zipcode,String	Country,String	MobilePhone)
					throws InterruptedException {
		logger().error("TestMethod statrted log");
		//logger.info("info log test class");
		//LogClass.startTestCase("this is in test class");
		//homePageClass.clickdesktopsButton(driver);
		System.out.println("HomePageTestithDatardocider class");
		System.out.println(Gender);
	}
	

	@BeforeMethod
	public void setUp() {
		logger().info("BeforeMethod statrted log");
		System.out.println("setup started");
		driver = launchApp();
		//homePageClass = new HomePageClass(driver);
		System.out.println("driver launched");
		System.out.println("setUp method closed");

	}

	@AfterMethod
	public void tearDown() {
		//logger().info("AfterMethod statrted log");
		System.out.println("tearDown method started");
		//driver.quit();
		System.out.println("tearDown method closed");
	}


}
