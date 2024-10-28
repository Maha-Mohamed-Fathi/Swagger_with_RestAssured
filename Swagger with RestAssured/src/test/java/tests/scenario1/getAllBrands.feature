Feature:Scenario1

  Scenario Outline: Get All Brands
    Given Swagger API
    And Send a GET request to the brands endpoint
    And Ensure the response status code is "<statusCode>"
    And Check that the list of brands has more than one entry
    And Validate that each brand object contains _id and name properties

    Examples:
      | statusCode |
      | 200        |



