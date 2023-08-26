package locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Scenario:
 * Open the browser
 * Enter facebook.com
 * Fetch all the links in the web page
 * Print the text on the elements in console
 * Close the browser
 */
public class TagNamePractice {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		Thread.sleep(2000);
		List<WebElement> links = driver.findElements(By.tagName("a"));
		Thread.sleep(2000);
		for(WebElement link: links) {
			System.out.println(link.getText());
		}
		Thread.sleep(2000);
		driver.close();
	}

}
