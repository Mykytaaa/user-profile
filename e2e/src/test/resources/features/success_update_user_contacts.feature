Feature: Update a user

  Scenario:
    Given User Profile Service is up and running

    And User Profile endpoint "/api/v1/users/user-contacts/{id}" with http method "PUT" available

    When a client wants to update its contacts 2 to:
      | id                           | 2                         |
      | phone_number                 | +919367785723             |
      | telegram_id                  | @secondTelegram_new_id    |


    Then response code is 200

    And response body contains:
      | id                           | 2                         |
      | phone_number                 | +919367785723             |
      | telegram_id                  | @secondTelegram_new_id    |