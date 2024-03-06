Feature: Error while updating non existing user details

  Scenario:
    Given User Profile Service is up and running

    And User Profile endpoint "/api/v1/users/user-contacts/{id}" with http method "PUT" available

    When a client wants to update its contacts 1000 to:
      | id                           | 1000                      |
      | phone_number                 | +919367785723             |
      | telegram_id                  | @secondTelegram_new_id    |


    Then response code is 404

    And response body contains:
      | status                       | 404                                                       |
      | message                      | Resource not found                                        |
      | details                      | User Details not found user details with user id: 1000    |