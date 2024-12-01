package co.edu.poli.controller;

import co.edu.poli.view.FaztMemoryConfigIndivialGameView;
import co.edu.poli.view.FaztMemoryFinalView;
import co.edu.poli.view.FaztMemoryIndividualView;
import co.edu.poli.view.FaztMemoryTwoPlayersView;
import co.edu.poli.view.FormInitView;
import co.edu.poli.view.ViewManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// Crear la vista del formulario inicial
		FormInitView formInitView = new FormInitView();
		FaztMemoryConfigIndivialGameView formConfigIndividualGame = new FaztMemoryConfigIndivialGameView();
		FaztMemoryIndividualView faztMemoryIndividual = new FaztMemoryIndividualView();
		FaztMemoryTwoPlayersView faztMemoryTwoPlayer = new FaztMemoryTwoPlayersView();
		
		FaztMemoryFinalView finalView = new FaztMemoryFinalView();
		// FarewellView farewellView = new FarewellView();
		
		// Inicializar el administrador de vistas
		ViewManager viewManager = new ViewManager(primaryStage);
		
		// Inicializar controladores
		new FormInitController(formInitView, viewManager, formConfigIndividualGame, faztMemoryTwoPlayer);
		new FaztMemoryConfigIndividualGameController(formConfigIndividualGame, viewManager, faztMemoryIndividual, finalView);
		
		// Inicializar la primera vista
		viewManager.changeView(formInitView.getScene());
	}

	public static void main(String[] args) {
		launch(args);
	}
}
