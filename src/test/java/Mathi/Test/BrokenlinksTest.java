package Mathi.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrokenlinksTest {
	
	String driverpath="src/main/java/Drivers/chromedriver.exe";
	WebDriver driver;
	
	@BeforeTest
	public void launchbrowser() throws InterruptedException
	{
		File file = new File("src/test/java/utility/datafile.properties");
		  
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
		driver.get(prop.getProperty("urlforbrokenlinktest"));
		driver.manage().window().maximize();
	}
	
	@Test

	public void linksTest()
	{
		List<WebElement> links=driver.findElements(By.tagName("a"));
		int linkcount=links.size();
		System.out.println(linkcount);
		HttpURLConnection huc = null;
        int respCode = 200;
		for (int i=0;i<links.size();i++)
		{
			String linkname=links.get(i).getText();
			String linkurl=links.get(i).getAttribute("href");
			//System.out.println(linkname+" :  "+ linkurl);
			String Homepage="https://professional-test.medtronic.com";
			
			
			if (linkurl==null || linkurl.isEmpty())
			{
				System.out.println(linkname +" url is Null or Empty  "+linkurl);
				continue;
			}
			
			else if (!linkurl.contains("test.medtronic.com"))
			{
				System.out.println(linkname +"  url is belongs to other domain  "+linkurl);
				continue;
			}
			
			else if (linkurl.contains("test.medtronic.com"))
			{
				System.out.println(linkname +"  url is professional.com domain  "+linkurl);
				continue;
			}
			
			
	        
			/*try {
                huc = (HttpURLConnection)(new URL(linkname).openConnection());
                
                huc.setRequestMethod("HEAD");
                
                huc.connect();
                
                respCode = huc.getResponseCode();
                System.out.println("response code" + respCode);
                
                if(respCode >= 400){
                    System.out.println(linkname+" is a broken link");
                }
                else{
                    System.out.println(linkname+" is a valid link");
                }
                    
            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
				*/
		}
		
		
	}
	
	@AfterTest
	public void closebrowser()
	{
		driver.close();
	}
}
