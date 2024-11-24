package co.edu.poli.view;

import co.edu.poli.model.FaztMemory;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class FaztMemoryView {
	private Scene scene;
	private Rectangle[][] rectangles;
	private FaztMemory faztMemory;
	
	public FaztMemoryView() {
		GridPane pane = new GridPane();
		pane.setPadding(new Insets(12, 12, 12, 12));
		pane.setHgap(12);
		pane.setVgap(12);
		this.rectangles = new Rectangle[4][4];
		
		for (int i = 0; i < this.rectangles.length; i++) {
			for (int j = 0; j < this.rectangles[i].length; j++) {
				this.rectangles[i][j] = new Rectangle(120, 120, Color.WHITE);
				pane.add(this.rectangles[i][j], j, i);
			}
		}
		pane.setAlignment(Pos.CENTER);
		
		setScene(new Scene(pane, 600, 600));
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
	
}
