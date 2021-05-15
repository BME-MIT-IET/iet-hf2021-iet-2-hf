Feature: The character steps on an empty block
  We want to see if the character drowning after steps on an empty block

  Scenario: The character drowns after step on an empty block
    Given We have an unstable map
    And An eskimo is in the first block
    When The character moves right
    Then The character starts drowning
