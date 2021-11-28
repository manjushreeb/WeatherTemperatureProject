package com.qa.ui.pages;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.tempInterface.TemparatureInterface;
import com.qa.ui.testBase.TestBase;

public class SearchPage extends TestBase implements TemparatureInterface {
	
	//Page Factory
	@FindBy(name = "query")
	WebElement searchField;
	
	@FindBy(xpath = "//div[@class='searchbar-content']/*[local-name()='svg'][1]")
	WebElement searchIcon;
	
	
	
	public SearchPage(WebDriver driver) {
		//initialSetUp(); 
		PageFactory.initElements(driver, this);
			
	}
	
	
	//Actions
	public static String ValidatePageTitle(){
		return driver.getTitle();	
	}
	
	public SearchResultPage Search(String city) {
		System.out.println("What is the city name "+city);
		//initialSetUp();
		//PageFactory.initElements(driver, this);	
		searchField.sendKeys(city);
		searchIcon.click();
		return new SearchResultPage(driver);
	}

	@Override
	public float getTemperature(String city)  {
		// TODO Auto-generated method stub
		float temperature = -1;
		SearchResultPage searchResult =this.Search(city);
		temperature = searchResult.getUITemp();
		System.out.println(temperature);
		return temperature;
	}

	
}
