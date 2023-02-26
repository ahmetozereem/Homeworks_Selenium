package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Question6Page;
import utilities.CommenSteps;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;

public class Question6Steps {
    Question6Page question6Page = new Question6Page();
    @Given("Kullanici ilgili sayfaya gider")
    public void kullaniciIlgiliSayfayaGider() {
        Driver.getDriver().get(ConfigReader.getProperty("url1"));
    }

    @When("Kullanici Cookies secenegini Accept All secenegi ile kabul eder")
    public void kullaniciCookiesSeceneginiAcceptAllSecenegiIleKabulEder() {
        CommenSteps.waitForVisibility(question6Page.acceptAllCookies, 5);
        question6Page.acceptAllCookies.click();
    }

    @And("Kullanici SearchBox kutusuna computer kelimesini yazar")
    public void kullaniciSearchBoxKutusunaComputerKelimesiniYazar() {

        question6Page.searchBox.sendKeys("computer");
    }

    @And("Kullanici arama butonuna basar")
    public void kullaniciAramaButonunaBasar() {
        question6Page.searchBox.sendKeys(Keys.ENTER);

    }

    @And("Kullanici filtre bolmesinden Windows on secenegine tiklar")
    public void kullaniciFiltreBolmesindenWindowsOnSecenegineTiklar() {
        question6Page.windows10.click();
    }

    @Then("Cikan seceneklerden en usteki urunun Windows on ozelligi oldugu dogrulanir")
    public void cikanSeceneklerdenEnUstekiUrununWindowsOnOzelligiOlduguDogrulanir() {
        Assert.assertTrue(question6Page.windows10Feature.getText().contains("Windows 10"));
    }
}
