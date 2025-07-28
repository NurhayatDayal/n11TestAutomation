package Pages;

import base.BaseTest;
import org.openqa.selenium.By;
import java.util.List;
import java.util.ArrayList;
import org.openqa.selenium.WebElement;

public class LoginPage extends BaseTest {

    public LoginPage sendKeysEmail (String email){
        driver.findElement(By.id("email")).sendKeys(email);
        return this;
    }

    public LoginPage sendKeysPassword (String password){
        driver.findElement(By.id("password")).sendKeys(password );
        return this;
    }

    public LoginPage clickLoginButton (){
        driver.findElement(By.cssSelector("[class='btnPrimary']")).click();
        return this;
    }

    public LoginPage clickSıfremıUnuttumButton(){
        driver.findElement(By.cssSelector("[class='forgotPassword']")).click();
        return this;
    }

    public String getErrorMessage(){
        String hataGirisText = driver.findElement(By.cssSelector("[class='error-message']")).getText();
        return hataGirisText;
    }

    public List<String> getAllErrorText() {
        List<WebElement> hataElementleri = driver.findElements(By.cssSelector("[class='errorText']"));
        List<String> mesajlar = new ArrayList<>();
        for (WebElement hata : hataElementleri) {
            mesajlar.add(hata.getText());
        }
        return mesajlar;
    }

    public LoginPage clearBox(String... texts) {
        for (String text : texts) {
            driver.findElement(By.id(text)).clear();
        }
        return this;
    }

    public String getMaskeInfo(){
        String hesapText = driver.findElement(By.id("password")).getAttribute("type");
        return hesapText;
    }

    public LoginPage clickMaskeButton(){
        driver.findElement(By.cssSelector("[class='toggle-password showInput']")).click();
        return this;
    }
}
