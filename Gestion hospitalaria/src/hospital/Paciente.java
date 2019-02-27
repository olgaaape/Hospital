package hospital;
import java.util.Arrays;
public class Paciente implements Comparable<Paciente>
{
   

	private static int numpaciente =0;
    private int id;
    private String nombre;
   

    public Paciente(String nombre)
    {
        this.nombre = nombre.toUpperCase();
        numpaciente++;
        this.id = numpaciente;
    }
    
    public String toString(){
        return id +":"+nombre;
    }    

    public static int getNumpaciente() {
		return numpaciente;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	/**Si es -1 el paramatro que le pasas es mayor, si es 1 el mayor es el tuyo y si es 0 son iguales*/
	public int compareTo(Paciente p) {
		
		return this.nombre.toUpperCase().compareTo(p.nombre.toUpperCase());
	}
}