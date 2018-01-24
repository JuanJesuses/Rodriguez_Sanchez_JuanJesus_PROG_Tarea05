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
	
}
