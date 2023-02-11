package utilities;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;

import javax.swing.*;
import java.time.Duration;

public class TestBase {

     protected Actions action = new Actions(Driver.getDriver());

    @BeforeMethod
    public void setup () {
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Driver.getDriver().get(ConfigReader.getProperty("projekturl"));
    }



    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
