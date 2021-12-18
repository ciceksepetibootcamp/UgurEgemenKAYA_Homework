Feature: Amazon search test

  Scenario: Amazon search testi
    Given Amazon.com sitesine girilir
    When Search bar a "SSD" yazılır
    Then SSD arama "SSD" görüntülenir