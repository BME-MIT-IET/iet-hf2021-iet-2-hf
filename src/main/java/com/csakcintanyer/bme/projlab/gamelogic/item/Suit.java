package com.csakcintanyer.bme.projlab.gamelogic.item;

import com.csakcintanyer.bme.projlab.gamelogic.entity.character.Character;
import com.csakcintanyer.bme.projlab.ui.View;

public class Suit extends CollectableItem
{
    public void interactWithCharacter(Character c)
    {
        // a karakter felvett egy Suit-ot.
        c.setHasSuit();
    }
    
    // suit kirajzolása
    public void draw(int x, int y)
    {
        View view = View.get();
        view.draw(view.suitIcon, x, y);
    }
    
    // kiíráshoz kell
    public String toString()
    {
        return "suit";
    }
}
