package com.csakcintanyer.bme.projlab;

import io.cucumber.java.an.E;
import io.cucumber.java.bs.A;
import io.cucumber.java.bs.I;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

public class Stepdefs {
    private Game game = Game.get();
    private IceMap map;
    private ArrayList<Character> characters = new ArrayList<Character>();
    private Character character;


    @Given("We have a {int} by {int} stable map")
    public void we_have_a_by_stable_map(Integer int1, Integer int2) {
        ArrayList<IceBlock> rowBlocks;
        ArrayList<ArrayList<IceBlock>> blocks = new ArrayList<ArrayList<IceBlock>>();

        for(int i = 0; i < int1; i++){
            rowBlocks = new ArrayList<IceBlock>();
            for(int y = 0; y < int2; y++){
                rowBlocks.add(new StableBlock(0));
            }
            blocks.add(rowBlocks);
        }

        map = new IceMap(blocks);
    }

    @Given("An eskimo is in the first block")
    public void an_eskimo_is_in_the_first_block() {
        Eskimo eskimo = new Eskimo(0);
        characters.add(eskimo);
        character = eskimo;

        eskimo.setIceBlock(map.getBlocks().get(0).get(0));
        map.getBlocks().get(0).get(0).getEntities().add(eskimo);

        game.init(map, characters, null);
    }

    @Given("An explorer is in the first block")
    public void an_explorer_is_in_the_first_block() {
        Explorer explorer = new Explorer(0);
        characters.add(explorer);
        character = explorer;

        explorer.setIceBlock(map.getBlocks().get(0).get(0));
        map.getBlocks().get(0).get(0).getEntities().add(explorer);

        game.init(map, characters, null);
    }

    @When("The character moves right")
    public void the_character_moves_right() {
        character.move(Direction.RIGHT);
    }

    @Then("The character should be in the right block")
    public void the_character_should_be_in_the_right_block() {
        assertEquals(character.getBlock(), map.getBlocks().get(0).get(1));
    }

    @Then("The character should drown")
    public void the_character_should_drown() {
        assertEquals(character.isDrowning(), false);
    }

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
}

