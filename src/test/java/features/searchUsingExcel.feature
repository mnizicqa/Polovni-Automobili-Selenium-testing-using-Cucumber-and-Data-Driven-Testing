Feature: Search

  @Smoke
  Scenario Outline: Search for a desired car brand
  As a user I should be able to search for a desired car

    Given I load test data from "TestData" "CarSearchData" "<row>"
    And I am on the polovni automobili home page and I accept cookies
    When I select brand
    And I select model
    And I enter price up to euros
    And I select year from
    And I select year to
    And I select chassis type
    And I check and verify chassis modal info
    And I select fuel type
    And I select region
    And I select option
    And I click on the credit checkbox
    And I click on the search button
    Then I should be able to see results page for selected car "<selectedCar>"

    Examples:
      | row | selectedCar          |
      | 1   | Audi A5              |
      | 2   | BMW 335              |
      | 3   | Mercedes Benz C 350  |
      | 4   | Porsche 911          |
      | 5   | Volkswagen Passat B8 |