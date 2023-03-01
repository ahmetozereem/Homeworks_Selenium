package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Question6Page {
    public Question6Page () {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (css = "#gdpr-banner-accept")
    public WebElement acceptAllCookies;
    @FindBy (css = "#gh-ac")
    public WebElement searchBox;
    @FindBy (css = "input#gh-btn")
    public WebElement searchBoxButton;
    @FindBy (xpath = "(//div[text()='Windows 10'])[1]")
    public WebElement windows10;
    @FindBy (xpath = "//span[text()='GAMING PC INTEL i7 16GB RAM - 250GB SSD 500GB HDD GT710 Windows 10 WLAN Computer']")
    public  WebElement windows10Feature;
}
