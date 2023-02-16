package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TableTestsPages {
    public TableTestsPages() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "(//td[text()='http://www.timconway.com'])[1]") // for first test
    public WebElement table4And5;

    @FindBy (css = "#table1[class='tablesorter'] thead tr th")
    public WebElement titleOfFirstTitleOfFirstTableList;

    @FindBy (xpath = "(//table[@id='table1']/thead/tr/th)[1]")
    public WebElement titleOfFirstTitleOfFirstTable;

    @FindBy (xpath = "(//table[@id='table1']/thead/tr/th)[2]")
    public WebElement titleOfsecondTitleOfFirstTable;

    @FindBy (xpath = "(//table[@id='table1']/thead/tr/th)[3]")
    public WebElement titleOfThirdTitleOfFirstTable;

    @FindBy (xpath = "(//table[@id='table1']/thead/tr/th)[4]")
    public WebElement titleOfFourthTitleOfFirstTable;

    @FindBy (xpath = "(//table[@id='table1']/thead/tr/th)[5]")
    public WebElement titleOfFifthTitleOfFirstTable;

    @FindBy (xpath = "(//table[@id='table1']/thead/tr/th)[6]")
    public WebElement titleOfSixthTitleOfFirstTable;

    @FindBy (xpath = "(//table[@id='table2']/thead/tr/th)[1]")
    public WebElement titleOfFirstTitleOfSecondTable;

    @FindBy (xpath = "(//table[@id='table2']/thead/tr/th)[2]")
    public WebElement titleOfsecondTitleOfSecondTable;

    @FindBy (xpath = "(//table[@id='table2']/thead/tr/th)[3]")
    public WebElement titleOfThirdTitleOfSecondTable;

    @FindBy (xpath = "(//table[@id='table2']/thead/tr/th)[4]")
    public WebElement titleOfFourthTitleOfSecondTable;

    @FindBy (xpath = "(//table[@id='table2']/thead/tr/th)[5]")
    public WebElement titleOfFifthTitleOfSecondTable;

    @FindBy (xpath = "(//table[@id='table2']/thead/tr/th)[6]")
    public WebElement titleOfSixthTitleOfSecondTable;

    @FindBy (xpath = "(//td[@class='dues'])[3]") // for third test
    public WebElement valueOfSecondTable;




}
