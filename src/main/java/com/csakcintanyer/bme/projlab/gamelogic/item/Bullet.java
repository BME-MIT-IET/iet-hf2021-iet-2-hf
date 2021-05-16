package com.csakcintanyer.bme.projlab.gamelogic.item;

import com.csakcintanyer.bme.projlab.gamelogic.entity.character.Character;
import com.csakcintanyer.bme.projlab.ui.View;

public class Bullet extends CollectableItem // csak gyűjthető
{
    public void interactWithCharacter(Character c)
    {
        /* ezzel a függvénnyel mondjuk meg a karakternek, hogy mostantól nála van a Bullet
         * Bulletből az egész játék során csak egy példány van
         */
        c.setHasBullet();
    }
    
    // Bullet kirajzolása
    public void draw(int x, int y)
    {
        View view = View.get();
        view.draw(view.bulletIcon, x, y);
    }
    
    // kiiráshoz kell
    public String toString()
    {
        return "bullet";
    }
}
