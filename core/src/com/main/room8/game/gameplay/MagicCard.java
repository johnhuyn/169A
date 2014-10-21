package com.main.room8.game.gameplay;

public class MagicCard extends Card 
{
	private String Name;
	private int AP;
	private String Type = "Magic";
	
	public MagicCard (String name, int ap)
	{
		this.Name = name;
		this.AP = ap;
	}
	
	////////////////////////////////Mutators///////////////////////////
	
	public void updateName(String newName)
	{
			this.Name = newName;
	}
	
	public void updateAP(int newAP)
	{
		this.AP = newAP;
	}
	
	///////////////////////Accessors///////////////////////////////////
	public String getName()
	{
		return Name;
	}
	
	public int getAP()
	{
		return AP;
	}
	
	public String getType()
	{
		return Type;
	}
	
	public void cardEffect()
	{
		
	}
}
