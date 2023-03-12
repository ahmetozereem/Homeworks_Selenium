package utilities;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ReUsableMethods {
    public static int getMax (ResultSet resultSet, String label) throws SQLException {
        int currentValue= 0;
        int maxValue =0;

        for(int i=1; i<=10;i++){
            resultSet.absolute(i);
            currentValue=resultSet.getInt(""+label+"");
            if(currentValue>maxValue){
                maxValue=currentValue;
            }
        }
        return maxValue;
    }

    public  static void getAllValueOfTable(Statement statement, String code ) throws SQLException {
        ResultSet resultSet = statement.executeQuery(code);
        // Başlıkları yazdır
        ResultSetMetaData rsmd = resultSet.getMetaData();
        int columnCount = rsmd.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            System.out.print(rsmd.getColumnName(i) + "\t");
        }
        System.out.println();

        // Verileri yazdır
        while (resultSet.next()) {
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(resultSet.getString(i) + "\t");
            }
            System.out.println();
        }
    }
}
