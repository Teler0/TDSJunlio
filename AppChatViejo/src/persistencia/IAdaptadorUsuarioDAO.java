package persistencia;

import java.util.List;
import modelo.Usuario;

public interface IAdaptadorUsuarioDAO {

	public boolean registrarUsuario(Usuario cliente);
	public void borrarUsuario(Usuario cliente);
	public void modificarUsuario(Usuario cliente);
	public Usuario recuperarUsuario(String codigo); //el codigo es el numero
	public List<Usuario> recuperarTodosUsuarios();
	
}