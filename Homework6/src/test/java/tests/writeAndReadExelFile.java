package tests;


import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;
import utilities.AllPages;
import utilities.TestBase;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class writeAndReadExelFile extends TestBase {
    AllPages allPages = new AllPages();
    @Test
    public void writeToExelFile () throws Exception {
        FileInputStream fis = new FileInputStream("C:\\Users\\Asus\\Desktop\\GitHupBulutluozHoca\\aa.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.createSheet("2.Sheet");
        sheet.createRow(0);
        sheet.getRow(0).createCell(0).setCellValue("Ahmet");
        sheet.getRow(0).createCell(1).setCellValue(true);
        sheet.createRow(1);
        sheet.getRow(1).createCell(0).setCellValue(2);
        sheet.getRow(1).createCell(1).setCellValue(1.1);

        File file = new File("C:\\Users\\Asus\\Desktop\\GitHupBulutluozHoca\\aa.xlsx");
        FileOutputStream fos = new FileOutputStream(file);
        workbook.write(fos);
        workbook.close();// dosyayı kaydeder
    }
    @Test
    public void readFromExelFile () throws Exception {

        FileInputStream fis = new FileInputStream("C:\\Users\\Asus\\Desktop\\GitHupBulutluozHoca\\aa.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheetAt(0);
        String valueOfCell= sheet.getRow(0).getCell(0).getStringCellValue();
        System.out.println("valueOfCell = " + valueOfCell);

        int numberOfRows = sheet.getPhysicalNumberOfRows();// satır sayısı
        System.out.println("numberOfRows = " + numberOfRows);
        int numberOfCell =sheet.getRow(1).getPhysicalNumberOfCells();// sütün sayisi
        System.out.println("numberOfCell = " + numberOfCell);
        // Exel dosyasındaki verileri getCellValue() methodu ile tek tek alıp yazdırabiliriz
        System.out.println("son: "+reUsableMethods.getCellValue(sheet,0,0));
        System.out.println("son: "+reUsableMethods.getCellValue(sheet,0,1));
        System.out.println("son: "+reUsableMethods.getCellValue(sheet,1,0));
        System.out.println("son: "+reUsableMethods.getCellValue(sheet,1,1));

        // Exel dosyasındaki verileri for döngüsü ile yazdırabiliriz
        for (int i=0;i<numberOfRows;i++){
            for (int j=0;j<numberOfCell;j++){
                System.out.print("||"+"\t"+reUsableMethods.getCellValue(sheet,i,j));
            }
            System.out.println(" ");
        }
    }
}
