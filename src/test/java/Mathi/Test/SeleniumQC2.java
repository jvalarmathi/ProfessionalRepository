package Mathi.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import com.agiletestware.bumblebee.annotations.testng.BumblebeeTestNGListener;
import com.agiletestware.bumblebee.annotations.BooleanValue;
import com.agiletestware.bumblebee.annotations.Bumblebee;
import com.agiletestware.bumblebee.annotations.webdriver.WebDriverTest;

@Bumblebee(testplan = "Subject\\SeleniumAutomation", testlab = "Root\\Professional.com", testset = "Selenium Test Set", testname = "SuccessfulLogin", hasSteps = BooleanValue.TRUE)
public class SeleniumQC2 implements WebDriverTest {
	String driverpath = "src/main/java/Drivers/chromedriver.exe";
	RemoteWebDriver webDriver;

	@Test(priority = 1)
	public void LaunchBrowser() {
		System.setProperty("webdriver.chrome.driver", driverpath);
		webDriver = new ChromeDriver();
		webDriver.get("https://professional-test.medtronic.com");
		webDriver.manage().window().maximize();
		
	}

	@Test(priority = 2)
	public void SuccessfulLogin() {
		webDriver.findElement(By.id("USER")).sendKeys("testprofile0531@hcp.com");
		webDriver.findElement(By.id("PASSWORD")).sendKeys("Test1234");
		webDriver.findElement(By.id("login")).click();
		String ActualTitle = webDriver.getTitle();
		String ExpectedTitle = "Medtronic Neuromodulation Products and Therapies | Healthcare Profession";
		Assert.assertEquals(ExpectedTitle, ActualTitle);
	}
	
	
	
	@Test(priority = 3)

	public void Closebrowser() {
		webDriver.close();
	}

	@Override
	public RemoteWebDriver getWebDriver() {
		return webDriver;
	}
	
	}


