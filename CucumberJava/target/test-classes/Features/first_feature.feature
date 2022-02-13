Feature: Counter
 
  Scenario: Increase counter value
    Given my count value is 15
		When I increase it by 3
		Then the new value is 18

