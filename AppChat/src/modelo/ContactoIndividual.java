package modelo;

public class ContactoIndividual extends Contacto {

	private String telefono;
	
	public ContactoIndividual(String nombre, String telefono) {
		super(nombre);
		this.telefono = telefono;
	}
	/**/
	
	public String getTelefono() {
		return this.telefono;
	}
}
