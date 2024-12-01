package co.edu.poli.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import co.edu.poli.model.Card;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class FaztMemoryIndividualView {
	private Scene scene;
	private Label timerLabel;
	private GridPane board;
	private SimpleIntegerProperty clicksCounter;
	private Timeline timer;
	
	private int seconds = 0; // Variable para llevar el tiempo
	
	public FaztMemoryIndividualView() {
		setClicksCounter(new SimpleIntegerProperty(0));
		
		timerLabel = new Label();
		timerLabel.setStyle("-fx-font-size: 30px; -fx-font-weight: bold; -fx-alignment: center;");
		
		// Para establecer el tiempo
		timerLabel.setText("00:00");
		
		// Crear un Timeline para actualizar el cronómetro
        this.timer = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
        	seconds++; // Incrementar el tiempo transcurrido
            timerLabel.setText(formatTime(seconds));
        }));
        this.timer.setCycleCount(Timeline.INDEFINITE); // Repetir indefinidamente
		
		board = new GridPane();
		board.setStyle("-fx-padding: 20px; -fx-alignment: center;");
		board.setPadding(new Insets(12, 12, 12, 12));
		board.setHgap(12);
		board.setVgap(12);
		
		VBox principal = new VBox(10);
		principal.setPadding(new Insets(12, 12, 12, 12));
		principal.getChildren().addAll(timerLabel, board);
		principal.setStyle("-fx-background-color: lightgray; -fx-padding: 20px; -fx-alignment: center;");
		
		setScene(new Scene(principal, 700, 700));
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}
	
	public GridPane getBoard() {
		return this.board;
	}
	
	public SimpleIntegerProperty getClicksCounter() {
		return clicksCounter;
	}

	public void setClicksCounter(SimpleIntegerProperty clicksCounter) {
		this.clicksCounter = clicksCounter;
	}
	
	public Timeline getTimer() {
		return this.timer;
	}
	
	// Metodos
	public void buildBoard(List<Card> cards, List<Rectangle> rectangles) {
		int columns = 4;
		for (int i = 0; i < cards.size(); i++) {
			int row = i / columns;
			int column = i % columns;
			board.add(rectangles.get(i), column, row);
		}
	}
	
	public Rectangle buildRectangleToCard(Card card) {
		Rectangle rectangle = new Rectangle(120, 120);
		rectangle.setFill(Color.WHITE); // Color inicial (carta oculta)
		rectangle.setArcWidth(10);
		rectangle.setArcHeight(10);
		rectangle.setStroke(Color.BLACK);
		rectangle.setStrokeWidth(2);
        return rectangle;
	}
	
	public Map<Integer, Color> generarMapaColores(List<Card> cards) {
        // Colores predefinidos
        Color[] coloresDisponibles = {
                Color.BLUE, Color.YELLOW, Color.RED, Color.GREEN,
                Color.ORANGE, Color.PURPLE, Color.PINK, Color.BROWN
        };

        Map<Integer, Color> mapa = new HashMap<>();
        for (Card card : cards) {
            if (!mapa.containsKey(card.getId())) {
                mapa.put(card.getId(), coloresDisponibles[mapa.size() % coloresDisponibles.length]);
            }
        }

        return mapa;
    }
	
	// Formatear el tiempo transcurrido en mm:ss
    private String formatTime(int totalSeconds) {
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }
}
