import Pages.LoginPage;
import Pages.MainPage;
import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import java.util.List;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();

    @Test
    public void BasariliGiris() {
        loginPage.sendKeysEmail(email)
                .sendKeysPassword(password)
                .clickLoginButton();
        sleep(3);
        assertEquals(mainPage.getAccountInfo(), "Hesabım");
    }

    @Test
    public void BasarisizGiris() {
        loginPage.sendKeysEmail(email)
                .sendKeysPassword("kalem25")
                .clickLoginButton();
        sleep(3);
        assertEquals(loginPage.getErrorMessage(), "E-posta adresi veya şifre hatalı, kontrol edebilir misin?");
    }

    @Test
    public void BosKarakterKontrolu() {
        loginPage.clickLoginButton();
        List<String> hatalar = loginPage.getAllErrorText();
        Assert.assertEquals(hatalar.get(0), "Geçerli bir e-posta adresi girmelisin.");
        Assert.assertEquals(hatalar.get(1), "Şifreni girebilir misin?");
        /*String eksikGirisText = driver.findElements(By.cssSelector("[class='errorText']")).get(0).getText();
        Assert.assertEquals(eksikGirisText, "Geçerli bir e-posta adresi girmelisin.");
        String eksikGirisText2 = driver.findElements(By.cssSelector("[class='errorText']")).get(1).getText();
        Assert.assertEquals(eksikGirisText2, "Şifreni girebilir misin?");*/
        loginPage.sendKeysEmail(email)
                .clickLoginButton();
        //driver.findElement(By.cssSelector("[class='btnPrimary']")).click();
        //String eksikGirisText1 = driver.findElements(By.cssSelector("[class='errorText']")).get(1).getText();
        //Assert.assertEquals(eksikGirisText1, "Şifreni girebilir misin?");
        Assert.assertEquals(hatalar.get(1), "Şifreni girebilir misin?");
        sleep(2);
        loginPage.sendKeysPassword(password)
                .clickLoginButton();
        //driver.findElement(By.id("password")).sendKeys(password);
        //driver.findElement(By.cssSelector("[class='btnPrimary']")).click();
        sleep(3);
        assertEquals(mainPage.getAccountInfo(), "Hesabım");
    }

    @Test
    public void MinKarakterKontrolu() {
        loginPage.sendKeysEmail("n").sendKeysPassword("k").clickLoginButton();
        //driver.findElement(By.id("email")).sendKeys("n");
        //driver.findElement(By.id("password")).sendKeys("k");
        //driver.findElement(By.cssSelector("[class='btnPrimary']")).click();
        List<String> hatalar = loginPage.getAllErrorText();
        Assert.assertEquals(hatalar.get(0), "Geçerli bir e-posta adresi girmelisin.");
        Assert.assertEquals(hatalar.get(1), "Girilen değer en az 6 karakter olmalıdır.");
        //String azGirisText = driver.findElements(By.cssSelector("[class='errorText']")).get(0).getText();
        //Assert.assertEquals(azGirisText, "Geçerli bir e-posta adresi girmelisin.");
        //String azGirisText2 = driver.findElements(By.cssSelector("[class='errorText']")).get(1).getText();
        //Assert.assertEquals(azGirisText2, "Girilen değer en az 6 karakter olmalıdır.");
        loginPage.clearBox("email")
                .clearBox("password");
        //driver.findElement(By.id("password")).clear();
        loginPage.sendKeysEmail(email)
                .sendKeysPassword(password)
                .clickLoginButton();
        //driver.findElement(By.id("email")).sendKeys(email);
        //driver.findElement(By.id("password")).sendKeys(password);
        //driver.findElement(By.cssSelector("[class='btnPrimary']")).click();
        sleep(3);
        assertEquals(mainPage.getAccountInfo(), "Hesabım");
    }
}
