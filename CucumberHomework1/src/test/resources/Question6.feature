Feature: Kullanici Ebay.de sitesindeki bir bilgisayarin Windows 10 ozelligini kontrol eder


  @question6
  Scenario: Kullanici Ebay.de sitesinde arama butonuna yazdigi kelime ile bir bilgisayarin Windows 10 ozelligini kontrol eder
    Given Kullanici ilgili sayfaya gider
    When Kullanici Cookies secenegini Accept All secenegi ile kabul eder
    And Kullanici SearchBox kutusuna computer kelimesini yazar
    And Kullanici arama butonuna basar
    And Kullanici filtre bolmesinden Windows on secenegine tiklar
    Then Cikan seceneklerden en usteki urunun Windows on ozelligi oldugu dogrulanir