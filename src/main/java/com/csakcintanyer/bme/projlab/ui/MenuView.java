package com.csakcintanyer.bme.projlab.ui;

import javax.swing.*;
import java.awt.*;

//Menü kirajzolása
public class MenuView extends JPanel
{
	
	//Kiválasztott menüpont nyilvántartása
	private Image currentMenuPoint = View.get().newgameIconColored.getImage();
	private int currentMenuPointx = 285;
	private int currentMenuPointy = 380;
	
	public void setCurrentMenuPointx(int currentMenuPointx)
	{
		this.currentMenuPointx = currentMenuPointx;
	}
	
	public void setCurrentMenuPointy(int currentMenuPointy)
	{
		this.currentMenuPointy = currentMenuPointy;
	}
	
	public Image getCurrentMenuPoint()
	{
		return currentMenuPoint;
	}
	
	public void setCurrentMenuPoint(Image image)
	{
		currentMenuPoint = image;
	}
	
	@Override
	public Dimension getPreferredSize()
	{
		return new Dimension(860, 960);
	}
	
	public void draw(Image image, int x, int y, Graphics g)
	{
		g.drawImage(image, x, y, this);
	}
	
	//Menü kirajzolása
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
		draw(View.get().backgroundIcon.getImage(), 0, 0, g);
		draw(View.get().titleIcon.getImage(), 72, 175, g);
		draw(View.get().menuIceBlockIcon.getImage(), 230, 330, g);
		draw(View.get().newgameIcon.getImage(), 285, 380, g);
		draw(View.get().loadgameIcon.getImage(), 265, 500, g);
		draw(View.get().exitIcon.getImage(), 350, 600, g);
		draw(View.get().menuBearIcon.getImage(), 61, 790, g);
		draw(getCurrentMenuPoint(), currentMenuPointx, currentMenuPointy, g);
	}
}
