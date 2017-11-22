@start
Feature: Testing an ANDROID CALCULATOR
  This feature contains the test scenario for the android calculator application.

  @basicOperation
  Scenario: Lounch My ANDROID CALCULATOR Application
    Given I want to lounch android calculator
    Then I want to perform addition and check outcomes
    Then I want to perform substraction and check outcomes
    Then I want to perform multiplication and check outcomes
    Then I want to perform division and check outcomes
    
  @clearInputAndResults
  Scenario: Clearing the result on screen
  	Given provide some input to calculator
  	Then clear the screen and check the screen