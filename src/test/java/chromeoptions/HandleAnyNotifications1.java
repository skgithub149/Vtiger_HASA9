package chromeoptions;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandleAnyNotifications1 {

	public static void main(String[] args) {
		
		// Key and value type depends on what key and value we are passing using put();
		HashMap<String, Integer> contentSettings=new HashMap<>();
		contentSettings.put("media_stream", 1);
		
		// Putting the contentSettings into the profile
		HashMap<String, Object> profile= new HashMap<>();
		profile.put("managed_default_content_settings", contentSettings);
		
		// Setting the preference
		HashMap<String, Object> prefs=new HashMap<>();
		prefs.put("profile", profile);
		
		//Create instance of ChromeOptions and into the options set the preference
		ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://webcamtests.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("webcam-launcher")).click();

	}

}
 