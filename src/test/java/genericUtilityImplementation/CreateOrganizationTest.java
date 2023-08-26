package genericUtilityImplementation;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import genericLibraries.ExcelUtility;
import genericLibraries.IConstantPath;
import genericLibraries.JavaUtility;
import genericLibraries.PropertiesUtility;
import genericLibraries.WebDriverUtility;

public class CreateOrganizationTest {

	public static void main(String[] args) {
		PropertiesUtility property = new PropertiesUtility();
		ExcelUtility excel = new ExcelUtility();
		JavaUtility jutil = new JavaUtility();
		WebDriverUtility webUtil = new WebDriverUtility(); 
		
		property.propertiesInitialization(IConstantPath.PROPERTIES_PATH);
		excel.excelInitialization(IConstantPath.EXCEL_PATH);
		
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("http://localhost:8888/");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebDriver driver = webUtil.launchBrowser(property.readFromProperties("browser"));
		webUtil.maximizeBrowser();
		webUtil.navigateToApp(property.readFromProperties("url"));
		webUtil.waitTillElementFound(Long.parseLong(property.readFromProperties("time")));
		
		if(driver.getTitle().contains("vtiger"))
			System.out.println("Login page displayed");
		else
			System.out.println("Login page not found");
		
		driver.findElement(By.name("user_name")).sendKeys(property.readFromProperties("username"));
		driver.findElement(By.name("user_password")).sendKeys(property.readFromProperties("password"));
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
		
//		Random random = new Random();
//		int randomNum = random.nextInt(100);
		
		Map<String, String> map = excel.readFromExcel("OrganizationsTestData", "Create Organization");
		
		String orgName = map.get("Organization Name")+jutil.generateRandomNum(100);
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[normalize-space(@value)='Save']")).click();
		
		String newOrgInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if(newOrgInfo.contains(orgName)) {
			System.out.println("Organization created successfully");
			excel.writeToExcel("OrganizationsTestData", "Create Organization", "Pass", IConstantPath.EXCEL_PATH);
		}
		else {
			System.out.println("Organization not created");
			excel.writeToExcel("OrganizationsTestData", "Create Organization", "Fail", IConstantPath.EXCEL_PATH);
		}
		
		WebElement adminICon = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//		Actions a = new Actions(driver);
//		a.moveToElement(adminICon).perform();
		webUtil.mouseHover(adminICon);
		
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
//		driver.quit();
		webUtil.quitAllWindows();
		excel.closeExcel();
	}

}
