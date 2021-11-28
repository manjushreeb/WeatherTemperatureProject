import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.BrowserVersion;

public class uiLayer {
	

	public String uiLayer(WebDriver driver) throws Exception {
		//System.setProperty("webdriver.gecko.driver","D:\\Temparature_project\\geckodriver.exe" );
			//WebDriver driver=new HtmlUnitDriver(BrowserVersion.FIREFOX_78, true);
		//WebDriver driver =new FirefoxDriver();
		driver.get("https://www.accuweather.com");
		String pageTitle = driver.getTitle();
		System.out.print(pageTitle);
		
		driver.findElement(By.name("query")).sendKeys("Bengaluru,Karnataka");
		driver.findElement(By.xpath("//div[@class='searchbar-content']/*[local-name()='svg'][1]")).click();
		pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		
		WebElement uiResult = new WebDriverWait(driver,30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[1]/div[@class ='cur-con-weather-card__body']/div[@class ='cur-con-weather-card__panel']/div/div/div[@class='temp']")));
		// Print the first result
		System.out.println(uiResult.getText());
		
		return uiResult.getText();
	}
	       	
	 

}
