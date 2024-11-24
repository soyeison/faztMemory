package co.edu.poli.view;

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

public class FaztMemoryTwoPlayersView {
	private Scene scene;
	private Rectangle[][] rectangles;
	private Label scoreFirstPlayerLabel;
	private Label scoreSecondPlayerLabel;
	// private FaztMemory faztMemory;
	
	public FaztMemoryTwoPlayersView() {
		Label firstName = new Label("Yeison: ");
		Label SecondName = new Label("Nidia: ");
		firstName.setStyle("-fx-font-size: 30px; -fx-font-weight: bold;");
		SecondName.setStyle("-fx-font-size: 30px; -fx-font-weight: bold;");
		
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
		labels.getChildren().addAll(firstName, scoreFirstPlayerLabel, espaciador, SecondName, scoreSecondPlayerLabel);
		
		GridPane gridPane = new GridPane();
		gridPane.setStyle("-fx-padding: 20px; -fx-alignment: center;");
		gridPane.setPadding(new Insets(12, 12, 12, 12));
		gridPane.setHgap(12);
		gridPane.setVgap(12);
		this.rectangles = new Rectangle[4][4];
		
		for (int i = 0; i < this.rectangles.length; i++) {
			for (int j = 0; j < this.rectangles[i].length; j++) {
				this.rectangles[i][j] = new Rectangle(120, 120, Color.WHITE);
				gridPane.add(this.rectangles[i][j], j, i);
			}
		}
		
		// Agregar un stackPane para agrupar el grid y el titulo label
		
		VBox principal = new VBox(10);
		principal.setPadding(new Insets(12, 12, 12, 12));
		principal.getChildren().addAll(labels, gridPane);
		principal.setStyle("-fx-background-color: lightgray; -fx-padding: 20px; -fx-alignment: center;");
		
		setScene(new Scene(principal, 700, 700));
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}
	
	public Rectangle[][] getRectangle() {
		return this.rectangles;
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
}
