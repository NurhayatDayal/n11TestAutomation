package Pages;

import base.BaseTest;
import org.openqa.selenium.By;

public class SıfremıUnuttumPage extends BaseTest {

    public SıfremıUnuttumPage clickDevamEtButton (){
        driver.findElement(By.cssSelector("[class='btnPrimary forgot-password-button']")).click();
        return this;
    }

    public SıfremıUnuttumPage sendKeysEmail (String email){
        driver.findElement(By.id("forgottenUserEmail")).sendKeys(email);
        return this;
    }
    public String getMailInfo(){
        String hesapText = driver.findElement(By.cssSelector("[class='info-content-title']")).getText();
        return hesapText;
    }
}
