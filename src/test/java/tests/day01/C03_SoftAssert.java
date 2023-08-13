package tests.day01;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;
//TestNG framework unda TestBase classini da kullanmak mümkün.

public class C03_SoftAssert extends TestBase {


    @Test
    public void test01() {
        // Test islemlerini softAssert ile yapınız ve hatalar icin mesaj versin
        // "https://amazon.com" sayfasına gidiniz
        driver.get("https://amazon.com");

        // Title'in "Amazon" icerdigini test edin
        SoftAssert softAssert = new SoftAssert();
        //softAssert instance oldugu icin ilk once obje olusturmamiz gerekiyor.
        // assert static oldugu icin daha önce obje olusturmamiza gerek yoktu.

        softAssert.assertTrue(driver.getTitle().contains("Amazon"),"Title Amazon Icermiyor");//softAssert ile problem olursa mesaj verebiliyoruz.

        // Arama kutusunun erisilebilir oldugunu test edin
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        softAssert.assertTrue(aramaKutusu.isEnabled(),"Arama Kutusuna Eriselemiyor.");//isEnabled() erisilebilir oldugunu test ediyoruz.

        // Arama kutusuna nutella yazıp aratın
        aramaKutusu.sendKeys("Nutella", Keys.ENTER);

        // Sonuc yazısının gorunur oldugunu test edin
        WebElement sonucYazisi = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        softAssert.assertTrue(sonucYazisi.isDisplayed(),"Sonuc Yazisi Görülemiyor.");//problem olursa bu yaziyi görecegiz.

        // Sonuc yazısının "Nutella" icerdigini test edin
        softAssert.assertTrue(sonucYazisi.getText().contains("Nutella"),"Sonuc yazisi Nutella icermiyor.");

        softAssert.assertAll();
        /*
        assertAll() yazip tüm hatalari listelemesini istemeliyiz aksi halde hata vermez
        */

        System.out.println("barika");

    }
}
//TestNG hem Assert ü hem de SoftAssert ü destekler.SoftAssert hatalari test classinin sonuna geldiginde hatalari toptan gösteriyordu.
//Assert ise ilk hata ile karsilastigi anda hemen failed veriyor.

        /*
        Junit'te Assert kullandıgımızda Assert faild oldugu anda test calısmayı durduruyordu.
        Ve geri kalanını calıstırmıyordu.

        TestNG'de hem Assert, hem softAssert yapıları var.
        Test sonuna kadar calıssın, testin sonunda tum hataları listelesin istiyorsak softAssert kullanırız.
        */

        /*
        softAssert'un hata bulsa bile calısmaya devam etme ozelligi softAssert.assertAll()'a kadardır.
        Eger softAssert.assertAll()'da hata bulunursa calısma durur.
        ve class'ın kalan kısmı calısmaz.

        System.out.println("barika"); mesela burda assertAll() hata olursa buradaki sout u yazdirmayacak.
         */

