package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DragAndDropPages {
    public DragAndDropPages() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "#save")
    public WebElement iFrameAcceptAll;

    @FindBy (css = "li[data-id='5']")
    public WebElement bankButton;

    @FindBy (css = "#bank li")
    public WebElement placeFolderDebitSideAccount;

    @FindBy (css = "#credit1 a")
    public WebElement sales;

    @FindBy (css = "#loan li")
    public WebElement placeFoldeCreditSideAccount;

    @FindBy (css = "#fourth[data-id='2'][class='block13 ui-draggable']")
    public WebElement fiveHundertButton;

    @FindBy (css = "#amt7")
    public WebElement placeFolderDebitSideAmount;

    @FindBy (css = "#amt8")
    public WebElement placeFolderCreditSideAmount;

    @FindBy (css = "#t7")
    public WebElement debitMovementAmount;

    @FindBy (css = "#t8")
    public WebElement creditMovementAmount;

    @FindBy (css = "div.table4_result")
    public WebElement table;
}
