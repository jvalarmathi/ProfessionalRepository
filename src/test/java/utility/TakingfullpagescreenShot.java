package utility;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;

public class TakingfullpagescreenShot {
	
	public void takingfullSS(WebDriver driver, String SS3) throws IOException
	{
	   final Screenshot screenshot = new AShot().shootingStrategy(
			    new ViewportPastingStrategy(500)).takeScreenshot(driver);
	 final BufferedImage image = screenshot.getImage();
	 File destfile=new File(SS3);
	 ImageIO.write(image, "PNG", destfile);
	 
	  //ImageIO.write(image, "PNG", new File("C:\\Users\\padivv2\\eclipse-workspace\\Test\\ScreenShots\\RequestAccessTest\\beforesubmit.png"));
			 /* TakesScreenshot Screen=((TakesScreenshot)driver);
				File srcfile= Screen.getScreenshotAs(OutputType.FILE);
				File destfile=new File(SS);
				FileUtils.copyFile(srcfile, destfile);*/
				
	}
}
