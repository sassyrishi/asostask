Feature: Use the website to change how search results are displayed
  So that I can select my yellow t shirts
  As an Australian customer
  I want to be able to reorganize how they are displayed

  Background:
    Given I'm on ASOS Homepage

  Scenario: Display search results in 4 columns
    Given I have searched for yellows t shirts on the Australian store
    And I have some yellow t shirts displayed
    When I organize them in 4 columns
    Then I should see some yellow t shirts organized in 4 columns