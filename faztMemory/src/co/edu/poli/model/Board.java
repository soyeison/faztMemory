package co.edu.poli.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Board {
	// Arreglos que contienen todas Las cartas del tablero
	private Card[] cards;
	// Contador de cartas descubiertas
	private int uncoveredCards = 0;
	// Tamaño del tablero ("easy" o "medium")
	private String size;
	
	// Constantes asociadas a los posibles tamanos del tablero
	// Tablero fácil (16 cartas)
	public final static String BOARD_SIZE_EASY = "easy";
	// Tablero medio (36 cartas)
	public final static String BOARD_SIZE_MEDIUM = "medium";
	
	// Cuando se cree el tablero necesito estableceer la configuracion del tamano en base a la dificultad
	public Board(String size) {
		// Configura el tablero
		init(size);
	}
	
	public void init(String size) {
		if (size == Board.BOARD_SIZE_EASY) {
			// Tablero con 16 cartas
			this.cards = new Card[16];
			this.size = Board.BOARD_SIZE_EASY;
		} else if (size == Board.BOARD_SIZE_MEDIUM) {
			// Tablero con 36 cartas
			this.cards = new Card[36];
			this.size = Board.BOARD_SIZE_MEDIUM;
		}
		
		// Inicializo los frentes y reversos de las cartas
		for (int i = 0; i < this.cards.length; i++) {
			if (i > (this.cards.length / 2) - 1) {
				// Mitad con reverso rojo
				this.cards[i] = new Card("Blanco", "Rojo");
			} else {
				// Mitad con reverso azul
				this.cards[i] = new Card("Blanco", "Azul");
			}
		}
		
		// Mexcla aleatoriamente Las cartas
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
	
	// Metodos funcionales
	
	/** 
	 * verifique si todas las cartas del tablero han sido descubiertas.
	 * @return false si aun quedan cartas por descubrir
	 */
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
	
	/** 
	 * Agrega una carta al contador que esta contando la cantidad de cartas descubriertas
	 * 
	 */
	public void addUncoveredCard() {
		this.uncoveredCards = this.uncoveredCards + 1;
	}
	
	/** 
	 * Metodo que valida si dos cartas al ser descubiertas son iguales
	 * Esto las establece como descubiertas y agrega al contador dos cartas descubiertas
	 */
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
	
	/** 
	 * Pinta el tablero devolciendo un string con el formato adecuado
	 * 
	 */
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
