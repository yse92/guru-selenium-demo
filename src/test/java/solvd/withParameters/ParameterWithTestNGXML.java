package solvd.withParameters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ParameterWithTestNGXML {
    String driverPath = "C:\\webdrivers\\chromedriver.exe";
    WebDriver driver;

    @Test
    @Parameters({"author", "searchKey"})
    public void testParameterWithXML(@Optional("Abc") String author, String searchKey) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://google.com");
        WebElement searchText = driver.findElement(By.name("q"));

        searchText.sendKeys(searchKey);
        System.out.println("Welcome -> " + author + " Your search key is -" + searchKey);

        System.out.println("Thread will sleep now");
        Thread.sleep(3000);

        System.out.println("Value in Google Search Box = " +
                searchText.getAttribute("value") + " ::: Value given by input = " + searchKey);
        AssertJUnit.assertTrue(searchText.getAttribute("value").equalsIgnoreCase(searchKey));

    }
}
