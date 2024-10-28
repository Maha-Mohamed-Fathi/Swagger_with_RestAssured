Feature:Scenario6

  Scenario Outline: Validate that the API throws an error when attempting to delete brand not exist
    Given Swagger API
    And Send a Delete request specific with "<brandID>"
    And Ensure that response status code is "<statusCode>" for delete not exist brand
    And Validate that the API throws an error when attempting to delete brand not exist return error "<responseErrorMessage>"
    Examples:
      | brandID | statusCode | responseErrorMessage   |
      | brandID | 422        | Unable to delete brand |