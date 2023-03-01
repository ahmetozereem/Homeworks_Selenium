package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.Homework2Page;
import utilities.CommenSteps;
import utilities.ConfigReader;
import utilities.Driver;

public class Homework2Steps {
    Homework2Page homework2Page = new Homework2Page();
    @Given("Kullanici ana sayfaya gider")
    public void kullaniciAnaSayfayaGider() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }
    @When("Kullanici Cookies ile ilgili onayi kabul eder")
    public void kullaniciCookiesIleIlgiliOnayiKabulEder() {
        try{
            CommenSteps.waitForClickablility(homework2Page.acceptAllCookies, 10);
            homework2Page.acceptAllCookies.click();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    @And("Kullanici ust menu bardan Pricing linkine tiklar")
    public void kullaniciUstMenuBardanPricingLinkineTiklar() {
        homework2Page.pricingButton.click();
    }
    @And("Kullanici bir paketi buy now butonu ile sepete ekler")
    public void kullaniciBirPaketiBuyNowButonuIleSepeteEkler() {
        homework2Page.buyNowButton.click();
    }
    @And("Kullanici ana sayfaya tekrar geri gider")
    public void kullaniciAnaSayfayaTekrarGeriGider() {
        try {
            CommenSteps.waitForVisibility(homework2Page.newPage,10);
        }catch (Exception e) {e.printStackTrace();}
        Driver.getDriver().navigate().back();
    }
    @Then("Kullanici sepet simgesi uzerindeki rakami dogrular")
    public void kullaniciSepetSimgesiUzerindekiRakamiDogrular() {
        String expectedValue ="1";
        String actualValue = homework2Page.verifyOfNummerOfItems.getText();
        System.out.println("expectedValue = " + expectedValue);
        System.out.println("actualValue = " + actualValue);
        Assert.assertTrue(actualValue.equals(expectedValue));
    }
}
