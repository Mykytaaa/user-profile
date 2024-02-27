Feature: Client error while creating a user with invalid parameters

  Scenario:

    Given User Profile Service is up and running

    And User Profile endpoint "/api/v1/users" with http method "POST" available

    When a client wants to create a user with mandatory parameters:
      | first_name                    | FirstNameMoreThanFiftyCharactersFirstNameMoreThanFiftyCharacters    |
      | last_name                     | LastNameMoreThanFiftyCharactersLastNameMoreThanFiftyCharacters      |
      | email                         | wackywalshupdatedexample.com                                        |
      | user_details.phone_number     | 923461788755                                                        |
      | user_details.telegram_id      | nick_ward                                                           |

    Then response code is 400

    And response body contains:
      | status                    | 400                         |
      | message                   | Validation error occurred   |
      | details                   | The length of your first name should ne between 1 and 50 characters, The length of your last name should ne between 1 and 50 characters, Phone number does not match pattern, Please provide a valid email address, Telegram id does not match pattern |
