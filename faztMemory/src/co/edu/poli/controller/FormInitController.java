package co.edu.poli.controller;

import co.edu.poli.view.ConfigIndivialGameView;
import co.edu.poli.view.ConfigTwoPlayersGameView;
import co.edu.poli.view.TwoPlayersView;
import co.edu.poli.view.FormInitView;
import co.edu.poli.view.ViewManager;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class FormInitController {
	private FormInitView formInitView;
	private ViewManager viewManager;
	private ConfigIndivialGameView configIndividualViewInstance;
	private ConfigTwoPlayersGameView configTwoPlayersViewInstance;
	
	public FormInitController(FormInitView initViewInstance, ViewManager viewManagerInstance, ConfigIndivialGameView configIndividualViewInstance, ConfigTwoPlayersGameView faztMemoryTwoPlayersInstance) {
		this.formInitView = initViewInstance;
		this.viewManager = viewManagerInstance;
		this.configIndividualViewInstance = configIndividualViewInstance;
		this.configTwoPlayersViewInstance = faztMemoryTwoPlayersInstance;
		
		configEvents();
	}
	
	public void configEvents() {
		// Agregar eventos para respondedr a botones
		formInitView.getInidivualGame().setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				viewManager.changeView(configIndividualViewInstance.getScene());
			}
		});
		
		formInitView.getTwoPlayersGame().setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				viewManager.changeView(configTwoPlayersViewInstance.getScene());
			}
		});
	}

}
