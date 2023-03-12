package utilities;

import java.sql.*;

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

    public  static void getAllValueOfTable( String code ) throws SQLException {
        Connection connection;
        Statement statement;
        connection = DriverManager.getConnection(ConfigReader.getProperty("db_url"), ConfigReader.getProperty("db_username"), ConfigReader.getProperty("db_password"));
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
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
