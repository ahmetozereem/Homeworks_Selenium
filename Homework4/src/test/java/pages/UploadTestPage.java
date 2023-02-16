package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class UploadTestPage {
    public UploadTestPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (css = "#file-upload")
    public WebElement uploadFile;

    @FindBy (css = "#file-submit")
    public WebElement submitFile;

    @FindBy (css = "#content div.example h3")
    public WebElement assertOfUploadTest;

}
