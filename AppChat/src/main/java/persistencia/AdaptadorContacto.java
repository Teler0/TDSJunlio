package persistencia;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import beans.Entidad;
import beans.Propiedad;
import modelo.Contacto;
import modelo.ContactoIndividual;
import modelo.Grupo;
import modelo.Mensaje;
import modelo.Usuario;
import tds.driver.FactoriaServicioPersistencia;
import tds.driver.ServicioPersistencia;

public class AdaptadorContacto implements IAdaptadorContactoDAO {

	private static ServicioPersistencia servPersistencia;
	private static AdaptadorContacto unicaInstancia = null;

	public static AdaptadorContacto getUnicaInstancia() {
		if (unicaInstancia == null)
			return new AdaptadorContacto();
		else
			return unicaInstancia;
	}

	private AdaptadorContacto() { 
		servPersistencia = FactoriaServicioPersistencia.getInstance().getServicioPersistencia(); 
	}
	
	/*esto es un cambio ------------*/
	
	
	public boolean registrarContacto(Contacto contacto) {
		
		Entidad eContacto;
		boolean existe = true;
		
		// Si la entidad est� registrada no la registra de nuevo
		try {
			eContacto = servPersistencia.recuperarEntidad(contacto.getCodigo());
		} catch (NullPointerException e) {
			existe = false;
		}
		
		if (existe) return false;
		
		eContacto = new Entidad();
		eContacto.setNombre("contacto");
		eContacto.setPropiedades(new ArrayList<Propiedad>(
				Arrays.asList(new Propiedad("nombre", contacto.getNombre()),
						new Propiedad("codigo", Integer.toString(contacto.getCodigo())), new Propiedad("imagen",contacto.getImagen()),
						new Propiedad("mensajes", obtenerMensajes(contacto.getMensajes()))
		 )));
		
		if (contacto instanceof ContactoIndividual) {
			eContacto = registrarContactoIndividual(eContacto, (ContactoIndividual) contacto);
		} else {
			eContacto = registrarGrupo(eContacto, (Grupo) contacto);
		}	
		
		if (contacto instanceof Grupo) {
			eContacto = registrarGrupo(eContacto, (Grupo) contacto);
		} else if (contacto instanceof ContactoIndividual) {
			eContacto = registrarContactoIndividual(eContacto, (ContactoIndividual) contacto);
		}
		
		return true;
	}

	
	public void borrarContacto(Contacto contacto) {
		Entidad eContacto = servPersistencia.recuperarEntidad(contacto.getCodigo());
		servPersistencia.borrarEntidad(eContacto);
	}


	public void modificarContacto(Contacto contacto) {
		// TODO Auto-generated method stub

	
		
		
		
		
	}

	
	public Contacto recuperarContactoIndividual(Entidad eContacto, String nombre, int codigo) {
		String telefono;
		telefono = servPersistencia.recuperarPropiedadEntidad(eContacto, "telefono"); //Recuperamos el  telefono
		Contacto contactoIndividual = new ContactoIndividual(nombre, telefono); //Creamos el contacto
		
		PoolDAO.getUnicaInstancia().addObjeto(codigo, contactoIndividual); //Añadimos el contacto y su codigo
		
		AdaptadorUsuario adaptadorUsuario = AdaptadorUsuario.getUnicaInstancia(); //Creamos una intancia de usuario para poder recuperarlo
		String idUsuario = servPersistencia.recuperarPropiedadEntidad(eContacto, "usuario"); //Recuperamos el numero
		
		Usuario usuario  = adaptadorUsuario.recuperarUsuario(idUsuario); //Recuperamos el contacto usando el numero
		((ContactoIndividual) contactoIndividual).setUsuario(usuario); //Hacemos casting y le metemos al usuario (ponerlo de otra forma)
		
		return contactoIndividual; 
	}
	
	
	public Contacto recuperarGrupo(Entidad eContacto, String nombre, int codigo) {

		Contacto grupo = new Grupo(nombre);
		PoolDAO.getUnicaInstancia().addObjeto(codigo, grupo);
		
		AdaptadorUsuario adaptadorUsuario = AdaptadorUsuario.getUnicaInstancia(); 
		int numeroUsuario = servPersistencia.recuperarPropiedadEntidad(eContacto, "admin");
		
		Usuario admin  = adaptadorUsuario.recuperarUsuario(codigoUsuario);
		((Grupo) grupo).setAdmin(admin);  // De aqui para arriba copy-paste de contactoIndividual
		

		
		return grupo;
	}

	

