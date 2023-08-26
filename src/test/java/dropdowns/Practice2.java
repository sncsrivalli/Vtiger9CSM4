package dropdowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Practice2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapp.skillrary.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement dropdown = driver.findElement(By.id("cars"));
		
		Select s = new Select(dropdown);
		if(s.isMultiple()) {
			s.selectByIndex(0);
			s.selectByValue("99");
			s.selectByVisibleText("INR 100 - INR 199 ( 16 )");
			
			Thread.sleep(2000);
			System.out.println(s.getFirstSelectedOption().getText());
			
			List<WebElement> selectedOptions = s.getAllSelectedOptions();
			for (WebElement e : selectedOptions) {
				System.out.println(e.getText());
			}
			
			s.deselectByIndex(0);
			s.deselectByValue("99");
			s.deselectByVisibleText("INR 100 - INR 199 ( 16 )");
		}
		else
			System.out.println("Single select");
		
		driver.quit();
	}

}
