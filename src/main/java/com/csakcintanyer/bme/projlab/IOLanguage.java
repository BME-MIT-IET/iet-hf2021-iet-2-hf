package com.csakcintanyer.bme.projlab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class IOLanguage
{
	// private constructor definition to hide the impicit public one
	private IOLanguage() {}

	// szerializált fájl betöltése
	public static void loadFile(String filePath)
	{
		IceMap iceMap = null;
		try ( // try-with-resources in Java
			FileInputStream file = new FileInputStream(filePath);
			ObjectInputStream in = new ObjectInputStream(file)
		)
		{
			// Reading the object from a file
			iceMap = (IceMap) in.readObject();
		}
		catch(IOException ex) { System.out.println("IOException is caught"); return; }
		catch(ClassNotFoundException ex) { System.out.println("ClassNotFoundException is caught"); return; }
		
		ArrayList<ArrayList<IceBlock>> blocks = iceMap.getBlocks();
		ArrayList<Character> characters = new ArrayList<>();
		Bear bear = null;
		for (ArrayList<IceBlock> row : blocks)
		{
			for (IceBlock iceBlock : row)
			{
				ArrayList<Entity> entities = iceBlock.getEntities();
				for (int k = 0; k < entities.size(); ++k)
				{
					Entity entity = iceBlock.getEntities().get(k);
					if (!(entity instanceof Bear))
						characters.add((Character) entity);
					else
						bear = (Bear) entity;
				}
			}
		}
		View.get().init(iceMap.N, iceMap.M);
		View.get().repaint();
		Game.get().init(iceMap, characters, bear);
	}
	
	// játékállá szerializálása
	public static void saveToFile(String filePath)
	{
		try (
			FileOutputStream file = new FileOutputStream(filePath);
			ObjectOutputStream out = new ObjectOutputStream(file);
		)
		{		
			// Method for serialization of object
			out.writeObject(Game.get().getIceMap());						
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
	}
}

