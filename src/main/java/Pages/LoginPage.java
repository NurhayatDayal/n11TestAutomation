package Pages;

import base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import java.util.List;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BaseTest {

    @Step("Email alanı doldurulur.")
    public LoginPage sendKeysEmail (String email){
        driver.findElement(By.id("email")).sendKeys(email);
        return this;
    }

    @Step("Parola alanı doldurulur.")
    public LoginPage sendKeysPassword (String password){
        driver.findElement(By.id("password")).sendKeys(password );
        return this;
    }

    @Step("Login butonuna tıklanır.")
    public LoginPage clickLoginButton (){
        driver.findElement(By.cssSelector("[class='btnPrimary']")).click();
        return this;
    }

    @Step("Şifremi Unuttum Butonuna Tıklanır.")
    public LoginPage clickSıfremıUnuttumButton(){
        driver.findElement(By.cssSelector("[class='forgotPassword']")).click();
        return this;
    }

    @Step("Hata Mesajı Alınır.")
    public String getErrorMessage(){
        String hataGirisText = driver.findElement(By.cssSelector("[class='error-message']")).getText();
        screenshot();
        return hataGirisText;
    }

    @Step("Hata Mesajları Alınır.")
    public List<String> getAllErrorText() {
        List<WebElement> hataElementleri = driver.findElements(By.cssSelector("[class='errorText']"));
        List<String> mesajlar = new ArrayList<>();
        for (WebElement hata : hataElementleri) {
            mesajlar.add(hata.getText());
        }
        screenshot();
        return mesajlar;
    }

    @Step("Text alanları temizlenir.")
    public LoginPage clearBox(String... texts) {
        for (String text : texts) {
            driver.findElement(By.id(text)).clear();
        }
        return this;
    }

    @Step("Maskeleme bilgisi alınır.")
    public String getMaskeInfo(){
        String hesapText = driver.findElement(By.id("password")).getAttribute("type");
        return hesapText;
    }

    @Step("Şifre Maskeleme İconuna Tıklanır.")
    public LoginPage clickMaskeButton(){
        driver.findElement(By.cssSelector("[class='toggle-password showInput']")).click();
        return this;
    }
    
}
