package utilities;

import java.sql.*;

public class ReUsableMethods {
    public static int getMax (String label,String tableName) throws SQLException {
        Connection connection;
        Statement statement;
        ResultSet resultSet;
        connection = DriverManager.getConnection(ConfigReader.getProperty("db_url"), ConfigReader.getProperty("db_username"), ConfigReader.getProperty("db_password"));
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String code ="select * from "+tableName+"";
        resultSet = statement.executeQuery(code);

        int currentValue= 0;
        int maxValue =0;


        for(int i=1; i<=countAllRow(tableName);i++){
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

    public static void addValuetoTable (String code) throws SQLException {
        Connection connection;
        Statement statement;
        connection = DriverManager.getConnection(ConfigReader.getProperty("db_url"), ConfigReader.getProperty("db_username"), ConfigReader.getProperty("db_password"));
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        statement.executeUpdate(code);
    }

    public static int countAllRow (String tableName) throws SQLException {
        Connection connection;
        Statement statement;
        ResultSet resultSet;
        connection = DriverManager.getConnection(ConfigReader.getProperty("db_url"), ConfigReader.getProperty("db_username"), ConfigReader.getProperty("db_password"));
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String code ="select * from "+tableName+"";
        resultSet = statement.executeQuery(code);
        int rowCount = 0;
        while (resultSet.next()) {
            rowCount++;
        }
        return rowCount;
    }

}
