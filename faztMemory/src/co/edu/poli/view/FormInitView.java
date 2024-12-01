package co.edu.poli.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class FormInitView {
	private Scene scene;
	private Button inidivualGame;
	private Button twoPlayersGame;

	public FormInitView() {
		Label title = new Label("Bienvenido a Fazt Memory");
		title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
		
		// Creacion ded botones
		inidivualGame = new Button("Juego individual");
		twoPlayersGame = new Button("Juego para dos");
		
		// VBox para botones
		VBox layout = new VBox(15);
		layout.getChildren().addAll(inidivualGame, twoPlayersGame);
		layout.setAlignment(Pos.CENTER);
		
		// StackPane para posicionar los botones y el titulo
		StackPane principal = new StackPane();
		principal.getChildren().addAll(title, layout);
		StackPane.setAlignment(title, Pos.TOP_CENTER);
		StackPane.setAlignment(layout, Pos.CENTER);
		principal.setPadding(new Insets(40, 10, 10, 10));
		
		
		setScene(new Scene (principal, 700, 700));
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public Button getInidivualGame() {
		return inidivualGame;
	}

	public void setInidivualGame(Button inidivualGame) {
		this.inidivualGame = inidivualGame;
	}

	public Button getTwoPlayersGame() {
		return twoPlayersGame;
	}

	public void setTwoPlayersGame(Button twoPlayersGame) {
		this.twoPlayersGame = twoPlayersGame;
	}
}
