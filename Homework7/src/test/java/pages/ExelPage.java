package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ExelPage {
    public ExelPage() {PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy (css = "#accept-cookie-notification")
    public WebElement acceptCookiesButton;

    @FindBy (css = "#user_full_name")
    public WebElement userFullName;

    @FindBy (css = "#user_email_login")
    public WebElement userEmailLogin;

    @FindBy (css = "#user_password")
    public WebElement userPassword;

    @FindBy (xpath = "//span[(text()='Invalid Characters')]")
    public WebElement InvalidCharacter;

    @FindBy (css = "#tnc_checkbox")
    public WebElement iAgreeCheckbox;

    @FindBy (css = "#user_submit")
    public WebElement signMeInButton;



    @FindBy (xpath = "//span[(text()='At least 6 characters')]")
    public WebElement errorMsg6Character;

    @FindBy (xpath = "//h1[contains(text(),'Quick question, for whom are you evaluating Live?')]")
    public WebElement textAfterSingIn;









}
