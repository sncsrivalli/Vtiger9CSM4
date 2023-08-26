package synchronization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Scenario:
 * Open the browser
 * Enter demo.actitime.com
 * Login to the application
 * Verify the home page
 * Close the browser
 */
public class ImplicitWaitPractice {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.actitime.com/login.do");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.id("loginButton")).click();
		
		WebElement title = driver.findElement(By.xpath("//td[text()='Enter Time-Track']"));
		
		if(title.isDisplayed())
			System.out.println("Home page displayed");
		else
			System.out.println("Home page not found");
		
		driver.close();
	}

}
