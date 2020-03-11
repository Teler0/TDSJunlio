package modelo;

public class Estado {

	private String mensaje;
	private String imagen;
	
	public Estado(String mensaje, String imagen) {
		this.mensaje = mensaje;
		this.imagen = imagen;
	}

	public String getMensaje() {
		return mensaje;
	}

	public String getImagen() {
		return imagen;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
}
