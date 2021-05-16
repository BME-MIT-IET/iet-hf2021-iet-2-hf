Feature: The player use several items
  The character can use several items to help him win the game

  Scenario: Characters uses a shovel to clear 2 layers of snow
    Given We have a 1 by 2 stable map, with 2 layer of snow
    And A shovel is placed in the first block
    And An eskimo is in the first block
    When The character clears the snow 2 times by hand
    And The character picks up the item
    And The character moves right
    And The character use the picked up item
    Then second block should be without snow

  Scenario: Characters uses a fragile shovel to clear 6 layers of snow, and the fragile shovel breaks
    Given We have a 1 by 2 stable map, with 6 layer of snow
    And A fragile shovel is placed in the first block
    And An eskimo is in the first block
    When The character clears the snow 6 times by hand
    And The character picks up the item
    And The character moves right
    And The character use the picked up item
    And The character use the picked up item
    And The character use the picked up item
    Then second block should be without snow
    And The fragile shovel should brake

  Scenario: Character uses tent on a stable block
    Given We have a 1 by 1 stable map, with 0 layer of snow
    And A tent is placed in the first block
    And An eskimo is in the first block
    When The character picks up the item
    And The character use the picked up item
    Then The first block should have a tent