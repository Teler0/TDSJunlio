import java.text.SimpleDateFormat;
import java.util.Date;

public class fecha {

	
	public static String stringFecha(Date fecha)
    {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String fechaString = formato.format(fecha);
    	

        return fechaString;
    }
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Date fecha = new Date();
		System.out.println(stringFecha(fecha));
		
		
		
		
		
		
		
	}

}
