package Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) throws Exception {
		//super(driver);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
		}
	
	@FindBy(id="USER")
	WebElement email;
	
	@FindBy(id="PASSWORD")
	WebElement password1;
	
	@FindBy(id="login")
	WebElement login;
	
	public void Enteremail(String user)
	{
		email.sendKeys(user);
	}
	
     public void Enterpassword(String password)
     {
    	 password1.sendKeys(password);
     }
     
     public void clicklogin()
     {
    	 login.click();
     }
     
     public void testhomepage()
     {
    	String  homepagetitleA= driver.getTitle();
    	String  homepagetitleE="Test";
    	if (homepagetitleA.equals(homepagetitleE))
    	{
    		System.out.println("Login issuccessful");
    		System.out.println(homepagetitleA);
    	}
    	else
    	{
    		System.out.println("Login is Unsuccessful");
    	}
    			
     }
}
