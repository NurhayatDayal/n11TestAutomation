package Pages;

import base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class SifremiUnuttumPage extends BaseTest {

    @Step("Devam Et butonuna tıklanır.")
    public SifremiUnuttumPage clickDevamEtButton (){
        driver.findElement(By.cssSelector("[class='btnPrimary forgot-password-button']")).click();
        return this;
    }

    @Step("Email alanı doldurulur.")
    public SifremiUnuttumPage sendKeysEmail (String email){
        driver.findElement(By.id("forgottenUserEmail")).sendKeys(email);
        return this;
    }

    @Step("Mail alanı doldurulur.")
    public String getMailInfo(){
        String hesapText = driver.findElement(By.cssSelector("[class='info-content-title']")).getText();
        return hesapText;
    }
}
