Feature: The player wins the game and it ends
    After having all the components and firing the gun the player wins the game

  Scenario: Character moves into stable block
    Given We have a 1 by 3 stable map
    And The items for win the game are placed on each block
    And An eskimo is in the first block
    When The character picks up the item
    And  The character moves right
    And The character picks up the item
    And  The character moves right
    And The character picks up the item
    And The character fires the gun
    Then The player should have won