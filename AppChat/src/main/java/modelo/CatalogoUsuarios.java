package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import persistencia.DAOException;
import persistencia.FactoriaDAO;
import persistencia.IAdaptadorUsuarioDAO;

public class CatalogoUsuarios {

	//cambio esto 
	//y esto tambien
	private Map<String,Usuario> usuarios; 
	private static CatalogoUsuarios unicaInstancia = new CatalogoUsuarios();
	
	private FactoriaDAO dao;
	private IAdaptadorUsuarioDAO adaptadorUsuario;
	
	private CatalogoUsuarios() {
		try {
  			dao = FactoriaDAO.getInstancia(FactoriaDAO.DAO_TDS);
  			adaptadorUsuario = dao.getUsuarioDAO();
  			usuarios = new HashMap<String,Usuario>();
  			this.cargarCatalogo();
  		} catch (DAOException eDAO) {
  			eDAO.printStackTrace();
  		}
	}
	
	public static CatalogoUsuarios getUnicaInstancia(){
		return unicaInstancia;
	}
	
	public List<Usuario> getUsuarios(){
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		for (Usuario u : usuarios.values()) 
			lista.add(u);
		return lista;
	}
	
	public Usuario getUsuario(int id) {
		for (Usuario u: usuarios.values()) {
			if (u.getId()==id) return u;
		}
		return null;
	}
	
	public Usuario getUsuario(String numero) {
		return usuarios.get(numero); 
	}
	
	public void addUsuario(Usuario u) {
		usuarios.put(u.getNumero(), u);
	}
	
	public void removeUsuario (Usuario u) {
		usuarios.remove(u.getNumero());
	}
	
	//Recupera todos los usuarios para trabajar con ellos en memoria
	private void cargarCatalogo() throws DAOException {
		 List<Usuario> usuariosBD = adaptadorUsuario.recuperarTodosUsuarios(); //Aqui he cambiado el adaptador y el metodo
		 for (Usuario u: usuariosBD) 
			     usuarios.put(u.getNumero(),u);
	}
}
