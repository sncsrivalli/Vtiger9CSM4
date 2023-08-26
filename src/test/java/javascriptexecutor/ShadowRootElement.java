package javascriptexecutor;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowRootElement {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("chrome://downloads/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Object obj = js.executeScript("return document.querySelector(\"body > downloads-manager\")"
				+ ".shadowRoot.querySelector(\"#toolbar\").shadowRoot.querySelector(\"#toolbar\")"
				+ ".shadowRoot.querySelector(\"#search\").shadowRoot.querySelector(\"#searchInput\")");
		WebElement element = (WebElement)obj;
		element.sendKeys("common io");
		
		Thread.sleep(2000);
		driver.quit();
	}

}
