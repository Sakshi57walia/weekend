package weekend;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * @author sakshi
 *
 */
public class Base {
	
	public WebDriver driver;

	@BeforeClass
	public void precondition() throws Exception {
		System.out.println("launch browser");
		WeekendProperties.ConfigFileReader();
		System.setProperty("webdriver.chrome.driver", WeekendProperties.getDriverPath());

		driver = new ChromeDriver();
		//WeekendProperties.getImplicitlyWait();
		driver.get(WeekendProperties.getApplicationUrl());
		driver.manage().window().maximize();

	}

	// close browser
	@AfterClass
	public void postcondition() {
		 driver.quit();
	}

}
