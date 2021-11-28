package com.qa.ui.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.tempInterface.TemparatureInterface;
import com.qa.ui.pages.SearchPage;
import com.qa.ui.pages.SearchResultPage;
import com.qa.ui.testBase.TestBase;

public class searchResultPageTest extends TestBase {
	SearchPage sp;
	SearchResultPage srp ;
	
	public searchResultPageTest() {
		super();
		}

	@BeforeMethod
	public void setUp() {
		initialSetUp();
		//sp = new SearchPage();
		//srp = new SearchResultPage();
		
	}
	
	@Test(priority = 1)
	public void validateSearchResultPageTitle() {
		//float resultTemp = srp.getTemperature("Bengaluru");
		sp.getTemperature("Bengaluru,KA");
		String title = srp.ValidateResultPageTitle();
		Assert.assertEquals(title,"Bengaluru, Karnataka, India Today, Tonight & Tomorrow's Weather Forecast | AccuWeather","OnsearchResultPage");
		System.out.println("validated "+title);
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

		
}
 