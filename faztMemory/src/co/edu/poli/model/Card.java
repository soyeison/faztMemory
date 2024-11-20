package co.edu.poli.model;

public class Card {
	// Imagen que se muestra en el frente de la carta
	private String imageFront;
	// Imagen que se muestra en la parte posterior de La carta
	private String imageBottom;
	// Estado de La carta (true si está descubierta)
	private boolean isDiscovered = false;
	
	/*
	 * Inicializa una instancia del objeto carta conlas dos imagenes como parametros
	 * 
	 */
	public Card(String imageFront, String imageBottom) {
		this.imageFront = imageFront;
		this.imageBottom = imageBottom;
	}
	
	// getters y setters
	
	/*
	 * DevuLeve La imagen deL frente de La carta.
	 * 
	 */
	public String getImagefront() {
		return this.imageFront;
	}
	
	/**
	 * Establece una nueva imagen para el frente de La carta.
	 * 
	 * @param imagenFront La nueva iamgen para el frente. 
	 */
	public void setImageFront(String imageFront) {
		this.imageFront = imageFront;
	}
	
	/**
	 * DevuLeve La imagen deL reverso de La carta.
	 * 
	 * @return String Imagen del reverso como un string.
	 */
	public String getImageBottom() {
		return this.imageBottom;
	}
	
	/**
	 * EstabLece una nueva imagen para el reverso de La carta.
	 * 
	 * @return "true" si La carta está descuvierta, "false" en caso contrario. 
	 */
	public void setImageBottom(String imageBottom) {
		this.imageBottom = imageBottom;
	}
	
	/** 
	 * Devuelve el estado actual de La carta
	 * 
	 * @return "true" si la carta está descubierta, "false" en caso contrario.
	 */
	public boolean getIsDiscovered() {
		return this.isDiscovered;
	}
	
	/** 
	 * cambia el estado de La carta a "descubierta"
	 */
	public void setIsDiscovered() {
		this.isDiscovered = true;
	}
	
	// Metodos funcionales
	
	/** 
	 * verifica si el reverso de esta carta es igual al de otra carta.
	 * 
	 * @param card La carta con La que se va a comparar
	 * @return "true" si los reversos de ambas cartas son iguales, "false" en caso contrario. 
	 */
	public boolean isEqual(Card card) {
		if (card.imageBottom == this.imageBottom) {
			return true;
		} else {
			return false;
		}
	}
}
