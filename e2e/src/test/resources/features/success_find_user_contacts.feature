Feature: Find user contacts by id

  Scenario:
    Given User Profile Service is up and running

    And User Profile endpoint "/api/v1/users/user-contacts/{id}" with http method "GET" available

    When a client wants to find its contacts with id: 1

    Then response code is 200

    And response body contains:
      | id                           | 1                     |
      | phone_number                 | +919367788755         |
      | telegram_id                  | @firstTelegram_id     |
