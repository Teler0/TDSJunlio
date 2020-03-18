package modelo;

public class Contacto {
	
	private String nombre;
	private String imagen;
	
	public Contacto(String nombre) {
		this.nombre = nombre;
		this.imagen = "default_image.png";
	}

	
	public String getNombre() {
		return this.nombre;
	}


	public String getImagen() {
		return imagen;
	}


	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
