package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.ConfigReader;
import utilities.ReUsableMethods;

import java.sql.*;

public class DataBaseSteps {
    String url = ConfigReader.getProperty("db_url");
    String username = ConfigReader.getProperty("db_username");
    String password = ConfigReader.getProperty("db_password");

    Connection connection;
    Statement statement;
    ResultSet resultSet;
    @Given("user connects to the database")
    public void userConnectsToTheDatabase() throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    }
    @When("user connects to the student table")
    public void userConnectsToTheStudentTable() throws SQLException {
        resultSet = statement.executeQuery("SELECT * FROM Urun");
    }

    @Then("print the total row count and verify")
    public void printTheTotalRowCountAndVerify() throws SQLException {
        int rowCount = 0;
        while (resultSet.next()) {
            rowCount++;
        }
        System.out.println("Total row count: " + rowCount);
        Assert.assertEquals(rowCount, 10);
    }

    @Then("print the most expensive product and verify")
    public void printTheMostExpensiveProductAndVerify() throws SQLException {
        int actualMaxPrice=ReUsableMethods.getMax("price","Urun");
        int expectedMaxPrice =8;
        Assert.assertEquals(actualMaxPrice,expectedMaxPrice);
    }

    @And("change the product name in the first row")
    public void changeTheProductNameInTheFirstRow() throws SQLException {
        String sql = "UPDATE Urun SET name='Kahve' WHERE id=1";
        statement.executeUpdate(sql);

        resultSet = statement.executeQuery("SELECT * FROM Urun");
        resultSet.first();
        String name = resultSet.getString("name");
        System.out.println("name = " + name);
    }

    @And("find average value of prices")
    public void findAverageValueOfPrices() throws SQLException {
        resultSet = statement.executeQuery("SELECT AVG(price) FROM Urun");
        if (resultSet.next()) {
            double averagePrice = resultSet.getDouble(1);
            System.out.println("ortalama fiyat: " + averagePrice);
        }
    }

    @And("write all of the table Urun")
    public void writeAllOfTheTableUrun() throws SQLException {
        String code = "SELECT id as Numara, name as Isim, price as Fiyat  FROM Urun ";
        ReUsableMethods.getAllValuesOfTable( code);
    }

    @And("write all of the name big")
    public void writeAllOfTheNameBig() throws SQLException {
        String code = "SELECT id, UPPER(name) as name, price FROM Urun ";
        ReUsableMethods.getAllValuesOfTable( code);
    }

    @And("write all of the name small")
    public void writeAllOfTheNameSmall() throws SQLException {
        String code = "SELECT id, LOWER(name) as name, price  FROM Urun ";
        ReUsableMethods.getAllValuesOfTable( code);
    }

    @And("write all of the name only first letter big")
    public void writeAllOfTheNameOnlyFirstLetterBig() throws SQLException {
        String code = "SELECT id, INITCAP(name) as name, price  FROM Urun ";
        ReUsableMethods.getAllValuesOfTable( code);
    }

    @And("write some values")
    public void writeSomeValues() throws SQLException {
        String code = "select * from Urun where price>3 order by 1 ASC, 3 Desc ";
        ReUsableMethods.getAllValuesOfTable( code);
    }
}
