Feature: Delivery

  Scenario: Calculate delay in delivery of products
    Given the delivery time is 05/04/2019
    When the delivery delays in 2 days
    Then the delivery will occur in 07/04/2019
    
  Scenario: Calculate shipping delay from China
  	Given the delivery time is 05/04/2019
    When the delivery delays in 2 months
    Then the delivery will occur in 05/06/2019
  
  
  
