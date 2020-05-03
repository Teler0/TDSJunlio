package persistencia;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import beans.Entidad;
import beans.Propiedad;
import modelo.Contacto;
import modelo.Usuario;
import tds.driver.FactoriaServicioPersistencia;
import tds.driver.ServicioPersistencia;

public class AdaptadorUsuario implements IAdaptadorUsuarioDAO {

	
	private static ServicioPersistencia servPersistencia;
	private static AdaptadorUsuario unicaInstancia = null;
	
	
	public static AdaptadorUsuario getUnicaInstancia() { // patron singleton
		if (unicaInstancia == null)
			return new AdaptadorUsuario();
		else
			return unicaInstancia;
	}
	
	private AdaptadorUsuario() {
		servPersistencia = FactoriaServicioPersistencia.getInstance().getServicioPersistencia();
	}
	
	
	@Override
	public boolean registrarUsuario(Usuario cliente) {
		Entidad eUsuario;
		boolean existe = true;
		
		// Si la entidad est� registrada no la registra de nuevo
		try {
			eUsuario = servPersistencia.recuperarEntidad(Integer.parseInt(cliente.getNumero()));
		} catch (NullPointerException e) {
			existe = false;
		}
		
		if (existe) return false;
		
		// crear entidad Usuario
		eUsuario = new Entidad();
		eUsuario.setNombre("usuario");
		eUsuario.setPropiedades(new ArrayList<Propiedad>(
				Arrays.asList(new Propiedad("numero", cliente.getNumero()), new Propiedad("nombre", cliente.getNombre()),
						new Propiedad("alias", cliente.getAlias()), new Propiedad("password",cliente.getPassword()),
						new Propiedad("imagen", cliente.getImagen()), new Propiedad("saludo", cliente.getSaludo()),
						new Propiedad("email", cliente.getEmail()), new Propiedad("isPremiun", Boolean.toString(cliente.isPremiun())),
						new Propiedad("id", Integer.toString(cliente.getId())), new Propiedad("fechaDeNacimiento", cliente.getFechaDeNacimiento()),
						new Propiedad("fechaDeRegistro", stringFecha(cliente.getFechaRegistro())), new Propiedad("listaDeContactos", obtenerContactos(cliente.getListaDeCntactos()))
		 )));
		
		// registrar entidad cliente
		eUsuario = servPersistencia.registrarEntidad(eUsuario);
		// asignar identificador unico
		// Se aprovecha el que genera el servicio de persistencia
	
		/*
		Falta la lista
		List<Contacto> listaDeContactos;*/
		
		return true; //Se ha creado
	}

	@Override
	public void borrarUsuario(Usuario cliente) {
		// TODO Auto-generated method stub
		Entidad eUsuario = servPersistencia.recuperarEntidad(Integer.parseInt(cliente.getNumero()));
		servPersistencia.borrarEntidad(eUsuario);
	}

