package vtigerTests;

import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateEventTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
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
		
		WebElement quickCreateDropdown = driver.findElement(By.id("qccombo"));
		Select s = new Select(quickCreateDropdown);
		s.selectByValue("Events");
		
		WebElement createToDo = driver.findElement(By.xpath("//b[text()='Create To Do']"));
		if(createToDo.isDisplayed())
			System.out.println("Create to do window is displayed");
		else
			System.out.println("Create to do window is not found");
		
		Random random = new Random();
		int randomNum = random.nextInt(100);
		String subject = "Meet"+randomNum;
		
		driver.findElement(By.name("subject")).sendKeys(subject);
		driver.findElement(By.id("jscal_trigger_date_start")).click();
		
		String reqDate = "19";
		int reqMonth = 10;
		int reqYear = 2025;
		
		String commonPath = "//div[@class='calendar' and contains(@style,'block')]/descendant::td[%s]";
		String actMonthYear = driver.findElement(By.xpath(formatPath(commonPath, "@class='title'"))).getText();
		
		String[] str = actMonthYear.split(", ");
		int actYear = Integer.parseInt(str[1]);
		
		while(actYear < reqYear) {
			driver.findElement(By.xpath(formatPath(commonPath, "text()='»'"))).click();
			actMonthYear = driver.findElement(By.xpath(formatPath(commonPath, "@class='title'"))).getText();
			
			str = actMonthYear.split(", ");
			actYear = Integer.parseInt(str[1]);
		}
		
		int actMonth = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(str[0])
				.get(ChronoField.MONTH_OF_YEAR);
		
		while(actMonth < reqMonth) {
			driver.findElement(By.xpath(formatPath(commonPath, "text()='›'"))).click();
			actMonthYear = driver.findElement(By.xpath(formatPath(commonPath, "@class='title'"))).getText();
			
			str = actMonthYear.split(", ");
			actMonth = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(str[0])
					.get(ChronoField.MONTH_OF_YEAR);
		}
		
		while(actMonth > reqMonth) {
			driver.findElement(By.xpath(formatPath(commonPath, "text()='‹'"))).click();
			actMonthYear = driver.findElement(By.xpath(formatPath(commonPath, "@class='title'"))).getText();
			
			str = actMonthYear.split(", ");
			actMonth = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(str[0])
					.get(ChronoField.MONTH_OF_YEAR);
		}
		
		driver.findElement(By.xpath(formatPath(commonPath, "text()='"+reqDate+"'"))).click();
		
		driver.findElement(By.id("jscal_trigger_due_date")).click();

		String reqDueDate = "19";
		int reqDueMonth = 10;
		int reqDueYear = 2026;
		
		//String commonPath1 = "//div[@class='calendar' and contains(@style,'block')]/descendant::td[%s]";
		String actMonthYear1 = driver.findElement(By.xpath(formatPath(commonPath, "@class='title'"))).getText();
		
		String[] str1 = actMonthYear1.split(", ");
		int actYear1 = Integer.parseInt(str1[1]);
		
		while(actYear1 < reqDueYear) {
			driver.findElement(By.xpath(formatPath(commonPath, "text()='»'"))).click();
			actMonthYear1 = driver.findElement(By.xpath(formatPath(commonPath, "@class='title'"))).getText();
			
			str1 = actMonthYear1.split(", ");
			actYear1 = Integer.parseInt(str1[1]);
		}
		
		int actMonth1 = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(str1[0])
				.get(ChronoField.MONTH_OF_YEAR);
		
		while(actMonth1 < reqDueMonth) {
			driver.findElement(By.xpath(formatPath(commonPath, "text()='›'"))).click();
			actMonthYear1 = driver.findElement(By.xpath(formatPath(commonPath, "@class='title'"))).getText();
			
			str1 = actMonthYear1.split(", ");
			actMonth1 = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(str1[0])
					.get(ChronoField.MONTH_OF_YEAR);
		}
		
		while(actMonth1 > reqDueMonth) {
			driver.findElement(By.xpath(formatPath(commonPath, "text()='‹'"))).click();
			actMonthYear1 = driver.findElement(By.xpath(formatPath(commonPath, "@class='title'"))).getText();
			
			str1 = actMonthYear1.split(", ");
			actMonth1 = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(str1[0])
					.get(ChronoField.MONTH_OF_YEAR);
		}
		
		driver.findElement(By.xpath(formatPath(commonPath, "text()='"+reqDueDate+"'"))).click();
		driver.findElement(By.xpath("//input[@value='  Save']")).click();
		
		String newEventInfoHeader = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		if(newEventInfoHeader.contains(subject))
			System.out.println("New event created");
		else
			System.out.println("New event creation failed");
		
		WebElement adminICon = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a = new Actions(driver);
		a.moveToElement(adminICon).perform();
		
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		driver.quit();
	}

	public static String formatPath(String commonPath, String replaceData) {
		return String.format(commonPath, replaceData);
	}
}
