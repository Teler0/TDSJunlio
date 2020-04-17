package persistencia;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import beans.Entidad;
import beans.Propiedad;
import modelo.Usuario;
import tds.driver.FactoriaServicioPersistencia;
import tds.driver.ServicioPersistencia;
import beans.Entidad;
import modelo.Contacto;
import modelo.ContactoIndividual;
import modelo.Grupo;
import modelo.Mensaje;

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
	
	@Override
	public boolean registrarContacto(Contacto contacto) {
		
		Entidad eContacto;
		boolean existe = true;
		
		// Si la entidad está registrada no la registra de nuevo
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

	@Override
	public void borrarContacto(Contacto contacto) {
		Entidad eContacto = servPersistencia.recuperarEntidad(contacto.getCodigo());
		servPersistencia.borrarEntidad(eContacto);
	}

	@Override
	public void modificarContacto(Contacto contacto) {
		// TODO Auto-generated method stub

	
		
		
		
		
	}

	@Override
	public Contacto recuperarContacto(int codigo) {
		
		// Si la entidad está en el pool la devuelve directamente
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
		String email = servPersistencia.recuperarPropiedadEntidad(eContacto, "email");
		String numeroU = servPersistencia.recuperarPropiedadEntidad(eUsuario, "numero");
		String fechaDeNacimiento = servPersistencia.recuperarPropiedadEntidad(eUsuario, "nombre");
		
		Contacto contacto = new Contacto(nombre);
		contacto.
		// IMPORTANTE:añadir el cliente al pool antes de llamar a otros
		// adaptadores
		//PoolDAO.getUnicaInstancia().addObjeto(numero, cliente);

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
