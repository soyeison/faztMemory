package co.edu.poli.view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class FaztMemoryIndividualView {
	private Scene scene;
	private Rectangle[][] rectangles;
	private Label timerLabel;
	// private FaztMemory faztMemory;
	
	public FaztMemoryIndividualView() {
		timerLabel = new Label();
		timerLabel.setStyle("-fx-font-size: 30px; -fx-font-weight: bold; -fx-alignment: center;");
		
		// Para establecer el tiempo
		timerLabel.setText("00:00");
		
		// Crear un Timeline para actualizar el cronómetro
//        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
//            tiempoTranscurrido++; // Incrementar el tiempo transcurrido
//            timerLabel.setText(formatearTiempo(tiempoTranscurrido));
//        }));
//        timeline.setCycleCount(Timeline.INDEFINITE); // Repetir indefinidamente
//        timeline.play(); // Iniciar el cronómetro
		
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
		principal.getChildren().addAll(timerLabel, gridPane);
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
	
	// Formatear el tiempo transcurrido en mm:ss
//    private String formatearTiempo(int segundosTotales) {
//        int minutos = segundosTotales / 60;
//        int segundos = segundosTotales % 60;
//        return String.format("%02d:%02d", minutos, segundos);
//    }
}
