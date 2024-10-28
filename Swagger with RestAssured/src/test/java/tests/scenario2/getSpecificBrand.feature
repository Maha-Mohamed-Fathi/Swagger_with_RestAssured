Feature:Scenario2

  Scenario Outline: Get Specific Brand
    Given Swagger API
    And Send a GET request specific with "<brandID>"
    And Ensure that response status code is "<statusCode>"
    And Validate that the brand's name matches the expected value
    Examples:
      | brandID | statusCode |
      | brandID | 200        |



