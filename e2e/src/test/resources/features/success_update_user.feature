Feature: Update a user

  Scenario:
    Given User Profile Service is up and running

    And User Profile endpoint "/api/v1/users/{id}" with http method "PUT" available

    When a client wants to update a user with id: 2
      | id                           | 2                             |
      | first_name                   | WackyUpdated                  |
      | last_name                    | WalshUpdated                  |
      | email                        | wackywalshupdated@example.com |
      | userDetails.id               | 2                             |
      | userDetails.phone_number     | +919542348755                 |
      | userDetails.telegram_id      | @secondTelegram_id            |

    Then response code is 200

    And response body contains:
      | id                           | 2                             |
      | first_name                   | WackyUpdated                  |
      | last_name                    | WalshUpdated                  |
      | email                        | wackywalshupdated@example.com |
      | userDetails.id               | 2                             |
      | userDetails.phone_number     | +919542348755                 |
      | userDetails.telegram_id      | @secondTelegram_id            |