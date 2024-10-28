Feature:Scenario4

  Scenario Outline: Validate API returns error when attempting to retrieve brand that doesn't exist
    Given Swagger API
    And Send a GET request specific with "<brandID>"
    And Ensure that response status code is "<statusCode>"
    And Validate API returns error with "<responseErrorMessage>"when attempting to retrieve brand that doesn't exist
    Examples:
      | brandID | statusCode | responseErrorMessage  |
      | brandID | 422        | Unable to fetch brand |