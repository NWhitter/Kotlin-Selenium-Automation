Feature: Add remove elements
  Ensure the user can add and remove buttons from the page

  Background:
    Given a web browser is on the add remove elements page

  Scenario Outline: Add buttons
    When the user clicks on the add element button <clicks> times
    Then <clicks> delete element buttons should be displayed

    Examples: Buttons
      | clicks |
      | 1      |
      | 4      |
      | 10     |

  Scenario Outline: Remove buttons
    And the user adds <addClicks> delete buttons
    When the user clicks the delete button <deleteClicks> times
    Then <buttonsLeft> delete element buttons should be displayed

    Examples: Buttons
      | addClicks | deleteClicks | buttonsLeft |
      | 1         | 1            | 0           |
      | 4         | 2            | 2           |