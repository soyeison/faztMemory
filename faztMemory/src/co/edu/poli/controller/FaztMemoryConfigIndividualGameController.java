package co.edu.poli.controller;

import co.edu.poli.view.FaztMemoryConfigIndivialGameView;
import co.edu.poli.view.FaztMemoryFinalView;
import co.edu.poli.view.FaztMemoryIndividualView;
import co.edu.poli.view.ViewManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class FaztMemoryConfigIndividualGameController {
	private FaztMemoryConfigIndivialGameView formConfigIndividualView;
	private ViewManager viewManager;
	
	private FaztMemoryIndividualView faztMemoryIndividualGameView;
	private FaztMemoryFinalView finalView;

	public FaztMemoryConfigIndividualGameController(FaztMemoryConfigIndivialGameView configIndividualGame, ViewManager viewManagerInstance, FaztMemoryIndividualView gameView, FaztMemoryFinalView finalView) {
		this.formConfigIndividualView = configIndividualGame;
		this.finalView = finalView;
		this.viewManager = viewManagerInstance;
		this.setFaztMemoryIndividualGameView(gameView);
		
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
	            	new FaztMemoryIndividualGameController(nameEntered, optionSelected, getFaztMemoryIndividualGameView(), finalView, viewManager);
	            	// Mostrar la vista del juego individual
	            	getFaztMemoryIndividualGameView().getTimer().play(); // Iniciar el cronómetro
	            	viewManager.changeView(getFaztMemoryIndividualGameView().getScene());
	            }
			}
		});
	}

	public FaztMemoryConfigIndivialGameView getFormConfigIndividualView() {
		return formConfigIndividualView;
	}

	public void setFormConfigIndividualView(FaztMemoryConfigIndivialGameView formConfigIndividualView) {
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

	public FaztMemoryIndividualView getFaztMemoryIndividualGameView() {
		return faztMemoryIndividualGameView;
	}

	public void setFaztMemoryIndividualGameView(FaztMemoryIndividualView faztMemoryIndividualGameView) {
		this.faztMemoryIndividualGameView = faztMemoryIndividualGameView;
	}
}
