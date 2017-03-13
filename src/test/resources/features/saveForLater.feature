Feature: Use the Asos website to find the tshirts
  So I can choose one sunglasses
  As a customer
  I want to be able to save tshirts for later

  Background:
    Given I'm on ASOS Homepage

  Scenario: search and save tshirts for later
    When I search for purple t shirts
    Then I should see some purple t shirts
    And I choose one tshirt
    And I save tshirt for later purchase
    Then I click on saved items link
    And I can see my saved tshirt