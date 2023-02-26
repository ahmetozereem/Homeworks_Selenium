package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.Question6Page;
import pages.Question7Page;
import utilities.CommenSteps;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReUsableMethods;

public class Question7Steps {
    Question7Page question7Page = new Question7Page();
    ReUsableMethods reUsableMethods = new ReUsableMethods();
    CommenSteps commenSteps = new CommenSteps();
    @Given("Kullainci ilgili sayfaya gitmelidir")
    public void kullainciIlgiliSayfayaGitmelidir() {
        Driver.getDriver().get(ConfigReader.getProperty("url2"));
    }

    @When("Kullanici Cookies leri kabul etmek icin AcceptAll ve close a tiklar")
    public void kullaniciCookiesLeriKabulEtmekIcinAcceptAllVeCloseATiklar() {
        question7Page.acceptAndCloseButton.click();
    }

    @And("Kullainci  ust menu bardan arama simgesine tiklar")
    public void kullainciUstMenuBardanAramaSimgesineTiklar() {
    question7Page.searchButton.click();
    }

    @And("Kullanici  search box kutusuna {string} yazar")
    public void kullaniciSearchBoxKutusunaYazar(String arg0) {
        question7Page.searchArea.sendKeys(arg0);

    }

    @And("Kullanici arama butonuna tiklar")
    public void kullaniciAramaButonunaTiklar() throws InterruptedException {
    question7Page.searchAreaButton.click();

    }

    @Then("Arama sonucu cikan ilk secenegin {string} kelimeleri barindirdigi Assert edilir.")
    public void aramaSonucuCikanIlkSeceneginKelimeleriBarindirdigiAssertEdilir(String arg0) {
        CommenSteps.waitForVisibility(question7Page.results, 5);
        Assert.assertTrue(question7Page.results.getText().contains(arg0));
    }
}
