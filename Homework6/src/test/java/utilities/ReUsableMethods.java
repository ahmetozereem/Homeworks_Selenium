package utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class ReUsableMethods {

    public String getXpath (int a) {
        return "(((//tbody)[1]/tr)["+ a +"]/td)[4]";
    }
    // Bu method bir exel dosyasından veri okumak için kullanılır

    public String getCellValue(Sheet sheet, int r, int c) {
        Row row = sheet.getRow(r);
        Cell cell = row.getCell(c);
        String value=null;

        switch (cell.getCellType()){
            case NUMERIC: value=String.valueOf(cell.getNumericCellValue());
                break;
            case BOOLEAN : value= String.valueOf(cell.getBooleanCellValue());
                break;
            case STRING:
            default: value= cell.getStringCellValue();
                break;
        }
        return value;
    }
}
