Feature:Scenario3

  Scenario Outline: Validate that the API prevents the creation of duplicate brand entries
    Given Swagger API
    And Send a Post request specific with "<brandName>"
    And Ensure that the response status code is "<statusCode>"
    And Validate that the API prevents the creation of duplicate brand entries and return error "<responseErrorMessage>"
    Examples:
      | brandName | statusCode | responseErrorMessage |
      | brandName | 422        | already exists       |