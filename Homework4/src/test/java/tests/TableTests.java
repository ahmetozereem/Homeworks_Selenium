package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TableTestsPages;
import utilities.Driver;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class TableTests extends TestBase {
    TableTestsPages tableTestsPages = new TableTestsPages();

    @Test
    public void questionOneTest () {
        String expectedValue = "http://www.timconway.com";
        String actualValue = tableTestsPages.table4And5.getText();
        //System.out.println("actualValue = " + actualValue);
        Assert.assertEquals(actualValue,expectedValue);
    }

    @Test
    public void questionTwo (){


        List<WebElement> listOfWebElements = new ArrayList<>();
        List<String> ListOftitlesOfFirstTable = new ArrayList<>();




    }

    @Test
    public void questionThree () {

        String expectedValue = "$100.00";
        String actualValue =tableTestsPages.valueOfSecondTable.getText();
        System.out.println("actualValue = " + actualValue);
        Assert.assertEquals(actualValue,expectedValue);

    }

}
