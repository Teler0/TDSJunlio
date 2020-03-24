package modelo;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Grupo extends Contacto {
		
	private List<ContactoIndividual> contactos;
	private Usuario administrador;

	public Grupo(String nombreGrupo) {
		super(nombreGrupo);
		this.contactos = new LinkedList<ContactoIndividual>();
		this.administrador = null;
		//Establecer imagen
	}
	//Falta implementar constructor
	public Grupo(String nombreGrupo, Usuario administrador) {
		
		super(nombreGrupo);
		this.administrador = administrador;
		this.contactos = new LinkedList<ContactoIndividual>();
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

	public void setContactos(List<ContactoIndividual> contactos) {
		this.contactos = contactos;
	}
	
	public void añadirMiembro(ContactoIndividual contacto) {
		
		contactos.add(contacto);
		
	}
	
	public void eliminarMiembro(Usuario admin, ContactoIndividual contacto) {
		
		if(admin == administrador) {
			contactos.remove(contacto);
		} else {
			System.out.println("No tienes permisos de administrador");
		} // Crearemos una ventana emergente de esas.
	}

	
	
	
	
 }
	