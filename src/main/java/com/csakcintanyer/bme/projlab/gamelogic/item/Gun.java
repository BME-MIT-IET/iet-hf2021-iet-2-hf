package com.csakcintanyer.bme.projlab.gamelogic.item;
import com.csakcintanyer.bme.projlab.gamelogic.entity.Entity;
import com.csakcintanyer.bme.projlab.gamelogic.Game;
import com.csakcintanyer.bme.projlab.gamelogic.entity.character.Character;
import com.csakcintanyer.bme.projlab.gamelogic.map.IceBlock;
import com.csakcintanyer.bme.projlab.ui.View;

import java.util.ArrayList;

public class Gun extends CollectableItem implements UsableItem
{
    // az item használata
    public boolean use(IceBlock block)
    {
        boolean hasFlare = false, hasBullet = false;
        ArrayList<Entity> entities = block.getEntities();
        // megnézzük, hogy az ezen a blockon lévő játékosoknál van-e a Flare és a Bullet.
        for (Entity e : entities)
        {
            if (!hasFlare)
                hasFlare = e.hasFlare();
            if (!hasBullet)
                hasBullet = e.hasBullet();
        }
        // ha mindkettő megvan, akkor el tudjuk sütni a fegyvert, nyertünk
        if (hasBullet && hasFlare && Game.get().getNumOfCharacters() == block.getEntities().size())
        {
            Game.get().win();
        }
        else
        {
            throw new IllegalArgumentException("Cannot use gun");
        }
        
        return false;
    }
    
    // gun kirajzolása
    public void draw(int x, int y)
    {
        View view = View.get();
        view.draw(view.gunIcon, x, y);
    }
    
    // kiíráshoz kell
    public String toString()
    {
        return "gun";
    }
    
    public void interactWithCharacter(Character c)
    {
        c.addItem(this); // inventoryhoz adjuk az itemet, mert UsableItem
    }
}
