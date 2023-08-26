package listenersTestng;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass2 {

	public static WebDriver sdriver;
	public WebDriver driver;
	
	@BeforeMethod
	public void methodConfig() {
		System.setProperty("webdriver.chrome.driver", 
				"./src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		sdriver = driver;
		driver.manage().window().maximize();
		driver.get("https://demo.actitime.com/login.do");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterMethod
	public void methodTear() {
		driver.quit();
	}
}
