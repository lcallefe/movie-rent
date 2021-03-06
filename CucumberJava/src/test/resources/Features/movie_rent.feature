Feature: 
  In order to control prices and return dates
  As a admin user
  I want to be able to manage customers movie rents

  Scenario: Sucessful movie rent
    Given a movie
      | stock |      2 |
      | price |    3.0 |
      | type  | normal |
    When I rent one of the movies
    Then the rent price will be R$3
    And the return date will be in the following day
    And the stock will have a balance of 1

  Scenario Outline: Movie rent when theres no stock
    Given a movie stock with 0 units
    When I rent one of the movies
    But it will not be possible because theres no stock
    Then the stock will have a balance of 0

  Scenario Outline: Special conditions to extended warranty
    Given a movie stock with 2 units
    And the rent price is R$<price>
    And the rent type is <type>
    When I rent one of the movies
    Then the rent price will be R$<value>
    And the return date will be in <days> days
    And the points earned will be equal to <points>
    And the stock will have a balance of 1

    Examples: 
      | price | type     | value | days | points |
      |     4 | extended |     8 |    3 |      2 |
      |     4 | normal   |     4 |    1 |      1 |
