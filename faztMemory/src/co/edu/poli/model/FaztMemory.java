package co.edu.poli.model;

import java.time.Duration;

public class FaztMemory {
	// Tablero del juego
	private Board board;
	// Jugador 1
	private Player player1;
	// Jugador 2 (si existe)
	private Player player2;
	// Jugador actual
	private Player currentPlayer;
	// Cronómetro para medir el tiempo del juego
	private GameTimer timer;
	
	/** 
	 * Constructor para eL modo de un jugador.
	 * 
	 * @param p1   El jugador 1.
	 * @param size Tamaño del tablero ("easy" o "medium"). 
	 */
	public FaztMemory(Player p1, String size) {
		board = new Board(size);
		this.player1 = p1;
		this.player2 = null;
		this.currentPlayer = null;
		this.timer = new GameTimer();
	}
	
	/** 
	 * Constructor para el modo de dos jugadores aplicando polimorfismo
	 * 
	 * @param p1   El jugador 1.
	 * @param p2   El jugador 2.
	 * @param size Tamaño del tablero ("easy" o "medium"). 
	 */
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
	/** 
	 * Valida si ya hubo un ganador
	 * 
	 * @return true en caso de que el juego ya tenga un ganador, false en caso contrario
	 */
	public boolean thereIsWin() {
		if (board.isAllCardsUncovered()) {
			return true;
		} else {
			return false;
		}
	}
	
	/** 
	 * Devuelve cual es el jugador actual
	 * 
	 * @return Player Devuelve instancia del jugador actual
	 */
	public Player getCurrentPlayer() {
		if (this.currentPlayer == null) {
			return null;
		} else {			
			return this.currentPlayer;
		}
	}
	
	/** 
	 * Metodo que cambia al siguiente jugador
	 * 
	 * @return Player Devuelve instancia del siguiente jugador
	 */
	public Player getNextPlayer() {
		if (this.currentPlayer.equals(this.player1)) {
			this.currentPlayer = this.player2;
		} else {
			this.currentPlayer = this.player1;
		}
		return this.currentPlayer;
	}
	
	/** 
	 * Metodo estatico que devuelve el primer jugador
	 * 
	 * @return Player Devuelve instancia del primer jugador
	 */
	public static Player getFirstPlayer(Player p1, Player p2) {
		return p1;
	}
	
	/** 
	 * Metodo que valida si dos cartas al ser descubiertas son iguales en el modo 1 solo jugador
	 * 
	 * @return true en caso que sean iguales al reverso, false en caso contrario
	 */
	public boolean tryDiscoveredTwoCards(Card firstCard, Card secondCard) {
		if (board.tryDiscoveredTwoCards(firstCard, secondCard)) {
			return true;
		} else {
			return false;
		}
	}
	
	/** 
	 * Metodo que valida si dos cartas al ser descubiertas son iguales en el modo 2 jugadores aplicando polimorfismo
	 * Adiciona puntaje al jugador en caso de que si las descubra correctamente
	 * 
	 * @return true en caso que sean iguales al reverso, false en caso contrario
	 */
	public boolean tryDiscoveredTwoCards(Player player, Card firstCard, Card secondCard) {
		if (board.tryDiscoveredTwoCards(firstCard, secondCard)) {
			// Aumentarle el puntaje al jugador actual
			addScoreToPlayer(1, player);
			return true;
		} else {
			return false;
		}
	}
	
	/** 
	 * Metodo privado que agrega score a un jugador. Este metodo solo lo usa el metodo "tryDiscoveredTwoCards"
	 * Adiciona puntaje al jugador
	 * 
	 * @param int score como el puntaje actual del jugador
	 * @param Player player el jugador al que se le adicionara puntaje
	 * @return int como el nuevo score del jugador
	 */
	private int addScoreToPlayer(int score, Player player) {
		int scoreBefore = player.getScore();
		
		int newScore = scoreBefore + score;
		
		player.setScore(newScore);
		
		return newScore;
	}
	
	/** 
	 * Obtiene el jugador con mas puntaje
	 * Solo aplica para modo de juego dos jugadores
	 * 
	 * @param Player player1 el primer jugador
	 * @param Player player2 el segundo jugador
	 * @return Player como el jugador con mas puntaje
	 */
	public Player getResult(Player player1, Player player2) {
		if (player1.getScore() > player2.getScore()) {
			return player1;
		} else if (player1.getScore() < player2.getScore()) {
			return player2;
		} else {
			return null;
		}
	}
	
	/** 
	 * Metodo envoltura para pintar el tablero
	 * 
	 */
//	public String paintBoard() {
//		return board.paintBoard();
//	}
	
	/** 
	 * Metodo que inicializa el cronometro
	 * Solo aplica para modo de juego de un jugador
	 * 
	 */
	public void startChronometer() {
		this.timer.start();
	}
	
	/** 
	 * Metodo que para el cronometro
	 * Solo aplica para modo de juego de un jugador
	 * 
	 */
	public void stopChronometer() {
		this.timer.stop();
	}
	
	/** 
	 * Metodo que obtiene el tiempo transcurrido
	 * Solo aplica para modo de juego de un jugador
	 * 
	 */
	public Duration getTotalTime() {
		return this.timer.getTotalTime();
	}
}
