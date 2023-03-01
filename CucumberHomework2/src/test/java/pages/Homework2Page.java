package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Homework2Page {
    public Homework2Page () {PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy (css = "button#onetrust-accept-btn-handler")
    public WebElement acceptAllCookies;

    @FindBy (css = "a[href='/purchase.aspx'][class='TK-Menu-Item-Link']")
    public WebElement pricingButton;

    @FindBy (css = "th[class='Complete'] div a")
    public WebElement buyNowButton;

    @FindBy (css = "span[class='u-fr price-small e2e-total-price']")
    public WebElement newPage;

    @FindBy (css = "span[class='TK-Counter TK-Counter--SC TK-Counter--Visible']")
    public WebElement verifyOfNummerOfItems;





}
