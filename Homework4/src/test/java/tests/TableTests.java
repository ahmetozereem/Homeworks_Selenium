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

    @Test (priority = 100)
    public void questionOneTest () {
        String expectedValue = "http://www.timconway.com";
        String actualValue = tableTestsPages.table4And5.getText();
        Assert.assertEquals(actualValue,expectedValue);

    }

    @Test (priority = -100)
    public void questionTwoTest (){
        List<WebElement> listOfWebElementsOfTable1 = tableTestsPages.table1Elements;
        List<String> listOftitlesOfFirstTable = new ArrayList<>();
        List<WebElement> listOfWebElementsOfTable2 = tableTestsPages.table2Elements;
        List<String> listOftitlesOfSecondTable = new ArrayList<>();

        for (int i=0;i<6;i++) {
            listOftitlesOfFirstTable.add(listOfWebElementsOfTable1.get(i).getText());
            listOftitlesOfSecondTable.add(listOfWebElementsOfTable2.get(i).getText());
            System.out.println(listOftitlesOfFirstTable.get(i) +"="+listOftitlesOfSecondTable.get(i));
            Assert.assertEquals(listOftitlesOfFirstTable.get(i), listOftitlesOfSecondTable.get(i));
        }

    }


    @Test (priority = 0)
    public void questionThreeTest () {
        String expectedValue = "$100.00";
        String actualValue =tableTestsPages.valueOfSecondTable.getText();
        System.out.println("actualValue = " + actualValue);
        Assert.assertEquals(actualValue,expectedValue);


    }

}
