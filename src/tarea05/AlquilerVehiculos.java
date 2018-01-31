package tarea05;

/**
 * 
 * @author Juan Jesús
 *
 */
public class AlquilerVehiculos {
	
	private final int MAX_TURISMOS = 100;
	private final int MAX_CLIENTES = 100;
	private final int MAX_ALQUILERES = 100;
	
	private Turismo[] turismos;
	private Cliente[] clientes;
	private Alquiler[] alquileres;
	
	/**
	 * Constructor que inicializa los arrays donde se almacenarán
	 * los objetos de tipo Turismo, Cliente y Alquiler
	 */
	public AlquilerVehiculos() {
		turismos = new Turismo[MAX_TURISMOS];
		clientes = new Cliente[MAX_CLIENTES];
		alquileres = new Alquiler[MAX_ALQUILERES];
	}
	
	/**
	 * Método que devuelve los turismos almacendos
	 * en el array turismos.
	 * @return turismos
	 */
	public Turismo[] getTurismos() {
		return turismos;
	}
	
	/**
	 * Método que devuelve los clientes almacenados
	 * en el array clientes.
	 * @return clientes
	 */
	public Cliente[] getClientes() {
		return clientes;
	}
	
	/**
	 * Método que devuelve los alquileres almacenados
	 * en el array alquileres.
	 * @return alquileres
	 */
	public Alquiler[] getAlquileres() {
		return alquileres;
	}
	
	/**
	 * Método que devuelve un cliente que busca en el array
	 * de clientes a través del dni pasado como parámetro
	 * @param dni
	 * @return cliente si hay coincidencia y null si no la hay
	 */
	public Cliente getCliente (String dni) {
		int posicion = 0; // Para guardar la posición del array que coincida con el dni encontrado en el array
		boolean clienteDni = false; // Booleano que se establecerá en true si hay coincidencia
		for (int i = 0; i < clientes.length; i++) {
			if(clientes[i] != null && clientes[i].getDni().equals(dni)) {
				clienteDni = true;
				posicion = i;
			}
		}
		
		if(clienteDni)
			return clientes[posicion];
		else
			return null;
	}
	
	/**
	 * Método que añade clientes al array de clientes
	 * @param cliente
	 */
	public void addCliente(Cliente cliente) {
		int posicion = 0;
		boolean posicionArray = false;
		for (int i=0; i<clientes.length; i++) {
			if(clientes[i] == null){ // Si la posición está vacía preparamos variables para añadir cliente al array
				posicionArray = true;
				posicion = i;
			}else if (clientes[i].getDni().equals(cliente.getDni())) {
				throw new ExcepcionAlquilerVehiculos ("Ya existe un cliente con el mismo DNI.");
			}
		}
		if(posicionArray) // Si verdadero se añade cliente a la posición del array que estaba null
			clientes[posicion] = cliente;
		else 
			throw new ExcepcionAlquilerVehiculos ("Cupo de clientes completo. Imposible añadir.");
	}
	
	/**
	 * Método que elimina un cliente del array si hay coincidencia
	 * con el dni pasado por parámetro
	 * @param dni
	 */
	public void delCliente (String dni) {
		int posicion = 0;
		boolean posicionArray = false;
		for(int i=0; i<clientes.length; i++) {
			if(clientes[i] != null && clientes[i].getDni().equals(dni)) {
				posicionArray = true;
				posicion = i;
			}
		}
		if(posicionArray) {
			for(int c = posicion; c<clientes.length-1; c++) {
				clientes[c] = clientes[c+1];
			}
			clientes[clientes.length-1] = null;
		}else {
			throw new ExcepcionAlquilerVehiculos ("No existe ningún cliente con el DNI introducido.");
		}
		
	}
	
	/**
	 * Método que devuelve un turismo que busca en el array de turismos
	 * si hay coincidencia con la matrícula pasada por parámetro 
	 * @param matricula
	 * @return turismo si hay coincidencia y null si no la hay
	 */
	public Turismo getTurismo(String matricula) {
		int posicion = 0;
		boolean turismoMatricula = false;
		
		for(int i=0; i<turismos.length; i++) {
			if(turismos[i] != null && turismos[i].getMatricula().equals(matricula)) {
				turismoMatricula = true;
				posicion = i;
			}
		}
		
		if(turismoMatricula)
			return turismos[posicion];
		else
			return null;
	}
	
	/**
	 * Añade turimos al array de turismos.
	 * @param turismo
	 */
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
	
	/**
	 * Elimina el turismo del array de turismos cuya matrícula coincida
	 * con la matrícula pasada por parámetro
	 * @param matricula
	 */
	public void delTurismo (String matricula) {
		int posicion = 0;
		boolean posicionArray = false;
		for(int i=0; i<turismos.length; i++) {
			if(turismos[i] != null && turismos[i].getMatricula().equals(matricula)) {
				posicionArray = true;
				posicion = i;
			}
		}
		if(posicionArray) {
			for(int c = posicion; c<turismos.length-1; c++) {
				turismos[c] = turismos[c+1];
			}
				turismos[turismos.length-1] = null;
		}else {
			throw new ExcepcionAlquilerVehiculos ("No existe ningún turismo con la matrícula introducida.");
		}
		
	}
	
	/**
	 * Inicia un nuevo alquiler
	 * @param cliente
	 * @param turismo
	 */
	public void openAlquiler (Cliente cliente, Turismo turismo) {
		int posicion = 0;
		boolean posicionOpen = false;
				
		for (int i=0; i<alquileres.length; i++) {
			if(alquileres[i] == null){
				posicionOpen = true;
				posicion = i;
			}else if(alquileres[i] != null && alquileres[i].getTurismo().getMatricula().equals(turismo.getMatricula())
					  && !alquileres[i].disponible()) {
				throw new ExcepcionAlquilerVehiculos ("Ya existe un alquiler de alta para ese vehículo");
			}	
		}		
		if(posicionOpen)
			alquileres[posicion] = new Alquiler(cliente, turismo);		
		else
			throw new ExcepcionAlquilerVehiculos ("El vehiculo no está disponible.");

	}
	
	/**
	 * Termina un alquiler iniciado
	 * @param cliente
	 * @param turismo
	 */
	public void closeAlquiler(Cliente cliente, Turismo turismo) {
		int posicion = 0;
		boolean posicionClose = false;
		
		for (int i=0; i<alquileres.length; i++) {
			if(alquileres[i] != null && alquileres[i].getTurismo().getMatricula().equals(turismo.getMatricula())
			   && alquileres[i].getCliente().getDni().equals(cliente.getDni()) && !alquileres[i].disponible())
			   posicionClose = true;
			   posicion = i;
		}
			
		if(posicionClose)
			alquileres[posicion].close();
		else
			throw new ExcepcionAlquilerVehiculos("Imposible cerrar el alquiler.");
	}
	
}
