Feature: Basic Authentication
  Ensure the user can log into the application with an valid username and password

  Background:
    Given a web browser is on the add basic auth page

  Scenario: Cancel login
    When the user clicks the cancel button on the login dialog
    Then the dialog should be closed