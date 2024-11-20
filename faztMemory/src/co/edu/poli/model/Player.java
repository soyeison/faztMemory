package co.edu.poli.model;

public class Player {
	// Nombre deL jugador 
	private String name;
	// Puntuación deL jugador
	private int score;
	
	public Player() {
		this.name = "Maquina";
	}
	
	public Player(String name) {
		this.name = name;
	}
	
	// getters y setters
	public String getName() {
		return this.name;
	}
	
	public void setScore(int newScore) {
		this.score = newScore;
	}
	
	public int getScore() {
		return this.score;
	}
}
