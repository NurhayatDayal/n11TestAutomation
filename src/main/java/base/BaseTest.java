package base;

import data.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends BaseLibrary {

    public static WebDriver driver;

    @BeforeMethod
    public void OpenBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @AfterMethod
    public void CloseBrowser(){
        driver.quit();
    }
}
