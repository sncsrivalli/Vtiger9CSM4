package vtigerTests;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateContactWithExistingOrgTest {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		if (driver.getTitle().contains("vtiger"))
			System.out.println("Login page displayed");
		else
			System.out.println("Login page not found");

		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).submit();

		if (driver.getTitle().contains("Home"))
			System.out.println("Home page is dispalyed");
		else
			System.out.println("Home page not found");

		driver.findElement(By.xpath("//a[text()='Contacts' and contains(@href,'action=index')]")).click();

		if (driver.getTitle().contains("Contacts"))
			System.out.println("Contacts page is displayed");
		else
			System.out.println("Contacts page not found");

		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

		WebElement createOrg = driver.findElement(By.xpath("//span[@class='lvtHeaderText']"));
		if (createOrg.getText().equals("Creating New Contact"))
			System.out.println("Creating New Organization page displayed");
		else
			System.out.println("Creating New Organization page not found");

		Random random = new Random();
		int randomNum = random.nextInt(100);
		String lastName = "ABC" + randomNum;
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.xpath("//img[contains(@onclick,'Accounts&action')]")).click();

		String parentID = driver.getWindowHandle();
		Set<String> ids = driver.getWindowHandles();
		for (String s : ids) {
			driver.switchTo().window(s);
		}

		List<WebElement> orgList = driver.findElements(
		By.xpath("//div[@id='ListViewContents']/descendant::table[@cellspacing='1']/descendant::tr/td[1]/a"));
		for (int i = 1; i < orgList.size(); i++) {
			
			if (orgList.get(i).getText().equals("TCS64")) {
				System.out.println(orgList.get(i).getText());
				orgList.get(i).click();
				break;
			}
		}

		driver.switchTo().window(parentID);
		driver.findElement(By.xpath("//input[normalize-space(@value)='Save']")).click();

		String newOrgInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();

		if (newOrgInfo.contains(lastName))
			System.out.println("Contact created successfully");
		else
			System.out.println("Contact not created");

		WebElement adminICon = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a = new Actions(driver);
		a.moveToElement(adminICon).perform();

		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

		driver.quit();
	}

}
