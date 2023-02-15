package tests;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Set;

public class Homework3 extends TestBase {

    @Test
    public void testsHomework() throws InterruptedException {
        WebElement cookies = Driver.getDriver().findElement(By.id("sp-cc-accept"));
        cookies.click();
        //Thread.sleep(2000);

        WebElement spracheAendern = Driver.getDriver().findElement(By.xpath("//*[@id='icp-nav-flyout']/span"));
        action.moveToElement(spracheAendern).perform();
        //Thread.sleep(2000);

        WebElement english = Driver.getDriver().findElement(By.xpath("//*[@id='nav-flyout-icp']/div[2]/a[1]/span/span[1]"));
        english.click();
        Thread.sleep(100);

        WebElement accountList = Driver.getDriver().findElement(By.id("nav-link-accountList-nav-line-1"));
        action.moveToElement(accountList).perform();
        //Thread.sleep(2000);

        WebElement findAGift = Driver.getDriver().findElement(By.partialLinkText("Find a Gift"));
        findAGift.click();

        WebElement giftsForEveryone = Driver.getDriver().findElement(By.xpath("//*[@id='reactApp']/div/div/div[2]/h2"));
        String gifts = giftsForEveryone.getText();
        System.out.println("gifts = " + gifts);
        //Thread.sleep(2000);


        ((JavascriptExecutor)Driver.getDriver()).executeScript("window.open('https://www.ebay.com', '_blank');");

        Set<String> pages = Driver.getDriver().getWindowHandles();
        String pageOfEbay = pages.toArray()[1].toString();
        System.out.println(pageOfEbay);

        Driver.getDriver().switchTo().window(pages.toArray()[1].toString());
        WebElement searchInEbay = Driver.getDriver().findElement(By.cssSelector("input[type='text']"));
        searchInEbay.sendKeys(gifts+Keys.ENTER);

        WebElement price = Driver.getDriver().findElement(By.xpath("//*[@id='srp-river-results']/ul/li[2]/div/div[2]/div[2]/div[1]/span"));
        String priceOfProdukt =price.getText();
        System.out.println("priceOfProdukt = " + priceOfProdukt);

        Assert.assertTrue(priceOfProdukt.contains("$89.99"));


}
}