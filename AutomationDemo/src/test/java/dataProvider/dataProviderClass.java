package dataProvider;

import org.testng.annotations.DataProvider;

public class dataProviderClass {
	 @DataProvider(name="DataProvider")
	    public Object[][] getDataFromDataprovider(){
	    return new Object[][] 
	    	{
	            { "jtestingtest182@gmail.com", "J12345678!", "TESTING8" },
	            { "jtestingtest182@gmail.com", "X!", "TESTING8" },
	        };

	    }
}
