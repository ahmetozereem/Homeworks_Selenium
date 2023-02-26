package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Question7Page {
    public Question7Page () {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (css = "button[id='onetrust-accept-btn-handler']")
    public WebElement acceptAndCloseButton;
    @FindBy (css = "#js-tlrk-nav-search-wrapper")
    public WebElement searchButton;
    @FindBy (css = "input[type='search']")
    public WebElement searchArea;
    @FindBy (css = "button[class='TK-Tag-Input-Button']")
    public WebElement searchAreaButton;
    @FindBy (css = "b.TK-Search-Results-Query")
    public WebElement results;
}
