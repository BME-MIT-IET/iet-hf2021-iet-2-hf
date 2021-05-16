package com.csakcintanyer.bme.projlab.ui;

import com.csakcintanyer.bme.projlab.ui.MenuKeyEventListener;
import com.csakcintanyer.bme.projlab.ui.MenuView;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class MenuWindow extends JFrame
{
	public MenuWindow()
	{
		super("Menu");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);
		
		setContentPane(new MenuView());
		pack();
		setLocationRelativeTo(null);
		
		MenuKeyEventListener listener = new MenuKeyEventListener(this);
		addKeyListener(listener);
	}
}

