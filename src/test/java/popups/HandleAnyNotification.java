package popups;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandleAnyNotification {

	public static void main(String[] args) throws InterruptedException {
		HashMap<String, Integer> contentSettings = new HashMap<String, Integer>();
		HashMap<String, Object> profile = new HashMap<String, Object>();
		HashMap<String, Object> preferences = new HashMap<String, Object>();
		
		ChromeOptions options = new ChromeOptions();
		
		contentSettings.put("media_stream", 1);
		profile.put("managed_default_content_settings", contentSettings);
		preferences.put("profile", profile);
		
		options.setExperimentalOption("prefs", preferences);
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		//driver.get("https://mictests.com/");
		driver.get("https://webcamtests.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//driver.findElement(By.id("mic-launcher")).click();
		driver.findElement(By.id("webcam-launcher")).click();
		
		Thread.sleep(4000);
		driver.quit();
	}

}
