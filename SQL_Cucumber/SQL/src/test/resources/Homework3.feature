@homework3
Feature: odev 3

  Background:
    Given user connects to the database

  Scenario: Yeni tablo eklemek ve tabladaki verilerle bazi islemler yapmak
    When kullanici employees adinda tablo olustutur ve tabloya verileri ekler
    And ID numarasinin sonu cift sayi olan satirlarin bilgelerini tablo olarak getirir
    And Tablodaki toplam satir sayisini bulur
    And Tablodaki maksimum maasi bulur
    And Tablodaki ikinci maksimum maasi bulur
    And Tablodaki maksimum maasa sahip satirin tüm bilgilerini getirir
    And Tablodaki ikinci maksimum maasa sahip satirin tüm bilgilerini getirir