package Mathi.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Objects.RequestAccessPage;
import utility.TakingScreenShot;
import utility.TakingfullpagescreenShot;

public class RequestAccessTest {
	String driverpath="src/main/java/Drivers/chromedriver.exe";
	WebDriver driver;
	Properties prop = new Properties();
	@BeforeTest
	public void Launchbrowser() throws InterruptedException
	{
		File file = new File("C:/Users/padivv2/eclipse-workspace/Test/src/test/java/utility/datafile.properties");
	  
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
		ob.enteremail(prop.getProperty("emailAddress"));
		ob.enterpwd(prop.getProperty("password"));
		ob.enterconfirmpwd(prop.getProperty("confirmPassword"));
	    ob.enterFN(prop.getProperty("firstName"));
	    ob.enterLN(prop.getProperty("lastName"));
	    ob.titleselect(prop.getProperty("title"));
	    ob.degreeselect(prop.getProperty("degree"));
	    ob.roleselect(prop.getProperty("role"));
	    ob.selectlicense();
	    ob.stateoflicenseselect(prop.getProperty("stateOfLicensure"));
	    ob.enterLnumber(prop.getProperty("licenseNumber"));
	    ob.enterorg(prop.getProperty("organization"));
	    ob.enteraddress1(prop.getProperty("address"));
	    ob.entercity(prop.getProperty("city"));
	    ob.selectstate(prop.getProperty("state"));
	    ob.enterZipcode(prop.getProperty("postalcode"));
	    ob.enterphone(prop.getProperty("telephone"));
	    ob.enterphysupport(prop.getProperty("physicianSupporting"));
	    ob.enterfacility(prop.getProperty("practiceFacilityOrg"));
	    ob.selectspeciality(prop.getProperty("Speciality"));
	    ob.selectspcialitycheckbox();
	    ob.selectshcpcheckbox();
	    TakingfullpagescreenShot SS3 = new TakingfullpagescreenShot();
		SS3.takingfullSS(driver, "C:\\Users\\padivv2\\eclipse-workspace\\Test\\ScreenShots\\RequestAccessTest\\beforesubmit.png");
	    ob.clicksubmit();
	    Thread.sleep(2000);
	    SS3.takingfullSS(driver, "C:\\Users\\padivv2\\eclipse-workspace\\Test\\ScreenShots\\RequestAccessTest\\aftersubmit.png");
	    String PagetitlelA=driver.getTitle();
		String PagetitleE="Registration Pending";
		if ( PagetitlelA.equals(PagetitleE))
		{
		System.out.println("Request Access is Successful");
	}
		else
		{
			System.out.println("Request Access is Not Successful");
		}
		}
@AfterTest
	
	public void Closebrowser()
	
	{
		driver.close();
	}
}
