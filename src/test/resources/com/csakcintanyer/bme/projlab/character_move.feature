Feature: Character can move between blocks
  We want to know how the characters can move between blocks

  Scenario: Character moves into a stable block
    Given We have a 1 by 2 stable map, with 0 layer of snow
    And An eskimo is in the first block
    When The character moves right
    Then The character should be in the right block
    Then The character shouldn't drown

  Scenario: Character moves into an empty block and starts to drowning
    Given We have a map with a stable and an empty block
    And An eskimo is in the first block
    When The character moves right
    Then The character should be in the right block
    Then The character starts drowning

  Scenario: Character moves into an unstable block, the block breaks, and the player starts drowning
    Given We have an unstable map
    And An eskimo is in the first block
    And There is another eskimo in the second block
    When The character moves right
    Then The character should be in the right block
    And The unstable block should brake
    And The character starts drowning
