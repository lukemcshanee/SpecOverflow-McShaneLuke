# User Story: As a user, I should be able to register on the website.

Feature: Registration

  Rule: Registration data should be valid
    Scenario: User should be able to log in after registering successfully
      Given the user navigates to the home page
      When the user clicks on the registration section
      And the user inputs valid username "luke" and password "1234"
      Then the user will be directed to the login page

  Rule: Password must be at least 4 characters long
    Scenario: User should be able to register with a password of at least 4 characters in length
      Given the user navigates to the home page
      When the user clicks on the registration section
      And the user inputs less than four characters for the password
      Then the user verifies that an error message appears

