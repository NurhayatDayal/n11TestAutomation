import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
//Kalem25
    @Test
    public void BasariliGiris () throws InterruptedException {
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(sifre);
        driver.findElement(By.cssSelector("[class='btnPrimary']")).click();
        Thread.sleep(3000);
        String hesapText = driver.findElement(By.cssSelector("[class='user']")).getAttribute("title");
        Assert.assertEquals(hesapText,"Hesabım");
    }

    @Test
    public void BasarisizGiris () throws InterruptedException {
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys("kalem25");
        driver.findElement(By.cssSelector("[class='btnPrimary']")).click();
        Thread.sleep(3000);
        String hataGirisText = driver.findElement(By.cssSelector("[class='error-message']")).getText();
        Assert.assertEquals(hataGirisText,"E-posta adresi veya şifre hatalı, kontrol edebilir misin?");
    }

    @Test
    public void BosKarakterKontrolu () throws InterruptedException {
        driver.findElement(By.cssSelector("[class='btnPrimary']")).click();
        String eksikGirisText = driver.findElements(By.cssSelector("[class='errorText']")).get(0).getText();
        Assert.assertEquals(eksikGirisText,"Geçerli bir e-posta adresi girmelisin.");
        String eksikGirisText2 = driver.findElements(By.cssSelector("[class='errorText']")).get(1).getText();
        Assert.assertEquals(eksikGirisText2,"Şifreni girebilir misin?");
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.cssSelector("[class='btnPrimary']")).click();
        String eksikGirisText1 = driver.findElements(By.cssSelector("[class='errorText']")).get(1).getText();
        Assert.assertEquals(eksikGirisText1,"Şifreni girebilir misin?");
        Thread.sleep(2000);
        driver.findElement(By.id("password")).sendKeys(sifre);
        driver.findElement(By.cssSelector("[class='btnPrimary']")).click();
        Thread.sleep(3000);
        String hesapText = driver.findElement(By.cssSelector("[class='user']")).getAttribute("title");
        Assert.assertEquals(hesapText,"Hesabım");
    }

    @Test
    public void MinKarakterKontrolu () throws InterruptedException {
        driver.findElement(By.id("email")).sendKeys("n");
        driver.findElement(By.id("password")).sendKeys("k");
        driver.findElement(By.cssSelector("[class='btnPrimary']")).click();
        String azGirisText = driver.findElements(By.cssSelector("[class='errorText']")).get(0).getText();
        Assert.assertEquals(azGirisText,"Geçerli bir e-posta adresi girmelisin.");
        String azGirisText2 = driver.findElements(By.cssSelector("[class='errorText']")).get(1).getText();
        Assert.assertEquals(azGirisText2,"Girilen değer en az 6 karakter olmalıdır.");
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(sifre);
        driver.findElement(By.cssSelector("[class='btnPrimary']")).click();
        Thread.sleep(3000);
        String hesapText = driver.findElement(By.cssSelector("[class='user']")).getAttribute("title");
        System.out.println(hesapText);
        Assert.assertEquals(hesapText,"Hesabım");
    }
}
