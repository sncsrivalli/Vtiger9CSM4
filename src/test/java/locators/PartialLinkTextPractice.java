package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Scenario:
 * Open the browser
 * Enter demo.actitime.com
 * Click on Forgot Your Password
 * Click on Return to login page
 * Close the browser
 */
public class PartialLinkTextPractice {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.actitime.com/login.do");
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("Forgot")).click();
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("Return")).click();
		Thread.sleep(2000);
		driver.close();

	}

}
