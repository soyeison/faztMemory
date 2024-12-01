package co.edu.poli.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class FinalView {
	private Scene scene;
	private Label finalGameLabel;
	private Label result;
	
	public FinalView() {
		finalGameLabel = new Label("El juego se ha terminado");
		
		result = new Label();
		setResult(result);
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(finalGameLabel, result);
		layout.setAlignment(Pos.CENTER);
		
		StackPane root = new StackPane(layout);
		
		setScene(new Scene(root, 700, 700));
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public Label getResult() {
		return result;
	}

	public void setResult(Label result) {
		this.result = result;
	}
}
