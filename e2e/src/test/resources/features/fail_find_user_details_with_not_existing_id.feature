Feature: Error while finding user details by user details id

  Scenario:
    Given User Profile Service is up and running

    And User Profile endpoint "/api/v1/users/user-contacts/{id}" with http method "GET" available

    When a client wants to find its contacts with id: 1000

    Then response code is 404

    And response body contains:
      | status                       | 404                                       |
      | message                      | Resource not found                        |
      | details                      | User Details not found with id: 1000      |