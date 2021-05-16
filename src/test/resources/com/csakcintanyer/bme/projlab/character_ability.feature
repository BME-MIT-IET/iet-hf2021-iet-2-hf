Feature: Characters can use their abilities
  We want to see if the Eskimo can build an igloo and if the Explorer can inspect a block's stability

  Scenario: Eskimo place an Igloo into a stable block
    Given We have a 1 by 1 stable map, with 0 layer of snow
    And An eskimo is in the first block
    When Eskimo place an Igloo
    Then An Igloo is on the block

  Scenario: Explorer inspects a stable block
    Given We have a 1 by 2 stable map, with 0 layer of snow
    And An explorer is in the first block
    When The character moves right
    And Explorer inspects a block on his left
    Then The block is checked