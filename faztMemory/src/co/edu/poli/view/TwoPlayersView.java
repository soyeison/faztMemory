package co.edu.poli.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import co.edu.poli.model.Card;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class TwoPlayersView {
	private Scene scene;
	private GridPane board;
	private SimpleIntegerProperty clicksCounter;
	
	private Label firstName;
	private Label secondName;
	private Label scoreFirstPlayerLabel;
	private Label scoreSecondPlayerLabel;
	// private FaztMemory faztMemory;
	
	public TwoPlayersView() {
		setClicksCounter(new SimpleIntegerProperty(0));
		
		firstName = new Label();
		secondName = new Label();
		firstName.setStyle("-fx-font-size: 30px; -fx-font-weight: bold;");
		secondName.setStyle("-fx-font-size: 30px; -fx-font-weight: bold;");
		
		// Labels que varian con eventos
		Label scoreInitFirstPlayer = new Label("0");
		Label scoreInitSecondPlayer = new Label("0");
		scoreInitFirstPlayer.setStyle("-fx-font-size: 30px; -fx-font-weight: bold;");
		scoreInitSecondPlayer.setStyle("-fx-font-size: 30px; -fx-font-weight: bold;");
		setScoreFirstPlayerLabel(scoreInitFirstPlayer);
		setScoreSecondPlayerLabel(scoreInitSecondPlayer);
		
		// Agregar un espaciador
		Region espaciador = new Region();
		HBox.setHgrow(espaciador, Priority.ALWAYS);
		
		// Agrupar estos labels
		HBox labels = new HBox();
		labels.getChildren().addAll(firstName, scoreFirstPlayerLabel, espaciador, secondName, scoreSecondPlayerLabel);
		
		// Aqui se pintan las cartas
		board = new GridPane();
		board.setStyle("-fx-padding: 20px; -fx-alignment: center;");
		board.setPadding(new Insets(12, 12, 12, 12));
		board.setHgap(12);
		board.setVgap(12);
		
		VBox principal = new VBox(10);
		principal.setPadding(new Insets(12, 12, 12, 12));
		principal.getChildren().addAll(labels, board);
		principal.setStyle("-fx-background-color: lightgray; -fx-padding: 20px; -fx-alignment: center;");
		
		setScene(new Scene(principal, 700, 700));
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}
	
	public Label getFirstName() {
		return firstName;
	}

	public void setFirstName(Label firstName) {
		this.firstName = firstName;
	}

	public Label getSecondName() {
		return secondName;
	}

	public void setSecondName(Label secondName) {
		this.secondName = secondName;
	}
	
	public Label getScoreFirstPlayerLabel() {
		return scoreFirstPlayerLabel;
	}

	public void setScoreFirstPlayerLabel(Label scoreFirstPlayerLabel) {
		this.scoreFirstPlayerLabel = scoreFirstPlayerLabel;
	}

	public Label getScoreSecondPlayerLabel() {
		return scoreSecondPlayerLabel;
	}

	public void setScoreSecondPlayerLabel(Label scoreSecondPlayerLabel) {
		this.scoreSecondPlayerLabel = scoreSecondPlayerLabel;
	}
	
	public SimpleIntegerProperty getClicksCounter() {
		return clicksCounter;
	}

	public void setClicksCounter(SimpleIntegerProperty clicksCounter) {
		this.clicksCounter = clicksCounter;
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
	
	public Map<Integer, Color> buildColorsMap(List<Card> cards) {
        // Colores predefinidos
        Color[] availableColors = {
                Color.BLUE, Color.YELLOW, Color.RED, Color.GREEN,
                Color.ORANGE, Color.PURPLE, Color.PINK, Color.BROWN
        };

        Map<Integer, Color> map = new HashMap<>();
        for (Card card : cards) {
            if (!map.containsKey(card.getId())) {
            	map.put(card.getId(), availableColors[map.size() % availableColors.length]);
            }
        }

        return map;
    }
}
