package Mathi.Test;

import java.io.File;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.agiletestware.bumblebee.annotations.testng.BumblebeeTestNGListener;
import com.agiletestware.bumblebee.annotations.testng.TestNGTestContext;
import com.agiletestware.bumblebee.annotations.BooleanValue;
import com.agiletestware.bumblebee.annotations.Bumblebee;
import com.agiletestware.bumblebee.annotations.BumblebeeTestStep;
import com.agiletestware.bumblebee.annotations.config.BumblebeeConfiguration;
import com.agiletestware.bumblebee.annotations.config.BumblebeeeConfigurationFactory;
import com.agiletestware.bumblebee.annotations.webdriver.WebDriverTest;

@Bumblebee(testplan = "Subject\\SeleniumAutomation", testlab = "Root\\Professional.com", testset = "Selenium Test Set", testname = "SuccessfulLogin1", hasSteps = BooleanValue.TRUE)
public class SeleniumQC2 implements WebDriverTest {
	public static final String BUMBLEBEE_TEST_CONTEXT_ATTR_NAME = "BumblebeeTestContext";
	private final BumblebeeConfiguration bumblebeeConfiguration = BumblebeeeConfigurationFactory.getConfiguration();
	private static final Logger LOGGER = Logger.getLogger(BumblebeeTestNGListener.class);
	String driverpath = "src/main/java/Drivers/chromedriver.exe";
	RemoteWebDriver webDriver;
	@BumblebeeTestStep(name = "Launchbrowser", description = "invoke browser and load the url ", expected = "Url should be loaded successfully")
	@Test(priority = 1)
	public void LaunchBrowser() {
		System.setProperty("webdriver.chrome.driver", driverpath);
		webDriver = new ChromeDriver();
		webDriver.get("https://professional-test.medtronic.com");
		webDriver.manage().window().maximize();
		
	}
	@BumblebeeTestStep(name = "Enter Userid", description = "Enter valid user id", expected = "User should able to enter email id")
	@Test(priority = 2)
	public void Enterlogin() {
		webDriver.findElement(By.id("USER")).sendKeys("testprofile0531@hcp.com");
	}
	@BumblebeeTestStep(name = "Enter Password", description = "Enter valid password", expected = "User should able to enter password and it should be encrypted format")
	@Test(priority = 3)
	public void Enterpassword()
	{
		webDriver.findElement(By.id("PASSWORD")).sendKeys("Test1234");
			}
	@BumblebeeTestStep(name = "Click Login", description = "Click Login button", expected = "Login should be successful")
	@Test(priority = 4)
	public void ClickSubmit()
	{
		webDriver.findElement(By.id("login")).click();
		
	}
	@BumblebeeTestStep(name = "Verify the home page after Login", description = "verify the Home page", expected = "After successful login it should redirect to home page")
	@Test(priority = 5)
	public void CheckPagetile()
	{
		String ActualTitle = webDriver.getTitle();
		String ExpectedTitle = "Medtronic Neuromodulation Products and Therapies | Healthcare Professionals";
		Assert.assertEquals(ExpectedTitle, ActualTitle);
	}
	
	
	@BumblebeeTestStep(name = "Close browser", description = "Close browser", expected = "Browser should be closed")
	@Test(priority = 6)

	public void Closebrowser() {
		webDriver.close();
	}
	@AfterMethod
	public void onTestSuccess(final ITestResult result) {
		
		final TestNGTestContext context = new TestNGTestContext();
		result.setAttribute(BUMBLEBEE_TEST_CONTEXT_ATTR_NAME, context);
		final File screenshot = webDriver.getScreenshotAs(OutputType.FILE);
		LOGGER.info("Taking screenshot: " + screenshot.getAbsolutePath());
		context.setScreenshot(screenshot);		
		}

	@Override
	public RemoteWebDriver getWebDriver() {
		return webDriver;
	}
	
	}


