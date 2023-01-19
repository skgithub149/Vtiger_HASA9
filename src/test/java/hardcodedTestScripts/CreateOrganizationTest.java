package hardcodedTestScripts;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrganizationTest {

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

		// Click on organization
		driver.findElement(By.linkText("Organizations")).click();

		// Organization page verification
		String organizations = driver.findElement(By.xpath("//a[@class='hdrLink']")).getText();

		if (organizations.contains("Organization"))
			System.out.println("Pass");
		else
			System.out.println("Fail");

		// Click on create organization button
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		// Creating new organization page verification
		String createOrg = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		if (createOrg.contains("Creating New Organization"))
			System.out.println("Pass");
		else
			System.out.println("Fail");

		// Create new organization
		WebElement organisationTextfield = driver.findElement(By.name("accountname"));
		organisationTextfield.sendKeys("QSP_Hebbal");

		WebElement websiteTextfield = driver.findElement(By.name("website"));
		websiteTextfield.sendKeys("https://www.qsp_hebbal.com");

		WebElement emailTextfield = driver.findElement(By.id("email1"));
		emailTextfield.sendKeys("qsp_hebbal@gmail.com");

		WebElement billAdd = driver.findElement(By.name("bill_street"));
		billAdd.sendKeys("Hebbal");

		WebElement billCity = driver.findElement(By.id("bill_city"));
		billCity.sendKeys("Banglore");

		WebElement billState = driver.findElement(By.id("bill_state"));
		billState.sendKeys("Karnataka");

		WebElement billCountry = driver.findElement(By.id("bill_country"));
		billCountry.sendKeys("India");

		// Click on save
		WebElement saveButton = driver.findElement(By.name("button"));
		saveButton.click();

		// Created organization page verification
		String newOrgInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (newOrgInfo.contains("QSP_Hebbal"))
			System.out.println("Pass");
		else
			System.out.println("Fail");

		// Sign out
		Actions a = new Actions(driver);

		WebElement signoutIcon = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		a.moveToElement(signoutIcon).perform();

		WebElement signoutButton = driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]"));
		signoutButton.click();

		driver.close();

	}

}
