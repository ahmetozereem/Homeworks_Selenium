package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.AllPages;
import utilities.Driver;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class TableTestQuestion2 extends TestBase {
    AllPages allPages = new AllPages();
    @Test
    public void tableTest (){
        // https://the-internet.herokuapp.com/tables sayfasına gidilir
        Driver.getDriver().navigate().to("https://the-internet.herokuapp.com/tables");
        // WebElement ve Double Listeleri oluşturulur
        List<WebElement> webElementList = new ArrayList<>();
        List<Double> doubleList = new ArrayList<>();
        // bu listelere bulunan WebElementler ve double değerler eklenir
        for (int i=1;i<5;i++){
            webElementList.add(Driver.getDriver().findElement(By.xpath(reUsableMethods.getXpath(i))));
            doubleList.add(Double.parseDouble(webElementList.get(i-1).getText().substring(1)));
        }
        // Assortion için ikinci liste oluşturulur ve 50 den büyük değerler bu listeye eklenir
        List<Double> doubleList2 = new ArrayList<>();
        for (Double a: doubleList) {
            //System.out.println("a = " + a);
            if(a>50){
                doubleList2.add(a);
            }
        }

        // ikinci liste ile assertion yapılır
        // Assert.assertTrue(doubleList2.contains(100.0));
        Double expectedVaue =100.0;
        Double actualValue=0.0;
        for (Double b: doubleList2) {
            if(b==100) {
                actualValue=b;
                System.out.println("actualValue = " + actualValue);
            }
        }
        Assert.assertEquals(expectedVaue,actualValue);
    }
}
