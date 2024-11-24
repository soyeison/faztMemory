package co.edu.poli.controller;

import co.edu.poli.view.FaztMemoryIndividualView;
import co.edu.poli.view.FaztMemoryTwoPlayersView;
import co.edu.poli.view.FormInitView;
import co.edu.poli.view.ViewManager;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// Crear la vista del formulario inicial
		FormInitView formInitView = new FormInitView();
		FaztMemoryIndividualView faztMemoryIndividual = new FaztMemoryIndividualView();
		FaztMemoryTwoPlayersView faztMemoryTwoPlayer = new FaztMemoryTwoPlayersView();
		// FarewellView farewellView = new FarewellView();
		
		// Inicializar el administrador de vistas
		ViewManager viewManager = new ViewManager(primaryStage);
		
		// Agregar eventos para cada una de las cartas de la vista FaztMemory
		Rectangle[][] cards = faztMemoryIndividual.getRectangle();
		for (int i = 0; i < cards.length; i++) {
			for (int j = 0; j < cards[i].length; j++) {
				Rectangle card = cards[i][j];
				card.setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						System.out.println("Evento de una carta");
						if (card.getFill() == Color.WHITE) {
							card.setFill(Color.RED);
						} else {
							card.setFill(Color.WHITE);
						}
					}
				});
			}
		}
		
		// Inicializar controladores
		new FormInitController(formInitView, viewManager, faztMemoryIndividual, faztMemoryTwoPlayer);
		
		// Inicializar la primera vista
		viewManager.changeView(formInitView.getScene());
	}

	public static void main(String[] args) {
		launch(args);
	}
}
