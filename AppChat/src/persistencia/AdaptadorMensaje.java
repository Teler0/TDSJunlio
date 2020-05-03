package persistencia;


import java.util.ArrayList;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import beans.Entidad;
import beans.Mensaje;
import beans.Propiedad;
import tds.driver.FactoriaServicioPersistencia;
import tds.driver.ServicioPersistencia;


public class AdaptadorMensaje implements IAdaptadorMensajeDAO {
	
	
	

	private static ServicioPersistencia servPersistencia;
	private static AdaptadorMensaje unicaInstancia = null;
	
	
	
	public static AdaptadorMensaje getUnicaInstancia() { // patron singleton
		if (unicaInstancia == null) {
			return new AdaptadorMensaje();
		} else
			return unicaInstancia;
	}
	
	private AdaptadorMensaje() { 
		servPersistencia = FactoriaServicioPersistencia.getInstance().getServicioPersistencia(); 
	}
	
	@Override
	public boolean registrarMensaje(Mensaje mensaje) {
		Entidad eMensaje;
		boolean existe = true;
	
		try {
			eMensaje = servPersistencia.recuperarEntidad(mensaje.getCodigo());
		} catch (NullPointerException e) {
			existe = false;
		}
		
		if (existe) return false;
		
		eMensaje = new Entidad();
		eMensaje.setNombre("Mensaje");  
		eMensaje.setPropiedades(new ArrayList<Propiedad>(Arrays.asList(
				new Propiedad("texto", mensaje.getTexto()),
				new Propiedad("emisor", mensaje.getEmisor().getNumero()),
			    new Propiedad("receptor", String.valueOf(mensaje.getReceptor().getCodigo())))));
		
		eMensaje = servPersistencia.registrarEntidad(eMensaje);
		
		mensaje.setCodigo(eMensaje.getId());
		
		return true;
	}
	
	public Mensaje recuperarMensaje(int codigo) {
		
		// Si la entidad est� en el pool la devuelve directamente
				if (PoolDAO.getUnicaInstancia().contiene(codigo))
					return (Mensaje) PoolDAO.getUnicaInstancia().getObjeto(codigo);
		Entidad eMensaje;
		String texto;
		String emisor;
		String receptor;
		
		eMensaje = servPersistencia.recuperarEntidad(codigo);
		
		texto = servPersistencia.recuperarPropiedadEntidad(eMensaje, "texto");
		emisor = servPersistencia.recuperarPropiedadEntidad(eMensaje, "emisor");
		receptor = servPersistencia.recuperarPropiedadEntidad(eMensaje, "receptor");
		
		/*COMO PASAR UN NUEVO EMISOR Y RECEPTOR, YA QUE SON USUARIO Y CONTACTO RESPETIVAMENTE*/
		/*PASAR CODIGOS EN EL CONSTRUCTOR�?*/
		
		Mensaje mensaje = new Mensaje(texto, , );
		mensaje.setCodigo(codigo);
		return mensaje;
	}
	
	public void borrarMensaje(Mensaje mensaje) {
		Entidad eMensaje;
		eMensaje = servPersistencia.recuperarEntidad(mensaje.getCodigo()); //Se le pasa el codigo de mensaje o el idMensjae �Actualizado?
		servPersistencia.borrarEntidad(eMensaje);
	}
	
	public void modificarMensaje(Mensaje mensaje) {
		Entidad eMensaje;
		eMensaje = servPersistencia.recuperarEntidad(mensaje.getCodigo());
		
		servPersistencia.eliminarPropiedadEntidad(eMensaje, "texto");
		servPersistencia.anadirPropiedadEntidad(eMensaje,"texto", mensaje.getTexto());
		
		servPersistencia.eliminarPropiedadEntidad(eMensaje, "emisor");
		servPersistencia.anadirPropiedadEntidad(eMensaje,"emisor", mensaje.getEmisor().getNumero());
		
		servPersistencia.eliminarPropiedadEntidad(eMensaje, "receptor");
		servPersistencia.anadirPropiedadEntidad(eMensaje,"receptor", String.valueOf(mensaje.getReceptor().getCodigo()));
		
		/*modificar la fecha �?*/
	}
	
	
	public List<Mensaje> recuperarTodosMensajes(){
		List<Mensaje> mensajes = new LinkedList<Mensaje>();
		List<Entidad> entidades = servPersistencia.recuperarEntidades("Mensaje");

		for (Entidad eMensaje : entidades) {
			mensajes.add(recuperarMensaje(eMensaje.getId()));
		}
		return productos;
	}

	
	

	
		
		
		

}
