package actionsClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
//This is an example for mouse hover automation
public class MouseHoverExample {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement kids = driver.findElement(By.xpath("//a[text()='Kids' and @class='desktop-main']"));

		Actions a = new Actions(driver);
		a.moveToElement(kids).perform();

		driver.findElement(By.xpath("//a[text()='Learning & Development']")).click();
		String pageTitle = driver.findElement(By.xpath("//div[@class='filter-summary-filter']")).getText();
		
		if (pageTitle.equals("Learning And Development Toys"))
			System.out.println("Pass");
		else
			System.out.println("Fail");

		driver.quit();
	}

}
