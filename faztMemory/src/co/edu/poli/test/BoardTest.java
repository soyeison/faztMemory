package co.edu.poli.test;

import java.util.ArrayList;
import java.util.List;

import co.edu.poli.model.Board;
import co.edu.poli.model.Card;
import junit.framework.TestCase;

public class BoardTest extends TestCase {
	
	public void testTryDiscoveredTwoCards() {
		Board board = new Board("easy");
		List<Card> cards = board.getCards();
		
		// Bucar cartas que sean iguales
		List<Card> equalCards = new ArrayList<>();
		equalCards.set(0, cards.get(0));
		for (int i = 0; i < cards.size(); i++) {
			Card tempCard = cards.get(i);
			if (tempCard.getId() == equalCards.get(0).getId()) {
				equalCards.set(i, tempCard);
			}
		}
		
		// Probar que si se puedieron descubrir las dos cartas
		assertEquals("Las carrtas no se lograron descubrir", true, board.tryDiscoveredTwoCards(equalCards.get(0), equalCards.get(1)));
		assertEquals("La carta 1 no esta descubierta", true, equalCards.get(0).getIsDiscovered());
		assertEquals("La carta 2 no esta descubierta", true, equalCards.get(1).getIsDiscovered());
		
		Board board1 = new Board("easy");
		List<Card> cards1 = board1.getCards();
		// Bucar cartas que sean diferentes
		List<Card> differentCards = new ArrayList<>();
		differentCards.set(0, cards1.get(0));
		for (int i = 0; i < cards1.size(); i++) {
			Card tempCard = cards1.get(i);
			if (tempCard.getId() != differentCards.get(0).getId()) {
				differentCards.set(i, tempCard);
			}
		}
		
		// Probar que no se pudieron descubrir dos cartas
		assertEquals("Las cardtas no se lograron descubrir", false, board.tryDiscoveredTwoCards(differentCards.get(0), differentCards.get(1)));
		assertEquals("La carta 3 esta descubierta", false, differentCards.get(0).getIsDiscovered());
		assertEquals("La carta 4 esta descubierta", false, differentCards.get(1).getIsDiscovered());
	}
	
//	public void testIsAllCardsUncovered() {
//		Board board = new Board("easy");
//		Card[] cards = board.getCards();
//		
//		for (Card card : cards) {
//			card.setIsDiscovered();
//			board.addUncoveredCard();
//		}
//		
//		// Validar que el metodo si determine que ya todas las cartas esten descubiertas
//		assertEquals("Las cartas no estan descubiertas", true, board.isAllCardsUncovered());
//		
//		Board board1 = new Board("easy");
//		Card[] cards1 = board1.getCards();
//		
//		cards1[0].setIsDiscovered();
//		
//		// Validar que el metodo no dedtermine que las cartas estan descubiertas
//		assertEquals("Las cartas estan descubiertas", false, board1.isAllCardsUncovered());
//	}

	// Hacerle test a paintBoard
//	public void testPaintBoard() {
//		Board boardEasy = new Board("easy");
//		
//		String boardStringEasy = boardEasy.paintBoard();
//		String[] boardSplitEasy = boardStringEasy.split("\\[Blanco\\]");
//		
//		assertEquals("El tablero no tiene el tamano esperado", 17, boardSplitEasy.length);
//		
//		Board boardHard = new Board("medium");
//		
//		String boardStringHard = boardHard.paintBoard();
//		String[] boardSplitHard = boardStringHard.split("\\[Blanco\\]");
//		
//		assertEquals("El tablero no tiene el tamano esperado", 37, boardSplitHard.length);
//	}
}
