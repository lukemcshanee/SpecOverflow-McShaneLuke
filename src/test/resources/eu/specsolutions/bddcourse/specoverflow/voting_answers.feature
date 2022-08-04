# User Story: As a user, I should be able to vote answers.

Feature: Voting Answers

  Background:
    Given the user is on the home page
    When the user clicks on the questions section

  Rule: The questions should be listed by votes descending
    Scenario: Questions should be displayed based on the number of votes in descending order
      Then the user verifies that questions are listed in descending order

  Rule: Only authenticated users can vote
    Scenario: The system gives voting permissions only to authenticated users
      And the user clicks on the first question
      And the user clicks on the vote up button
      Then the user is verified, a pop-up message appears











