package Mathi.Test;

public class Snippet {
	public void takingscreenshotTest(WebDriver driver; String SS)
		{
			TakesScreenshot SS1= ((TakesScreenShot)driver);
			File srcfile = SS1.getScreenshotAs(OutputType<X>.FILE);
			File destfile=new File (SS);
			FileUtils.copyDirectory(srcfile, destfile);
		}
}

