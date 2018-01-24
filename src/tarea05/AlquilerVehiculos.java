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
	
	public String getCliente (String dni) {
		int posicion = 0;
		boolean clienteDni = false;
		for (int i = 0; i < clientes.length; i++) {
			if(clientes[i].getDni().equals(dni)) {
				clienteDni = true;
				posicion = i;
			}
		}
		
		if(clienteDni)
			return clientes[posicion].toString();
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
			throw new ExcepcionAlquilerVehiculos ("Cupo de clientes lleno. Imposible añadir.");
	}
	
	public void delCliente(String dni) {
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
	
}
