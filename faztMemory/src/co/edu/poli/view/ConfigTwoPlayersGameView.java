package co.edu.poli.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class ConfigTwoPlayersGameView {
	private Scene scene;
	private ComboBox<String> gameDifficult;
	private TextField firstName;
	private TextField secondName;
	private Button send;
	
	public ConfigTwoPlayersGameView() {
		Label title = new Label("Por favor rellene los siguientes campos");
		title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
		
		// Creacion ded botones
		Label labelOptions = new Label("Elige una opción:");
        gameDifficult = new ComboBox<>();
        gameDifficult.getItems().addAll("easy", "medium");
        gameDifficult.setPromptText("Seleccionar...");
        
        Label labelName = new Label("Por favor ingrese el nombre de los jugadores:");
        this.firstName = new TextField();
        this.firstName.setPromptText("Nombre del primer jugador: ");
        this.firstName.setStyle("-fx-pref-width: 50px;");
        
        this.secondName = new TextField();
        this.secondName.setPromptText("Nombre del segundo jugador: ");
        this.secondName.setStyle("-fx-pref-width: 50px;");
        
        setSend(new Button("Enviar"));
        
        // VBox para botones
 		VBox layout = new VBox(15);
 		layout.getChildren().addAll(labelOptions, gameDifficult, labelName, firstName, secondName, send);
 		layout.setAlignment(Pos.CENTER);
 		
 		// StackPane para posicionar los botones y el titulo
		StackPane principal = new StackPane();
		principal.getChildren().addAll(title, layout);
		StackPane.setAlignment(title, Pos.TOP_CENTER);
		StackPane.setAlignment(layout, Pos.CENTER);
		principal.setPadding(new Insets(40, 10, 10, 10));
        
		setScene(new Scene (principal, 700, 700));
	}
	
	// getters y setters
	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}
	
	public Button getSend() {
		return this.send;
	}
	
	public void setSend(Button sendBotton) {
		this.send = sendBotton;
	}
	
	public ComboBox<String> getGameDifficult() {
		return this.gameDifficult;
	}
	
	public void setGameDifficult(ComboBox<String> gameDifficult) {
		this.gameDifficult = gameDifficult;
	}
	
	public TextField getFirstName() {
		return this.firstName;
	}
	
	public void setFirstName(TextField playerName) {
		this.firstName = playerName;
	}
	
	public TextField getSecondName() {
		return this.secondName;
	}
	
	public void setSecondName(TextField playerName) {
		this.secondName = playerName;
	}
}
