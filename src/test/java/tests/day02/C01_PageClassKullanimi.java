package tests.day02;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class C01_PageClassKullanimi {

    @Test
    public void test01() throws IOException {

        // amazon sayfasına gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        AmazonPage amazonPage = new AmazonPage();

        // dropdown'dan "Computers" optionunu secin
        Select select = new Select(amazonPage.ddm);
        select.selectByVisibleText("Computers");

        // arama motoruna "Asus" yazıp aratın
        amazonPage.aramaKutusu.sendKeys("Asus",Keys.ENTER);

        // ikinci urunun fotografını cekin

        //1.Yol
        //LocalDateTime date = LocalDateTime.now();
        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYMMddHHmmss");
        //String tarih = date.format(dtf);
        // File kayit = new File("target/ekranGoruntusu/kayit"+tarih+".Jpeg");
        // File gecici = amazonPage.ikinciUrun.getScreenshotAs(OutputType.FILE);
        //FileUtils.copyFile(gecici,kayit);

        //2.Yol
        String tarih = new SimpleDateFormat("_ddMMyyyy_hh_mm_ss").format(new Date());
        String dosyaYolu = "target/screenShot/ikinciUrun" + tarih+ ".jpg" ;
        FileUtils.copyFile(amazonPage.ikinciUrun.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));


        // ikinci urune tıklayın
        amazonPage.ikinciUrun.click();

        // title'ının "ASUS" icerdigini test edin
        Assert.assertTrue(Driver.getDriver().getTitle().contains("ASUS"));

        // sayfayı kapatın
        Driver.closeDriver();

    }
}
