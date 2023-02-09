package homework1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tests {

    WebDriver driver = new ChromeDriver();

    @Before
    public void setUp () throws InterruptedException {

        // 1.Step
        driver.get("http://www.gcreddy.com/project/admin/login.php");
        driver.manage().window().maximize();
        //Thread.sleep(3000);
    }

    @After
    public void tearDown () {
        driver.close();
    }

    @Test
    public void testGcreddy() throws InterruptedException {
        //2.Step
        WebElement username =driver.findElement(By.xpath("//*[@id='contentText']/table/tbody/tr[2]/td/form/table/tbody/tr[1]/td/input"));
        username.sendKeys("gcreddy");
        //Thread.sleep(3000);
        //3.Step
        WebElement passwort = driver.findElement(By.xpath("//*[@id='contentText']/table/tbody/tr[2]/td/form/table/tbody/tr[2]/td/input"));
        passwort.sendKeys("Temp@2020");
        //4.Step
        WebElement login = driver.findElement(By.xpath("//*[@id='tdb1']/span[2]"));
        login.click();
        //5.Step
        WebElement customers = driver.findElement(By.xpath("//*[@id='ui-accordion-adminAppMenu-header-2']/a"));
        customers.click();
        //6.Step
        WebElement customer2 = driver.findElement(By.xpath("//*[@id='ui-accordion-adminAppMenu-panel-2']/ul/li/a"));
        customer2.click();
        //7.Step
        WebElement edit = driver.findElement(By.xpath("//*[@id='tdb1']/span[2]"));
        edit.click();
        //8.Step
        WebElement firstname = driver.findElement(By.xpath("//*[@id='contentText']/table/tbody/tr[4]/td/table/tbody/tr[2]/td[2]/input"));
        firstname.clear();
        firstname.sendKeys("Ahmet");
        //9.Step
        WebElement lastname = driver.findElement(By.xpath("//*[@id='contentText']/table/tbody/tr[4]/td/table/tbody/tr[3]/td[2]/input"));
        lastname.clear();
        lastname.sendKeys("Kara");
        //10.Step
        WebElement dateofBird = driver.findElement(By.xpath("//*[@id='customers_dob']"));
        dateofBird.clear();
        dateofBird.sendKeys("02/07/1990");
        //11.Step
        WebElement eMail = driver.findElement(By.xpath("//*[@id='contentText']/table/tbody/tr[4]/td/table/tbody/tr[5]/td[2]/input"));
        eMail.clear();
        eMail.sendKeys("ahmetkara@gmail.com");
        //12.Step
        WebElement companyName = driver.findElement(By.xpath("//*[@id='contentText']/table/tbody/tr[7]/td/table/tbody/tr/td[2]/input"));
        companyName.clear();
        companyName.sendKeys("Karakoc Insaat");
        //13.Step
        WebElement streetAddress = driver.findElement(By.xpath("//*[@id='contentText']/table/tbody/tr[10]/td/table/tbody/tr[1]/td[2]/input"));
        streetAddress.clear();
        streetAddress.sendKeys("Karagol Sokak");
        //14.Step
        WebElement suburb = driver.findElement(By.xpath("//*[@id='contentText']/table/tbody/tr[10]/td/table/tbody/tr[2]/td[2]/input"));
        suburb.clear();
        suburb.sendKeys("abcde");
        //15.Step
        WebElement postCode = driver.findElement(By.xpath("//*[@id='contentText']/table/tbody/tr[10]/td/table/tbody/tr[2]/td[2]/input"));
        postCode.clear();
        postCode.sendKeys("12345");
        //16.Step
        WebElement city = driver.findElement(By.xpath("//*[@id='contentText']/table/tbody/tr[10]/td/table/tbody/tr[4]/td[2]/input"));
        city.clear();
        city.sendKeys("Bünde");
        //17.Step
        WebElement state = driver.findElement(By.xpath("//*[@id='contentText']/table/tbody/tr[10]/td/table/tbody/tr[5]/td[2]/input"));
        state.clear();
        state.sendKeys("Berlin");
        //18.Step
        WebElement country = driver.findElement(By.xpath("//*[@id='contentText']/table/tbody/tr[10]/td/table/tbody/tr[6]/td[2]/select"));
        country.click();
        country.sendKeys("Germany");
        //19.Step
        WebElement telephoneNumber = driver.findElement(By.xpath("//*[@id='contentText']/table/tbody/tr[13]/td/table/tbody/tr[1]/td[2]/input"));
        telephoneNumber.clear();
        telephoneNumber.sendKeys("123456789");
        //20.Step
        WebElement faxNumber = driver.findElement(By.xpath("//*[@id='contentText']/table/tbody/tr[13]/td/table/tbody/tr[2]/td[2]/input"));
        faxNumber.clear();
        faxNumber.sendKeys("12345");
        //21.Step
        WebElement newsletter = driver.findElement(By.xpath("//*[@id='contentText']/table/tbody/tr[16]/td/table/tbody/tr/td[2]/select"));
        newsletter.click();
        newsletter.sendKeys("S");
        //22.Step
        WebElement save = driver.findElement(By.xpath("//*[@id='tdb1']/span[2]"));
        save.click();
        //23.Step
        WebElement search = driver.findElement(By.xpath("//*[@id='contentText']/table/tbody/tr[1]/td/table/tbody/tr/td[3]/input"));
        search.sendKeys("Ahmet");
        search.sendKeys(Keys.ENTER);
        //24.Step
        WebElement savedLastName = driver.findElement(By.xpath("//*[@id='defaultSelected']/td[1]"));
        WebElement savedFirstName = driver.findElement(By.xpath("//*[@id='defaultSelected']/td[2]"));


        String actualFirstName =savedFirstName.getText();
        String actualLastName = savedLastName.getText();

        System.out.println("actualFirstName = " + actualFirstName);
        System.out.println("actualLastName = " + actualLastName);

        String expectedFirstName = "Ahmet";
        String expectedLastName = "Kara";

        Assert.assertEquals(expectedFirstName, actualFirstName);
        Assert.assertEquals(expectedLastName, actualLastName);
        Thread.sleep(3000);

        //25.Step
        WebElement logoff = driver.findElement(By.xpath("/html/body/table[1]/tbody/tr[2]/td[2]/a"));
        logoff.click();
        Thread.sleep(2000);

        // delete the account
        WebElement username2 = driver.findElement(By.xpath("//*[@id='contentText']/table/tbody/tr[2]/td/form/table/tbody/tr[1]/td/input"));
        username2.sendKeys("gcreddy");
        Thread.sleep(2000);

        WebElement passwort2 = driver.findElement(By.xpath("//*[@id='contentText']/table/tbody/tr[2]/td/form/table/tbody/tr[2]/td/input"));
        passwort2.sendKeys("Temp@2020");
        Thread.sleep(2000);

        WebElement login2 = driver.findElement(By.xpath("//*[@id='tdb1']/span[2]"));
        login2.click();
        Thread.sleep(2000);

        WebElement customers3 = driver.findElement(By.xpath("//*[@id='ui-accordion-adminAppMenu-header-2']/a"));
        customers3.click();
        Thread.sleep(2000);
        //6.Step
        WebElement customer4 = driver.findElement(By.xpath("//*[@id='ui-accordion-adminAppMenu-panel-2']/ul/li/a"));
        customer4.click();
        Thread.sleep(2000);

        WebElement search2 = driver.findElement(By.xpath("//*[@id='contentText']/table/tbody/tr[1]/td/table/tbody/tr/td[3]/input"));
        search2.sendKeys("Ahmet");
        search2.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        WebElement delete = driver.findElement(By.xpath("//*[@id='tdb3']/span[2]"));
        delete.click();
        Thread.sleep(2000);

        WebElement delete2 = driver.findElement(By.xpath("//*[@id='tdb2']/span[2]"));
        delete2.click();
        Thread.sleep(2000);

        WebElement logoff2 = driver.findElement(By.xpath("/html/body/table[1]/tbody/tr[2]/td[2]/a"));
        logoff2.click();
        Thread.sleep(2000);

    }
}
