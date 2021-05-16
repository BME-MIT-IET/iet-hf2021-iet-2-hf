package com.csakcintanyer.bme.projlab;

import static junit.framework.Assert.assertEquals;

import java.util.ArrayList;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdefs {
    private Game game = Game.get();
    private IceMap map;
    private ArrayList<Character> characters = new ArrayList<Character>();
    private Character character;

    /**
     * Initalization steps
     */

    @Given("We have a {int} by {int} stable map, with {int} layer of snow")
    public void we_have_a_by_stable_map_with_layer_of_snow(Integer int1, Integer int2, Integer int3) {
        ArrayList<IceBlock> rowBlocks;
        ArrayList<ArrayList<IceBlock>> blocks = new ArrayList<ArrayList<IceBlock>>();

        for(int i = 0; i < int1; i++){
            rowBlocks = new ArrayList<IceBlock>();
            for(int y = 0; y < int2; y++){
                rowBlocks.add(new StableBlock(int3));
            }
            blocks.add(rowBlocks);
        }

        map = new IceMap(blocks);
    }

    @Given("We have an unstable map")
    public void we_have_an_unstable_map() {
        ArrayList<IceBlock> rowBlocks =new ArrayList<IceBlock>();
        ArrayList<ArrayList<IceBlock>> blocks = new ArrayList<ArrayList<IceBlock>>();

        rowBlocks.add(new UnstableBlock(0, 1));
        rowBlocks.add(new UnstableBlock(0, 1));

        blocks.add(rowBlocks);
        map = new IceMap(blocks);
    }

    @Given("We have a map with a stable and an empty block")
    public void we_have_a_map_with_a_stable_and_an_empty_block() {
        ArrayList<IceBlock> rowBlocks =new ArrayList<IceBlock>();
        ArrayList<ArrayList<IceBlock>> blocks = new ArrayList<ArrayList<IceBlock>>();

        rowBlocks.add(new StableBlock(0));
        rowBlocks.add(new EmptyBlock(0));

        blocks.add(rowBlocks);
        map = new IceMap(blocks);
    }

    @Given("An eskimo is in the first block")
    public void an_eskimo_is_in_the_first_block() {
        Eskimo eskimo = new Eskimo(0);
        characters.add(eskimo);
        character = eskimo;
        character.setEnergy(40);

        eskimo.setIceBlock(map.getBlocks().get(0).get(0));
        map.getBlocks().get(0).get(0).getEntities().add(eskimo);

        game.init(map, characters, null);
    }

    @Given("An explorer is in the first block")
    public void an_explorer_is_in_the_first_block() {
        Explorer explorer = new Explorer(0);
        characters.add(explorer);
        character = explorer;
        character.setEnergy(40);

        explorer.setIceBlock(map.getBlocks().get(0).get(0));
        map.getBlocks().get(0).get(0).getEntities().add(explorer);

        game.init(map, characters, null);
    }

    @Given("There is another eskimo in the second block")
    public void there_is_another_eskimo_in_the_second_block() {
        Eskimo eskimo = new Eskimo(1);
        characters.add(eskimo);

        eskimo.setIceBlock(map.getBlocks().get(0).get(1));
        map.getBlocks().get(0).get(1).getEntities().add(eskimo);

        game.init(map, characters, null);
    }

    /**
     * Character Move steps
     */

    @When("The character moves right")
    public void the_character_moves_right() {
        character.move(Direction.RIGHT);
    }

    @Then("The character should be in the right block")
    public void the_character_should_be_in_the_right_block() {
        assertEquals(character.getBlock(), map.getBlocks().get(0).get(1));
    }

    /**
     * Drowning assertion steps
     */

    @Then("The character shouldn't drown")
    public void the_character_shouldnt_drown() {
        assertEquals(character.isDrowning(), false);
    }

    @Then("The character starts drowning")
    public void the_character_starts_drowning() {
        assertEquals(character.isDrowning(), true);
    }

    @Then("The unstable block should brake")
    public void the_unstable_block_should_brake() {
        assertEquals(map.getBlocks().get(0).get(1).getStability(), 0);
    }

    /**
     * Ability steps
     */

    @When("Eskimo place an Igloo")
    public void eskimo_place_an_igloo() {
        character.useAbility();
    }

    @Then("An Igloo is on the block")
    public void an_igloo_is_on_the_block() {
        assertEquals(map.getBlocks().get(0).get(0).hasIgloo(), true);
    }

    @When("Explorer inspects a block on his left")
    public void explorer_inspects_a_block() {
        character.useAbility();
    }

    @Then("The block is checked")
    public void the_block_is_checked() {
        assertEquals(map.getBlocks().get(0).get(0).isChecked(), true);
    }

    /**
     * Item using steps
     */

    @Given("A shovel is placed in the first block")
    public void a_shovel_is_placed_in_the_first_block() {
        map.getBlocks().get(0).get(0).setItem(new Shovel());
    }

    @Given("A fragile shovel is placed in the first block")
    public void a_fragile_shovel_is_placed_in_the_first_block() {
        map.getBlocks().get(0).get(0).setItem(new FragileShovel());
    }

    @Given("A tent is placed in the first block")
    public void a_tent_is_placed_in_the_first_block() {
        map.getBlocks().get(0).get(0).setItem(new Tent());
    }

    @When("The character clears the snow {int} times by hand")
    public void the_character_clears_the_snow_times_by_hand(Integer int1) {
        for (int i = 0; i < int1; i++){
            character.clear();
        }
    }

    @When("The character use the picked up item")
    public void the_character_use_the_picked_up_item() {
        character.useItem(0);
    }

    @Then("second block should be without snow")
    public void second_block_should_be_without_snow() {
        assertEquals(map.getBlocks().get(0).get(0).getSnow(), 0);
    }

    @Then("The fragile shovel should brake")
    public void the_fragile_shovel_should_brake() {
        assertEquals(character.getInventory().isEmpty(), true);
    }

    @Then("The first block should have a tent")
    public void the_first_block_should_have_a_tent() {
        assertEquals(map.getBlocks().get(0).get(0).hasTent(), true);
    }

    /**
     * Game winning steps
     */

    @Given("The items for win the game are placed on each block")
    public void the_items_for_win_the_game_are_placed_on_each_block() {
        map.getBlocks().get(0).get(0).setItem(new Flare());
        map.getBlocks().get(0).get(1).setItem(new Bullet());
        map.getBlocks().get(0).get(2).setItem(new Gun());
    }


    @Given("One winning item is not, but other winning items are placed on each block")
    public void one_winning_item_is_not_but_other_winning_items_are_placed_on_each_block() {
        //The missing piece is a flare in the first block
        map.getBlocks().get(0).get(1).setItem(new Bullet());
        map.getBlocks().get(0).get(2).setItem(new Gun());
    }

    @When("The character picks up the item")
    public void the_character_picks_up_the_item() {
        character.pickUp();
    }

    @When("The character fires the gun")
    public void the_character_fires_the_gun() {
        character.useItem(0);
    }

    @Then("The player should have won")
    public void the_player_should_have_won() {
        assertEquals(game.isWin(), true);
    }

    @Then("The player haven't won yet")
    public void the_player_haven_t_won_yet() {
        assertEquals(game.isWin(), false);
    }
}

