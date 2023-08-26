package synchronization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomWait {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
		
		driver.findElement(By.xpath("//button[text()='Start']")).click();

		int count = 0;
		while(count < 20) {
			try {
				String text = driver.findElement(By.xpath("//h4[text()='Hello World!']")).getText();
				System.out.println(text);
				break;
			}catch(Exception e) {
				count++;
				Thread.sleep(1000);
			}
		}
		driver.quit();
	}

}
