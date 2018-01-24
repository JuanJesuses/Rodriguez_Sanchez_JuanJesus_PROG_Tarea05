package tarea05;

public class AlquilerVehiculos {
	
	private final int MAX_TURISMOS = Integer.MAX_VALUE;
	private final int MAX_CLIENTES = Integer.MAX_VALUE;
	private final int MAX_ALQUILERES = Integer.MAX_VALUE;
	
	private Turismo[] turismos;
	private Cliente[] clientes;
	private Alquiler[] alquileres;
	
	public AlquilerVehiculos() {
		turismos = new Turismo[MAX_TURISMOS];
		clientes = new Cliente[MAX_CLIENTES];
		alquileres = new Alquiler[MAX_ALQUILERES];
	}

	public Turismo[] getTurismos() {
		return turismos;
	}

	public Cliente[] getClientes() {
		return clientes;
	}

	public Alquiler[] getAlquileres() {
		return alquileres;
	}
	
	public Cliente getCliente (String dni) {
		int posicion = 0;
		boolean clienteDni = false;
		for (int i = 0; i < clientes.length; i++) {
			if(clientes[i].getDni().equals(dni)) {
				clienteDni = true;
				posicion = i;
			}
		}
		
		if(clienteDni)
			return clientes[posicion];
		else
			return null;
	}
	
	public void addCliente(Cliente cliente) {
		int posicion = 0;
		boolean posicionArray = false;
		for (int i=0; i<clientes.length; i++) {
			if(clientes[i] == null){
				posicionArray = true;
				posicion = i;
			}else if (clientes[i].getDni().equals(cliente.getDni())) {
				throw new ExcepcionAlquilerVehiculos ("Ya existe un cliente con el mismo DNI.");
			}
		}
		if(posicionArray)
			clientes[posicion] = cliente;
		else
			throw new ExcepcionAlquilerVehiculos ("Cupo de clientes completo. Imposible añadir.");
	}
	
	public void delCliente (String dni) {
		int posicion = 0;
		
		for(int i=0; i<clientes.length; i++) {
			if(clientes[i] != null && clientes[i].getDni().equals(dni)) {
				posicion = i;
				
				for(int c = posicion; c<clientes.length-1; c++) {
					clientes[c] = clientes[c+1];
				}
				clientes[clientes.length-1] = null;
			}else {
				throw new ExcepcionAlquilerVehiculos ("No existe ningún cliente con el DNI introducido.");
			}
		}
	}
	
	public Turismo getTurismo(String matricula) {
		int posicion = 0;
		boolean turismoMatricula = false;
		
		for(int i=0; i<turismos.length; i++) {
			if(turismos[i].getMatricula().equals(matricula)) {
				turismoMatricula = true;
				posicion = i;
			}
		}
		
		if(turismoMatricula)
			return turismos[posicion];
		else
			return null;
	}
	
	public void addTurismo (Turismo turismo) {
		int posicion = 0;
		boolean posicionArray = false;
		for (int i=0; i<turismos.length; i++) {
			if(turismos[i] == null){
				posicionArray = true;
				posicion = i;
			}else if (turismos[i].getMatricula().equals(turismo.getMatricula())) {
				throw new ExcepcionAlquilerVehiculos ("Ya existe un turismo con la matrícula introducida.");
			}
		}
		if(posicionArray)
			turismos[posicion] = turismo;
		else
			throw new ExcepcionAlquilerVehiculos ("Cupo de turismos completo. Imposible añadir.");
	}
	
	public void delTurismo (String matricula) {
		int posicion = 0;
		
		for(int i=0; i<turismos.length; i++) {
			if(turismos[i] != null && turismos[i].getMatricula().equals(matricula)) {
				posicion = i;
				
				for(int c = posicion; c<turismos.length-1; c++) {
					turismos[c] = turismos[c+1];
				}
				turismos[turismos.length-1] = null;
			}else {
				throw new ExcepcionAlquilerVehiculos ("No existe ningún turismo con la matrícula introducida.");
			}
		}
	}
	
	public void openAlquiler (Cliente cliente, Turismo turismo) {
		int posicion = 0;
		boolean posicionOpen = false;
		
		for (int i=0; i<alquileres.length; i++) {
			if(alquileres[i] == null && alquileres[i].getTurismo().getDisponible()) {
				posicionOpen = true;
				posicion = i;
			}else {
				throw new ExcepcionAlquilerVehiculos ("El vehiculo no está disponible.");
			}
		}
		
		if(posicionOpen)
			alquileres[posicion] = new Alquiler(cliente, turismo);
	}
	
	
	
}
