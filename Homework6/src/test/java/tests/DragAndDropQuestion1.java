package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.AllPages;
import utilities.Driver;
import utilities.TestBase;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import static utilities.Driver.driver;

public class DragAndDropQuestion1 extends TestBase {

    AllPages allPages = new AllPages();

    @Test
    public void dragAndDropTest() {
        Driver.getDriver().switchTo().frame("gdpr-consent-notice");
        allPages.dragAndDropPages.iFrameAcceptAll.click();
        // Kullanıcı BANK objesini Debit Side Sol Account kutusuna taşıyarak yerleştirir.
        actions.dragAndDrop(allPages.dragAndDropPages.bankButton,
                allPages.dragAndDropPages.placeFolderDebitSideAccount).build().perform();

        // Kullanıcı SALES objesini Credit Side Sol Account kutusuna taşıyarak yerleştirir
        actions.dragAndDrop(allPages.dragAndDropPages.sales,
                allPages.dragAndDropPages.placeFoldeCreditSideAccount).build().perform();

        // Kullanıcı 5000 objesini Debit Side Sağ Amount kutusuna taşıyarak yerleştirir.
        actions.dragAndDrop(allPages.dragAndDropPages.fiveHundertButton,
                allPages.dragAndDropPages.placeFolderDebitSideAmount).build().perform();

        // Kullanıcı 5000 objesini Credit Side Sağ Amount kutusuna taşıyarak yerleştirir
        actions.dragAndDrop(allPages.dragAndDropPages.fiveHundertButton,
                allPages.dragAndDropPages.placeFolderCreditSideAmount).build().perform();

        // Aşağıda çıkan Ek Tablo içerisinden 5000 objeleri SoftAssert ile Valide edilir.

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(allPages.dragAndDropPages.debitMovementAmount.getText().contains("5000"));
        softAssert.assertTrue(allPages.dragAndDropPages.creditMovementAmount.getText().contains("5000"));
        softAssert.assertAll();

        // Doğru yerleştirme sonucu tablo altında ortaya çıkan Perfect yazısı Hard Assert ile teyit edilir
        String text =allPages.dragAndDropPages.table.getText();
        System.out.println("text = " + text);
        Assert.assertEquals(allPages.dragAndDropPages.table.getText(), "Perfect!");
    }

    @Test
    public void iFrameList () {
        // Sayfadaki iframe ler listeye alınır:
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));

        // İçerik sayısı ve iframe sayısı hakkında bilgi yazdırılır:
        System.out.println("Bu sayfada " + iframes.size() + " adet iframe var.");

        // Her bir iframe için id veya name özniteliklerini yazdırın
        for (WebElement iframe : iframes) {
            String id = iframe.getAttribute("id");
            String name = iframe.getAttribute("name");
            System.out.println("Iframe id: " + id + ", name: " + name);
        }
        // Sayfadaki cookies ler listeye alınır

        Set<Cookie> cookies = Driver.getDriver().manage().getCookies();
        System.out.println("Bu sayfada " + cookies.size() + " adet cookies var.");

        WebElement targetIframe = null;
        for (WebElement iframe : iframes) {
            Driver.getDriver().switchTo().frame(iframe);
            try {
                WebElement acceptCookiesButton = Driver.getDriver().findElement(By.id("#save"));
                targetIframe = iframe;
                break;
            } catch (NoSuchElementException e) {
                // "accept-cookies" ID'siyle bir element bulunamazsa, iframe'in çerezleri kabul etmesi gerekmez.
            }
            Driver.getDriver().switchTo().defaultContent();
        }
    }
}
