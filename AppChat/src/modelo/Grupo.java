package modelo;

import java.util.LinkedList;
import java.util.List;

public class Grupo extends Contacto {
		
	private List<ContactoIndividual> contactos;
		
	private Usuario administrador;
	private String nombreGrupo;
	
	//Falta implementar constructor
	public Grupo(String nombreGrupo, Usuario administrador) {
		
		super(nombreGrupo);
		this.administrador = administrador;
		this.contactos = new LinkedList<ContactoIndividual>();
		
	}

	public List<ContactoIndividual> getContactos() {
		return contactos;
	}

	public void setContactos(List<ContactoIndividual> contactos) {
		this.contactos = contactos;
	}

	public Usuario getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Usuario administrador) {
		this.administrador = administrador;
	}

	public String getNombreGrupo() {
		return nombreGrupo;
	}

	public void setNombreGrupo(String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}
	
	public void añadirMiembro(ContactoIndividual contacto) {
		
		contactos.add(contacto);
		
	}
	
	public void eliminarMiembro(Usuario admin, ContactoIndividual contacto) {
		
		if(admin == administrador) {
		
		contactos.remove(contacto);
		} else {System.out.println("No tienes permisos de administrador");} // Crearemos una ventana emergente de esas.
	}
	
	
	
 }
	