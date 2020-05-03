package persistencia;

import java.util.List;

import modelo.Contacto;

public interface IAdaptadorContactoDAO {

	public boolean registrarContacto(Contacto contacto);
	public void borrarContacto(Contacto contacto);
	public void modificarContacto(Contacto contacto);
	public Contacto recuperarContacto(int codigo);
	public List<Contacto> recuperarTodosContactos();

}
