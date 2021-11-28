import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class TestRunner {
	
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.gecko.driver","D:\\Temparature_project\\geckodriver.exe" );
		//WebDriver driver=new HtmlUnitDriver(BrowserVersion.FIREFOX_78, true);
		WebDriver driver =new FirefoxDriver();
		uiLayer ui = new uiLayer();
		String uiResponse= ui.uiLayer(driver);
		String uiTemp = uiResponse.substring(0,2);
		int uiTemp_int = Integer.parseInt(uiTemp);
		Thread.sleep(10);
		
		restAPI api = new restAPI();
		int apiTemp = api.get("https://api.openweathermap.org/data/2.5/weather?q=Bengaluru&appid=7fe67bf08c80ded756e598d6f8fedaea");
		compareTemparature compare = new compareTemparature();
		compare.comparetemp(uiTemp_int, apiTemp);
	}

}
