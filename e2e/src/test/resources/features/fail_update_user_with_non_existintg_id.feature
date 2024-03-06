Feature: Error while updating non existing user

  Scenario:
    Given User Profile Service is up and running

    And User Profile endpoint "/api/v1/users/{id}" with http method "PUT" available

    When a client wants to update a user with id: 1000
      | id                           | 1000                          |
      | first_name                   | WackyUpdated                  |
      | last_name                    | WalshUpdated                  |
      | email                        | wackywalshupdated@example.com |
      | userDetails.id               | 2                             |
      | userDetails.phone_number     | +919542348755                 |
      | userDetails.telegram_id      | @secondTelegram_id            |

    Then response code is 404

    And response body contains:
      | status                       | 404                               |
      | message                      | Resource not found                |
      | details                      | User not found with id: 1000      |