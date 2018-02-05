package utility;

import org.testng.annotations.DataProvider;

public class DataProviderTest {

	@DataProvider(name="SearchProvider")
    public Object[][] getDataFromDataprovider(){
    return new Object[][] 
    	{
    	    {"", "","BlankInputs"},
            { "Test", "India" , "Invalidcredential"},
            { "test@hcp.com", "UK" ,"Unregisteredemailid"},
            { "testprofile0531@hcp.com", "Test1234","Valid credential" }
        };
	}
        @DataProvider(name="url")
        public Object[][] getDataFromDataprovider1(){
        return new Object[][] 
        	{
        	    {"", ""},
                { "Test", "India" },
                { "test@hcp.com", "UK" },
                { "testprofile0531@hcp.com", "Test1234" }
            };

}
}
