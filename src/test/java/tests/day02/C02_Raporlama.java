package tests.day02;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C02_Raporlama extends TestBaseRapor {

    @Test
    public void test01() {
        extentTest=extentReports.createTest("Batch151","Amazonu test edebilmeli");
        //extentTest e testname ve description degerlerini atamaliyiz.

        // 'https://www.amazon.com' adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("AMAZON SAYFASINA GIDILDI");

        // arama kutusuna "Java" yazip aratın
        AmazonPage amazonPage= new AmazonPage();
        amazonPage.aramaKutusu.sendKeys("Java", Keys.ENTER);
        extentTest.info("ARAMA KUTUSUNA JAVA YAZIP; ARATILDI.");

        // sonuc yazisinin "Java" icerdigini test edin
        Assert.assertTrue(amazonPage.sonucYazisi.getText().contains("Mava"));
        extentTest.pass("SONUC YAZISININ JAVA ICERDIGI TEST EDILDI.");

        // kontrollu olarak yeni bir sayfa acın
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        extentTest.info("KONTROLLU YENI SAYFA ACILDI.");

        // yeni acılan sayfada "Kitap" aratın
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        amazonPage.aramaKutusu.sendKeys("Kitap",Keys.ENTER);
        extentTest.info("YENI ACILAN SAYFADA KITAP ARATILDI.");

        // sonuc yazisinin Kitap icerdigini test edin
        Assert.assertTrue(amazonPage.sonucYazisi.getText().contains("Kitap"));
        extentTest.pass("SONUC YAZISININ KITAP ICERDIGI TEST EDILDI.");

        // sayfayı kapatınız
        Driver.closeDriver();
        extentTest.info("SAYFA KAPATILDI.");




    }
}
