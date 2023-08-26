package vtigerTests;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrganizationTest {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		if(driver.getTitle().contains("vtiger"))
			System.out.println("Login page displayed");
		else
			System.out.println("Login page not found");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).submit();
		
		if(driver.getTitle().contains("Home"))
			System.out.println("Home page is dispalyed");
		else
			System.out.println("Home page not found");
		
		driver.findElement(By.xpath("//a[text()='Organizations' and contains(@href,'action=index')]")).click();
		
		if(driver.getTitle().contains("Organizations"))
			System.out.println("Organizations page is displayed");
		else
			System.out.println("Organizations page not found");
		
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		WebElement createOrg = driver.findElement(By.xpath("//span[@class='lvtHeaderText']"));
		if(createOrg.getText().equals("Creating New Organization"))
			System.out.println("Creating New Organization page displayed");
		else
			System.out.println("Creating New Organization page not found");
		
		Random random = new Random();
		int randomNum = random.nextInt(100);
		
		String orgName = "TCS"+randomNum;
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[normalize-space(@value)='Save']")).click();
		
		String newOrgInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if(newOrgInfo.contains(orgName))
			System.out.println("Organization created successfully");
		else
			System.out.println("Organization not created");
		
		WebElement adminICon = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG'"
				+ "]"));
		Actions a = new Actions(driver);
		a.moveToElement(adminICon).perform();
		
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		driver.quit();
	}

}
