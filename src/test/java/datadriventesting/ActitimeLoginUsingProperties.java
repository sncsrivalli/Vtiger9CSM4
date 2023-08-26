package datadriventesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActitimeLoginUsingProperties {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(getData("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(getData("time"))));

		driver.findElement(By.id("username")).sendKeys(getData("username1"));
		driver.findElement(By.name("pwd")).sendKeys(getData("password1"));
		driver.findElement(By.id("loginButton")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(getData("time"))));
		try {
			wait.until(ExpectedConditions.titleContains("Enter Time-Track"));
			System.out.println("Test Pass");
		} catch (Exception e) {
			System.out.println("Test Fail");
		}
		driver.quit();
	}
	
	public static String getData(String key) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("./src/test/resources/data.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties property = new Properties();
		try {
			property.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return property.getProperty(key);
	}

}
