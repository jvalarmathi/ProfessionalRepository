package Mathi.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.ITestResult;

import com.agiletestware.bumblebee.annotations.BooleanValue;
import com.agiletestware.bumblebee.annotations.Bumblebee;
import com.agiletestware.bumblebee.annotations.BumblebeeTestStep;
import com.agiletestware.bumblebee.annotations.testng.BumblebeeTestNGListener;
import com.agiletestware.bumblebee.annotations.testng.TestNGTestContext;
import com.agiletestware.bumblebee.annotations.webdriver.WebDriverTest;
import com.agiletestware.bumblebee.annotations.config.BumblebeeConfiguration;
import com.agiletestware.bumblebee.annotations.config.BumblebeeeConfigurationFactory;
import utility.TakingfullpagescreenShot;


@Bumblebee(testplan = "Subject\\SeleniumAutomation", testlab = "Root\\Professional.com", testset = "Selenium Test Set", testname = "RequestAccessValidation1", hasSteps = BooleanValue.TRUE)

public class RequestaccessvalidationTestB implements WebDriverTest{
	public static final String BUMBLEBEE_TEST_CONTEXT_ATTR_NAME = "BumblebeeTestContext";
	private final BumblebeeConfiguration bumblebeeConfiguration = BumblebeeeConfigurationFactory.getConfiguration();
	private static final Logger LOGGER = Logger.getLogger(BumblebeeTestNGListener.class);

