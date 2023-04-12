Feature: Home Page

Scenario: Home page validation
      Given  User Launch Chrome browser
      When   User opens URL "http://reqres.in"
      Then   Page Title should be "Reqres - A hosted REST-API ready to respond to your AJAX requests"
      And    Click on "SINGLE USER NOT FOUND"
      And    Close browser 