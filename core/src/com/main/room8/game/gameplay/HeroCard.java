package com.main.room8.game.gameplay;

public class HeroCard extends Card
{
	
	private String Name; // name of Card
	private int Attack; // Base Attack Damage of Hero
	private int Health; // Max Health Pool of Hero
	private int CHealth; // Current Health of Hero
	private int AP; // Max Action Points Pool
	private int CAP; // Current Action Points
	private String Type = "Hero";
	
	public HeroCard(String Name, int Attack,int Health, int AP)
	{
		this.Name = Name;
		this.Attack = Attack;
		this.Health = Health;
		this.AP = AP;
		this.CAP = AP;
		this.CHealth = Health;
	}
	
	//////////////////////////////// Mutators///////////////////////////
	public void updateName(String newName)
	{
		this.Name = newName;
	}
	
	public void updateHealth(int newHealth)
	{
		this.Health = newHealth;
	}
	
	public void updateCHealth(int newCHealth)
	{
		this.CHealth = newCHealth;
	}
	
	public void updateAP(int newAP)
	{
		this.AP = newAP;
	}
	
	public void updateCAP(int newCAP)
	{
		this.CAP = newCAP;
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
	
	public int getHealth()
	{
		return Health;
	}
	
	public int getCHealth()
	{
		return CHealth;
	}
	
	public int getAttack()
	{
		return Attack;
	}
	
	public int getCAP()
	{
		return CAP;
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