	@Override
	public void modificarUsuario(Usuario cliente) {
		// TODO Auto-generated method stub
		
		Entidad eUsuario = servPersistencia.recuperarEntidad(Integer.parseInt(cliente.getNumero()));

		servPersistencia.eliminarPropiedadEntidad(eUsuario, "numero");
		servPersistencia.anadirPropiedadEntidad(eUsuario, "numero", cliente.getNumero());
		servPersistencia.eliminarPropiedadEntidad(eUsuario, "nombre");
		servPersistencia.anadirPropiedadEntidad(eUsuario, "nombre", cliente.getNombre());
		servPersistencia.eliminarPropiedadEntidad(eUsuario, "alias");
		servPersistencia.anadirPropiedadEntidad(eUsuario, "alias", cliente.getAlias());
		servPersistencia.eliminarPropiedadEntidad(eUsuario, "password");
		servPersistencia.anadirPropiedadEntidad(eUsuario, "password", cliente.getPassword());
		servPersistencia.eliminarPropiedadEntidad(eUsuario, "fechaDeNacimiento");
		servPersistencia.anadirPropiedadEntidad(eUsuario, "fehcaDeNacimiento", cliente.getFechaDeNacimiento());
		servPersistencia.eliminarPropiedadEntidad(eUsuario, "fechaDeRegistro");
		servPersistencia.anadirPropiedadEntidad(eUsuario, "fechaDeRegistro", stringFecha(cliente.getFechaRegistro()));
		servPersistencia.eliminarPropiedadEntidad(eUsuario, "id");
		servPersistencia.anadirPropiedadEntidad(eUsuario, "id", Integer.toString(cliente.getId()));
		servPersistencia.eliminarPropiedadEntidad(eUsuario, "email");
		servPersistencia.anadirPropiedadEntidad(eUsuario, "email", cliente.getEmail());
		servPersistencia.eliminarPropiedadEntidad(eUsuario, "password");
		servPersistencia.anadirPropiedadEntidad(eUsuario, "password", cliente.getPassword());
		servPersistencia.eliminarPropiedadEntidad(eUsuario, "imagen");
		servPersistencia.anadirPropiedadEntidad(eUsuario, "imagen", cliente.getImagen());
		servPersistencia.eliminarPropiedadEntidad(eUsuario, "saludo");
		servPersistencia.anadirPropiedadEntidad(eUsuario, "saludo", cliente.getSaludo());
		servPersistencia.eliminarPropiedadEntidad(eUsuario, "isPremiun");
		servPersistencia.anadirPropiedadEntidad(eUsuario, "isPremiun", Boolean.toString(cliente.isPremiun()));
	}


	@Override
	public List<Usuario> recuperarTodosUsuarios() {
		// TODO Auto-generated method stub
		
		List<Entidad> eUsuarios = servPersistencia.recuperarEntidades("usuario");
		List<Usuario> usuarios = new LinkedList<Usuario>();

		for (Entidad eUsuario : eUsuarios) {
			usuarios.add(recuperarUsuario(eUsuario.getId()));
		}
		
		return usuarios;
	}

	/*===================FUNCIONALIDAD==================*/
		
	public static String stringFecha(Date fecha)
    {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String fechaString = formato.format(fecha);
    	
        return fechaString;
    }
	
	@Override
	public Usuario recuperarUsuario(String codigo) { // pone codigo, pero nah es el numero

		int numero = Integer.parseInt(codigo);
		// Si la entidad est� en el pool la devuelve directamente
		if (PoolDAO.getUnicaInstancia().contiene(numero))
			return (Usuario) PoolDAO.getUnicaInstancia().getObjeto(numero);

		// si no, la recupera de la base de datos
		Entidad eUsuario;
		String nombre;
		String alias;

		// recuperar entidad
		eUsuario = servPersistencia.recuperarEntidad(numero);

		// recuperar propiedades que no son objetos
		alias = servPersistencia.recuperarPropiedadEntidad(eUsuario, "alias");
		nombre = servPersistencia.recuperarPropiedadEntidad(eUsuario, "nombre");
		String password = servPersistencia.recuperarPropiedadEntidad(eUsuario, "password");
		String email = servPersistencia.recuperarPropiedadEntidad(eUsuario, "email");
		String numeroU = servPersistencia.recuperarPropiedadEntidad(eUsuario, "numero");
		String saludo = servPersistencia.recuperarPropiedadEntidad(eUsuario, "saludo");
		String fechaDeNacimiento = servPersistencia.recuperarPropiedadEntidad(eUsuario, "fechaDeNacimiento");
		
		Usuario cliente = new Usuario(alias, nombre, fechaDeNacimiento, numeroU, password, email, saludo);

		// IMPORTANTE:a�adir el cliente al pool antes de llamar a otros
		// adaptadores
		PoolDAO.getUnicaInstancia().addObjeto(numero, cliente);

		// recuperar propiedades que son objetos llamando a adaptadores
		// ventas
		return cliente;
		
	}

	
	public String obtenerContactos(List<C> contactos) {
		String codigos = "";
		for (Object contacto : contactos) {
			codigos += ((Contacto)contacto).getCodigo() + ",";
		}
		return codigos;
	}
	
	
	
}
