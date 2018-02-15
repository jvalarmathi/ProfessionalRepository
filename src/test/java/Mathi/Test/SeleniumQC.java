package Mathi.Test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.agiletestware.bumblebee.annotations.BooleanValue;
import com.agiletestware.bumblebee.annotations.Bumblebee;

import Objects.RequestAccessPage;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;
import utility.TakingfullpagescreenShot;
@Bumblebee(testplan = "Subject\\SeleniumAutomation", testlab = "Root\\Professional.com", testset = "Selenium Test Set",hasSteps = BooleanValue.TRUE)
public class SeleniumQC {
	String driverpath="src/main/java/Drivers/chromedriver.exe";
	WebDriver driver;
	Properties prop = new Properties();
	@Test(priority=1)
	@BeforeTest()
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
	
	@Test(priority=2)
	public void RequestAccessTest() throws IOException, InterruptedException
	{
		RequestAccessPage ob=new RequestAccessPage(driver);
		ob.regionselect(prop.getProperty("region"));
		//TakingfullpagescreenShot SS3 = new TakingfullpagescreenShot();
		//SS3.takingfullSS(driver);
		ob.clicksubmit();
		//SS3.takingfullSS(driver, "ScreenShots\\RequestAccessValidationTest\\aftersubmit1.png");
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

	@Test
			public void takingfullSS(WebDriver driver) throws IOException
		{
		   final Screenshot screenshot = new AShot().shootingStrategy(
				    new ViewportPastingStrategy(500)).takeScreenshot(driver);
		 final BufferedImage image = screenshot.getImage();
		// File destfile=new File(SS3);
		// ImageIO.write(image, "PNG", destfile);
		 
		  //ImageIO.write(image, "PNG", new File("C:\\Users\\padivv2\\eclipse-workspace\\Test\\ScreenShots\\RequestAccessTest\\beforesubmit.png"));
				 /* TakesScreenshot Screen=((TakesScreenshot)driver);
					File srcfile= Screen.getScreenshotAs(OutputType.FILE);
					File destfile=new File(SS);
					FileUtils.copyFile(srcfile, destfile);*/
					
		}
@Test(priority=4)
	
	public void Closebrowser()
	
	{
		driver.close();
	}
}

