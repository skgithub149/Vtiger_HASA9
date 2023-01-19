package chromeoptions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class StartMaximizedBrowser {

		public static void main(String[] args) {
			
			ChromeOptions opt=new ChromeOptions();
			opt.addArguments("start-maximized");
			opt.addArguments("--disable-notifications");
			
			WebDriver driver=new ChromeDriver(opt);
			driver.get("https://www.yatra.com/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


	}

}
