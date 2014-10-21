package com.main.room8.game.gameplay;

public class WeaponCard extends Card{
	
	private String Name; 
	private int Attack; // Weapon Damage
	private int AP; // Action Point Cost to use Card
	private String Type = "Weapon";
	
	public WeaponCard(String name, int Attack, int AP)
	{
		this.Name = name;
		this.Attack = Attack;
		this.AP = AP;
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
	
	public void updateAttack(int newAttack)
	{
		this.Attack = newAttack;
	}
	
	///////////////////////Accessors///////////////////////////////////
	public String getName()
	{
		return Name;
	}
	
	public int getAttack()
	{
		return Attack;
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
