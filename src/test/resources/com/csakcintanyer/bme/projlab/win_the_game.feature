Feature: The player wins the game if fires the gun with all it's parts
    After having all the components and firing the gun the player wins the game

  Scenario: Characters has all the parts and fires the gun
    Given We have a 1 by 3 stable map, with 0 layer of snow
    And The items for win the game are placed on each block
    And An eskimo is in the first block
    When The character picks up the item
    And  The character moves right
    And The character picks up the item
    And  The character moves right
    And The character picks up the item
    And The character fires the gun
    Then The player should have won

  Scenario: Characters doesn't have all the parts and fires the gun
    Given We have a 1 by 3 stable map, with 0 layer of snow
    And One winning item is not, but other winning items are placed on each block
    And An eskimo is in the first block
    When The character picks up the item
    And  The character moves right
    And The character picks up the item
    And  The character moves right
    And The character picks up the item
    And The character fires the gun
    Then The player haven't won yet