Feature: Create User successfully

  Scenario:

    Given User Profile Service is up and running

    And User Profile endpoint "/api/v1/users" with http method "POST" available

    When a client wants to create a user with mandatory parameters:
      | first_name                    | Nick                    |
      | last_name                     | Ward                    |
      | email                         | nickward@gmail.com      |
      | user_details.phone_number     | +923461788755           |
      | user_details.telegram_id      | @nick_ward              |

    Then response code is 200

    And response body contains:
      | first_name                    | Nick                    |
      | last_name                     | Ward                    |
      | email                         | nickward@gmail.com      |
      | user_details.phone_number     | +923461788755           |
      | user_details.telegram_id      | @nick_ward              |