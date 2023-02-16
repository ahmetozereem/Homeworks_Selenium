package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TableTestsPages {
    public TableTestsPages() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "(//td[text()='http://www.timconway.com'])[1]") // for first test
    public WebElement table4And5;

    @FindBy (css = "#table1[class='tablesorter'] thead tr th") // for second test (Table 1)
    public List<WebElement> table1Elements;

    @FindBy (css = "#table2[class='tablesorter'] thead tr th") // for second test (Table 2)
    public List<WebElement> table2Elements;

    @FindBy (xpath = "(//td[@class='dues'])[3]") // for third test
    public WebElement valueOfSecondTable;




}
