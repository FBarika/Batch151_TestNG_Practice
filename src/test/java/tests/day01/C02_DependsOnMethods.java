package tests.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;
import utilities.TestBase;

import java.time.Duration;

public class C02_DependsOnMethods extends TestBase {

    // test01 isimli bir test methodu olusturunuz. Ve amazona gidiniz
    // test02 isimli bir test methodu olusturunuz. Ve arama motoruna "Nutella" Yazıp aratın
    // test03 isimli bir test methodu olusturunuz. Ve sonuc yazısının "Nutella" icerdigini test edelim


    // test02 isimli test methodunu, test01'e baglayınız.
    // test03 isimli test methodunu, test02'ye baglayınız.

    WebDriver driver;
    @BeforeClass //TestNG de beforeclass methodunu static yapmaya gerek yok.
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--lang=en");
        driver= new ChromeDriver(opt);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @AfterClass
    public void afterClass() {
        driver.close();
    }

    @Test
    public void test01() {
        driver.get("https://amazon.com");
    }

    @Test(dependsOnMethods = "test01")
    public void test02() {
        WebElement aramaMotoru = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        aramaMotoru.sendKeys("Nutella", Keys.ENTER);
    }

    @Test(dependsOnMethods = "test02")
    public void test03() {

        WebElement aramaSonucu = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(aramaSonucu.getText().contains("Nutella"));
    }

    /*
    DependsOnMethod test methodlarinin calisma sirasina karismaz.(Bunu priority belirler.)
    Sadece bagli olan test baglandigi testin sonucuna bakar.
    Baglandigi test passed olmazsa baglanan test hic calismaz.

     */
}
