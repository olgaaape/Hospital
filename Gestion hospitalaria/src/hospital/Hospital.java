package hospital;
import java.util.Arrays;

public class Hospital
{ 
    private Paciente tpacientes[];
    private int contadorpacientes;

    public Hospital(int numpacientes)
    {
        tpacientes = new Paciente[numpacientes];
        contadorpacientes = 0;
    }

    // Ingreso de un paciente al hospital
    public boolean ingreso(Paciente p)
    {
        if (contadorpacientes<tpacientes.length) {
        	tpacientes[contadorpacientes]=p;
        	contadorpacientes++;
        	return true;
        }
        return false;
    }
    // Alta del paciente - se borra de la tabla
    public boolean alta ( int id_paciente){

        int pos = -1;
    	for (int i=0; i < contadorpacientes; i++){
    		if ( tpacientes[i].getId() == id_paciente ){
    			pos = i;
    			break;
    		}
    	}
		if ( pos >=0){
			// Desplazo a la izquierda para borrar
			for (int i=pos; i < contadorpacientes-1; i++){
				tpacientes[i] = tpacientes[i+1];
			}
			contadorpacientes--;
		}
		if (pos>=0) {
			return true;
		}
		return false;
    }    
    
    // Devuelve el paciente con el identidador indicado o null si no existe
    public Paciente buscar(int id){
    	for (int i = 0; i < contadorpacientes; i++) {
    		if (tpacientes[i].getId()==id) {
    			return tpacientes[i];
    		}
    	}
    	return null;
    }
    
    // Imprime por consola la lista ORDENADO por NOMBRE de pacientes ***

    public void listapacientes (){
  		System.out.println("======= LISTADO DE PACIENTES =======");
  		Arrays.sort(tpacientes,0,contadorpacientes);
    	for (int i = 0; i < contadorpacientes; i++) {	
    		 System.out.println(tpacientes[i].toString());	 
    	}
     
    }    
       
    // Devuelve el mas grave o el caso de paciente con la misma gravedad el
    // que su identificador sea mas bajo.
    public Paciente pacienteMasUrgente(){
    	int gravedad=4; //Variable que guarda la gravedad, para ir comparando
     
    	Paciente maxg = null;//Variable que guarda el paciente mas grave cada vez que se compare
    	 if (tpacientes[0] instanceof PacienteGrave ) {//COmprueba que el primero sea grave, si lo es guardas el pacient    	 }
    		 gravedad = ((PacienteGrave)tpacientes[0]).getgravedad().ordinal();//Cambiar la gravedad porque es mayor
    	 }
    	 maxg=tpacientes[0];//Guardas el primer paciente
    	 
    	//Recorremos el array de pacientes 
    	for (int i = 1; i < contadorpacientes; i++) {
    		
    		Paciente aux = tpacientes[i];//Guarda los pacientes del array para compararlos con maxg
    		 //Preguntamos si es un pacientegrave
   		 	 if (aux instanceof PacienteGrave ) {
   		 		 //Sabemos que es un paciente grave pero como lo hemos creado de tipo paciente hay que hacer casting
   		 		 PacienteGrave auxg = (PacienteGrave ) aux; 
   		 		 if ( auxg.getgravedad().ordinal() <  gravedad){
   		 			 maxg = auxg; 
   		 			 gravedad =auxg.getgravedad().ordinal();
   		 		 }
   		 	 }
    	}
    		
    return maxg;  
        
    }    
}
