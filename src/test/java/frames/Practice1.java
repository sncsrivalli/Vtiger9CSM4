package frames;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(2000);
		driver.switchTo().frame("callout");
		driver.findElement(By.xpath("//button[text()='No thanks']")).click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		
		driver.findElement(By.name("q")).sendKeys("selenium"+Keys.ENTER);
		Thread.sleep(2000);
		driver.quit();
	}

}
