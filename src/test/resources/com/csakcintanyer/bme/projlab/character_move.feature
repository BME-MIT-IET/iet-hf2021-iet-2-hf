Feature: Character can move between blocks
  We want to know how the characters can move between blocks

  Scenario: Character moves into stable block
    Given We have a 1 by 2 stable map
    And An eskimo is in the first block
    When The character moves right
    Then The character should be in the right block
    Then The character should drown
