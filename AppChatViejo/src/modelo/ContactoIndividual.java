package modelo;

public class ContactoIndividual extends Contacto {

	private String telefono;
	private Usuario usuario;
	
	public ContactoIndividual(String nombre, String telefono) {
		super(nombre);
		this.telefono = telefono;
		this.usuario = null;
	}

	
	public String getTelefono() {
		return this.telefono;
	}	
	
	public void setUsuario(Usuario usuario) {
		
		this.usuario = usuario;
		this.setImagen(usuario.getImagen());
	}
	
	public Usuario getUsuario() {
		
		return usuario;
		
}}
