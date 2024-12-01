package co.edu.poli.controller;

import co.edu.poli.view.ConfigIndivialGameView;
import co.edu.poli.view.ConfigTwoPlayersGameView;
import co.edu.poli.view.FinalView;
import co.edu.poli.view.IndividualView;
import co.edu.poli.view.TwoPlayersView;
import co.edu.poli.view.FormInitView;
import co.edu.poli.view.ViewManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// Crear la vista del formulario inicial
		FormInitView formInitView = new FormInitView();
		ConfigIndivialGameView formConfigIndividualGame = new ConfigIndivialGameView();
		IndividualView faztMemoryIndividual = new IndividualView();
		ConfigTwoPlayersGameView formConfigTwoPlayers = new ConfigTwoPlayersGameView();
		TwoPlayersView faztMemoryTwoPlayer = new TwoPlayersView();
		
		FinalView finalView = new FinalView();
		// FarewellView farewellView = new FarewellView();
		
		// Inicializar el administrador de vistas
		ViewManager viewManager = new ViewManager(primaryStage);
		
		// Inicializar controladores
		new FormInitController(formInitView, viewManager, formConfigIndividualGame, formConfigTwoPlayers);
		new ConfigIndividualGameController(formConfigIndividualGame, viewManager, faztMemoryIndividual, finalView);
		new ConfigTwoPlayersGameController(formConfigTwoPlayers, viewManager, faztMemoryTwoPlayer, finalView);
		
		// Inicializar la primera vista
		viewManager.changeView(formInitView.getScene());
	}

	public static void main(String[] args) {
		launch(args);
	}
}
