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

        /* Birinci klasik yöntem

        List<WebElement> listOfWebElementsOfTable1 = new ArrayList<>();
        List<String> listOftitlesOfFirstTable = new ArrayList<>();

        listOfWebElementsOfTable1.add(tableTestsPages.titleOfFirstTitleOfFirstTable);
        listOfWebElementsOfTable1.add(tableTestsPages.titleOfsecondTitleOfFirstTable);
        listOfWebElementsOfTable1.add(tableTestsPages.titleOfThirdTitleOfFirstTable);
        listOfWebElementsOfTable1.add(tableTestsPages.titleOfFourthTitleOfFirstTable);
        listOfWebElementsOfTable1.add(tableTestsPages.titleOfFifthTitleOfFirstTable);
        listOfWebElementsOfTable1.add(tableTestsPages.titleOfSixthTitleOfFirstTable);

            for (int i=0;i<6;i++) {
                listOftitlesOfFirstTable.add(listOfWebElementsOfTable1.get(i).getText());
        }
            for ( String  a : listOftitlesOfFirstTable) {
            System.out.println(a);

        }

        List<WebElement> listOfWebElementsOfTable2 = new ArrayList<>();
        List<String> listOftitlesOfSecondTable = new ArrayList<>();

        listOfWebElementsOfTable2.add(tableTestsPages.titleOfFirstTitleOfSecondTable);
        listOfWebElementsOfTable2.add(tableTestsPages.titleOfsecondTitleOfSecondTable);
        listOfWebElementsOfTable2.add(tableTestsPages.titleOfThirdTitleOfSecondTable);
        listOfWebElementsOfTable2.add(tableTestsPages.titleOfFourthTitleOfSecondTable);
        listOfWebElementsOfTable2.add(tableTestsPages.titleOfFifthTitleOfSecondTable);
        listOfWebElementsOfTable2.add(tableTestsPages.titleOfSixthTitleOfSecondTable);

            for (int i=0;i<6;i++) {
            listOftitlesOfSecondTable.add(listOfWebElementsOfTable2.get(i).getText());
        }
            for ( String  b : listOftitlesOfSecondTable) {
            System.out.println(b);
        }

            for (int i=0;i<6;i++) {
            Assert.assertEquals(listOftitlesOfFirstTable.get(i), listOftitlesOfSecondTable.get(i));
        }

         */

        // ikinci yöntem

        List<WebElement> listOfWebElementsOfTable1 = Driver.getDriver().findElements(By.cssSelector("#table1[class=\"tablesorter\"] thead tr th"));
        List<String> listOftitlesOfFirstTable = new ArrayList<>();
        List<WebElement> listOfWebElementsOfTable2 = Driver.getDriver().findElements(By.cssSelector("#table2[class=\"tablesorter\"] thead tr th"));
        List<String> listOftitlesOfSecondTable = new ArrayList<>();

        for (int i=0;i<6;i++) {
            listOftitlesOfFirstTable.add(listOfWebElementsOfTable1.get(i).getText());
            listOftitlesOfSecondTable.add(listOfWebElementsOfTable2.get(i).getText());
            //System.out.println(listOftitlesOfFirstTable.get(i) +"="+listOftitlesOfSecondTable.get(i));
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
