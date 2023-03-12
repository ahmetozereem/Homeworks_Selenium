package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import pages.Homework3Page;
import utilities.CommenSteps;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;
import java.util.NoSuchElementException;

public class Homework3Steps {
    Homework3Page homework3Page = new Homework3Page();
    public String firstNummerOfOrder;
    public String secondNummerOfOrder;
    @Given("kullanici {string} web sayfasina gider")
    public void kullaniciWebSayfasinaGider(String url) {
        Driver.getDriver().get(url);
    }
    @When("kullanici cookiesi kabul eder")
    public void kullaniciCookiesiKabulEder() throws InterruptedException {
       Driver.wait(3);
        try{
            CommenSteps.waitForClickablility(homework3Page.acceptAllCookies, 10);
            homework3Page.acceptAllCookies.click();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    @And("kullanici Pricing linkine tiklar")
    public void kullaniciPricingLinkineTiklar() {
        homework3Page.pricingButton.click();
    }
    @And("kullanici BuyNow butonu ile sepete bir urun ekler")
    public void kullaniciBuyNowButonuIleSepeteBirUrunEkler() {
        homework3Page.buyNowButton.click();
    }
    @And("kullanici Pricing sayfasina geri doner")
    public void kullaniciPricingSayfasinaGeriDoner() {
        try{
            CommenSteps.waitForClickablility(homework3Page.acceptAllCookies, 10);
            homework3Page.acceptAllCookies.click();

        }catch (Exception e) {
            e.printStackTrace();
        }
        homework3Page.goToHomepage.click();
    }
    @And("kullanici Buynow butonu ile bir urun daha ekler")
    public void kullaniciBuynowButonuIleBirUrunDahaEkler() {
        homework3Page.pricingButton.click();
        homework3Page.buyNowButton1.click();
    }
    @And("kullanici ana sayfaya geri doner")
    public void kullaniciAnaSayfayaGeriDoner() {
        try {
            CommenSteps.waitForVisibility(homework3Page.newPage,10);
        }catch (Exception e) {e.printStackTrace();}
        homework3Page.goToHomepage.click();
    }
    @And("kullanici sepete uzerindeki mevcut sayiyi alir")
    public void kullaniciSepeteUzerindekiMevcutSayiyiAlir() {
        firstNummerOfOrder = homework3Page.verifyOfNummerOfItems.getText();
        System.out.println("firstNummerOfOrder = " + firstNummerOfOrder);
    }
    @And("kullanici sepete tekrar gider")
    public void kullaniciSepeteTekrarGider() {
        Driver.getDriver().navigate().to("https://store.progress.com/your-order");
    }
    @And("kullanici sepetteki urunlerden bir tanesini Delete linki ile siler")
    public void kullaniciSepettekiUrunlerdenBirTanesiniDeleteLinkiIleSiler() {
        homework3Page.deleteItem.click();
    }
    @Then("kullanici sepet simgesi uzerindeki sayinin bir eksildigini kontrol eder")
    public void kullaniciSepetSimgesiUzerindekiSayininBirEksildiginiKontrolEder() {
        homework3Page.goToHomepage.click();
        secondNummerOfOrder = homework3Page.verifyOfNummerOfItems.getText();
        System.out.println("secondNummerOfOrder = " + secondNummerOfOrder);
        Assert.assertEquals(Integer.parseInt(firstNummerOfOrder)-1,Integer.parseInt(secondNummerOfOrder));
    }
}
