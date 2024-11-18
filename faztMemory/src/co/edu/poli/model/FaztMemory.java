package co.edu.poli.model;

import java.time.Duration;

public class FaztMemory {
	private Board board;
	private Player player1;
	private Player player2;
	private Player currentPlayer;
	private GameTimer timer;
	
	public FaztMemory(Player p1, String size) {
		board = new Board(size);
		this.player1 = p1;
		this.player2 = null;
		this.currentPlayer = null;
		this.timer = new GameTimer();
	}
	
	public FaztMemory(Player p1, Player p2, String size) {
		board = new Board(size);
		this.player1 = p1;
		this.player2 = p2;
	}
	
	// getters y setters
	public Board getBoard() {
		return this.board;
	}
	
	public Player getPlayer1() {
		return this.player1;
	}
	
	public Player getPlayer2() {
		return this.player2;
	}
	
	public void setCurrentPlayer(Player p) {
		this.currentPlayer = p;
	}

	public GameTimer getTimer() {
		return timer;
	}
	
	// Metodos
	public boolean thereIsWin() {
		if (board.isAllCardsUncovered()) {
			return true;
		} else {
			return false;
		}
	}
	
	public Player getCurrentPlayer() {
		if (this.currentPlayer == null) {
			return null;
		} else {			
			return this.currentPlayer;
		}
	}
	
	public Player getNextPlayer() {
		if (this.currentPlayer.equals(this.player1)) {
			this.currentPlayer = this.player2;
		} else {
			this.currentPlayer = this.player1;
		}
		return this.currentPlayer;
	}
	
	public static Player getFirstPlayer(Player p1, Player p2) {
		return p1;
	}
	
	public boolean tryDiscoveredTwoCards(Card firstCard, Card secondCard) {
		if (board.tryDiscoveredTwoCards(firstCard, secondCard)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean tryDiscoveredTwoCards(Player player, Card firstCard, Card secondCard) {
		if (board.tryDiscoveredTwoCards(firstCard, secondCard)) {
			// Aumentarle el puntaje al jugador actual
			addScoreToPlayer(1, player);
			return true;
		} else {
			return false;
		}
	}
	
	private int addScoreToPlayer(int score, Player player) {
		int scoreBefore = player.getScore();
		
		int newScore = scoreBefore + score;
		
		player.setScore(newScore);
		
		return newScore;
	}
	
	public Player getResult(Player player1, Player player2) {
		if (player1.getScore() > player2.getScore()) {
			return player1;
		} else if (player1.getScore() < player2.getScore()) {
			return player2;
		} else {
			return null;
		}
	}
	
	public String paintBoard() {
		return board.paintBoard();
	}
	
	public void startChronometer() {
		this.timer.start();
	}
	
	public void stopChronometer() {
		this.timer.stop();
	}
	
	public Duration getTotalTime() {
		return this.timer.getTotalTime();
	}
}
