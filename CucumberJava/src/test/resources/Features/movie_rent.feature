Feature: 
	In order to control prices and return dates
	As a admin user
	I want to be able to manage customers movie rents


  Scenario: Sucessful movie rent
    Given a movie stock with 2 units
    And the rent price is R$3
    When I rent one of the movies
    Then the rent price will be R$3
    And the return date will be in the following day
    And the stock will have a balance of 1

  Scenario: Movie rent when theres no stock
    Given a movie stock with 0 units
    When I rent one of the movies
    Then it will not be possible because theres no stock
    And the stock will have a balance of 0

  Scenario: Special conditions to extended warranty
    Given a movie stock with 2 units
    And the rent price is R$4
    And the rent type is extended warranty
    When I rent one of the movies
    Then the rent price will be R$8
    And the return date will be in 3 days
    And the points earned will be equal to 2
