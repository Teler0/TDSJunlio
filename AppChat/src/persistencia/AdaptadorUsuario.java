package persistencia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
	public void registrarUsuario(Usuario cliente) {
		Entidad eUsuario;
		boolean existe = true;
		
		// Si la entidad está registrada no la registra de nuevo
		try {
			eUsuario = servPersistencia.recuperarEntidad(Integer.parseInt(cliente.getNumero()));
		} catch (NullPointerException e) {
			existe = false;
		}
		
		if (existe) return;
		
		// crear entidad Usuario
		eUsuario = new Entidad();
		eUsuario.setNombre(cliente.getNombre());
		eUsuario.setPropiedades(new ArrayList<Propiedad>(
				Arrays.asList(new Propiedad("numero", cliente.getNumero()), new Propiedad("nombre", cliente.getNombre()),
						new Propiedad("alias", cliente.getAlias()), new Propiedad("password",cliente.getPassword()),
						new Propiedad("imagen", cliente.getImagen()), new Propiedad("saludo", cliente.getSaludo()),
						new Propiedad("email", cliente.getEmail()), new Propiedad("isPremiun", Boolean.toString(cliente.isPremiun())),
						new Propiedad("id", Integer.toString(cliente.getId()))
		 )));
		
		// registrar entidad cliente
		eUsuario = servPersistencia.registrarEntidad(eUsuario);
		// asignar identificador unico
		// Se aprovecha el que genera el servicio de persistencia
	
		/*


		boolean isPremiun;
		Date fechaDeNacimiento;
		int id;
		List<Contacto> listaDeContactos;
		Date fechaRegistro;*/
		
		
	}

	@Override
	public void borrarUsuario(Usuario cliente) {
		// TODO Auto-generated method stub
		Entidad eUsuario = servPersistencia.recuperarEntidad(Integer.parseInt(cliente.getNumero()));
	}

	@Override
	public void modificarUsuario(Usuario cliente) {
		// TODO Auto-generated method stub

	}

	@Override
	public Usuario recuperarUsuario(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> recuperarTodosUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

}
