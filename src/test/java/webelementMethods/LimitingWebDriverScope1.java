package webelementMethods;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LimitingWebDriverScope1 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement footer = driver.findElement(By.xpath("//div[@class='navFooterVerticalColumn navAccessibility']"));
		
		List<WebElement> footerLinks = footer.findElements(By.tagName("a"));
		for (WebElement link : footerLinks) {
			System.out.println(link.getText());
		}
		
		driver.quit();
	}

}
