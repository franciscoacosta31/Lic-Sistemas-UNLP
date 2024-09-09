package ar.edu.unlp.oo1.ejercicio1.impl;

import ar.edu.unlp.oo1.ejercicio1.WallPost;

public class WallPostImpl implements WallPost {

	private String text = "Undefined post";
	private int likes;
	private boolean featured;
	
	
	public WallPostImpl(String text, int likes, boolean featured) {
		this.text = text;
		this.likes = likes;
		this.featured = featured;
	}
	
	public WallPostImpl() {}

	
    @Override
    public String toString() {
        return "WallPost {" +
            "text: " + getText() +
            ", likes: '" + getLikes() + "'" +
            ", featured: '" + isFeatured() + "'" +
            "}";
    }

    // Retorna el texto descriptivo de la publicación
	@Override
	public String getText() {
		return this.text;
	}
	
	// Setea el texto descriptivo de la publicación
	@Override
	public void setText(String text) {
		this.text = text;
	}

	// Retorna la cantidad de “me gusta”
	@Override
	public int getLikes() {
		return this.likes;
	}

	// Incrementa la cantidad de likes en uno
	@Override
	public void like() {
		this.likes++;
	}

	// Decrementa la cantidad de likes en uno. Si ya es 0, no hace nada
	@Override
	public void dislike() {
		if(this.likes > 0) {
			this.likes--;
		}
	}

	// Retorna true si el post está marcado como destacado, false en caso contrario
	@Override
	public boolean isFeatured() {
		return this.featured;
	}

	// Cambia el post del estado destacado a no destacado y viceversa
	@Override
	public void toggleFeatured() {
		this.featured = !this.featured;
	}
}
