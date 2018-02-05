package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakingScreenShot {
	
	
	public void SSTest(WebDriver driver, String SS) throws IOException
	{
		TakesScreenshot Screen=((TakesScreenshot)driver);
		File srcfile= Screen.getScreenshotAs(OutputType.FILE);
		File destfile=new File(SS);
		FileUtils.copyFile(srcfile, destfile);
		
	}

}
