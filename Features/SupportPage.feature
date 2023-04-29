Feature: Support Page

Scenario: Support page validation
      Given  User Launch Chrome browser
      Then   Maximize window
      When   User opens URL "https://reqres.in"
      When   Click on Support Reqres button
      When   Verify one-time & monthly support options are present
      When   Verify upgrade button is present
      Then   Close browser 