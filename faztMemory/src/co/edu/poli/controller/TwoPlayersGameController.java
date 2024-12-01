package co.edu.poli.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import co.edu.poli.model.Board;
import co.edu.poli.model.Card;
import co.edu.poli.model.FaztMemory;
import co.edu.poli.model.Player;
import co.edu.poli.view.FinalView;
import co.edu.poli.view.TwoPlayersView;
import co.edu.poli.view.ViewManager;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class TwoPlayersGameController {
	private TwoPlayersView twoPlayersView;
	private FinalView finalView;
	private ViewManager viewManager;
	
	private List<Rectangle> rectangles;
	private FaztMemory faztMemory;
	private Board board;
	private List<Card> cards;
	private Map<Integer, Color> colorsMap;
	
	private Card firstCardSelected = null;
	private Player currentPlayer = null;
	private Player firstPlayer;
	private Player secondPlayer;
	
	public TwoPlayersGameController(String firstName, String secondName, String gameDifficult, TwoPlayersView twoPlayersViewInstance, FinalView finalView, ViewManager viewManager) {
		// Inicializar los jugadores en base al anterior formulario
		firstPlayer = new Player(firstName);
		secondPlayer = new Player(secondName);
		// Inicilizar el juego
		faztMemory = new FaztMemory(firstPlayer, secondPlayer, gameDifficult);
		board = faztMemory.getBoard();
		cards = board.getCards();
		// Inicilizar el primer jugador
		currentPlayer = FaztMemory.getFirstPlayer(firstPlayer, secondPlayer);
		faztMemory.setCurrentPlayer(currentPlayer);
		
		this.colorsMap = twoPlayersViewInstance.buildColorsMap(cards, gameDifficult);
		this.twoPlayersView = twoPlayersViewInstance;
		this.finalView = finalView;
		this.viewManager = viewManager;
		this.rectangles = new ArrayList<>();
		
		// Inicilizar rectangulos
		initializeRectangles();
		
		// Establecer los nombres en los labels
		twoPlayersViewInstance.getFirstName().setText(firstName);
		twoPlayersViewInstance.getSecondName().setText(secondName);
		// Contruir tablero
		twoPlayersViewInstance.buildBoard(cards, rectangles, gameDifficult);
		
		// inicializar listener
		configClickEvent();
	}
	
	private void initializeRectangles() {
        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            Rectangle rectangle = twoPlayersView.buildRectangleToCard(card);
            configEvent(rectangle, card);
            rectangles.add(rectangle);
        }
    }
	
	private void configEvent(Rectangle rectangle, Card card) {
		rectangle.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				twoPlayersView.getClicksCounter().set(twoPlayersView.getClicksCounter().get() + 1);
				// Logica para revisar cartas
				if (card.getIsDiscovered()) {
					return;
				}
				
				card.setIsDiscovered(true);
				rectangle.setFill(colorsMap.get(card.getId()));
				
				if (firstCardSelected == null) {
					firstCardSelected = card;
				} else {
					// Segunda carta descubierta por este jugador
					if (faztMemory.tryDiscoveredTwoCards(currentPlayer, firstCardSelected, card)) {
						// Son iguales por lo que mantenerles el color
						rectangle.setFill(colorsMap.get(card.getId()));
						
						// Actualizar el puntaje del usuario en la vista
						if (twoPlayersView.getFirstName().getText() == currentPlayer.getName()) {
							twoPlayersView.getScoreFirstPlayerLabel().setText(String.valueOf(currentPlayer.getScore()));;
						} else {
							twoPlayersView.getScoreSecondPlayerLabel().setText(String.valueOf(currentPlayer.getScore()));;
						}
					} else {
						// No son iguales
						Card lastCard = firstCardSelected;
						Rectangle lastRectangle = rectangles.get(cards.indexOf(lastCard));
						
						// Ocultarlas las tarjetas con un tiempo de delay
						new Thread(() -> {
	                        try {
	                            Thread.sleep(1000); // Esperar un segundo
	                        } catch (InterruptedException e) {
	                            e.printStackTrace();
	                        }
	                        card.setIsDiscovered(false);
	                        lastCard.setIsDiscovered(false);

	                        Platform.runLater(() -> {
	                            rectangle.setFill(Color.WHITE); // Les pongo de nuevo el color por defecto
	                            lastRectangle.setFill(Color.WHITE);
	                        });
	                    }).start();
					}
					firstCardSelected = null; // Reiniciar selección
					
					// Pasar al siguiente jugador
					currentPlayer = faztMemory.getNextPlayer();
					faztMemory.setCurrentPlayer(currentPlayer);
				}
			}
		});
	}
	
	private void configClickEvent() {
		twoPlayersView.getClicksCounter().addListener((observable, oldValue, newValue) -> {
			if (faztMemory.thereIsWin()) {
				Player winner = faztMemory.getResult(firstPlayer, secondPlayer);
				if (winner == null) {
					finalView.getResult().setText("Empate!!!");
				} else {					
					finalView.getResult().setText("El ganador es: " + winner.getName());
				}
				viewManager.changeView(finalView.getScene());
			}
		});
		
	}
}
