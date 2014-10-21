package com.main.room8.game.gameplay;

public class EnemyCard extends Card 
{
	private String Name;
	private int Attack;
	private int Health;
	private int CHealth;
	private String Type = "Enemy";
	
	public EnemyCard (String name, int attack, int health)
	{
		this.Name = name;
		this.Attack = attack;
		this.Health = health;
		this.CHealth = health;
		
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
	
	public void updateCHealth(int newCHealth)
	{
		this.CHealth = newCHealth;
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
	
	public String getType()
	{
		return Type;
	}

	public void cardEffect ()
	{
		
	}
}
