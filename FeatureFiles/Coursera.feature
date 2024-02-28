Feature: Coursera project

  Scenario: Getting data of courses
    Given launched the browser and open url
    When search Course
    And select language
    And select level
    Then Getting data of courses

  Scenario: Printing the list of Languages and Levels
    Given Gettig the list of languages
    When Click on apply button
    Then getting list of levels

  Scenario: Fill the form with invalid emailid
    Given get back to home page
    When Click on For Enterprises
    And Click on Soltions
    And Click on For Campus
    And Fill the form
    And Submit the form
    Then Capture the Error Message
    
