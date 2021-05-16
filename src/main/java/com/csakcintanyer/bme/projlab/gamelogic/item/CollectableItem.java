package com.csakcintanyer.bme.projlab.gamelogic.item;

import com.csakcintanyer.bme.projlab.ui.Drawable;
import com.csakcintanyer.bme.projlab.gamelogic.entity.character.Character;

import java.io.Serializable;

/**
 * @author zsoko
 *A CollectableItem-eket nem lehet "felvenni" az inventoryba, ezek egyből felhasználódnak
 */

public abstract class CollectableItem implements Serializable, Drawable
{
    // felvettünk egy itemet.
    public abstract void interactWithCharacter(Character c) throws IllegalArgumentException;
}
