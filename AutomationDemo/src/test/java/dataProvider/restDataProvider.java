package dataProvider;

import org.testng.annotations.DataProvider;

public class restDataProvider {
    @DataProvider(name = "DataProvider")
    public Object[][] restDataProvider() {
        return new Object[][]
                {
                        {"Joaquin", "QA"},
                        {"Emma", "Dev"},
                        {"Eve", "HR"},
                        {"Charles", "DBA"},
                        {"Tracey", "SM"},
                };

    }
}
