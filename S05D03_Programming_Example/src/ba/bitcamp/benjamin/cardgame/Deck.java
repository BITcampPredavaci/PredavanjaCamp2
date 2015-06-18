package ba.bitcamp.benjamin.cardgame;

import java.util.Random;

public class Deck {

	private Card[] cards;
	private int numberOfDealtCards = 0;

	public Deck(boolean includeJokers) {
		if (includeJokers == true) {
			this.cards = new Card[54];
			cards[53] = new Card();
			cards[52] = new Card();
		} else {
			this.cards = new Card[52];
		}

		generateCards();
		shuffleCards();
	}

	private void generateCards() {
		int counter = 0;
		for (int j = Card.ACE; j <= Card.KING; j++) {
			cards[counter++] = new Card(j, Card.HEART);
			cards[counter++] = new Card(j, Card.CLUB);
			cards[counter++] = new Card(j, Card.SPADE);
			cards[counter++] = new Card(j, Card.DIAMOND);
		}
	}
	
	public void shuffleCards(){
		Random rand = new Random();
		for(int i = 0; i < cards.length; i++){
			int first = rand.nextInt(cards.length);
			int second = rand.nextInt(cards.length);
			Card temp = cards[first];
			cards[first] = cards[second];
			cards[second] = temp;
		}
	}
	
	public int remainingCards(){
		return cards.length - numberOfDealtCards;
	}
	
	public boolean isEmpty(){
		return remainingCards() == 0;
	}
	
	public Card dealCard(){
		if(isEmpty())
			throw new UnsupportedOperationException("Deck is empty");
		return cards[numberOfDealtCards++];
	}
	

}
