package co.edu.poli.test;

import java.time.Instant;

import co.edu.poli.model.GameTimer;
import junit.framework.TestCase;

public class GameTimerTest extends TestCase {

	/** 
	 * Testea el metodo start de la clase GameTimer
	 * 
	 */
	public void testStart() {
		GameTimer gameTimer = new GameTimer();
		gameTimer.start();
		
		assertEquals("El temporizador aun no ha iniciado", true, gameTimer.getStarTtime() != null);
	}
	
	/** 
	 * Testea el metodo stop de la clase GameTimer
	 * 
	 */
	public void testStop() {
		GameTimer gameTimer = new GameTimer();
		gameTimer.start();
		gameTimer.stop();
		Instant firstStop = gameTimer.getEndTime();
		
		// Esperar unos segundo y ver que el tiempo sea el mismo
		try {
            Thread.sleep(1000); // Pausa el hilo por 1000 milisegundos (1 segundo)
        } catch (InterruptedException e) {
            System.out.println("El hilo fue interrumpido.");
        }
		Instant secondStop = gameTimer.getEndTime();
		
		assertEquals("El temporizador aun no se ha detenido", true, firstStop == secondStop);
	}
	
	public void testTetTotalTime() {
		GameTimer gameTimer = new GameTimer();
		gameTimer.start();
		gameTimer.stop();
		
		assertEquals("La funcion esta devolviendo null o algo diferente a Instant", true, gameTimer.getTotalTime() != null);
	}
}
