package tarea05;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 
 * @author Juan Jesus
 *
 */
public class Cliente {
	
	private String nombre;
	private String dni;
	private String direccion;
	private String localidad;
	private String codigoPostal;
	private int identificador;
	private static int numClientes;
	
	/**
	 * Constructor copia
	 * @param cliente
	 */
	public Cliente (Cliente cliente) {
		
		nombre = cliente.getNombre();
		dni = cliente.getDni();
		direccion = cliente.getDireccion();
		localidad = cliente.getLocalidad();
		codigoPostal = cliente.getCodigoPostal();
		
	}
	
	/**
	 * Constructor con parámetros
	 * @param nombre
	 * @param dni
	 * @param direccion
	 * @param localidad
	 * @param codigoPostal
	 */
	public Cliente (String nombre, String dni, String direccion, String localidad, String codigoPostal) {
		
		numClientes++;
		identificador = numClientes;
		this.nombre = nombre;
		
		if (compruebaDni(dni))
			this.dni = dni;
		else
			throw new ExcepcionAlquilerVehiculos ("El DNI introducido no es válido.");
		
		this.direccion = direccion;
		this.localidad = localidad;
		
		if (compruebaCodigoPostal(codigoPostal))
			this.codigoPostal = codigoPostal;
		else
			throw new ExcepcionAlquilerVehiculos ("El código Postal introducido no es válido.");
		
	}
	
	/**
	 * Método que devuelve un boolean si el patrón introducido 
	 * para el código postal es correcto.
	 * @param codigoPostal
	 * @return boolean
	 */
	private boolean compruebaCodigoPostal (String codigoPostal) {
		Pattern patron = Pattern.compile("[0-9]{5}");
		Matcher emparejador = patron.matcher(codigoPostal);
		
		return emparejador.matches();
	}
	
	/**
	 * Método que devuelve un boolean si el patrón introducido 
	 * para el DNI es correcto
	 * @param dni
	 * @return boolean
	 */
	private boolean compruebaDni(String dni) {
		Pattern patron = Pattern.compile("[0-9]{8}[A-Z]");
		Matcher emparejador = patron.matcher(dni);
		
		return emparejador.matches();
	}

	public String getNombre() {
		return nombre;
	}

	public String getDni() {
		return dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public int getIdentificador() {
		return identificador;
	}

	@Override
	public String toString() {
		return "CLIENTE: \nNOMBRE: " + nombre + " DNI: " + dni + " DIRECCIÓN: " + direccion + " LOCALIDAD: " + localidad
				+ " CÓDIGO POSTAL: " + codigoPostal + " IDENTIFICADOR: " + identificador + "";
	}

}
