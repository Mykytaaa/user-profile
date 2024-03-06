Feature: Find a user by id

  Scenario:
    Given User Profile Service is up and running

    And User Profile endpoint "/api/v1/users/{id}" with http method "GET" available

    When a client wants to find a user with id: 1000

    Then response code is 404

    And response body contains:
      | status                       | 404                               |
      | message                      | Resource not found                |
      | details                      | User not found with id: 1000      |