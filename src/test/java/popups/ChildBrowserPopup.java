package popups;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChildBrowserPopup {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Closing the login window
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		
		//Search for mobile
		driver.findElement(By.name("q")).sendKeys("mobiles");
		driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
		
		//Click on first mobile
		driver.findElement(By.xpath("//div[text()='SAMSUNG Galaxy F13 (Nightsky Green, 64 GB)']")).click();
		
		//New window opens, collect parent and child window addresses
		String parentID = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		
		//Switch to child window
		for (String s : allWindows) {
			driver.switchTo().window(s);
		}
		
		//Click on Add To Cart and close
		driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
		driver.close();
		
		//Switch to parent window and refresh
		driver.switchTo().window(parentID);
		driver.navigate().refresh();
		
		//Validate text on cart icon
		WebElement cartIcon = driver.findElement(By.xpath("//div[@class='KK-o3G']"));
		if(cartIcon.getText().equals("1"))
			System.out.println("Item added to cart");
		else
			System.out.println("Add to cart failed");
		
		driver.quit();
	}

}
