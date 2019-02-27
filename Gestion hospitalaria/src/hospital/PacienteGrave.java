package hospital;

public class PacienteGrave extends Paciente
{
  
    private TipoGravedad gravedad; 

    public PacienteGrave(String nombre, TipoGravedad gravedad)
    {
        super(nombre);
        this.gravedad=gravedad;
        
    }

    public String toString()
    {
    	return getId()+":"+getNombre()+" Gravedad: "+gravedad;
    }
    
    public TipoGravedad getgravedad() {
		return gravedad;
	}
    
}