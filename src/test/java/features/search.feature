Feature: Search

#  Scenario: Search for a car brand Audi
#  As a user I should be able to search for car brand Audi
#
#    Given I am on the polovni automobili home page and I accept cookies
#    When I select brand "Audi"
#    And I select model "A5"
#    And I enter price up to "30000" euros
#    And I select year from "2015 god."
#    And I select year to
#    And I select chassis type
#    And I check and verify chassis modal info
#    And I select fuel type
#    And I select region "Beograd"
#    And I select option "Samo polovna vozila"
#    And I click on the credit checkbox
#    And I click on the search button
#    Then I should be able to see results page for selected car "Audi A5"
#
#  Scenario: Search for a car brand BMW
#  As a user I should be able to search for car brand BMW
#
#    Given I am on the polovni automobili home page and I accept cookies
#    When I select brand "BMW"
#    And I select model "335"
#    And I enter price up to "30000" euros
#    And I select year from "2015 god."
#    And I select year to
#    And I select chassis type
#    And I check and verify chassis modal info
#    And I select fuel type
#    And I select region "Vojvodina"
#    And I select option "Samo polovna vozila"
#    And I click on the credit checkbox
#    And I click on the search button
#    Then I should be able to see results page for selected car "BMW 335"
#
#  Scenario: Search for a car brand Mercedes
#  As a user I should be able to search for car brand Mercedes
#
#    Given I am on the polovni automobili home page and I accept cookies
#    When I select brand "Mercedes Benz"
#    And I select model "C 350"
#    And I enter price up to "30000" euros
#    And I select year from "2015 god."
#    And I select year to
#    And I select chassis type
#    And I check and verify chassis modal info
#    And I select fuel type
#    And I select region "Beograd"
#    And I select option "Samo polovna vozila"
#    And I click on the credit checkbox
#    And I click on the search button
#    Then I should be able to see results page for selected car "Mercedes Benz C 350"

  Scenario Outline: Search for a desired car brand
  As a user I should be able to search for a desired car

    Given I am on the polovni automobili home page and I accept cookies
    When I select brand "<brand>"
    And I select model "<model>"
    And I enter price up to "<price>" euros
    And I select year from "<year_from>"
    And I select year to
    And I select chassis type
    And I check and verify chassis modal info
    And I select fuel type
    And I select region "<region>"
    And I select option "<usedOrNew>"
    And I click on the credit checkbox
    And I click on the search button
    Then I should be able to see results page for selected car "<selectedCar>"

    Examples:
      | brand         | model     | price | year_from | region     | usedOrNew           | selectedCar          |
      | Audi          | A5        | 30000 | 2015 god. | Beograd    | Samo polovna vozila | Audi A5              |
      | BMW           | 335       | 30000 | 2015 god. | Vojvodina  | Samo polovna vozila | BMW 335              |
      | Mercedes Benz | C 350     | 35000 | 2015 god. | Beograd    | Samo polovna vozila | Mercedes Benz C 350  |
      | Porsche       | 911       | 35000 | 2010 god. | Beograd    | Samo polovna vozila | Porsche 911          |
      | Volkswagen    | Passat B8 | 30000 | 2015 god. | Podunavski | Samo polovna vozila | Volkswagen Passat B8 |