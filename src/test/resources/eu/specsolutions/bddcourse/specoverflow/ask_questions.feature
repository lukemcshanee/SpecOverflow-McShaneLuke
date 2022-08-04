# User Story: As a user, I should be able to ask questions.

Feature: Ask Questions

  Background:
    Given the user is on the home page

  Rule: Only authenticated users can ask questions

    Scenario: Should be asked questions by only authenticated users
      When the user clicks on ask question section
      And the user completes the ask a question section
      Then a warning message appears

  Rule: Similar questions to the one being asked are suggested

    Scenario: Should be asked a similar question to the previous ones
      When the user is logged in
      And the user clicks on ask question section
      And the user completes the ask a question section
      Then a "What are the locators in Selenium?" message appears

