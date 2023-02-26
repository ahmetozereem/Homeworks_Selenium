Feature: Kullanici ilgili sitede iki kelimeyi arar ve varliklarini kontrol eder

  Background:
    Given Kullainci ilgili sayfaya gitmelidir


    @question7
  Scenario Outline: Kullanici ilgili sitede iki kelimeyi arar ve varliklarini kontrol eder

      When Kullanici Cookies leri kabul etmek icin AcceptAll ve close a tiklar
      And Kullainci  ust menu bardan arama simgesine tiklar
      And Kullanici  search box kutusuna "<aranacak kelime>" yazar
      And Kullanici arama butonuna tiklar
      Then Arama sonucu cikan ilk secenegin "<aranacak kelime>" kelimeleri barindirdigi Assert edilir.
      # Asagida Kullandigimiz tablo yöntemi ile DDT yani Data Driven Testing yapmis oluyoruz.
    Examples:
      |aranacak kelime|
      |keyword test|
      |data testing|
