package Pages;

import base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class MainPage extends BaseTest {

    @Step("Hesap Bilgisi Alınır.")
    public String getAccountInfo(){
        String hesapText = driver.findElement(By.cssSelector("[class='user']")).getAttribute("title");
        sleep(5);

        screenshot();
        return hesapText;
    }
}
