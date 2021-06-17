package weekend;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/**
 * @author sakshi
 * 
 * That class is responsible to automate basic functionality of weekend page.
 *
 */
public final class Weekend extends Base {
	Logger logger = LogManager.getLogger(Weekend.class);

	/**
	 * @throws InterruptedException
	 * 
	 * This method is responsible for setting all mandatory fields in search component
	 */
	@Test(priority = 1)
	public void viewDeals() throws InterruptedException {
		try {

			logger.info("Search with all Mandatory fields ");
			

			// System.out.println("Search with all Mandatory fields ");
			WeekendProperties.ConfigFileReader();

			
			Thread.sleep(1000);
			logger.info("Click on Loctaion field ");
			driver.findElement(By.xpath("//span[text()='Set current city or town']")).click();
			Thread.sleep(1000);
			logger.info("Enter values in location field Loctaion field ");

			WebElement clearlocation = driver.findElement(By.xpath("//input[@type='search']"));
			clearlocation.sendKeys(Keys.CONTROL + "a");
			driver.findElement(By.xpath("//input[@type='search']")).sendKeys(WeekendProperties.getApplicationLocation());
			Thread.sleep(1000);
			logger.info("Click on Radius field ");
			driver.findElement(By.xpath("//div[text()='Radius']")).click();
			Thread.sleep(1000);

			System.out.println(driver.findElements(By.xpath("//span[@class='ControlSelectItem_label__IbRcQ']")).size());
			Thread.sleep(1000);
			logger.info("Enter values in Radius field ");
			driver.findElement(By.xpath("//span[text()='" + WeekendProperties.getApplicationRadius() + "']")).click();
			logger.info("Click on From field ");
			driver.findElement(By.xpath("//div[text()='From']")).click();
			while (true) {
				logger.info("Checking the month value ");
				String t = driver.findElement(By.xpath("(//div[@class='Header_label__M8amp'])[1]")).getText();
				if (t.equals(WeekendProperties.getApplicationStartingmonth())) {
					break;
				} else {
					driver.findElement(By
							.xpath("//body[1]/div[1]/main[1]/div[1]/div[1]/header[1]/div[5]/div[1]/div[1]/div[1]/div[2]/div[1]/div[4]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/header[1]/div[3]/button[1]/span[1]/span[1]/span[1]"))
							.click();
				}
			}

			List<WebElement> alldates = driver.findElements(By.xpath("//time[@class='Day_label__MJnuS']"));
			for (WebElement ele : alldates) {
				String date = ele.getText();
				if (date.equals(WeekendProperties.getApplicationStartingdate())) {
					ele.click();
					break;
				}
			}
			Thread.sleep(1000);
			logger.info("Click on To field ");
			driver.findElement(By.xpath("//div[text()='To']")).click();
			while (true) {
				logger.info("Checking the day value  ");
				String t1 = driver.findElement(By.xpath("(//div[@class='Header_label__M8amp'])[1]")).getText();

				if (t1.equals(WeekendProperties.getApplicationEndingmonth())) {
					break;
				} else {
					driver.findElement(By
							.xpath("//body[1]/div[1]/main[1]/div[1]/div[1]/header[1]/div[5]/div[1]/div[1]/div[1]/div[2]/div[1]/div[4]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/header[1]/div[3]/button[1]/span[1]/span[1]/span[1]"))
							.click();
				}
			}
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,100)");

			List<WebElement> alldates1 = driver.findElements(By.xpath("//time[@class='Day_label__MJnuS']"));
			for (WebElement ele1 : alldates1) {
				String date1 = ele1.getText();
				if (date1.equals(WeekendProperties.getApplicationEndingdate())) {
					ele1.click();
					break;
				}
			}
			Thread.sleep(1000);
			logger.info("Click on Guests field ");
			driver.findElement(By.xpath("(//div[text()='Guests'])[1]")).click();

			WebElement toClear = driver.findElement(By.xpath("(//input[@class='NumberInput_value__1i8N5'])[1]"));
			toClear.sendKeys(Keys.CONTROL + "a");
			logger.info("Enter value in adult field ");
			driver.findElement(By.xpath("(//input[@class='NumberInput_value__1i8N5'])[1]")).sendKeys(WeekendProperties.getAdult());
			Thread.sleep(1000);
			WebElement toClear1 = driver.findElement(By.xpath("(//input[@class='NumberInput_value__1i8N5'])[2]"));
			toClear1.sendKeys(Keys.CONTROL + "a");

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			logger.info("Enter value in children field ");
			driver.findElement(By.xpath("(//input[@class='NumberInput_value__1i8N5'])[2]")).sendKeys(WeekendProperties.getChildren());
			driver.findElement(By.xpath("//div[text()='Guests']")).click();
			Thread.sleep(1000);
			WebElement toClear4 = driver.findElement(By.xpath("(//input[@class='NumberInput_value__1i8N5'])[1]"));
			toClear4.sendKeys(Keys.CONTROL + "a");
			logger.info("Enter value in Room field ");
			driver.findElement(By.xpath("(//input[@class='NumberInput_value__1i8N5'])[1]")).sendKeys(WeekendProperties.getAdult());
			Thread.sleep(1000);
			WebElement toClear2 = driver.findElement(By.xpath("(//input[@class='NumberInput_value__1i8N5'])[3]"));
			toClear2.sendKeys(Keys.CONTROL + "a");
			Thread.sleep(1000);

			driver.findElement(By.xpath("(//input[@class='NumberInput_value__1i8N5'])[3]")).sendKeys(WeekendProperties.getRooms());
			Thread.sleep(1000);
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.scrollBy(0,100)");
			Thread.sleep(1000);

			driver.findElement(By.xpath("(//div[text()='Guests'])[1]")).click();
			logger.info("Click on Apply button ");
			driver.findElement(By.xpath("(//button[text()='Apply'])[1]")).click();
			logger.info("Scrolling the window ");
			JavascriptExecutor js2 = (JavascriptExecutor) driver;
			js2.executeScript("window.scrollBy(0,500)");
			Thread.sleep(30000);
			logger.info("Click on View detail  button ");
			driver.findElement(By.xpath("(//span[text()='View Deal '])[1]")).click();
			// driver.switchTo().defaultContent();
			String parentWindow = driver.getWindowHandle();
			Set<String> allWindows = driver.getWindowHandles();
			for (String curWindow : allWindows) {
				driver.switchTo().window(curWindow);
			}
			driver.switchTo().window(parentWindow);
			Thread.sleep(10000);
			logger.info("Done with all Mandatory fields ");

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	@Test(priority = 0)
	private void findLocation() throws InterruptedException {
		try {
			logger.info("Search with only Location ");

			WeekendProperties.ConfigFileReader();

			
			Thread.sleep(1000);

			logger.info("Click on Loctaion field ");
			driver.findElement(By.xpath("//span[text()='Set current city or town']")).click();
			Thread.sleep(1000);
			logger.info("Enter values in location field Loctaion field ");
			driver.findElement(By.xpath("//input[@type='search']")).sendKeys(WeekendProperties.getApplicationLocation1());
			Thread.sleep(1000);
			JavascriptExecutor js2 = (JavascriptExecutor) driver;
			js2.executeScript("window.scrollBy(0,500)");
			logger.info("Done with Location search ");
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

	@Test(priority = 2)
	private void findDates() throws InterruptedException {
		try {
			logger.info("Search with only Dates");

			WeekendProperties.ConfigFileReader();
			
			Thread.sleep(1000);
			logger.info("Click on From field");
			driver.findElement(By.xpath("//div[text()='From']")).click();
			while (true) {
				logger.info("Checking the Starting  month value  ");
				String t = driver.findElement(By.xpath("(//div[@class='Header_label__M8amp'])[1]")).getText();
				if (t.equals(WeekendProperties.getApplicationStartingmonth())) {
					break;
				} else {
					driver.findElement(By
							.xpath("//body[1]/div[1]/main[1]/div[1]/div[1]/header[1]/div[5]/div[1]/div[1]/div[1]/div[2]/div[1]/div[4]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/header[1]/div[3]/button[1]/span[1]/span[1]/span[1]"))
							.click();
				}
			}
			logger.info("Checking the day value  ");
			List<WebElement> alldates = driver.findElements(By.xpath("//time[@class='Day_label__MJnuS']"));
			for (WebElement ele : alldates) {
				String date = ele.getText();
				if (date.equals(WeekendProperties.getApplicationStartingdate1())) {
					ele.click();
					break;
				}
			}
			Thread.sleep(1000);
			logger.info("Click on To field");
			driver.findElement(By.xpath("//div[text()='To']")).click();
			while (true) {
				logger.info("Checking the Ending month value  ");
				String t1 = driver.findElement(By.xpath("(//div[@class='Header_label__M8amp'])[1]")).getText();

				if (t1.equals(WeekendProperties.getApplicationEndingmonth())) {
					break;
				} else {
					driver.findElement(By
							.xpath("//body[1]/div[1]/main[1]/div[1]/div[1]/header[1]/div[5]/div[1]/div[1]/div[1]/div[2]/div[1]/div[4]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/header[1]/div[3]/button[1]/span[1]/span[1]/span[1]"))
							.click();
				}
			}
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,100)");
			logger.info("Checking the day value  ");
			List<WebElement> alldates1 = driver.findElements(By.xpath("//time[@class='Day_label__MJnuS']"));
			for (WebElement ele1 : alldates1) {
				String date1 = ele1.getText();
				if (date1.equals(WeekendProperties.getApplicationEndingdate1())) {
					ele1.click();
					break;
				}
			}
			Thread.sleep(1000);
			JavascriptExecutor js2 = (JavascriptExecutor) driver;
			js2.executeScript("window.scrollBy(0,500)");
			logger.info("Done with Dates field");
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}
