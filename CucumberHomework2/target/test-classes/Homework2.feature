Feature: Kullanici sepete bir urun ekler ve sepet simgesi uzerinde bu urun sayisindaki artisi görur

  Background:
    Given Kullanici ana sayfaya gider

  @homework
  Scenario: Sepete bir urun eklenince sepet simgesi uzerindeki sayi bir artsin

    When Kullanici Cookies ile ilgili onayi kabul eder
    And Kullanici Cookies ile ilgili onayi kabul eder
    And Kullanici ust menu bardan Pricing linkine tiklar
    And Kullanici bir paketi buy now butonu ile sepete ekler
    And Kullanici ana sayfaya tekrar geri gider
    Then  Kullanici sepet simgesi uzerindeki rakami dogrular