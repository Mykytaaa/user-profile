Feature: Find a user by id

  Scenario:
    Given User Profile Service is up and running

    And User Profile endpoint "/api/v1/users/{id}" with http method "GET" available

    When a client wants to find a user with id: 1

    Then response code is 200

    And response body contains:
      | id                           | 1                     |
      | first_name                   | John                  |
      | last_name                    | Walsh                 |
      | email                        | johnwalsh@example.com |
      | userDetails.id               | 1                     |
      | userDetails.phone_number     | +919367788755         |
      | userDetails.telegram_id      | @firstTelegram_id     |