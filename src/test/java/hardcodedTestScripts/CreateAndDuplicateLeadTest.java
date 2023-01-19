package hardcodedTestScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateAndDuplicateLeadTest {

	public static void main(String[] args) {
		// Launching Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Login page verification
		String title = driver.findElement(By.xpath("//a[@href='http://www.vtiger.com']")).getText();

		if (title.contains("vtiger"))
			System.out.println("Login Page Displayed");
		else
			System.out.println("Login Page is not Displayed");

		// Login to the application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("manager");
		driver.findElement(By.id("submitButton")).click();

		// Home page verification
		String homePageText = driver.findElement(By.xpath("//a[@class='hdrLink']")).getText();
		if (homePageText.contains("Home"))
			System.out.println("Home Page is displayed");
		else
			System.out.println("Home Page is not displayed");
		
		// Click on lead
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		
		// Lead page verification
		String leads = driver.findElement(By.xpath("//a[@class='hdrLink']")).getText();
		if (leads.contains("Leads")) {
			System.out.println("lead page displayed");
		}
		else {
			System.out.println("lead page not displayed");
		}
		
		// Click on new lead button
		driver.findElement(By.xpath("//img[@alt='Create Lead...']")).click();
		
		// Creating new lead page verification
		String createLead = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		if (createLead.contains("Creating New Lead")) {
			System.out.println("Create new lead page displayed");
		}
		else {
			System.out.println("Create new lead page not displayed");
		}
		
		// Creating new lead
		WebElement salutationDropdown = driver.findElement(By.xpath("//select[@name='salutationtype']"));
		Select salutation = new Select(salutationDropdown);
		salutation.selectByValue("Mrs.");
		
		driver.findElement(By.name("lastname")).sendKeys("Suraj");
		driver.findElement(By.name("company")).sendKeys("Delloite");
		
		// Click on save
		driver.findElement(By.xpath("//input[contains(@value,'Save')]")).click();
		
		// Created lead page verification
		String newLeadInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(newLeadInfo.contains("Suraj"))
			System.out.println("Pass");
		else
			System.out.println("Fail");
		
		// Click on duplicate
		driver.findElement(By.name("Duplicate")).click();
		
		// Duplicating page verification
		String duplicatingPage = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		if(duplicatingPage.contains("Suraj"))
			System.out.println("Pass");
		else
			System.out.println("Fail");
		
		// Modifying last name
		WebElement lastName = driver.findElement(By.name("lastname"));
		lastName.clear();
		lastName.sendKeys("Chandan");
		
		// Click on save button
		driver.findElement(By.xpath("//input[contains(@value,'Save')]")).click();
		
		//To go to leads page
		driver.findElement(By.xpath("//a[@class='hdrLink']")).click();
		
		// New lead created verification
		String newLead = driver.findElement(By.xpath("//table[@class='lvt small']/descendant::tr[last()]/td[3]/a")).getText();
		if(newLead.equals("Chandan")) {
			System.out.println("Pass");
		}
		else {
			System.out.println("Fail");
		}
		
		// Mouse hover to administrator icon
		WebElement administratorIcon = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a = new Actions(driver);
		a.moveToElement(administratorIcon).perform();
		
		// Sign out
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		
		// Closing browser
		driver.close();
	}
}
