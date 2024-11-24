package co.edu.poli.view;

import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;

public class FarewellView {
	private Scene scene;
	
	public FarewellView() {
		FlowPane pane = new FlowPane(Orientation.VERTICAL);
		pane.getChildren().addAll(new Label("El juego ha terminado"));
		pane.getChildren().addAll(new Button("Nos vemos pronto"));
		setScene(new Scene (pane, 200, 200));
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}
}
