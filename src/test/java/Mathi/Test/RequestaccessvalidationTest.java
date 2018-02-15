package Mathi.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.agiletestware.bumblebee.annotations.BooleanValue;
import com.agiletestware.bumblebee.annotations.Bumblebee;

import Objects.RequestAccessPage;
import utility.TakingScreenShot;
import utility.TakingfullpagescreenShot;
@Bumblebee(testplan = "Subject\\SeleniumAutomation", testlab = "Root\\Professional.com", testset = "Selenium Test Set", testname = "RequestAccessvalidationTest",hasSteps = BooleanValue.TRUE)

public class RequestaccessvalidationTest {
	String driverpath="src/main/java/Drivers/chromedriver.exe";
	WebDriver driver;
	Properties prop = new Properties();
	@BeforeTest
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
		driver.get(prop.getProperty("profUSurl"));
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	
	@Test
	public void RequestAccessTest() throws IOException, InterruptedException
	{
		RequestAccessPage ob=new RequestAccessPage(driver);
		ob.regionselect(prop.getProperty("region"));
		TakingfullpagescreenShot SS3 = new TakingfullpagescreenShot();
		SS3.takingfullSS(driver, "ScreenShots\\RequestAccessValidationTest\\beforesubmit1.png");
		ob.clicksubmit();
		SS3.takingfullSS(driver, "ScreenShots\\RequestAccessValidationTest\\aftersubmit1.png");
        ob.headmsg();
        ob.Emailmsg();
        ob.passwordmsg();
        ob.fnmsg();
        ob.lnmsg();
        ob.facilitymsg();
        ob.address1msg();
        ob.citymsg();
        ob.statemsg();
        ob.zipcodemsg();
        ob.phonemsg();
        ob.specialitymsg();
        ob.hcpcheckboxmsg();
}

@AfterTest
	
	public void Closebrowser()
	
	{
		driver.close();
	}
}
