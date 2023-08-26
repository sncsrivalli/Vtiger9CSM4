package webelementMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SendKeysPractice2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//html")).sendKeys(Keys.F5);
		//driver.findElement(By.linkText("Forgotten password?")).sendKeys(Keys.chord(Keys.CONTROL,Keys.ENTER));
		Thread.sleep(3000);
		driver.quit();
	}

}
