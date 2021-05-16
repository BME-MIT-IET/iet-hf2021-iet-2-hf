package com.csakcintanyer.bme.projlab;

import com.csakcintanyer.bme.projlab.gamelogic.Game;
import com.csakcintanyer.bme.projlab.ui.View;

// játékmenetet futtató szál
public class GameThread extends Thread
{
	@Override
	public void run()
	{
		View.get().repaint();
		Game.get().start();
	}
}
