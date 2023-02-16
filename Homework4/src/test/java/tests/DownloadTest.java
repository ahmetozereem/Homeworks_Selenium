package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DownloadTestPage;
import utilities.Driver;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class DownloadTest extends TestBase {
    DownloadTestPage downloadTestPage = new DownloadTestPage();
    @Test
     public void downloadTest () throws InterruptedException {
        Driver.getDriver().navigate().to("https://the-internet.herokuapp.com/download");
        downloadTestPage.photoTest.click();
        Driver.wait(3);
        String home = System.getProperty("user.home");
        String pathOfPhoto = home+"/Downloads/photoTest.jpg";
        System.out.println("pathOfPhoto = " + pathOfPhoto);
        Assert.assertTrue(Files.exists(Paths.get(pathOfPhoto)));
    }





}
