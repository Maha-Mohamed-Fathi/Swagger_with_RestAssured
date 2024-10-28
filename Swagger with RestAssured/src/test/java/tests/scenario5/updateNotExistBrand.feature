Feature:Scenario5

  Scenario Outline: Validate that the API throws an error when attempting to update brand not exist
    Given Swagger API
    And Send a Put request specific with "<brandID>" and "<brandName>"
    And Ensure that the response status code is "<statusCode>" for update brand
    And Validate that the API throws an error when attempting to update brand not exist return error "<responseErrorMessage>"
    Examples:
      | brandID | brandName | statusCode | responseErrorMessage    |
      | brandID | brandName | 422        | Unable to update brands |