package webelementMethods;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementScreenshot {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.swiggy.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement foodImage = driver.findElement(By.xpath("//div[@class='_2h2bu']"));
		
		File src = foodImage.getScreenshotAs(OutputType.FILE);
		File dest = new File("./ElementScreenshot/foodImage.png");
		FileUtils.copyFile(src, dest);
		
		driver.close();
	}

}
