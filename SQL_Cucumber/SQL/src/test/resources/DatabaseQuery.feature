@dbQuery
Feature: Database Query

  Background:
    Given user connects to the database

  Scenario: user verified number of student table rows
    When user connects to the student table
    Then print the total row count and verify

  Scenario: user verified number of student table rows
    When user connects to the student table
    Then print the most expensive product and verify

  Scenario: user verified number of student table rows
    When user connects to the student table
    And change the product name in the first row
    And find average value of prices
    And write all of the table Urun
    And write all of the name big
    And write all of the name small
    And write all of the name only first letter big
    And write some values





