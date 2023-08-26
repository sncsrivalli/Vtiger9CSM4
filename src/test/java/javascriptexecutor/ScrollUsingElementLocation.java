package javascriptexecutor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollUsingElementLocation {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement trendiestPicks = driver.findElement(By.xpath("//a[text()='Popular Destinations']"));
		Point loc = trendiestPicks.getLocation();
		int x = loc.getX();
		int y = loc.getY();
		System.out.println(x+"\t"+y);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy("+x+","+y+")");
		
		Thread.sleep(2000);
		driver.quit();
	}

}
