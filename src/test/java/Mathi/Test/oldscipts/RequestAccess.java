package Mathi.Test.oldscipts;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utility.TakingScreenShot;

public class RequestAccess {
	String driverpath="src/main/java/Drivers/chromedriver.exe";
	WebDriver driver;
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
		Properties prop = new Properties();
		
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
	
	@Test
	
	public void RequestAccessTest() throws IOException, InterruptedException
	{
		//driver.findElement(By.id("container-hp")).click();
		Select selectregion=new Select(driver.findElement(By.id("region")));
		selectregion.selectByVisibleText("United States");
		driver.findElement(By.id("emailAddress")).sendKeys("emailtest1@test.com");
		driver.findElement(By.id("password")).sendKeys("Test1234");
		driver.findElement(By.id("confirmPassword")).sendKeys("Test1234");
		driver.findElement(By.id("firstName")).sendKeys("Valar");
		driver.findElement(By.id("lastName")).sendKeys("Mathi");
		Select title = new Select (driver.findElement(By.id("title")));
		title.selectByVisibleText("Mrs");
		Select degree=new Select (driver.findElement(By.id("degree")));
		degree.selectByVisibleText("MA");
		Select role= new Select(driver.findElement(By.id("role")));
		role.selectByVisibleText("Therapist");
		driver.findElement(By.id("licenseRadio")).click();
		Select licensure=new Select(driver.findElement(By.id("stateOfLicensure")));
		licensure.selectByVisibleText("California");
		driver.findElement(By.id("licenseNumber")).sendKeys("1234567890");
		driver.findElement(By.id("organization")).sendKeys("Testfacility");
		driver.findElement(By.id("address")).sendKeys("Testaddress");
		driver.findElement(By.id("city")).sendKeys("Ottawa");
		Select state=new Select(driver.findElement(By.id("state")));
		state.selectByVisibleText("Ohio");
		driver.findElement(By.id("postalcode")).sendKeys("123456");
		driver.findElement(By.id("telephone")).sendKeys("1234567890123456");
		driver.findElement(By.id("physicianSupporting")).sendKeys("Testphysician");
		driver.findElement(By.id("practiceFacilityOrg")).sendKeys("TestpracticeOrg");
		Select speciality=new Select(driver.findElement(By.id("speciality")));
		speciality.selectByVisibleText("Anesthesiology");
		driver.findElement(By.id("treatmentOptions_null")).click();
		driver.findElement(By.id("hcpVerification")).click();
		TakingScreenShot SS= new TakingScreenShot();
		SS.SSTest(driver, "C:\\Users\\padivv2\\eclipse-workspace\\Test\\ScreenShots\\Requestaccess\\beforesubmit.png");
		driver.findElement(By.id("submit_btn")).click();
		Thread.sleep(2000);
		SS.SSTest(driver, "C:\\Users\\padivv2\\eclipse-workspace\\Test\\ScreenShots\\Requestaccess\\aftersubmit.png");
		System.out.println("Page Name: "+driver.getTitle());
	}
@AfterTest
	
	public void Closebrowser()
	
	{
		driver.close();
	}
}
