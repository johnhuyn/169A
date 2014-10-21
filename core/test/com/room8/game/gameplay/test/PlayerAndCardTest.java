package com.room8.game.gameplay.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import com.main.room8.game.gameplay.*;

import org.junit.Before;
import org.junit.Test;

public class PlayerAndCardTest {

	Player tester;
	HeroCard hero;
	WeaponCard weapon;
	ArmourCard armour;
	MagicCard magic;
	
	@Before
	public void setUpTest()
	{
		tester = new Player();
		hero = new HeroCard("SumNoob",9000,10,1);
		weapon = new WeaponCard("GenericSword", 1000, 1);
		armour = new ArmourCard("Golden Armour", 25, 1);
		magic = new MagicCard("Silent Fart", 0);
	}
	
	@Test
	public void testPlayerAndCards()
	{
		tester.updateHero(hero);
		assertEquals(10, tester.getPlayerHealth());
		tester.addCard(weapon);
		tester.addCard(armour);
		tester.addCard(magic);
		assertEquals(3, tester.getCurrentDeckSize());
		tester.drawCard();
		tester.drawCard();
		tester.drawCard();
		ArrayList<Card> temp = tester.getPlayerHand();
		for (int i = 0; i < temp.size(); i ++)
		{
			String name = temp.get(i).getName();
			String type = temp.get(i).getType();
			int attack = 0;
			int ap = 0;
			int health = 0;
			if(type.equals("Weapon"))
			{
				WeaponCard tempWeap = (WeaponCard) temp.get(i);
				attack = tempWeap.getAttack();
				ap = tempWeap.getAP();
			}
			else if(type.equals("Armour"))
			{
				ArmourCard tempArmour = (ArmourCard) temp.get(i);
				health = tempArmour.getHealth();
				ap = tempArmour.getAP();
			}
			else if(type.equals("Magic"))
			{
				MagicCard tempMagic = (MagicCard) temp.get(i);
				ap = tempMagic.getAP();
			}
			
			System.out.println(name + ": " + type);
			System.out.println("    Attack: " + attack + " AP: " + ap + " Health: " + health);
		}
		
	}
}
