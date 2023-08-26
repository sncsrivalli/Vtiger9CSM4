package listenersTestng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listenersTestng.ListenerImplementationExtentReports.class)
public class ActitimeTest extends BaseClass2{

	@Test
	public void loginTest() {
		driver.findElement(By.id("username"))
				.sendKeys("admin"+Keys.TAB+"manager"+Keys.ENTER);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Assert.assertTrue(wait.
				until(ExpectedConditions.titleContains("Ent Time-Track")));
	}
}
