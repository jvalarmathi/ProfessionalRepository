package Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.agiletestware.bumblebee.annotations.BooleanValue;
import com.agiletestware.bumblebee.annotations.Bumblebee;
import com.agiletestware.bumblebee.annotations.BumblebeeTestStep;


public class ProfessionalLoginPage {
	public void loginPage (WebDriver driver) {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
	}
	
	@FindBy(xpath=".//*[@id='container-hp']/header/div[1]/div/img")
	WebElement logo;
	
	@Test(priority=1)
	@BumblebeeTestStep(name = "Check Metroniclogo", description = "Check the Metronic logo in left side right corner of header1", expected = "Logo should be present")
	public void LogoTest()
	{
	
		Assert.assertTrue(logo.isDisplayed());
	}
}
