package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.AllPages;
import utilities.Driver;
import utilities.ExcelUtil;
import utilities.TestBase;

import java.io.IOException;

public class WriteExel extends TestBase {
    AllPages allPages = new AllPages();

    @Test
    public void question1NegativTest() throws IOException {
        String path = "./src/test/resources/UserInformation.xlsx";
        // Kullanıcı Cookies seçeneğini Accept All seçeneği ile kabul eder.
        allPages.exelPage.acceptCookiesButton.click();

        //Kullanıcı Proje içerisindeki EXCEL dosyasından
        // aldığı kullanıcı adı ve soyadını Full name TextBox’ına yazar.

        ExcelUtil excelUtil = new ExcelUtil(path, "user_names");
        allPages.exelPage.userFullName.sendKeys(excelUtil.getCellData(1,0));
         // Kullanıcı Proje içerisindeki EXCEL dosyasındaki GEÇERSİZ EMAİLLER Sheet’inden
        // aldığı kullanıcı email adresini Business Email TextBox’ına yazar.
        ExcelUtil excelUtil2 = new ExcelUtil(path, "invalid_emails");
        allPages.exelPage.userEmailLogin.sendKeys(excelUtil.getCellData(1,0));
        // Kullanıcı password textbox kutusuna tıklar.
        allPages.exelPage.userPassword.click();

        //INVALID olarak girilen MAIL adresini yarattığı hata mesajı “Invalid Email” validate(assert) edilir.
        Assert.assertEquals(allPages.exelPage.InvalidCharacter.getText(),"Invalid Characters");
    }

    @Test
    public void question2NegativTest() throws IOException {
        String path = "./src/test/resources/UserInformation.xlsx";
        // Kullanıcı Cookies seçeneğini Accept All seçeneği ile kabul eder.
        //allPages.exelPage.acceptCookiesButton.click();

        // Kullanıcı Proje içerisindeki EXCEL dosyasından aldığı
        // kullanıcı adı ve soyadını Full name TextBox’ına yazar.
        ExcelUtil excelUtil = new ExcelUtil(path, "user_names");
        allPages.exelPage.userFullName.sendKeys(excelUtil.getCellData(2,0));

        // Kullanıcı Proje içerisindeki EXCEL dosyasındaki GEÇERLİ EMAİLLER Sheet’inden
        // aldığı kullanıcı email adresini Business Email TextBox’ına yazar.
        ExcelUtil excelUtil2 = new ExcelUtil(path, "valid_emails");
        allPages.exelPage.userEmailLogin.sendKeys(excelUtil2.getCellData(1,0));

        // Kullanıcı password textbox kutusuna EXCEL dosyasındaki GEÇERSİZ PASSWORD
        // Sheetinden aldığı 6 karakterden kısa password’ü yazar.
        ExcelUtil excelUtil3 = new ExcelUtil(path, "invalid_passwords");
        allPages.exelPage.userPassword.sendKeys(excelUtil3.getCellData(1,0));

        //Kullanıcı SignmeIn butonuna tıklar.

        allPages.exelPage.signMeInButton.click();

        //allPages.exelPage.iAgreeCheckbox.click();

        //INVALID olarak girilen PASSWORD’ün  yarattığı
        // hata mesajı “At least 6 characters” validate(assert) edilir.

        Assert.assertEquals(allPages.exelPage.errorMsg6Character.getText(),"At least 6 characters");

    }
    @Test
    public void question3PositivTest() throws IOException {
        String path = "./src/test/resources/UserInformation.xlsx";
        // Kullanıcı Cookies seçeneğini Accept All seçeneği ile kabul eder.
        //allPages.exelPage.acceptCookiesButton.click();

        // Kullanıcı Proje içerisindeki EXCEL dosyasından aldığı
        // kullanıcı adı ve soyadını Full name TextBox’ına yazar.
        ExcelUtil excelUtil = new ExcelUtil(path, "user_names");
        allPages.exelPage.userFullName.sendKeys(excelUtil.getCellData(3,0));

        // Kullanıcı Proje içerisindeki EXCEL dosyasındaki GEÇERLİ EMAİLLER Sheet’inden
        // aldığı kullanıcı email adresini Business Email TextBox’ına yazar.
        ExcelUtil excelUtil2 = new ExcelUtil(path, "valid_emails");
        allPages.exelPage.userEmailLogin.sendKeys(excelUtil2.getCellData(2,0));

        // Kullanıcı password textbox kutusuna EXCEL dosyasındaki GEÇERSİZ PASSWORD
        // Sheetinden aldığı 6 karakterden kısa password’ü yazar.
        ExcelUtil excelUtil3 = new ExcelUtil(path, "valid_passwords");
        allPages.exelPage.userPassword.sendKeys(excelUtil3.getCellData(1,0));
        // Kullanıcı “I agrre…” Checkbox’ına tıklar.

        allPages.exelPage.iAgreeCheckbox.click();

        //Kullanıcı SignmeIn butonuna tıklar.

        allPages.exelPage.signMeInButton.click();

        //Başarılı bir şekilde kayıt yapıldığı Validate edilir.
        Assert.assertTrue(allPages.exelPage.textAfterSingIn.getText().contains("Quick question, for whom are you evaluating Live?"));












    }

}

