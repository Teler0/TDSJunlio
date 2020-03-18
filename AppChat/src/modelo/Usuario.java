package modelo;

import java.util.Date;
import java.util.List;
import java.util.LinkedList;

public class Usuario implements Descuento {

	String alias; //Nombre del usuario en AppChat
	String nombre; //Nombre real del usuario
	String numero;
	String password;
	boolean isPremiun;
	String imagen;
	Date fechaDeNacimiento;
	String saludo;
	String email;
	int id;
	List<Contacto> listaDeContactos;
	Date fechaRegistro;
	
	private Usuario(String alias, String nombre, Date fechaDeNacimiento, String numero, String password, String email, String saludo) {
		this.alias = alias;
		this.nombre = nombre;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.numero = numero;
		this.password = password;
		this.email = email;
		if(saludo==null){
			this.saludo = "Hola, buenos dias";
		}else { this.saludo = saludo;}
		this.imagen = "imagenpordefecto";
		this.isPremiun = false;
		this.listaDeContactos = new LinkedList<Contacto>();
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isPremiun() {
		return isPremiun;
	}
	public void setPremiun(boolean isPremiun) {
		this.isPremiun = isPremiun;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public Date getFechadenacimiento() {
		return fechaDeNacimiento;
	}
	public void setFechadenacimiento(Date fechadenacimiento) {
		this.fechaDeNacimiento = fechadenacimiento;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getSaludo() {
		return saludo;
	}
	public void setSaludo(String saludo) {
		this.saludo = saludo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void añadirContacto(Contacto contacto) {
		
		listaDeContactos.add(contacto);
		
	}
	
	public void eliminarContacto(Contacto contacto) {
		
		listaDeContactos.remove(contacto);
		
	}
	
}	
	

