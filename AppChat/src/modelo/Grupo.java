package modelo;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Grupo extends Contacto {
		
	private List<ContactoIndividual> contactos;
		/**/
	private Usuario administrador;

	
	public Grupo(String nombreGrupo) {
		super(nombreGrupo);
		this.contactos = new LinkedList<ContactoIndividual>();
		this.administrador = null;
		//Establecer imagen
	}

	public List<ContactoIndividual> getContactos() {
		return Collections.unmodifiableList(this.contactos);
	}

	public Usuario getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Usuario administrador) {
		this.administrador = administrador;
	}
	
	
	public void addContacto(ContactoIndividual contacto) {
		this.contactos.add(contacto);
	}
	
	
	
 }
	