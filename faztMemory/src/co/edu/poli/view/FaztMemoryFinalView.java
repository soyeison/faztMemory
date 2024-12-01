package co.edu.poli.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;

public class FaztMemoryFinalView {
	private Scene scene;
	private Label finalGameLabel;
	
	public FaztMemoryFinalView() {
		finalGameLabel = new Label("El juego se ha terminado");
		finalGameLabel.setAlignment(Pos.CENTER);
		
		setScene(new Scene(finalGameLabel, 700, 700));
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}
}
