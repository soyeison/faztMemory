package co.edu.poli.test;

import co.edu.poli.model.Card;
import junit.framework.TestCase;

public class CardTest extends TestCase {
	
	public void testIsEqual() {
		Card card1 = new Card("Blanco", "Rojo");
		Card card2 = new Card("Blanco", "Rojo");
		Card card3 = new Card("Blanco", "Azul");
		
		// Probar que si card 1 y card2 tienen el mismo elemento debajo
		assertEquals("Las cartas no coinciden", true, card1.isEqual(card2));
		
		// Probar que card1 y card3 tienen diferentes elementos debajo
		assertEquals("Las cartas coinciden", false, card1.isEqual(card3));
	}
}
