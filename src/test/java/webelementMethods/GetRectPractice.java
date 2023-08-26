package webelementMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetRectPractice {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement discount = driver.findElement(By.xpath("//img[contains(@src,'Main-Banner_Desktop_13')]"));
		Rectangle rect = discount.getRect();
		System.out.println("X coordinate: "+rect.getX()+"\nY coordinate: "+rect.getY());
		System.out.println("Height: "+rect.getHeight()+"\nWidth: "+rect.getWidth());
		
		driver.close();
	}

}
