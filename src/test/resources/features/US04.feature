Feature: Retrieve all the characters

  Scenario: Retain and validate all the character
    Given API sends the request to this "https://thronesapi.com/api/v2/Characters" end point
    When API sends a request you expect the status code to be 200
    And Retrieve all the data from path id=1

