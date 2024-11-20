package co.edu.poli.model;

import java.time.Duration;
import java.time.Instant;

public class GameTimer {
	// Momneto en que se inicia eL cronómetro
	private Instant starTtime;
	// Momento en que se detiene el cronómetro
	private Instant endTime;
	
	// Getters y setters
	public Instant getStarTtime() {
		return starTtime;
	}

	public void setStarTtime(Instant starTtime) {
		this.starTtime = starTtime;
	}

	public Instant getEndTime() {
		return endTime;
	}

	public void setEndTime(Instant endTime) {
		this.endTime = endTime;
	}
	
	// Metodos
	/** 
	 * Metodo para inicializar el cronometro
	 * 
	 */
	public void start() {
		this.setStarTtime(Instant.now());
	}

	/** 
	 * Metodo para parar el cronometro
	 * 
	 */
	public void stop() {
		if (this.getStarTtime()== null) {
			System.out.println("Aun no se ha comenzado el cronometro");
			return;
		}
		this.setEndTime(Instant.now());
	}
	
	/** 
	 * Metodo para obtener el tiempo total transcurrido
	 * 
	 */
	public Duration getTotalTime() {
		if (this.getStarTtime()== null) {
			System.out.println("Aun no se ha comenzado el cronometro");
			return null;
		}
		Instant current = (this.getEndTime() != null) ? this.getEndTime() : Instant.now();
		Duration total = Duration.between(this.getStarTtime(), current);
		return total;
	}
	
}
