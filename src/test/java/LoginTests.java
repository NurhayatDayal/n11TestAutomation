import Pages.LoginPage;
import Pages.MainPage;
import Pages.SifremiUnuttumPage;
import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.List;
import org.testng.annotations.Test;


public class LoginTests extends BaseTest {

    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();
    SifremiUnuttumPage sifremiUnuttumPage = new SifremiUnuttumPage();

    @Test (description = "TC001 - Başarılı Kullanıcı Girişi")
    public void BasariliGiris() {
        //((JavascriptExecutor) driver).executeScript("let e=document.querySelector('efilli-layout-dynamic'); if(e) e.style.display='none';");

        loginPage.sendKeysEmail(email)
                .sendKeysPassword(password).
                rollDown().
                clickLoginButton();
        sleep(3);
        assertEquals(mainPage.getAccountInfo(), "Hesabım");
    }

    @Test (description = "TC002 - Hatalı Kullanıcı Girişi")
    public void BasarisizGiris() {
        loginPage.sendKeysEmail(email)
                .sendKeysPassword("kalem25")
                .rollDown()
                .clickLoginButton();
        sleep(3);
        assertEquals(loginPage.getErrorMessage(), "E-posta adresi veya şifre hatalı, kontrol edebilir misin?");
    }

    @Test (description = "TC003 - Boş Karakter Kontrolü")
    public void BosKarakterKontrolu() {
        loginPage.rollDown()
                .clickLoginButton();
        List<String> hatalar = loginPage.getAllErrorText();
        assertEquals(hatalar.get(0), "Geçerli bir e-posta adresi girmelisin.");
        assertEquals(hatalar.get(1), "Şifreni girebilir misin?");
        /*String eksikGirisText = driver.findElements(By.cssSelector("[class='errorText']")).get(0).getText();
        Assert.assertEquals(eksikGirisText, "Geçerli bir e-posta adresi girmelisin.");
        String eksikGirisText2 = driver.findElements(By.cssSelector("[class='errorText']")).get(1).getText();
        Assert.assertEquals(eksikGirisText2, "Şifreni girebilir misin?");*/
        loginPage.sendKeysEmail(email)
                .rollDown()
                .clickLoginButton();
        //driver.findElement(By.cssSelector("[class='btnPrimary']")).click();
        //String eksikGirisText1 = driver.findElements(By.cssSelector("[class='errorText']")).get(1).getText();
        //Assert.assertEquals(eksikGirisText1, "Şifreni girebilir misin?");
        Assert.assertEquals(hatalar.get(1), "Şifreni girebilir misin?");
        sleep(2);
        loginPage.sendKeysPassword(password)
                .rollDown()
                .clickLoginButton();
        //driver.findElement(By.id("password")).sendKeys(password);
        //driver.findElement(By.cssSelector("[class='btnPrimary']")).click();
        sleep(3);
        assertEquals(mainPage.getAccountInfo(), "Hesabım");
    }

    @Test (description = "TC004 - Minimum Karakter Kontrolü")
    public void MinKarakterKontrolu() {
        loginPage.sendKeysEmail("n")
                .sendKeysPassword("k")
                .rollDown()
                .clickLoginButton();
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
                .rollDown()
                .clickLoginButton();
        //driver.findElement(By.id("email")).sendKeys(email);
        //driver.findElement(By.id("password")).sendKeys(password);
        //driver.findElement(By.cssSelector("[class='btnPrimary']")).click();
        sleep(3);
        assertEquals(mainPage.getAccountInfo(), "Hesabım");
    }

    @Test (description = "TC005 - Email Validation Kontrolü")
    public void EmailValidationKontrolu(){
        loginPage.sendKeysEmail("nurhayatdayal")
                .sendKeysPassword(password);
        List<String> hatalar = loginPage.getAllErrorText();
        assertEquals(hatalar.get(0),"Geçerli bir e-posta adresi girmelisin.");
    }

    @Test (description = "TC006 - Şifremi Unuttum Kontrolü")
    public void SıfremıUnuttumKontrolu(){
        loginPage.rollDown()
                .clickSıfremıUnuttumButton();
        sleep(3);
        assertEquals(driver.getCurrentUrl(), "https://www.n11.com/sifremiunuttum/mailgonder");
        sifremiUnuttumPage.sendKeysEmail(email);
        loginPage.rollDown();
        sifremiUnuttumPage.clickDevamEtButton();
        sleep(3);
        assertEquals(sifremiUnuttumPage.getMailInfo(),"E-postanı gönderdik!");
    }

    @Test (description = "TC007 - Şifre Maskeleme Kontrolü")
    public void SıfreMaskeleemKontrolu(){
        loginPage.sendKeysEmail(email)
                .sendKeysPassword(password);
        assertEquals(loginPage.getMaskeInfo(),"password");
        loginPage.clickMaskeButton();
        assertEquals(loginPage.getMaskeInfo(),"text");
    }

}
