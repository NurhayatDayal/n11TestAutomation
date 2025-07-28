package base;

import data.Data;
import base.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class BaseTest extends BaseLibrary {

    public static WebDriver driver;

    @BeforeMethod
    public void OpenBrowser(Method method){
       // driver = new ChromeDriver();
        String browser = "chrome"; // default

        // Test metodunda @Browser varsa değerini al
        if (method.isAnnotationPresent(Browser.class)) {
            Browser browserAnnotation = method.getAnnotation(Browser.class);
            browser = browserAnnotation.value().toLowerCase();
        }

        switch (browser) {
            case "edge":
                System.setProperty("webdriver.edge.driver", "C:\\WebDriver\\msedgedriver.exe");
                driver = new EdgeDriver();
                break;
            case "chrome":
            default:
                driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.get(url);
    }

    @AfterMethod
    public void CloseBrowser(){
        driver.quit();
    }
}
