package solvd.withoutParameters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;

public class NoParameterWithTestNGXML {
    String driverPath = "C:\\webdrivers\\chromedriver.exe";
    WebDriver driver;

    @Test
    public void testNoParameter() throws InterruptedException {
        String author = "guru99";
        String searchKey = "india";

        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://google.com");
        WebElement searchText = driver.findElement(By.name("q"));
        searchText.sendKeys(searchKey);

        System.out.println("Welcome ->" + author +  " Your search key is -> " + searchKey);
        System.out.println("Thread will sleep now");

        Thread.sleep(3000);
        System.out.println("Value in Google Search Box = " +
                searchText.getAttribute("value") +
                " ::: Value given by input = " + searchKey);

        AssertJUnit.assertTrue(searchText.getAttribute("value").equalsIgnoreCase(searchKey));
    }
}
