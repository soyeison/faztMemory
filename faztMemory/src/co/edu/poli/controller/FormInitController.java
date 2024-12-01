package co.edu.poli.controller;

import co.edu.poli.view.FaztMemoryConfigIndivialGameView;
import co.edu.poli.view.FaztMemoryTwoPlayersView;
import co.edu.poli.view.FormInitView;
import co.edu.poli.view.ViewManager;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class FormInitController {
	private FormInitView formInitView;
	private ViewManager viewManager;
	private FaztMemoryConfigIndivialGameView faztMemoryConfigIndividualViewInstance;
	private FaztMemoryTwoPlayersView faztMemoryTwoPlayersView;
	
	public FormInitController(FormInitView initViewInstance, ViewManager viewManagerInstance, FaztMemoryConfigIndivialGameView faztMemoryConfigIndividualViewInstance, FaztMemoryTwoPlayersView faztMemoryTwoPlayersInstance) {
		this.formInitView = initViewInstance;
		this.viewManager = viewManagerInstance;
		this.setFaztMemoryConfigIndividualViewInstance(faztMemoryConfigIndividualViewInstance);
		this.setFaztMemoryTwoPlayersView(faztMemoryTwoPlayersInstance);
		
		configEvents();
	}
	
	public void configEvents() {
		// Agregar eventos para respondedr a botones
		formInitView.getInidivualGame().setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				viewManager.changeView(getFaztMemoryConfigIndividualViewInstance().getScene());
			}
		});
		
		formInitView.getTwoPlayersGame().setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				viewManager.changeView(getFaztMemoryTwoPlayersView().getScene());
			}
		});
	}

	public FaztMemoryTwoPlayersView getFaztMemoryTwoPlayersView() {
		return faztMemoryTwoPlayersView;
	}

	public void setFaztMemoryTwoPlayersView(FaztMemoryTwoPlayersView faztMemoryTwoPlayersView) {
		this.faztMemoryTwoPlayersView = faztMemoryTwoPlayersView;
	}

	public FaztMemoryConfigIndivialGameView getFaztMemoryConfigIndividualViewInstance() {
		return faztMemoryConfigIndividualViewInstance;
	}

	public void setFaztMemoryConfigIndividualViewInstance(FaztMemoryConfigIndivialGameView faztMemoryConfigIndividualViewInstance) {
		this.faztMemoryConfigIndividualViewInstance = faztMemoryConfigIndividualViewInstance;
	}


}
