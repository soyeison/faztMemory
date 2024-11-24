package co.edu.poli.controller;

import java.time.Duration;
import java.util.Scanner;

import co.edu.poli.model.Board;
import co.edu.poli.model.Card;
import co.edu.poli.model.FaztMemory;
import co.edu.poli.model.Player;

public class Main {

	public static void main(String[] args) {
		boolean game = true;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Este es el juego de Fazt Memory");

		while (game) {
			// Dar las opciones para el tipo de juego
			System.out.println("Por favor seleccione el tipo de juego");
			System.out.println("1. Juego contra el tiempo");
			System.out.println("2. Juego para dos");
			int gameMode = scanner.nextInt();
	        scanner.nextLine();
	        
	        switch (gameMode) {
			case 1: {
				// Juego contra reloj
				System.out.println("Ingrese un nombre: ");
				String name = scanner.nextLine();
				Player player = new Player(name);
				FaztMemory faztMemory = new FaztMemory(player, "easy");
				Board board = faztMemory.getBoard();
				Card[] cards = faztMemory.getBoard().getCards();
				while (!board.isAllCardsUncovered()) {
					System.out.println("Este es el tablero");
					System.out.println(faztMemory.paintBoard());
					
					// comenzar a correr el tiempo
					if (faztMemory.getTimer().getStarTtime() == null) {						
						faztMemory.startChronometer();
					}
					
					// Se selecciona una carta
					System.out.println("Ingrese la posicion de la primera carta: ");
					int option1 = scanner.nextInt();
			        scanner.nextLine();
			        // Seleccionar la carta del mazo
			        Card card1 = cards[option1 - 1];
			        while(card1.getIsDiscovered()) {
			        	System.out.println("Por favor selecciona una carta que no este descubierta");
						option1 = scanner.nextInt();
				        scanner.nextLine();
				        card1 = cards[option1 - 1];
			        }
			        
			        System.out.println("Ingrese la posicion de la segunda carta: ");
					int option2 = scanner.nextInt();
			        scanner.nextLine();
			        // Seleccionar la carta del mazo
			        Card card2 = cards[option2 - 1];
			        while(card2.getIsDiscovered()) {
			        	System.out.println("Por favor selecciona una carta que no este descubierta");
						option2 = scanner.nextInt();
				        scanner.nextLine();
				        card2 = cards[option2 - 1];
			        }
			        
			        faztMemory.tryDiscoveredTwoCards(card1, card2);
				}
				System.out.println(faztMemory.paintBoard());
				faztMemory.stopChronometer();
				Duration totalTime = faztMemory.getTotalTime();
				long minutes = totalTime.toMinutes();
				long seconds = totalTime.minusMinutes(minutes).toSeconds();
				System.out.println("El tiempo total fue: " + minutes + " minutos" + " y " + seconds + " segundos");
				game = false;
				break;
			}
			case 2: {
				System.out.println("Ingrese el nombre del primer jugador: ");
				String name1 = scanner.nextLine();
				Player player1 = new Player(name1);
				System.out.println("Ingrese el nombre del segundo jugador: ");
				String name2 = scanner.nextLine();
				Player player2 = new Player(name2);
				FaztMemory faztMemory = new FaztMemory(player1, player2, "easy");
				Card[] cards = faztMemory.getBoard().getCards();
				// Juego para dos
				// Metodo para saber si alguien ya gano
				while(!faztMemory.thereIsWin()) {
					// Pintar el tablero
					System.out.println("Este es el tablero");
					System.out.println(faztMemory.paintBoard());
					// Darle el turno al siguiente jugador
					if (faztMemory.getCurrentPlayer() == null) {
						Player firstPlayer = FaztMemory.getFirstPlayer(player1, player2);
						faztMemory.setCurrentPlayer(firstPlayer);
					} else {
						Player nextPlayer = faztMemory.getNextPlayer();
						faztMemory.setCurrentPlayer(nextPlayer);
					}
					System.out.println("El jugador actual es: " + faztMemory.getCurrentPlayer().getName());
					// Se selecciona una carta
					System.out.println("Ingrese la posicion de la primera carta: ");
					int option1 = scanner.nextInt();
			        scanner.nextLine();
			        // Seleccionar la carta del mazo
			        Card card1 = cards[option1 - 1];
			        while(card1.getIsDiscovered()) {
			        	System.out.println("Por favor selecciona una carta que no este descubierta");
						option1 = scanner.nextInt();
				        scanner.nextLine();
				        card1 = cards[option1 - 1];
			        }
					
			        System.out.println("Ingrese la posicion de la segunda carta: ");
					int option2 = scanner.nextInt();
			        scanner.nextLine();
			        // Seleccionar la carta del mazo
			        Card card2 = cards[option2 - 1];
			        while(card2.getIsDiscovered()) {
			        	System.out.println("Por favor selecciona una carta que no este descubierta");
						option2 = scanner.nextInt();
				        scanner.nextLine();
				        card2 = cards[option2 - 1];
			        }
			        
					faztMemory.tryDiscoveredTwoCards(faztMemory.getCurrentPlayer(), card1, card2);
					// Imprimir los score actualizados
					System.out.println("Score del jugador 1: " + player1.getScore());
					System.out.println("Score del jugador 2: " + player2.getScore());
				}
				System.out.println("El juego se ha terminado");
				Player winner = faztMemory.getResult(player1, player2);
				String resultString = null;
				if (winner == null) {
					resultString = "Empate";
				} else if (winner.equals(player1)) {
					resultString = player1.getName() + " gano";
				} else if (winner.equals(player2)) {
					resultString = player2.getName() + " gano";
				}
				System.out.println("El resultado es:  " + resultString);
				game = false;
				break;
			}
			}
	        System.out.println("El juego finalizo. Hasta pronto.");
		}
		scanner.close();
	}
}
