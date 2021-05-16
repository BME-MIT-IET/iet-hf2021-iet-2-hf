package com.csakcintanyer.bme.projlab.ui;

import com.csakcintanyer.bme.projlab.GameThread;
import com.csakcintanyer.bme.projlab.IOLanguage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MenuKeyEventListener implements KeyListener
{
	JFrame window; //MenuWindow
	public Thread thread; //GameThread
	
	
	//menü irányítása
	public void MenuAction(KeyEvent keyEvent)
	{
		Container view = window.getContentPane();
		MenuView menuView = (MenuView) view;
		
		switch (keyEvent.getKeyCode())
		{
			
			//Up/W - menüpont felfele
			case KeyEvent.VK_UP:
			case KeyEvent.VK_W:
				if (menuView.getCurrentMenuPoint() == View.get().newgameIconColored.getImage())
				{
					menuView.setCurrentMenuPoint(View.get().exitIconColored.getImage());
					menuView.setCurrentMenuPointx(350);
					menuView.setCurrentMenuPointy(600);
				}
				else if (menuView.getCurrentMenuPoint() == View.get().loadgameIconColored.getImage())
				{
					menuView.setCurrentMenuPoint(View.get().newgameIconColored.getImage());
					menuView.setCurrentMenuPointx(285);
					menuView.setCurrentMenuPointy(380);
				}
				else if (menuView.getCurrentMenuPoint() == View.get().exitIconColored.getImage())
				{
					menuView.setCurrentMenuPoint(View.get().loadgameIconColored.getImage());
					menuView.setCurrentMenuPointx(265);
					menuView.setCurrentMenuPointy(500);
				}
				break;
			
			//Down/S - menüpont lefele
			case KeyEvent.VK_DOWN:
			case KeyEvent.VK_S:
				if (menuView.getCurrentMenuPoint() == View.get().newgameIconColored.getImage())
				{
					menuView.setCurrentMenuPoint(View.get().loadgameIconColored.getImage());
					menuView.setCurrentMenuPointx(265);
					menuView.setCurrentMenuPointy(500);
				}
				else if (menuView.getCurrentMenuPoint() == View.get().loadgameIconColored.getImage())
				{
					menuView.setCurrentMenuPoint(View.get().exitIconColored.getImage());
					menuView.setCurrentMenuPointx(350);
					menuView.setCurrentMenuPointy(600);
				}
				else if (menuView.getCurrentMenuPoint() == View.get().exitIconColored.getImage())
				{
					menuView.setCurrentMenuPoint(View.get().newgameIconColored.getImage());
					menuView.setCurrentMenuPointx(285);
					menuView.setCurrentMenuPointy(380);
				}
				break;
			
			//Enter - menüpont kiválasztása
			case KeyEvent.VK_ENTER:
				//Startgame - új játék indítása
				if (menuView.getCurrentMenuPoint() == View.get().newgameIconColored.getImage())
				{
					Windows.get().inputWindow.setVisible(true);
				}
				
				//Loadgame - pálya betöltés és játék indítása
				if (menuView.getCurrentMenuPoint() == View.get().loadgameIconColored.getImage())
				{
					window.setVisible(false);
					IOLanguage.loadFile("lastSavedGameState.txt");
					thread = new GameThread();
					thread.start();
				}
				
				//Exit - program bezárása
				if (menuView.getCurrentMenuPoint() == View.get().exitIconColored.getImage())
				{
					System.exit(0);
				}
				break;
			default:
			
		}
	}
	
	public MenuKeyEventListener(JFrame window)
	{
		this.window = window;
	}
	
	@Override
	public void keyTyped(KeyEvent keyEvent)
	{
		// not used
	}
	
	@Override
	public void keyPressed(KeyEvent keyEvent)
	{
		// not used
	}
	
	@Override
	public void keyReleased(KeyEvent keyEvent)
	{
		MenuAction(keyEvent);
		window.repaint();
	}
}
