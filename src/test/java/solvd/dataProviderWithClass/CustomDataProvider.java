package solvd.dataProviderWithClass;

import org.testng.annotations.DataProvider;

public class CustomDataProvider {
    @DataProvider(name = "SearchProvider")
    public static Object[][] getDataFromDataProvider() {
        return new Object[][]{
                {"Guru99", "India"},
                {"Krishna", "UK"},
                {"Bhupesh", "USA"}
        };
    }
}
