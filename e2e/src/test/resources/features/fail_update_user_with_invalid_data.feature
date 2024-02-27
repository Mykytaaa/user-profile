Feature: Error while updating a user with invalid data

  Scenario:
    Given User Profile Service is up and running

    And User Profile endpoint "/api/v1/users/{id}" with http method "PUT" available

    When a client wants to update a user with id: 2
      | id                           | 2                                                                      |
      | first_name                   | FirstNameMoreThanFiftyCharactersFirstNameMoreThanFiftyCharacters       |
      | last_name                    | LastNameMoreThanFiftyCharactersLastNameMoreThanFiftyCharacters         |
      | email                        | wackywalshupdatedexample.com                                           |
      | userDetails.id               | 2                                                                      |
      | userDetails.phone_number     | +919542348755                                                          |
      | userDetails.telegram_id      | @secondTelegram_id                                                     |

    Then response code is 400

    And response body contains:
      | status                       | 400                                                                                      |
      | message                      | Validation error occurred                                                                |
      | details                      | size must be between 1 and 50, size must be between 1 and 50, Email should be valid      |