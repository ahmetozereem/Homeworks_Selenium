package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UploadTestPage;
import utilities.Driver;

public class UploadTest {
    UploadTestPage uploadTestPage = new UploadTestPage();
    @Test
    public void uploadTest () {
        Driver.getDriver().navigate().to("https://the-internet.herokuapp.com/upload");
        String pathOfPhoto = "C:/Users/Asus/Downloads/photoTest.jpg";
        uploadTestPage.uploadFile.sendKeys(pathOfPhoto);
        uploadTestPage.submitFile.click();
        Assert.assertEquals(uploadTestPage.assertOfUploadTest.getText(),"File Uploaded!");
    }
}
