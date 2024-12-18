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

public class IndividualView {
	private Scene scene;
	private Label timerLabel;
	private GridPane board;
	private SimpleIntegerProperty clicksCounter;
	private Timeline timer;
	
	private int seconds = 0; // Variable para llevar el tiempo
	
	public IndividualView() {
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
	
	public void setTimerLabel(Label newTimer) {
		this.timerLabel = newTimer;
	}
	
	public Label getTimerLabel() {
		return this.timerLabel;
	}
	
	// Metodos
	public void buildBoard(List<Card> cards, List<Rectangle> rectangles, String gameDifficult) {
		if (gameDifficult == "easy") {			
			int columns = 4;
			for (int i = 0; i < cards.size(); i++) {
				int row = i / columns;
				int column = i % columns;
				board.add(rectangles.get(i), column, row);
			}
		} else {
			int columns = 6;
			for (int i = 0; i < cards.size(); i++) {
				int row = i / columns;
				int column = i % columns;
				board.add(rectangles.get(i), column, row);
			}
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
	
	public Map<Integer, Color> buildColorsMap(List<Card> cards, String gameDifficult) {
        // Colores predefinidos
		Color[] availableColor;
		System.out.println("cards" + cards.size());
		
		 if (gameDifficult == "easy") {
			 	availableColor = new Color[8]; // Si la condición es verdadera
	        } else {
	        	availableColor = new Color[16]; // Si la condición es falsa
	        }
		
		for (int i = 0; i < availableColor.length; i++) {
			availableColor[i] = Color.color(Math.random(), Math.random(), Math.random()); // Genera colores aleatorios
        }

        Map<Integer, Color> map = new HashMap<>();
        for (Card card : cards) {
            if (!map.containsKey(card.getId())) {
            	map.put(card.getId(), availableColor[map.size() % availableColor.length]);
            }
        }

        return map;
    }
	
	// Formatear el tiempo transcurrido en mm:ss
    public String formatTime(int totalSeconds) {
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }
}
