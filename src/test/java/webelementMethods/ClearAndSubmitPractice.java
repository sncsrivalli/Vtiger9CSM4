package webelementMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClearAndSubmitPractice {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement searchTF = driver.findElement(By.id("twotabsearchtextbox"));
		
		searchTF.sendKeys("shoes");
		Thread.sleep(2000);
		searchTF.clear();
		Thread.sleep(2000);
		searchTF.sendKeys("chocolate");
		
		driver.findElement(By.id("nav-search-submit-button")).submit();
		Thread.sleep(2000);
		driver.close();
	}

}
