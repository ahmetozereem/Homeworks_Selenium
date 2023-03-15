package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import utilities.ConfigReader;
import utilities.ReUsableMethods;

import java.sql.*;

public class Homework3Steps {
    String url = ConfigReader.getProperty("db_url");
    String username = ConfigReader.getProperty("db_username");
    String password = ConfigReader.getProperty("db_password");

    Connection connection;
    Statement statement;
    ResultSet resultSet;
    @When("kullanici employees adinda tablo olustutur ve tabloya verileri ekler")
    public void kullaniciEmployeesAdindaTabloOlustuturVeTabloyaVerileriEkler() throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String code = "create table employees (id integer, name char (50), state char(50), salary integer, company char(50))";
        try {
            statement.executeUpdate(code);
        }catch (SQLException e) {
            System.out.println("Veritabanı hatası: " + e.getMessage());}

        ReUsableMethods.addValuetoTable("INSERT INTO employees VALUES(123456789, 'Johnny Walk', 'New Hampshire', 2500, 'IBM')");
        ReUsableMethods.addValuetoTable("INSERT INTO employees VALUES (234567891, 'Brian Pitt', 'Florida', 1500,'LINUX')");
        ReUsableMethods.addValuetoTable("INSERT INTO employees VALUES(245678901, 'Eddie Murphy', 'Texas', 3000, 'WELLS FARGO')");
        ReUsableMethods.addValuetoTable("INSERT INTO employees VALUES(456789012, 'Teddy Murphy', 'Virginia',1000, 'GOOGLE')");
        ReUsableMethods.addValuetoTable("INSERT INTO employees VALUES(567890124, 'Eddie Murphy','Massachuset', 7000, 'MICROSOFT')");
        ReUsableMethods.addValuetoTable("INSERT INTO employees VALUES(456789012, 'Brad Pitt', 'Texas', 1500,'TD BANK')");
        ReUsableMethods.addValuetoTable("INSERT INTO employees VALUES(123456719, 'Adem Stone', 'New Jersey', 2500, 'IBM')");
    }
    @And("ID numarasinin sonu cift sayi olan satirlarin bilgelerini tablo olarak getirir")
    public void ıdNumarasininSonuCiftSayiOlanSatirlarinBilgeleriniTabloOlarakGetirir() throws SQLException {
        String code ="select * from employees where mod(id,2)=0";
        ReUsableMethods.getAllValueOfTable(code);
    }

    @And("Tablodaki toplam satir sayisini bulur")
    public void tablodakiToplamSatirSayisiniBulur() throws SQLException {
        int satirSayisi=ReUsableMethods.countAllRow("employees");
        System.out.println("Satir Sayisi = " + satirSayisi);

    }

    @And("Tablodaki maksimum maasi bulur")
    public void tablodakiMaksimumMaasiBulur() throws SQLException {
        int firstMaxPrice=ReUsableMethods.getMax("salary","employees");
        System.out.println("firstMaxPrice = " + firstMaxPrice);
        // alternatif olarak :
        //String code ="select Max(salary) As Maksimum_Maas from employees";
       // ReUsableMethods.getAllValueOfTable(code);
    }

    @And("Tablodaki ikinci maksimum maasi bulur")
    public void tablodakiIkinciMaksimumMaasiBulur() throws SQLException {
        String code ="select max(salary) from employees where salary!=(select max(salary) from employees)";
        ReUsableMethods.getAllValueOfTable(code);
    }

    @And("Tablodaki maksimum maasa sahip satirin tüm bilgilerini getirir")
    public void tablodakiMaksimumMaasaSahipSatirinTümBilgileriniGetirir() throws SQLException {
        String code ="select * from employees where salary=(select max(salary) from employees)";
        ReUsableMethods.getAllValueOfTable(code);
    }

    @And("Tablodaki ikinci maksimum maasa sahip satirin tüm bilgilerini getirir")
    public void tablodakiIkinciMaksimumMaasaSahipSatirinTümBilgileriniGetirir() throws SQLException {
        String code ="select * from employees where salary=(select max(salary) from employees where salary!=(select max(salary) from employees))";
        ReUsableMethods.getAllValueOfTable(code);
    }
}
