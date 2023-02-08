package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(xpath = "//a[text()='Organizations']")
	private WebElement organizationsTab;
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorIcon;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOrganizations() {
		organizationsTab.click();
		
	}

}
