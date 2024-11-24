package co.edu.poli.controller;

import co.edu.poli.view.FaztMemoryIndividualView;
import co.edu.poli.view.FaztMemoryTwoPlayersView;
import co.edu.poli.view.FormInitView;
import co.edu.poli.view.ViewManager;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class FormInitController {

	private FormInitView formInitView;
	private ViewManager viewManager;
	// private FaztMemoryView faztMemoryView;
	private FaztMemoryIndividualView faztMemoryIndividualView;
	private FaztMemoryTwoPlayersView faztMemoryTwoPlayersView;
	
	public FormInitController(FormInitView initViewInstance, ViewManager viewManagerInstance, FaztMemoryIndividualView faztMemoryIndividualViewInstance, FaztMemoryTwoPlayersView faztMemoryTwoPlayersInstance) {
		this.formInitView = initViewInstance;
		this.viewManager = viewManagerInstance;
		this.setFaztMemoryIndividualView(faztMemoryIndividualViewInstance);
		this.setFaztMemoryTwoPlayersView(faztMemoryTwoPlayersInstance);
		
		configEvents();
	}
	
	public void configEvents() {
		// Agregar eventos para respondedr a botones
		formInitView.getInidivualGame().setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				viewManager.changeView(getFaztMemoryIndividualView().getScene());
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

	public FaztMemoryIndividualView getFaztMemoryIndividualView() {
		return faztMemoryIndividualView;
	}

	public void setFaztMemoryIndividualView(FaztMemoryIndividualView faztMemoryIndividualView) {
		this.faztMemoryIndividualView = faztMemoryIndividualView;
	}
}
