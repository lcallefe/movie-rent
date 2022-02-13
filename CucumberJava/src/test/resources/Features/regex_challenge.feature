Feature: Buying airlane tickets

  Scenario: Generic steps
    Given the ticket is AF345
    And the ticket price is R$ 230.45
    And the passenger name is "Fulano da Silva"
    And the passenger's cellphone number is 99999-9999
    When I create the steps
    Then the test will pass

  Scenario: Reusing last scenario steps
    Given the ticket is AB167
    And the special ticket is AB167
    And the ticket price is R$ 230.45
    And the passenger name is "Fulano da Silva"
    And the passengers cellphone number is 9999-9999

  Scenario: Denying last scenarios steps
    Given the ticket is CD123
    And the ticket is AG1234
    And the ticket price is R$ 1,230.45
    And the passenger name is "Ciclano Beltrano da Silva Moraes Callefe Ferreira"
    #Given the passengers cellphone number is 1234-5678
    #Given the passengers cellphone number is 999-2223
