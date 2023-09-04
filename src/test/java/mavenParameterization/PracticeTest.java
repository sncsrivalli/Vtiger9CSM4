package mavenParameterization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PracticeTest {

	@Test
	public void test1() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(System.getProperty("url"));
		
		long time = Long.parseLong(System.getProperty("time"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		
		String user = System.getProperty("user");
		String pwd = System.getProperty("pwd");
		
		driver.findElement(By.id("username")).sendKeys(user+Keys.TAB+pwd+Keys.ENTER);
		Thread.sleep(3000);
		driver.close();
	}
}
