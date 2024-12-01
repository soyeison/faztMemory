package co.edu.poli.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import co.edu.poli.model.Board;
import co.edu.poli.model.Card;
import co.edu.poli.model.FaztMemory;
import co.edu.poli.model.Player;
import co.edu.poli.view.FinalView;
import co.edu.poli.view.IndividualView;
import co.edu.poli.view.ViewManager;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class IndividualGameController {
	private IndividualView individualView;
	private FinalView finalView;
	private ViewManager viewManager;
	
	private List<Rectangle> rectangles;
	private FaztMemory faztMemory;
	private Board board;
	private List<Card> cards;
	private Map<Integer, Color> colorsMap;
	
	private Card firstCardSelected = null;
	
	public IndividualGameController(String playerName, String gameDifficult, IndividualView individualGameView, FinalView finalView, ViewManager viewManager) {
		// Inicializar el jugador en base a l formulario pasado
		Player player = new Player(playerName);
		// Inicializar juego
		faztMemory = new FaztMemory(player, gameDifficult);
		board = faztMemory.getBoard();
		cards = faztMemory.getBoard().getCards();
		
		this.colorsMap = individualGameView.buildColorsMap(cards, gameDifficult);
		this.individualView = individualGameView;
		this.finalView = finalView;
		this.viewManager = viewManager;
		this.rectangles = new ArrayList<>();
		
		
		// Inicializar rectangulos
		initializeRectangles();
		
		// Contruir tablero
		individualGameView.buildBoard(cards, rectangles, gameDifficult);
		
		// inicializar listener
		configClickEvent();
	}
	
	private void initializeRectangles() {
        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            Rectangle rectangle = individualView.buildRectangleToCard(card);
            configEvent(rectangle, card);
            rectangles.add(rectangle);
        }
    }
	
	private void configEvent(Rectangle rectangle, Card card) {
		rectangle.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				individualView.getClicksCounter().set(individualView.getClicksCounter().get() + 1);
				if (card.getIsDiscovered()) {
					return; // Ignorar el click si la carta esta descubierta
				}
				
				card.setIsDiscovered(true);
				rectangle.setFill(colorsMap.get(card.getId()));
				
				
				if (firstCardSelected == null) {
					firstCardSelected = card;
				} else {
					// Segunda carta descubierta
					if (board.tryDiscoveredTwoCards(firstCardSelected, card)) {
						// Son iguales por lo que mantenerles el color
						rectangle.setFill(colorsMap.get(card.getId()));
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
				}
			}
		});
	}
	
	private void configClickEvent() {
		individualView.getClicksCounter().addListener((observable, oldValue, newValue) -> {
			if (faztMemory.getBoard().getUncoveredCards() == 14 || faztMemory.getBoard().getUncoveredCards() == 36) {
				individualView.getTimer().stop();
			}
			if (faztMemory.thereIsWin()) {
				finalView.getResult().setText("Su tiempo fue: " + individualView.getTimerLabel().getText());
				viewManager.changeView(finalView.getScene());
			}
		});
		
	}
}
