package modelo;

public class Estado {

	private String mensaje;  ///Supongo que el mensaje es una cadena en si, no un objeto de la clase mensaje como antes.
	private String imagen;
	
	public Estado(String mensaje) {
		this.mensaje = mensaje;
		this.imagen = "default_image.png";
	}

	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getImagen() {
		return imagen;
	}

	
	

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	
	
}
