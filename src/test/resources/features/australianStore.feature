Feature: Use the website to find products in the Australian store
  So that I can order a shirt
  As an Australian customer
  I want to be able to find t shirts in my store

  Background:
    Given I'm on ASOS Homepage

  Scenario: Search for t shirts in Australian store
    And I select Australia as locale
    When I search for yellow t shirts in the Australian store
    Then I should see some yellow t shirts