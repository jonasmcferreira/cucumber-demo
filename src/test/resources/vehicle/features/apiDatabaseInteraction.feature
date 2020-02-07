Feature: An API interacts with the database

  Scenario Outline: sending requests to the API populate the database
    Given I have an empty database
    When I make a <type> request to the API
    Then I receive a status of <code>
    And I have an entry in the database
    Examples:
      |type   | code | entries |
      |valid  | 200  | 1       |
      |invalid| 500  | 0       |