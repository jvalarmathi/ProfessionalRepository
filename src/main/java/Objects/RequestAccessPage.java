package Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RequestAccessPage {

	
public RequestAccessPage (WebDriver driver) {
	PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
}



     @FindBy(id="region")
     WebElement regiondd;
     @FindBy(id="emailAddress")
     WebElement email;
     @FindBy(id="password")
     WebElement pwd;
     @FindBy(id="confirmPassword")
     WebElement cpwd;
     @FindBy(id="firstName")
     WebElement FN;
     @FindBy(id="lastName")
     WebElement LN;
     @FindBy(id="title")
     WebElement title;
     @FindBy(id="degree")
     WebElement degree;
     @FindBy(id="role")
     WebElement role;
     @FindBy(id="licenseRadio")
     WebElement license;
     @FindBy(id="stateOfLicensure")
     WebElement stateoflicensure;
     @FindBy(id="licenseNumber")
     WebElement Lnumber;
     @FindBy(id="organization")
     WebElement org;
     @FindBy(id="address")
     WebElement address1;
     @FindBy(id="city")
     WebElement city;
     @FindBy(id="state")
     WebElement state;
     @FindBy(id="postalcode")
     WebElement zipcode;
     @FindBy(id="telephone")
     WebElement phone;
     @FindBy(id="physicianSupporting")
     WebElement physupport;
     @FindBy(id="practiceFacilityOrg")
     WebElement facility;
     @FindBy(id="speciality")
     WebElement speciality;
     @FindBy(id="treatmentOptions_null")
     WebElement spcialitycheckbox;
     @FindBy(id="hcpVerification")
     WebElement hcpcheckbox;
     @FindBy(id="submit_btn")
     WebElement submit;
     @FindBy(id="submit-message")
     WebElement headmsg;
     @FindBy(xpath=".//*[@id='onePageRegistrationForm']/div[2]/div/div/p")
     WebElement Emailmsg;
     @FindBy(id="sevenChars")
     WebElement passwordmsg;
     @FindBy(xpath=".//*[@id='onePageRegistrationForm']/div[4]/div[1]/div/p")
     WebElement fnmsg;
     @FindBy(xpath=".//*[@id='onePageRegistrationForm']/div[4]/div[2]/div/p")
     WebElement lnmsg;
     @FindBy(xpath=".//*[@id='onePageRegistrationForm']/div[5]/div[1]/div/p")
     WebElement titlemsg;
     @FindBy(xpath=".//*[@id='onePageRegistrationForm']/div[5]/div[2]/div/p")
     WebElement degreemsg;
     @FindBy(xpath=".//*[@id='onePageRegistrationForm']/div[6]/div/div/div/p")
     WebElement rolemsg;
     @FindBy(xpath=".//*[@id='onePageRegistrationForm']/div[13]/div/div[1]/p")
     WebElement facilitymsg;
     @FindBy(xpath=".//*[@id='onePageRegistrationForm']/div[13]/div/div[2]/p")
     WebElement address1msg;
     @FindBy(xpath=".//*[@id='onePageRegistrationForm']/div[13]/div/div[4]/p")
     WebElement citymsg;
     @FindBy(xpath=".//*[@id='onePageRegistrationForm']/div[14]/div[1]/div/div/p")
     WebElement statemsg;
     @FindBy(xpath=".//*[@id='onePageRegistrationForm']/div[14]/div[2]/div/p")
     WebElement zipcodemsg;
     @FindBy(xpath=".//*[@id='onePageRegistrationForm']/div[15]/div/div/div[1]/div/p")
     WebElement phonemsg;
     @FindBy(xpath=".//*[@id='specialitySection']/div/div/div/p")
     WebElement specialitymsg;
     @FindBy(xpath=".//*[@id='uniform-step1-checkbox']/p")
     WebElement hcpcheckboxmsg;
     
     
     
     public void      address1msg()
     {
    	String      address1msgA=address1msg.getText();
    	String      address1msgE="Please enter a street address";
    	if (      address1msgE.equals(address1msgA))
        {
     	   System.out.println("Address1 message is matching with expected message:   " +      address1msgA);
        }
        else
        {
     	   System.out.println("Address1 message is not matching with expected message:  " +      address1msgA); 
        }
    	
     }

     public void     citymsg()
     {
    	String     citymsgA= citymsg.getText();
    	String     citymsgE="Please enter a city";
    	if (     citymsgE.equals(citymsgA))
        {
     	   System.out.println("City message is matching with expected message:   " +     citymsgA);
        }
        else
        {
     	   System.out.println("City message is not matching with expected message:  " +     citymsgA); 
        }
    	
     }

     
     public void    statemsg()
     {
    	String    statemsgA=statemsg.getText();
    	String    statemsgE="Please select a state";
    	if (    statemsgE.equals(statemsgA))
        {
     	   System.out.println("State message is matching with expected message:   " +    statemsgA);
        }
        else
        {
     	   System.out.println("State message is not matching with expected message:  " +    statemsgA); 
        }
    	
     }

     
     public void   zipcodemsg()
     {
    	String   zipcodemsgA=zipcodemsg.getText();
    	String   zipcodemsgE="Please enter a ZIP/Postal Code";
    	if (   zipcodemsgE.equals(zipcodemsgA))
        {
     	   System.out.println("Zipcode message is matching with expected message:   " +   zipcodemsgA);
        }
        else
        {
     	   System.out.println("Zipcode message is not matching with expected message:  " +   zipcodemsgA); 
        }
    	
     }

     public void  phonemsg()
     {
    	String  phonemsgA= phonemsg.getText();
    	String  phonemsgE="Please enter a valid phone number";
    	if (  phonemsgE.equals( phonemsgA))
        {
     	   System.out.println("Phone message is matching with expected message:   " +  phonemsgA);
        }
        else
        {
     	   System.out.println("Phone message is not matching with expected message:  " +  phonemsgA); 
        }
    	
     }

     
     public void specialitymsg()
     {
    	String specialitymsgA=specialitymsg.getText();
    	String specialitymsgE="Please select a specialty";
    	if ( specialitymsgE.equals(specialitymsgA))
        {
     	   System.out.println("Speciality message is matching with expected message:   " + specialitymsgA);
        }
        else
        {
     	   System.out.println("Speciality message is not matching with expected message:  " + specialitymsgA); 
        }
    	
     }

     public void hcpcheckboxmsg()
     {
    	String hcpcheckboxmsgA=hcpcheckboxmsg.getText();
    	String hcpcheckboxmsgE="Please verify that you are a healthcare professional";
    	if ( hcpcheckboxmsgE.equals(hcpcheckboxmsgA))
        {
     	   System.out.println("Hcpcheckbox message is matching with expected message:   " + hcpcheckboxmsgA);
        }
        else
        {
     	   System.out.println("Hcpcheckbox message is not matching with expected message:  " + hcpcheckboxmsgA); 
        }
    	
     }
     
     public void facilitymsg()
     {
    	String facilitymsgA=facilitymsg.getText();
    	String facilitymsgE="Please enter a practice/organization name";
    	if ( facilitymsgE.equals(facilitymsgA))
        {
     	   System.out.println("Facility message is matching with expected message:   " + facilitymsgA);
        }
        else
        {
     	   System.out.println("Facility message is not matching with expected message:  " + facilitymsgA); 
        }
    	
     }
     
     public void rolemsg()
     {
    	String RolemsgA=rolemsg.getText();
    	String RolemsgE="Please select a role";
    	if ( RolemsgE.equals(RolemsgA))
        {
     	   System.out.println("Degree message is matching with expected message:   " + RolemsgA);
        }
        else
        {
     	   System.out.println("Degree message is not matching with expected message:  " + RolemsgA); 
        }
    	
     }
     public void degreemsg()
     {
    	String DegreemsgA=degreemsg.getText();
    	String DegreemsgE="Please select a degree";
    	if (DegreemsgE.equals(DegreemsgA))
        {
     	   System.out.println("Degree message is matching with expected message:   " + DegreemsgA);
        }
        else
        {
     	   System.out.println("Degree message is not matching with expected message:  " + DegreemsgA); 
        }
    	
     }
     public void titlemsg()
     {
    	String TitlemsgA=titlemsg.getText();
    	String TitlemsgE="Please select a title";
    	if (TitlemsgE.equals(TitlemsgA))
        {
     	   System.out.println("Title message is matching with expected message:   " + TitlemsgA);
        }
        else
        {
     	   System.out.println("Title message is not matching with expected message:  " + TitlemsgA); 
        }
    	
     }
     
     public void lnmsg()
     {
    	String LnmsgA=lnmsg.getText();
    	String LnmsgE="Please enter a last name";
    	if (LnmsgE.equals(LnmsgA))
        {
     	   System.out.println("Lastname message is matching with expected message:   " + LnmsgA);
        }
        else
        {
     	   System.out.println("Lastname message is not matching with expected message:  " + LnmsgA); 
        }
    	
     }
     
     public void fnmsg()
     {
    	String FnmsgA=fnmsg.getText();
    	String FnmsgE="Please enter a first name";
    	if (FnmsgE.equals(FnmsgA))
        {
     	   System.out.println("Firstname message is matching with expected message:   " + FnmsgA);
        }
        else
        {
     	   System.out.println("Firstname message is not matching with expected message:  " + FnmsgA); 
        }
    	
     }
     
     public void passwordmsg()
     {
    	String PwdmsgA=passwordmsg.getText();
    	String PwdmsgE="Password must contain seven characters or more ";
    	if (PwdmsgE==PwdmsgA)
        {
     	   System.out.println("Password message is matching with expected message:   " + PwdmsgA);
        }
        else
        {
     	   System.out.println("Password message is matching with expected message:  " + PwdmsgA); 
        }
    	
     }
     
     public void Emailmsg()
     {
    	String EmailmsgA=Emailmsg.getText();
    	String EmailmsgE="Please enter an e-mail address";
    	if (EmailmsgE.equals(EmailmsgA))
        {
     	   System.out.println("Email message is matching with expected message:   " + EmailmsgA);
        }
        else
        {
     	   System.out.println("Email message is not matching with expected message:  " + EmailmsgA); 
        }
    	
     }
     public void headmsg()
     {
    	 String headmsgA = headmsg.getText();
         String headmsgE = "Please correct the errors below.";
       if (headmsgE.equals(headmsgA))
       {
    	   System.out.println("Header message is matching with expected message:   " + headmsgA);
       }
       else
       {
    	   System.out.println("Header message is not matching with expected message:  " + headmsgA); 
       }
        		
    	 
     }
     
     public void regionselect(String region1)
     {
    	 Select regiondropdown=new Select(regiondd);
    	 regiondropdown.selectByVisibleText(region1);
    	 
     }
     
     public void enteremail(String emailAddress)
     {
    	 email.sendKeys(emailAddress);
     }
     
     public void enterpwd(String password)
     {
    	 pwd.sendKeys(password);
     }
     public void enterconfirmpwd(String confirmPassword)
     {
    	 cpwd.sendKeys(confirmPassword);
     }
     public void enterFN(String firstName)
     {
    	 FN.sendKeys(firstName);
     }
     public void enterLN(String lastName)
     {
    	 LN.sendKeys(lastName);
     }
    	 public void titleselect(String title1)
         {
        	 Select titledd=new Select(title);
        	 titledd.selectByVisibleText(title1);
        	 
         }
    	 public void degreeselect(String degree1)
         {
        	 Select degreedropdown=new Select(degree);
        	degreedropdown.selectByVisibleText(degree1);
        	 
         }
    	 public void roleselect(String role1)
         {
        	 Select roledropdown=new Select(role);
        	 roledropdown.selectByVisibleText(role1);
        	 
         }
     
     public void selectlicense()
     {
    	 license.click();
     }
     
     public void stateoflicenseselect(String stateOfLicensure1)
     {
    	 Select soldropdown=new Select(stateoflicensure);
    	 soldropdown.selectByVisibleText(stateOfLicensure1);
    	 
     }
     public void enterLnumber(String licenseNumber)
     {
    	 Lnumber.sendKeys(licenseNumber);
    	 
     }
     public void enterorg(String organization)
     {
    	 org.sendKeys(organization);
    	 
     }
         
     
     public void enteraddress1(String addresss)
     {
    	 address1.sendKeys(addresss);
     }
     
     public void entercity(String city1)
     {
    	 city.sendKeys(city1);
     }
          
     public void selectstate(String state1)
     {
    	 Select statedropdown=new Select(state);
    	statedropdown.selectByVisibleText(state1);
    	 
     }
     
     public void enterZipcode(String postalcode)
     {
    	 zipcode.sendKeys(postalcode);
     }
     public void enterphone(String telephone)
     {
    	 phone.sendKeys(telephone);
     }
     public void enterphysupport(String physicianSupporting)
     {
    	 physupport.sendKeys(physicianSupporting);
     }
     
          public void enterfacility(String practiceFacilityOrg)
     {
    	 facility.sendKeys(practiceFacilityOrg);
     }
     
     public void selectspeciality(String Speciality1)
     {
    	 Select specialitydropdown=new Select(speciality);
    	 specialitydropdown.selectByVisibleText(Speciality1);
    	 
     }     
     
     public void selectspcialitycheckbox()
     {
    	 spcialitycheckbox.click();
    	 }
     
     public void selectshcpcheckbox()
     {
    	 hcpcheckbox.click();
    	 }
     
     public void clicksubmit()
     {
    	 submit.click();
     }
     
     
     
}
