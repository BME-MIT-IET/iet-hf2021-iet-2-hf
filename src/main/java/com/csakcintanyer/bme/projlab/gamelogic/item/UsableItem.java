package com.csakcintanyer.bme.projlab.gamelogic.item;

import com.csakcintanyer.bme.projlab.gamelogic.map.IceBlock;

// az használható Item-eknek van Use függvényük is, erre van a UsableItem
public interface UsableItem
{
	// item használata
	boolean use(IceBlock block);
}
