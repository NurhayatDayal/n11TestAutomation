package Pages;

import base.BaseTest;
import org.openqa.selenium.By;

public class MainPage extends BaseTest {

    public String getAccountInfo(){
        String hesapText = driver.findElement(By.cssSelector("[class='user']")).getAttribute("title");
        return hesapText;
    }
}
