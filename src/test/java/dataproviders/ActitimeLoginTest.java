package dataproviders;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ActitimeLoginTest {

	@DataProvider
	public Object[][] loginData(){
		Object[][] obj = new Object[2][2];
		
		obj[0][0] = "admin";
		obj[0][1] = "manager";
		
		obj[1][0] = "trainee";
		obj[1][1] = "trainee";
		
		return obj;
	}
	
	@Test(dataProvider = "loginData")
	public void actitimeLogin(String username, String password) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.actitime.com/login.do");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("username"))
			.sendKeys(username+Keys.TAB+password+Keys.ENTER);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains("Enter Time-Track"));
		
		driver.quit();		
	}
}
