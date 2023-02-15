package utilities;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
    protected Actions actions = new Actions(Driver.getDriver());

    @BeforeMethod
    public void setup(){

        Driver.getDriver().get(ConfigReader.getProperty("projectUrl"));
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        Driver.closeDriver();
    }
}
