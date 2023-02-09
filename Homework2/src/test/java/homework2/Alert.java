package homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import com.github.javafaker.Faker;

public class Alert {


    @BeforeMethod
    public void testBefore(){
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }

    @Test
    public void AssertFalseTest () {

        // Sign in yazılı alana tıklanır

        WebElement singInButton = Driver.getDriver().findElement(By.xpath("/html/body/header/div[2]/div/nav/ul/li/a"));
        singInButton.click();

        // Create a new account a tıklanır

        WebElement createNewAccount = Driver.getDriver().findElement(By.partialLinkText("Create a new account"));
        createNewAccount.click();

        // Firs name sekmesine isim gönderilir

        WebElement firstName= Driver.getDriver().findElement(By.id("user[first_name]"));
        firstName.sendKeys(ConfigReader.getProperty("userFirstName"));

        // Last name sekmesine soy isim gönderilir
        WebElement lastName= Driver.getDriver().findElement(By.id("user[last_name]"));
        lastName.sendKeys(ConfigReader.getProperty("userLastName"));

        // email yazılır
        WebElement email= Driver.getDriver().findElement(By.id("user[email]"));
        email.sendKeys(ConfigReader.getProperty("eMail"));

        // Passwort yazılır
        WebElement password= Driver.getDriver().findElement(By.id("user[password]"));
        password.sendKeys(ConfigReader.getProperty("password"));
        //Faker faker= new Faker();
        //String fakePassword= faker.internet().password();
        //password.sendKeys(fakePassword);
        //System.out.println(fakePassword);

        //Sign up a tıklanır

        WebElement signUp = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        signUp.click();

        //Checkbox secilmedi dogrulama testi
        WebElement checkBox= Driver.getDriver().findElement(By.id("user[terms]"));
        Assert.assertFalse(checkBox.isSelected());



    }

    @Test
    public void assertTrueAndEqualTest () { // AssertTrue veya Equal ile pozitif test yazımı:
        // Sign in yazılı alana tıklanır

        WebElement singInButton = Driver.getDriver().findElement(By.xpath("/html/body/header/div[2]/div/nav/ul/li/a"));
        singInButton.click();

        // Create a new account a tıklanır

        WebElement createNewAccount = Driver.getDriver().findElement(By.partialLinkText("Create a new account"));
        createNewAccount.click();

        // Firs name sekmesine isim gönderilir

        WebElement firstName= Driver.getDriver().findElement(By.id("user[first_name]"));
        firstName.sendKeys(ConfigReader.getProperty("userFirstName"));

        // Last name sekmesine soy isim gönderilir
        WebElement lastName= Driver.getDriver().findElement(By.id("user[last_name]"));
        lastName.sendKeys(ConfigReader.getProperty("userLastName"));

        // email yazılır
        WebElement email= Driver.getDriver().findElement(By.id("user[email]"));
        email.sendKeys(ConfigReader.getProperty("eMail"));

        // Passwort yazılır
        WebElement password= Driver.getDriver().findElement(By.id("user[password]"));

        password.sendKeys(ConfigReader.getProperty("password"));


        // checkbox tıklanır

        WebElement checkBox= Driver.getDriver().findElement(By.id("user[terms]"));
        checkBox.click();

        //Sign up a tıklanır

        WebElement signUp = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        signUp.click();

        // doğrulama testi

        WebElement memberAccount= Driver.getDriver().findElement(By.xpath("//button[@class='dropdown__toggle-button']"));
        String NewMemberName = memberAccount.getText();
        System.out.println("NewMemberName = " + NewMemberName);

        Assert.assertTrue(NewMemberName.contains(ConfigReader.getProperty("userFirstName")));



    }

    @Test
    public void loginTest () {
        // Sign in yazılı alana tıklanır

        WebElement singInButton = Driver.getDriver().findElement(By.xpath("/html/body/header/div[2]/div/nav/ul/li/a"));
        singInButton.click();

        WebElement eMail = Driver.getDriver().findElement(By.id("user[email]"));
        eMail.sendKeys(ConfigReader.getProperty("eMail"));

        WebElement password = Driver.getDriver().findElement(By.id("user[password]"));
        password.sendKeys(ConfigReader.getProperty("password"));

        WebElement signUp = Driver.getDriver().findElement(By.xpath("/html/body/main/div/div/article/form/div[5]/button"));
        signUp.click();

        WebElement memberAccount= Driver.getDriver().findElement(By.xpath("/html/body/header/div[2]/div/nav/ul/li[2]/button"));
        String NewMemberName = memberAccount.getText();
        System.out.println("NewMemberName = " + NewMemberName);

        Assert.assertTrue(NewMemberName.contains(ConfigReader.getProperty("userFirstName")));


    }

    @AfterMethod @Ignore
    public void testAfter(){
        Driver.closeDriver();
    }





}
