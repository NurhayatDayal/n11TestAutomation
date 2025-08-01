package base;

import io.qameta.allure.Step;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends BaseLibrary {

    @BeforeMethod
    @Step("Seçilen browserda sayfa açılır.")
    public void OpenBrowser(){
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.get(url);
    }

   /* @AfterMethod
    public void CloseBrowser(){
        driver.quit();
    }*/
}
