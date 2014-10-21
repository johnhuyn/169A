package com.main.room8.game.gameplay;

public class ArmourCard extends Card {
	
	private String Name;
	private int Health; // increases Hero Defenses - EHP (Effective Health Pool)
	private int AP; // AP cost of card
	private String Type = "Armour";
	
	public ArmourCard (String name, int health, int ap)
	{
		this.Name = name;
		this.Health = health;
		this.AP = ap;
	}
	
	////////////////////////////////Mutators///////////////////////////
	public void updateName(String newName)
	{
		this.Name = newName;
	}
	
	public void updateHealth(int newHealth)
	{
		this.Health = newHealth;
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
	
	public int getHealth()
	{
		return Health;
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