	String driverpath="src/main/java/Drivers/chromedriver.exe";
	RemoteWebDriver driver;
	Properties prop = new Properties();
	@BumblebeeTestStep(name = "Launchbrowser", description = "invoke browser and load the url ", expected = "Url should be loaded successfully")
	@Test(priority=1)
	public void Launchbrowser() throws InterruptedException
	{
		File file = new File("src/test/java/utility/datafile.properties");
	  
	FileInputStream fileInput = null;
	try {
		fileInput = new FileInputStream(file);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	//Properties prop = new Properties();
	
	//load properties file
	try {
		prop.load(fileInput);
	} catch (IOException e) {
		e.printStackTrace();
	}
		System.setProperty("webdriver.chrome.driver",driverpath);
		driver=new ChromeDriver();
		driver.get("https://wwwp-test.medtronic.com/extregistration/neuroHCP/onePageRegistration?USER=");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	
	@BumblebeeTestStep(name = "SelectRegion", description = "Select US region from dropdown selection", expected = "User is able to select Region")
	@Test(priority=2)
	
	public void SelectRegion() throws IOException 
	{
		WebElement region=driver.findElement(By.id("region"));
		Select regiondd =new Select(region);
		regiondd.selectByVisibleText("United States");
		TakingfullpagescreenShot SS3 = new TakingfullpagescreenShot();
		SS3.takingfullSS(driver, "ScreenShots\\RequestAccessValidationTest\\beforesubmit1.png");
	}
	@BumblebeeTestStep(name = "ClickSubmit", description = "Click Submit button", expected = "It should submit the form")
	@Test(priority=3)
	public void ClickSubmit() throws IOException, InterruptedException
	{ 
		WebElement Submit= driver.findElement(By.id("submit_btn"));
		Submit.click();
		TakingfullpagescreenShot SS3 = new TakingfullpagescreenShot();
		SS3.takingfullSS(driver, "ScreenShots\\RequestAccessValidationTest\\aftersubmit1.png");
		}
	@BumblebeeTestStep(name = "Validate header field error message", description = "Keep the field empty/ blank input", expected = "Proper error should display for the  field")
	@Test(priority=4)
	public void ValidateHeaderErrormessages()
	{
		WebElement header=driver.findElement(By.id("submit-message"));
		String headmsgA=header.getText();
		String headmsgE = "Please correct the error below.";
        Assert.assertEquals(headmsgE, headmsgA);          
	}
	@BumblebeeTestStep(name = "Validate Email field error message", description = "Keep the field empty/ blank input", expected = "Proper error should display for the  field")
	@Test(priority=5)
	public void ValidateEmailErrormessages()
	{
		WebElement email=driver.findElement(By.xpath(".//*[@id='onePageRegistrationForm']/div[2]/div/div/p"));
		String EmailmsgA=email.getText(); 
		String EmailmsgE="Please enter an email address";
		Assert.assertEquals(EmailmsgE, EmailmsgA);

	}
	@BumblebeeTestStep(name = "Validate password field error message", description = "Keep the field empty/ blank input", expected = "Proper error should display for the  field")

	@Test(priority=6)
	public void ValidatepasswordErrormessages()
	{
		WebElement pwd=driver.findElement(By.id("sevenChars"));
		String PwdmsgA=pwd.getText();
    	String PwdmsgE="Password must contain seven characters or more ";
    	Assert.assertEquals(PwdmsgE, PwdmsgA);
    	
     }
	@BumblebeeTestStep(name = "Validate FN field error message", description = "Keep the field empty/ blank input", expected = "Proper error should display for the  field")

	@Test(priority=7)
	public void ValidateFNErrormessages()
	{
		WebElement fn=driver.findElement(By.xpath(".//*[@id='onePageRegistrationForm']/div[4]/div[1]/div/p"));
		String FnmsgA=fn.getText();
    	String FnmsgE="Please enter first name";
    	Assert.assertEquals(FnmsgE, FnmsgA);
    	
     }

	@BumblebeeTestStep(name = "Validate LN field error message", description = "Keep the field empty/ blank input", expected = "Proper error should display for the  field")

	@Test(priority=8)
	public void ValidateLNErrormessages()
	{
		WebElement lnmsg=driver.findElement(By.xpath(".//*[@id='onePageRegistrationForm']/div[4]/div[2]/div/p"));
		String LnmsgA=lnmsg.getText();
    	String LnmsgE="Please enter a last name";
    	Assert.assertEquals(LnmsgE, LnmsgA);
    	
     }

	@BumblebeeTestStep(name = "Validate Facility field error message", description = "Keep the field empty/ blank input", expected = "Proper error should display for the  field")

	@Test(priority=9)
	public void ValidateFacilityErrormessages()
	{
		WebElement facilitymsg=driver.findElement(By.xpath(".//*[@id='onePageRegistrationForm']/div[13]/div/div[1]/p"));
			
				String facilitymsgA=facilitymsg.getText();
		    	String facilitymsgE="Please enter a practice/organization name";
		    	Assert.assertEquals(facilitymsgE, facilitymsgA);
	}
	@BumblebeeTestStep(name = "Validate Address1 field error message", description = "Keep the field empty/ blank input", expected = "Proper error should display for the  field")

	@Test(priority=10)
	public void ValidateAddress1Errormessages()
	{
	WebElement address1msg=driver.findElement(By.xpath(".//*[@id='onePageRegistrationForm']/div[13]/div/div[2]/p"));
	String      address1msgA=address1msg.getText();
	String      address1msgE="Please enter a street address";
	Assert.assertEquals(address1msgE, address1msgA);

	}
	@BumblebeeTestStep(name = "Validate City field error message", description = "Keep the field empty/ blank input", expected = "Proper error should display for the  field")

	@Test(priority=11)
	public void ValidateCityErrormessages()
	{
		WebElement citymsg=driver.findElement(By.xpath(".//*[@id='onePageRegistrationForm']/div[13]/div/div[4]/p"));
		String     citymsgA= citymsg.getText();
    	String     citymsgE="Please enter a city";
    	Assert.assertEquals(citymsgE, citymsgA);

	}
	@BumblebeeTestStep(name = "Validate State field error message", description = "Keep the field empty/ blank input", expected = "Proper error should display for the  field")
	@Test(priority=12)
	public void ValidateStateErrormessages()
	{
		
		WebElement statemsg=driver.findElement(By.xpath(".//*[@id='onePageRegistrationForm']/div[14]/div[1]/div/div/p"));
		String    statemsgA=statemsg.getText();
    	String    statemsgE="Please ";
    	Assert.assertEquals(statemsgE, statemsgA);
    	
     }

	@BumblebeeTestStep(name = "Validate Zipcode field error message", description = "Keep the field empty/ blank input", expected = "Proper error should display for the  field")

	@Test(priority=13)
	public void ValidateZipcodeErrormessages()
	{
		WebElement zipcodemsg = driver.findElement(By.xpath(".//*[@id='onePageRegistrationForm']/div[14]/div[2]/div/p"));
		String   zipcodemsgA=zipcodemsg.getText();
    	String   zipcodemsgE="Please enter ";
    	Assert.assertEquals(zipcodemsgE, zipcodemsgA);	
    	}
	@BumblebeeTestStep(name = "Validate Phone field error message", description = "Keep the field empty/ blank input", expected = "Proper error should display for the  field")

	@Test(priority=14)
	public void ValidatePhoneErrormessages()
	{
		WebElement phonemsg=driver.findElement(By.xpath(".//*[@id='onePageRegistrationForm']/div[15]/div/div/div[1]/div/p"));
		String  phonemsgA= phonemsg.getText();
    	String  phonemsgE="Please enter a valid phone number";
    	Assert.assertEquals(phonemsgE, phonemsgA);
    	
     }

	@BumblebeeTestStep(name = "Validate Spciality field error message", description = "Keep the field empty/ blank input", expected = "Proper error should display for the  field")

	@Test(priority=15)
	public void ValidateSpecialityErrormessages()
	{
		WebElement specialitymsg= driver.findElement(By.xpath(".//*[@id='specialitySection']/div/div/div/p"));
		String specialitymsgA=specialitymsg.getText();
    	String specialitymsgE="Please select a specialty";
    	Assert.assertEquals(specialitymsgE, specialitymsgA);

	}
	
	@BumblebeeTestStep(name = "Validate HCP Checkbox field error message", description = "Keep the field empty/ blank input", expected = "Proper error should display for the  field")
	@Test(priority=16)
	public void ValidateHCPCheckboxErrormessages()
	{
		WebElement hcpcheckboxmsg=driver.findElement(By.xpath(".//*[@id='uniform-step1-checkbox']/p"));
		String hcpcheckboxmsgA=hcpcheckboxmsg.getText();
    	String hcpcheckboxmsgE="Please verify that you are a healthcare professional";
    	Assert.assertEquals(hcpcheckboxmsgE, hcpcheckboxmsgA);

	}
	      
	@BumblebeeTestStep(name = "Close browser", description = "Close the  browser", expected = "Browser should be closed")

	@Test(priority=17)	
	public void Closebrowser()
	
	{
		driver.close();
	}

@Override
public RemoteWebDriver getWebDriver() {
	return driver;
}

@AfterMethod
public void onTestSuccess(final ITestResult result) {
	
	final TestNGTestContext context = new TestNGTestContext();
	result.setAttribute(BUMBLEBEE_TEST_CONTEXT_ATTR_NAME, context);
	final File screenshot = driver.getScreenshotAs(OutputType.FILE);
	LOGGER.info("Taking screenshot: " + screenshot.getAbsolutePath());
	context.setScreenshot(screenshot);
	
	}


}



