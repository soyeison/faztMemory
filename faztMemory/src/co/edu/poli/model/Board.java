package co.edu.poli.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {
	// Arreglos que contienen todas Las cartas del tablero
	private List<Card> cards;
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
			this.cards = new ArrayList<>();
			this.size = Board.BOARD_SIZE_EASY;
		} else if (size == Board.BOARD_SIZE_MEDIUM) {
			// Tablero con 36 cartas
			this.cards = new ArrayList<>();
			this.size = Board.BOARD_SIZE_MEDIUM;
		}
		
		int iterator = size == Board.BOARD_SIZE_EASY ? 8 : 16;
		
		for (int i = 0; i < iterator; i++) { // 8 pares de cartas
            this.cards.add(new Card(i));
            this.cards.add(new Card(i));
        }
		Collections.shuffle(this.cards);
		
	}
	
	// setters y getters
	public int getUncoveredCards() {
		return this.uncoveredCards;
	}
	
	public List<Card> getCards() {
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
			firstCard.setIsDiscovered(true);
			secondCard.setIsDiscovered(true);
			
			// Agregar las dos cartas descubiertas al tablero
			addUncoveredCard();
			addUncoveredCard();
			
			return true;
		} else {
			return false;
		}
	}
	
	/** 
	 * Pinta el tablero devolviendo un string con el formato adecuado
	 * 
	 */
//	public String paintBoard() {
//		String board = " ";
//		for (int i = 0; i < cards.length; i++) {
//			if(!cards[i].getIsDiscovered()) {
//				board = board + "[" + cards[i].getImagefront() + "]" + " ";
//			} else {
//				board = board + " " + cards[i].getImageBottom() + " ";
//			}
//			if ((i + 1) % 4 == 0) {
//				board = board + "\n" + " ";
//			}
//		}
//		
//		return board;
//	}
}
