package co.edu.poli.model;

public class Card {
	private String imageFront;
	private String imageBottom;
	private boolean isDiscovered = false;
	
	public Card(String imageFront, String imageBottom) {
		this.imageFront = imageFront;
		this.imageBottom = imageBottom;
	}
	
	// getters y setters
	public String getImagefront() {
		return this.imageFront;
	}
	
	public void setImageFront(String imageFront) {
		this.imageFront = imageFront;
	}
	
	public String getImageBottom() {
		return this.imageBottom;
	}
	
	public void setImageBottom(String imageBottom) {
		this.imageBottom = imageBottom;
	}
	
	public boolean getIsDiscovered() {
		return this.isDiscovered;
	}
	
	public void setIsDiscovered() {
		this.isDiscovered = true;
	}
	
	// Metodos
	public boolean isEqual(Card card) {
		if (card.imageBottom == this.imageBottom) {
			return true;
		} else {
			return false;
		}
	}
}
