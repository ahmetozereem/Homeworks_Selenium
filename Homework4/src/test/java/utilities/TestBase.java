package utilities;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public class TestBase {
    protected Actions actions = new Actions(Driver.getDriver());

    @BeforeMethod
    public void setup(){
        Driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Driver.getDriver().manage().timeouts().pageLoadTimeout(100, SECONDS);

        Driver.getDriver().get(ConfigReader.getProperty("projectUrl"));

    }
    @AfterClass
    public void tearDown() throws InterruptedException {
       Driver.closeDriver();

    }
}
