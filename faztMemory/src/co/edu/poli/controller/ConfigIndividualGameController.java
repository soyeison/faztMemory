package co.edu.poli.controller;

import co.edu.poli.view.ConfigIndivialGameView;
import co.edu.poli.view.FinalView;
import co.edu.poli.view.IndividualView;
import co.edu.poli.view.ViewManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class ConfigIndividualGameController {
	private ConfigIndivialGameView formConfigIndividualView;
	private ViewManager viewManager;
	
	private IndividualView individualGameView;
	private FinalView finalView;

	public ConfigIndividualGameController(ConfigIndivialGameView configIndividualGame, ViewManager viewManagerInstance, IndividualView gameView, FinalView finalView) {
		this.formConfigIndividualView = configIndividualGame;
		this.finalView = finalView;
		this.viewManager = viewManagerInstance;
		this.setIndividualGameView(gameView);
		
		configEvents();
	}
	
	private void configEvents() {
		formConfigIndividualView.getSend().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String optionSelected = formConfigIndividualView.getGameDifficult().getValue();
	            String nameEntered = formConfigIndividualView.getName().getText();

	            // Validar que ambos campos estén completos
	            if (optionSelected == null || nameEntered.isEmpty()) {
	                showAlert(Alert.AlertType.ERROR, "Formulario incompleto", "Por favor, completa todos los campos.");
	            } else {
	            	// Pasarle parametros para que sepa que tamano renderizar
	            	new IndividualGameController(nameEntered, optionSelected, getIndividualView(), finalView, viewManager);
	            	// Mostrar la vista del juego individual
	            	getIndividualView().getTimer().play(); // Iniciar el cronómetro
	            	viewManager.changeView(getIndividualView().getScene());
	            }
			}
		});
	}

	public ConfigIndivialGameView getFormConfigIndividualView() {
		return formConfigIndividualView;
	}

	public void setFormConfigIndividualView(ConfigIndivialGameView formConfigIndividualView) {
		this.formConfigIndividualView = formConfigIndividualView;
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

	public IndividualView getIndividualView() {
		return individualGameView;
	}

	public void setIndividualGameView(IndividualView IndividualGameView) {
		this.individualGameView = IndividualGameView;
	}
}
