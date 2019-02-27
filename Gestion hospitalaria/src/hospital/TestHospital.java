package hospital;

public class TestHospital
{
    public static void main (String argv[]){
        Hospital lapaz = new Hospital(10);
        
        lapaz.ingreso(new Paciente("Pepe"));
        lapaz.ingreso(new Paciente("Ana"));
        lapaz.ingreso(new PacienteGrave("luis",TipoGravedad.MENOS_GRAVE));
        lapaz.alta(2); // Se borra el paciente Ana
        
        lapaz.listapacientes();
        Paciente p = lapaz.buscar(3);  // Busco a luis
        System.out.println("BUSCAR: El paciente con id = 3 es "+p);
        
        lapaz.ingreso(new PacienteGrave("Jaime",TipoGravedad.MUY_GRAVE));
        lapaz.ingreso(new Paciente("Ramon"));
        lapaz.ingreso(new PacienteGrave("Maria",TipoGravedad.MUY_GRAVE));
        lapaz.listapacientes();
        
        // Debe mostrar a Jaime
        System.out.println("Paciente mas urgente:"+ lapaz.pacienteMasUrgente());      
    }         
       
}