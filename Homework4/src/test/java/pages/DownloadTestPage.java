package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DownloadTestPage {
    public DownloadTestPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy (css = "#content div.example a[href='download/photoTest.jpg']")
    public WebElement photoTest;
}
