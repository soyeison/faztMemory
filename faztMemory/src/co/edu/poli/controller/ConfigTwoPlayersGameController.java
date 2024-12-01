package co.edu.poli.controller;

import co.edu.poli.view.ConfigTwoPlayersGameView;
import co.edu.poli.view.FinalView;
import co.edu.poli.view.TwoPlayersView;
import co.edu.poli.view.ViewManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class ConfigTwoPlayersGameController {
	private ConfigTwoPlayersGameView formConfigTwoPlayersView;
	private TwoPlayersView twoPlayersView;
	private ViewManager viewManager;
	private FinalView finalView;
	
	public ConfigTwoPlayersGameController(ConfigTwoPlayersGameView formConfigTwoPlayers, ViewManager viewManagerInstance, TwoPlayersView twoPlayersViewInstance, FinalView finalView) {
		this.formConfigTwoPlayersView = formConfigTwoPlayers;
		this.twoPlayersView = twoPlayersViewInstance;
		this.viewManager = viewManagerInstance;
		this.finalView = finalView;
		
		configEvents();
	}
	
	private void configEvents() {
		formConfigTwoPlayersView.getSend().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String optionSelected = formConfigTwoPlayersView.getGameDifficult().getValue();
				String firstName = formConfigTwoPlayersView.getFirstName().getText();
				String secondName = formConfigTwoPlayersView.getSecondName().getText();
				
				// Validar que ambos campos estén completos
	            if (optionSelected == null || firstName.isEmpty() || secondName.isEmpty()) {
	                showAlert(Alert.AlertType.ERROR, "Formulario incompleto", "Por favor, completa todos los campos.");
	            } else {
	            	// Inicilizar controlador de juego para dos
	            	new TwoPlayersGameController(firstName, secondName, optionSelected, twoPlayersView, finalView, viewManager);
	            	// Mostrar la vista del juego para dos
	            	viewManager.changeView(twoPlayersView.getScene());
	            }
			}
		});
	}

	public ConfigTwoPlayersGameView getFormConfigTwoPlayersView() {
		return formConfigTwoPlayersView;
	}

	public void setFormConfigTwoPlayersView(ConfigTwoPlayersGameView formConfigTwoPlayersView) {
		this.formConfigTwoPlayersView = formConfigTwoPlayersView;
	}
	
	// Metodos
	// Método para mostrar alertas
    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alerta = new Alert(type);
        alerta.setTitle(title);
        alerta.setHeaderText(null);
        alerta.setContentText(message);
        alerta.showAndWait();
    }
}
