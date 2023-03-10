package utilities;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
    protected Actions actions = new Actions(Driver.getDriver());
    protected WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

    public ReUsableMethods reUsableMethods = new ReUsableMethods();
    @BeforeMethod
    public void setup(){
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        Driver.getDriver().get(ConfigReader.getProperty("projectUrl"));
    }
    @AfterMethod
    public void tearDown(){
        //Driver.closeDriver();
    }
}
