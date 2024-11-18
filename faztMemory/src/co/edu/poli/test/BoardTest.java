package co.edu.poli.test;

import co.edu.poli.model.Board;
import co.edu.poli.model.Card;
import junit.framework.TestCase;

public class BoardTest extends TestCase {
	
	public void testTryDiscoveredTwoCards() {
		Board board = new Board("easy");
		Card[] cards = board.getCards();
		
		// Bucar cartas que sean iguales
		Card[] equalCards = new Card[2];
		equalCards[0] = cards[0];
		for (int i = 0; i < cards.length; i++) {
			Card tempCard = cards[i];
			if (tempCard.getImageBottom() == equalCards[0].getImageBottom()) {
				equalCards[1] = tempCard;
			}
		}
		
		// Probar que si se puedieron descubrir las dos cartas
		assertEquals("Las carrtas no se lograron descubrir", true, board.tryDiscoveredTwoCards(equalCards[0], equalCards[1]));
		assertEquals("La carta 1 no esta descubierta", true, equalCards[0].getIsDiscovered());
		assertEquals("La carta 2 no esta descubierta", true, equalCards[1].getIsDiscovered());
		
		Board board1 = new Board("easy");
		Card[] cards1 = board1.getCards();
		// Bucar cartas que sean diferentes
		Card[] differentCards = new Card[2];
		differentCards[0] = cards1[0];
		for (int i = 0; i < cards1.length; i++) {
			Card tempCard = cards1[i];
			if (tempCard.getImageBottom() != differentCards[0].getImageBottom()) {
				differentCards[1] = tempCard;
			}
		}
		
		// Probar que no se pudieron descubrir dos cartas
		assertEquals("Las cardtas no se lograron descubrir", false, board.tryDiscoveredTwoCards(differentCards[0], differentCards[1]));
		assertEquals("La carta 3 esta descubierta", false, differentCards[0].getIsDiscovered());
		assertEquals("La carta 4 esta descubierta", false, differentCards[1].getIsDiscovered());
	}
	
	public void testIsAllCardsUncovered() {
		Board board = new Board("easy");
		Card[] cards = board.getCards();
		
		for (Card card : cards) {
			card.setIsDiscovered();
			board.addUncoveredCard();
		}
		
		// Validar que el metodo si determine que ya todas las cartas esten descubiertas
		assertEquals("Las cartas no estan descubiertas", true, board.isAllCardsUncovered());
		
		Board board1 = new Board("easy");
		Card[] cards1 = board1.getCards();
		
		cards1[0].setIsDiscovered();
		
		// Validar que el metodo no dedtermine que las cartas estan descubiertas
		assertEquals("Las cartas estan descubiertas", false, board1.isAllCardsUncovered());
	}

	// Hacerle test a paintBoard
	public void testPaintBoard() {
		Board boardEasy = new Board("easy");
		
		String boardStringEasy = boardEasy.paintBoard();
		String[] boardSplitEasy = boardStringEasy.split("\\[Blanco\\]");
		
		assertEquals("El tablero no tiene el tamano esperado", 17, boardSplitEasy.length);
		
		Board boardHard = new Board("medium");
		
		String boardStringHard = boardHard.paintBoard();
		String[] boardSplitHard = boardStringHard.split("\\[Blanco\\]");
		
		assertEquals("El tablero no tiene el tamano esperado", 37, boardSplitHard.length);
	}
}
