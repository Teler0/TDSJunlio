package modelo;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Contacto {
	
	private String nombre;
	private int codigo;
	private String imagen;
	private List<Mensaje> mensajes;
	
	
	public Contacto(String nombre) {
		this.nombre = nombre;
		this.codigo = 0;
		this.imagen = null;
		this.mensajes = new LinkedList<Mensaje>();
	}

	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	public String getNombre() {
		return this.nombre;
	}


	public int getCodigo() {
		return codigo;
	}


	public String getImagen() {
		return imagen;
	}


	public List<Mensaje> getMensajes() {
		return Collections.unmodifiableList(this.mensajes);
	}
	
}
