package com.main.room8.game.gameplay;

import java.util.ArrayList;
import java.util.Random;

public class Player {

	private HeroCard Avatar;
	private int deckLimit = 60;
	private int currentDeckSize;
	private ArrayList<Card> deck;
	private ArrayList<Card> depletionPile;
	private ArrayList<Card> hand;
	
	public Player ()
	{
		this.deck = new ArrayList<Card>();
		this.depletionPile = new ArrayList<Card>();
		this.hand = new ArrayList<Card>();
		currentDeckSize = 0;
	}
	
	/////////////////////////// Actions /////////////////////////
	
	
	// function : addCard
	// @param: Card newCard - a new card to be added to the player's deck
	// Effect : adds a new card to a player's deck unless they are at the deck limit.
	public void addCard(Card newCard)
	{
		if(currentDeckSize < deckLimit)
		{
			deck.add(newCard);
			currentDeckSize += 1;
		}
	}
	
	// function : drawCard
	// Effect: draws a random card from the player's deck and adds it to the players hand 
	// and removes it from their deck after
	public void drawCard()
	{
		if(currentDeckSize > 0)
		{
			Random r = new Random();
			int random = r.nextInt(currentDeckSize);
			hand.add(deck.get(random));
			deck.remove(random);
		
		}
		else // out of cards, what do?
		{
			
		}
	}
	
	// function: playCard
	// @param: card - selected card from player's hand to be played
	// Effect: plays the card from the players hand, then removes it and adds it to 
	// depletionPile.
	public void playCard(Card card)
	{
		card.cardEffect(); // does something?
		this.hand.remove(card);
		this.depletionPile.add(card);
	}
	
	/////////////////////////// Mutator /////////////////////////
	public void updateHero(HeroCard hero)
	{
		this.Avatar = hero;
	}
	
	public void updateDeckLimit( int newDeckLimit)
	{
		this.deckLimit = newDeckLimit;
	}
	
	
	/////////////////////////// Accessor ////////////////////////
	public int getPlayerHealth()
	{
		return Avatar.getCHealth();
	}
	
	public int getCurrentDeckSize()
	{
		return this.currentDeckSize;
	}
	
	public ArrayList<Card> getPlayerHand()
	{
		return this.hand;
	}
	
	public int getDepletionCount()
	{
		return this.depletionPile.size();
	}
}
