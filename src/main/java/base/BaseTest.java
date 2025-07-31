package base;

import data.Data;
import base.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class BaseTest extends BaseLibrary {



    @BeforeMethod
    @Step("Seçilen browserda sayfa açılır.")
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
                EdgeOptions options = new EdgeOptions();
                //options.addArguments("--window-size=1920,1080"); // Ekranı büyütür
// Headless moddaysa:
               // options.addArguments("--headless=new");
                driver = new EdgeDriver(options);

                //driver = new EdgeDriver();
                break;
            case "chrome":
            default:
                ChromeOptions options2 = new ChromeOptions();
               // options2.addArguments("--window-size=1920,1080"); // Ekranı büyütür
// Headless modda çalışıyorsan bunu da ekle:
               // options2.addArguments("--headless=new");
                driver = new ChromeDriver(options2);
                //driver = new ChromeDriver();
        }

        //driver.manage().window().setSize(new Dimension(1920, 1080));
        //2a7d83f8-effc-496f-ab9f-ed6840f0a847
       // driver.manage().window().maximize();
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().window().maximize();
        System.out.println("Window size: " + driver.manage().window().getSize());
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("document.querySelector('.cookie-banner').style.display='none';");
        driver.get(url);
    }
   /*public void OpenBrowser(Method method){
        String browser = "chrome"; // default

// Test metodunda @Browser varsa değerini al
        if (method.isAnnotationPresent(Browser.class)) {
            Browser browserAnnotation = method.getAnnotation(Browser.class);
            browser = browserAnnotation.value().toLowerCase();
        }

        switch (browser) {
            case "edge":
                System.setProperty("webdriver.edge.driver", "C:\\WebDriver\\msedgedriver.exe");

                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--headless=new");
                edgeOptions.addArguments("--disable-gpu");
                edgeOptions.addArguments("--window-size=1920,1080");

                driver = new EdgeDriver(edgeOptions);
                break;

            case "chrome":
            default:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless=new");
                chromeOptions.addArguments("--disable-gpu");
                chromeOptions.addArguments("--window-size=1920,1080");

                driver = new ChromeDriver(chromeOptions);
                break;
        }

// Eğer window-size headless'te işe yaramazsa, yine de setSize ile zorla ayarla:
        driver.manage().window().setSize(new Dimension(1920, 1080));
        sleep(15);
        System.out.println("Window size: " + driver.manage().window().getSize());

        driver.get(url);

    }*/

    @AfterMethod
    public void CloseBrowser(){
        driver.quit();
    }
}
