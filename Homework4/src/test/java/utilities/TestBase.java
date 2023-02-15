package utilities;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
    protected Actions actions = new Actions(Driver.getDriver());

    @BeforeMethod
    public void setup(){
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Driver.getDriver().get(ConfigReader.getProperty("projectUrl"));
    }
    @AfterMethod
    public void tearDown(){
        //Driver.closeDriver();
    }
}
