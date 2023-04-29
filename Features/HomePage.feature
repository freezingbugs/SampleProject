Feature: Home Page

Scenario: Home page validation
      Given  User Launch Chrome browser
      Then   Maximize window
      When   User opens URL "https://reqres.in"
      Then   Maximize window      
      Then   Click on SINGLE USER NOT FOUND
      Then   Verify Request 
      Then   Verify Response
      And    Validate support button is displayed 
      Then   Close Browser 
      
      

      