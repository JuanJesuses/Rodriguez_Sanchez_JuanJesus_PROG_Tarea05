package tarea05;

public class ExcepcionAlquilerVehiculos extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public ExcepcionAlquilerVehiculos(String mensaje) {
		
		super (mensaje);
		
	}
	
}
