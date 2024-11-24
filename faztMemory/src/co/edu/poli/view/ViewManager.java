package co.edu.poli.view;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewManager {
	private Stage stage;
	
	public ViewManager(Stage stage) {
		this.setStage(stage);
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	// Metodos
	public void changeView(Scene scene) {
		this.stage.setScene(scene);
		this.stage.show();
	}
}
