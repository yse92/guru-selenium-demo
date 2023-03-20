package solvd.contextDataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ParameterByITestContextInDataProvider {
    WebDriver driver;
    String driverPath = "C:\\webdrivers\\chromedriver.exe";


    @BeforeTest(groups = {"A", "B"})
    public void setup() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://google.com");
    }
    @Test(dataProvider="SearchProvider",groups="A")
    public void testMethodA(String author, String searchKey) throws InterruptedException {
        {
            //search google text box
            WebElement searchText = driver.findElement(By.name("q"));
            //search a value on it
            searchText.sendKeys(searchKey);
            System.out.println("Welcome ->" + author + " Your search key is->" + searchKey);
            Thread.sleep(3000);
            String testValue = searchText.getAttribute("value");
            System.out.println(testValue + "::::" + searchKey);
            searchText.clear();
            //verify correct value in search box
            Assert.assertTrue(testValue.equalsIgnoreCase(searchKey));
        }
    }

    @Test(dataProvider="SearchProvider",groups="B")
    public void testMethodB(String searchKey) throws InterruptedException {
        {
            //find google search box
            WebElement searchText = driver.findElement(By.name("q"));
            //search a value on it
            searchText.sendKeys(searchKey);
            System.out.println("Welcome ->Unknown user Your search key is->"+searchKey);
            Thread.sleep(3000);
            String testValue = searchText.getAttribute("value");
            System.out.println(testValue +"::::"+searchKey);
            searchText.clear();
            //verify correct value in search box
            Assert.assertTrue(testValue.equalsIgnoreCase(searchKey));
        }
    }

    /**
     * Here the DAtaProvider will provide Object array on the basis on ITestContext
     * @param c
     * @return
     */
    @DataProvider(name="SearchProvider")
    public Object[][] getDataFromDataProvider(ITestContext c) {
        Object[][] groupArray = null;
        for (String group : c.getIncludedGroups()) {
            if(group.equalsIgnoreCase("A")){
                groupArray = new Object[][] {
                        { "Guru99", "India" },
                        { "Krishna", "UK" },
                        { "Bhupesh", "USA" }
                };
                break;
            }
            else if(group.equalsIgnoreCase("B"))
            {
                groupArray = new Object[][] {
                        {  "Canada" },
                        {  "Romania" },
                        {  "Japan" }
                };
            }
            break;
        }
        return groupArray;
    }
}
