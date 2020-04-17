package modelo;

import java.time.LocalTime;

public class Mensaje {
	
	int codigo; // Para identificarlos mas claramente
	String texto;
	Usuario emisor;
	Contacto receptor; // Puede ser un grupo o contacto individual.
	LocalTime  timestamp;
	
	private Mensaje(String texto, Usuario emisor, Contacto receptor){
		
		codigo = 0;
		this.texto = texto;
		this.emisor = emisor;
		this.receptor = receptor;
		timestamp = LocalTime.now(); // Da la hora actual
				
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Usuario getEmisor() {
		return emisor;
	}

	public void setEmisor(Usuario emisor) {
		this.emisor = emisor;
	}

	public Contacto getReceptor() {
		return receptor;
	}

	public void setReceptor(Contacto receptor) {
		this.receptor = receptor;
	}

	public LocalTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalTime timestamp) {
		this.timestamp = timestamp;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	
	
	
	

}
