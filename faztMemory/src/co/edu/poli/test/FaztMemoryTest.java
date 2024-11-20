package co.edu.poli.test;

import co.edu.poli.model.Board;
import co.edu.poli.model.Card;
import co.edu.poli.model.FaztMemory;
import co.edu.poli.model.Player;
import junit.framework.TestCase;

public class FaztMemoryTest extends TestCase {
	
	public void testThereIsWin() {
		Player firstPlayer = new Player("Test1");
		Player secondPlayer = new Player("Test2");
		FaztMemory faztMemory = new FaztMemory(firstPlayer, secondPlayer, "easy");
		
		// Testear que aun no hay nadie que ha ganado
		assertEquals("Ya hay un ganador", false, faztMemory.thereIsWin());
		
		// Testear que ya hay un ganador cuando todas las cartas estan descubiertas
		Card[] cards = faztMemory.getBoard().getCards();
		Board board = faztMemory.getBoard();
		for (Card card : cards) {
			card.setIsDiscovered();
			board.addUncoveredCard();
		}
		
		assertEquals("Aun no hay un ganador", true, faztMemory.thereIsWin());
	}
	
	public void testGetCurrentPlayer() {
		Player firstPlayer = new Player("Test1");
		Player secondPlayer = new Player("Test2");
		FaztMemory faztMemory = new FaztMemory(firstPlayer, secondPlayer, "easy");
		
		// Validar que primero se debe seleccionar el jugador inicial
		assertEquals("Ya hay un jugador seleccionado", true, faztMemory.getCurrentPlayer() == null);
	
		// Validar que se devuelva el primer jugador cuando se le da el turno a este
		Player playerToInit = FaztMemory.getFirstPlayer(firstPlayer, secondPlayer);
		faztMemory.setCurrentPlayer(playerToInit);
		assertEquals("No hay jugador actual", true, faztMemory.getCurrentPlayer() != null);
	}
	
	public void testGetNextPlayer() {
		Player firstPlayer = new Player("Test1");
		Player secondPlayer = new Player("Test2");
		FaztMemory faztMemory = new FaztMemory(firstPlayer, secondPlayer, "easy");
		Player playerToInit = FaztMemory.getFirstPlayer(firstPlayer, secondPlayer);
		faztMemory.setCurrentPlayer(playerToInit);
		
		// Como el jugador que inicia es el jugador firstPlayer, el metodo deberia devolver al segundo jugador
		Player nextPlayer = faztMemory.getNextPlayer();
		assertEquals("Los jugadores son el mismo", false, firstPlayer.equals(nextPlayer));
	}
	
	public void testGetResult() {
		Player firstPlayer = new Player("Test1");
		Player secondPlayer = new Player("Test2");
		FaztMemory faztMemory = new FaztMemory(firstPlayer, secondPlayer, "easy");
		
		firstPlayer.setScore(2);
		secondPlayer.setScore(4);
		
		// El test deberia indicar que el jugador con mas puntaje es el dos
		assertEquals("El jugador con mas puntos es el jugador uno", true, faztMemory.getResult(firstPlayer, secondPlayer) == secondPlayer);
		
		// en caso de empate deberia devolver null
		firstPlayer.setScore(4);
		assertEquals("Hay un jugador con mas puntaje", null, faztMemory.getResult(firstPlayer, secondPlayer));
	}
}
