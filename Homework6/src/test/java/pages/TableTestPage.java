package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.ReUsableMethods;
import utilities.TestBase;

import java.util.List;

public class TableTestPage {
    public TableTestPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    public TestBase testBase = new TestBase();




}
