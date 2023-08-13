package tests.day01;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_PageClassKullanimi {


    @Test
    public void test01() {
        // facebook anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));
        FacebookPage facebookPage = new FacebookPage();
        facebookPage.cookie.click();
        // kullanıcı email kutusuna rastgele bir isim yazın
        facebookPage.emailKutusu.sendKeys("barika");
        // kullanıcı sifre kutusuna rastgele bir password yazın
        facebookPage.sifreKutusu.sendKeys("12345");

        // giris yap butonuna tıklayın
        facebookPage.login.click();

        // Das bist du nicht? gorunur oldugunu test edin
        Assert.assertTrue(facebookPage.sifreHataliYazisi.isDisplayed());

        // sayfayı kapatın
        Driver.closeDriver();

    }
}
