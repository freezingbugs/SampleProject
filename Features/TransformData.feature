Feature: Data Transformation

Scenario: CSV and DB data validation
      Given Read CSV Data
      When  Initialize DB
      Then  Read DB Data
      And   Validation CSV with DB data
      Then  Test Execution
      