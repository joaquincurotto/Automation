package dataProvider;

import org.testng.annotations.DataProvider;

public class dataProviderClass {
	 @DataProvider(name="DataProvider")
	    public Object[][] getDataFromDataprovider(){
	    return new Object[][] 
	    	{
	            { "Globant1", "A"},

	        };

	    }
}
