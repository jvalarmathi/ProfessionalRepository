package Mathi.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.agiletestware.bumblebee.annotations.BooleanValue;
import com.agiletestware.bumblebee.annotations.Bumblebee;
import com.agiletestware.bumblebee.annotations.BumblebeeTestStep;

import Objects.ProfessionalLoginPage;
import utility.TakingfullpagescreenShot;

@Test
public class Professionalheaderandfootertestafterlogin {
	String driverpath="src/main/java/Drivers/chromedriver.exe";
	public  WebDriver driver;
	Properties prop = new Properties();
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
	driver.get(prop.getProperty("profloginurl"));
	driver.manage().window().maximize();
	}
	@Test(priority=1)
	public void LoginTest() throws InterruptedException, IOException
	{
		//driver.findElement(By.xpath(".//*[@id='container-hp']/header/div[1]/div/ol/li[2]/a")).click();
		driver.findElement(By.id("USER")).sendKeys(prop.getProperty("profuser"));
		driver.findElement(By.id("PASSWORD")).sendKeys(prop.getProperty("profpwd"));		
		TakingfullpagescreenShot SS3 = new TakingfullpagescreenShot();
		SS3.takingfullSS(driver, "ScreenShots\\Professional\\beforelogin.png");
		//driver.findElement(By.id("login")).click();
		Thread.sleep(3000);
		SS3.takingfullSS(driver, "ScreenShots\\Professional\\afterlogin.png");
	}
	@Test(priority=2)
	public void logoTest()
	{
	WebElement logo=driver.findElement(By.xpath(".//*[@id='container-hp']/header/div[1]/div/img"));
	Assert.assertTrue(logo.isDisplayed());	
	}
	@Test(priority=2)
	public void ReqacceesslinkTest()
	{
	WebElement Requestaccessink=driver.findElement(By.xpath(".//*[@id='container-hp']/header/div[1]/div/ol/li[1]/a"));
	String ReqA=Requestaccessink.getAttribute("href");
	String ReqE="https://wwwp-test.medtronic.com/extregistration/neuroHCP/registration";
	Assert.assertEquals(ReqA, ReqE);
	}
	@Test(priority=3)
	public void LoginlinkTest()
	{
		
	WebElement Login=driver.findElement(By.xpath(".//*[@id='container-hp']/header/div[1]/div/ol/li[2]/a"));
	String LogintextA=Login.getText();
	String LogintextE="LOG IN";
	Assert.assertEquals(LogintextA, LogintextA);
	String LoginA=Login.getAttribute("href");
	String LoginE="http://professional-test.medtronic.com/secure/";
	Assert.assertEquals(LoginA, LoginE);
	}
	@Test(priority=4)
	public void HCPlinkTest()
	{
		WebElement HCPlink=driver.findElement(By.xpath(".//*[@id='container-hp']/header/div[2]/div/p/a"));
		String HCPlinktextA=HCPlink.getText();
		String HCPlinktextE="FOR HEALTHCARE PROFESSIONALS";
	Assert.assertEquals(HCPlinktextA, HCPlinktextE);
	String HCPlinkA=HCPlink.getAttribute("href");
	String HCPlinkE="";
	Assert.assertEquals(HCPlinkA, HCPlinkE);
		}	
	
	@Test(priority=5)
	public void EducationTrainingTest()
	{
		WebElement edu=driver.findElement(By.xpath(".//*[@id='primary-nav']/ul/li[1]/a"));
		String ETlinktextA=edu.getText();
		String ETlinktextE="EDUCATION & TRAINING";
		Assert.assertEquals(ETlinktextA, ETlinktextE);
		String ETlinkA=edu.getAttribute("href");
		String ETlinkE="http://professional-test.medtronic.com/ee/";
		Assert.assertEquals(ETlinkA, ETlinkE);
		
	}
	@Test(priority=6)
	public void ReimpursementandpracticeTest()
	{
		WebElement re=driver.findElement(By.xpath(".//*[@id='primary-nav']/ul/li[2]/a"));
		String relinktextA=re.getText();
		String relinktextE="REIMBURSEMENT & PRACTICE MANAGEMENT";
		Assert.assertEquals(relinktextA, relinktextE);
		String RPlinkA=re.getAttribute("href");
		String RPlinkE="http://professional-test.medtronic.com/rm/index.htm";
		Assert.assertEquals(RPlinkA, RPlinkE);
		
	}
	
	@Test(priority=7)
	public void FootertextTest()
	{
		WebElement footertxt=driver.findElement(By.xpath(".//*[@id='footer-nav']/p"));
		String FootertextA=footertxt.getText();
		String FootertextE="2017 Medtronic";
		Assert.assertEquals(FootertextA, FootertextE);
		}
	@Test(priority=8)
	public void medtroniclinkTest()
	{
		WebElement medlink=driver.findElement(By.xpath(".//*[@id='footer']/li[1]/a"));
		String medtextA=medlink.getText();
		Assert.assertEquals("Medtronic.com", medtextA);
		String medlinkurlA=medlink.getAttribute("href");
		String medlinkurlE="http://www-test.medtronic.com/us-en/index.html";
		Assert.assertEquals(medlinkurlA, medlinkurlE);
	}
	@Test(priority=9)
	public void privacylinkTest()
	{
		WebElement privacylink=driver.findElement(By.xpath(".//*[@id='footer']/li[2]/a"));
		String privacytextA=privacylink.getText();
		Assert.assertEquals("Privacy Statement", privacytextA);
		String privacylinkurlA=privacylink.getAttribute("href");
		String privacylinkurlE="http://www-test.medtronic.com/us-en/privacy-statement.html";
		Assert.assertEquals(privacylinkurlA, privacylinkurlE);
		}
	@Test(priority=10)
	public void termsofuselinkTest()
	{
		WebElement termsofuselink=driver.findElement(By.xpath(".//*[@id='footer']/li[3]/a"));
		String TUtextA=termsofuselink.getText();
		Assert.assertEquals("Terms of Use",TUtextA);
		String TULinkurlA=termsofuselink.getAttribute("href");
		String TULinkurlE="http://www-test.medtronic.com/us-en/terms-of-use.html";
		Assert.assertEquals(TULinkurlA, TULinkurlE);
	}
	@Test(priority=11)
	public void CustomersupportLinkTest()
	{
		WebElement customersupportlink=driver.findElement(By.xpath(".//*[@id='footer']/li[4]/a"));
		String CStextA=customersupportlink.getText(); 
		Assert.assertEquals("Customer Support", CStextA);
		String CSlinkurlA=customersupportlink.getAttribute("href");
		String CSlinkurlE="http://professional-test.medtronic.com/customer-support/index.htm#.VvmfieIrLRY";
		Assert.assertEquals(CSlinkurlA, CSlinkurlE);
	}
	
	@Test(priority=12)
	public void ContactuslinkTest()
	{
		WebElement contactuslink=driver.findElement(By.xpath(".//*[@id='footer']/li[5]/a"));
		String CUtextA=contactuslink.getText();
		Assert.assertEquals("Contact Us", CUtextA);
		String CUlinkurlA=contactuslink.getAttribute("href");
		String CUlinkurlE="http://professional-test.medtronic.com/customer-support/contact-us/index.htm#.Vvmfq-IrLRY";
		Assert.assertEquals(CUlinkurlA, CUlinkurlE);
	}
	
	@Test(priority=13)
	public void Closebrowser()
	{
		driver.close();
	}
	
}
	
	
	


