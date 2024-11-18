package co.edu.poli.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Board {
	private Card[] cards;
	private int uncoveredCards = 0;
	private String size;
	
	// Constantes asociadas a los posibles tamanos del tablero
	public final static String BOARD_SIZE_EASY = "easy";
	public final static String BOARD_SIZE_MEDIUM = "medium";
	
	// Cuando se cree el tablero necesito estableceer la configuracion del tamano en base a la dificultad
	public Board(String size) {
		init(size);
	}
	
	public void init(String size) {
		if (size == Board.BOARD_SIZE_EASY) {
			this.cards = new Card[16];
			this.size = Board.BOARD_SIZE_EASY;
		} else if (size == Board.BOARD_SIZE_MEDIUM) {
			this.cards = new Card[36];
			this.size = Board.BOARD_SIZE_MEDIUM;
		}
		
		// Inicializo los frentes y reversos de las cartas
		for (int i = 0; i < this.cards.length; i++) {
			if (i > (this.cards.length / 2) - 1) {
				this.cards[i] = new Card("Blanco", "Rojo");
			} else {
				this.cards[i] = new Card("Blanco", "Azul");
			}
		}
		
		List<Card> cardsList = Arrays.asList(this.cards);
		Collections.shuffle(cardsList);
		this.cards = cardsList.toArray(new Card[0]);
		
	}
	
	// setters y getters
	public Card[] getCards() {
		return this.cards;
	}
	
	public String getSize() {
		return this.size;
	}
	
	// Metodos
	public boolean isAllCardsUncovered() {
		if (this.size == Board.BOARD_SIZE_EASY) {
			if (this.uncoveredCards == 16) {
				return true;
			} else {
				return false;
			}
		} else if (this.size == Board.BOARD_SIZE_MEDIUM) {
			if (this.uncoveredCards == 36) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public void addUncoveredCard() {
		this.uncoveredCards = this.uncoveredCards + 1;
	}
	
	public boolean tryDiscoveredTwoCards(Card firstCard, Card secondCard) {
		// Validar que las dos cartas no se hayan descubierto antes
		if (firstCard.isEqual(secondCard)) {
			// Descubrir las dos cartas
			firstCard.setIsDiscovered();
			secondCard.setIsDiscovered();
			
			// Agregar las dos cartas descubiertas al tablero
			addUncoveredCard();
			addUncoveredCard();
			
			return true;
		} else {
			return false;
		}
	}
	
	public String paintBoard() {
		String board = " ";
		for (int i = 0; i < cards.length; i++) {
			if(!cards[i].getIsDiscovered()) {
				board = board + "[" + cards[i].getImagefront() + "]" + " ";
			} else {
				board = board + " " + cards[i].getImageBottom() + " ";
			}
			if ((i + 1) % 4 == 0) {
				board = board + "\n" + " ";
			}
		}
		
		return board;
	}
}
