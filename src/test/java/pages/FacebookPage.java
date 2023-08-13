package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {

    public FacebookPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    //cookies i kabul edin
    @FindBy(xpath = "(//*[@type='submit'])[3]")
    public WebElement cookie;

    // kullanıcı email kutusuna rastgele bir isim yazın
    @FindBy(xpath = "//*[@class='inputtext _55r1 _6luy']")
    public WebElement emailKutusu;

    // kullanıcı sifre kutusuna rastgele bir password yazın
    @FindBy(xpath = "//*[@id='pass']")
    public WebElement sifreKutusu;

    // giris yap butonuna tıklayın
    @FindBy(xpath = "//*[@name='login']")
    public WebElement login;

    // Das bist du nicht?, gorunur oldugunu test edin
    @FindBy(xpath = "//*[@id='not_me_link']")
    public WebElement sifreHataliYazisi;



}