	public Contacto recuperarContacto(int codigo) {
		
		// Si la entidad est� en el pool la devuelve directamente
		if (PoolDAO.getUnicaInstancia().contiene(codigo))
			return (Contacto) PoolDAO.getUnicaInstancia().getObjeto(codigo);

		// si no, la recupera de la base de datos
		Entidad eContacto;
		String nombre;
		String imagen;

		// recuperar entidad
		eContacto = servPersistencia.recuperarEntidad(codigo);

		// recuperar propiedades que no son objetos
		nombre = servPersistencia.recuperarPropiedadEntidad(eContacto, "nombre");
		imagen = servPersistencia.recuperarPropiedadEntidad(eContacto, "imagen");
		String numero = servPersistencia.recuperarPropiedadEntidad(eUsuario, "numero");
		
		Contacto contacto;
		try {
			contacto = recuperarContactoIndividual(eContacto, nombre, codigo);
		} catch (Exception e) {
			contacto = recuperarGrupo(codigo, eContacto, nombre);
		}
		
		contacto.setImagen(imagen); //Insertamos lo que falta
		contacto.setCodigo(codigo);
		
		// IMPORTANTE:a�adir el cliente al pool antes de llamar a otros
		// adaptadores
		PoolDAO.getUnicaInstancia().addObjeto(nombre);

		// recuperar propiedades que son objetos llamando a adaptadores
		// ventas
		return contacto;

	}

	@Override
	public List<Contacto> recuperarTodosContactos() {
		// TODO Auto-generated method stub
		return null;
	}

	///Funcionalidad 
	
	private String obtenerMensajes(List<Mensaje> mensajes) {
		String texto = "";
		for (Mensaje mensaje : mensajes) {
			texto += mensaje.getTexto() + ";;";
		}
		return texto;
	}
	
	
	private Entidad registrarGrupo(Entidad eContacto, Grupo grupo) {

		List<Propiedad> propiedades = eContacto.getPropiedades();
		propiedades.add(new Propiedad("administrador", String.valueOf(grupo.getAdministrador().getNumero())));
		propiedades.add(new Propiedad("contactos", AdaptadorUsuario.obtenerContactos(grupo.getContactos())));
		eContacto.setPropiedades(propiedades);
		return eContacto;

	}
	
	private Entidad registrarContactoIndividual(Entidad eContacto, ContactoIndividual contacto) {
		
		List<Propiedad> propiedades = eContacto.getPropiedades();
		propiedades.add(new Propiedad("numero", contacto.getTelefono()));
		propiedades.add(newPropiedad("usuario",String.valueOf(contacto.getUsuario().getNumero()));		
		eContacto.setPropiedades(propiedades);
		return eContacto;
	}


	
/*	private <L> List<L> obtenerMensajesDesdeCodigos(String lineas) {

		List<T> mensajes = new LinkedList<T>();
		StringTokenizer strTok = new StringTokenizer(lineas, ",");
		AdaptadorMensajeTDS adaptadorMensaje = AdaptadorMensajeTDS.getUnicaInstancia();
		while (strTok.hasMoreTokens()) {
			mensajes.add((T) adaptadorMensaje.recuperarMensaje(Integer.valueOf((String) strTok.nextElement())));
		}
		return mensajes;
	}*/
	
}
