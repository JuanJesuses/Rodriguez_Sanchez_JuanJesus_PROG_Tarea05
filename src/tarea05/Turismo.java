package tarea05;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * 
 * @author Juan Jesús
 *
 */
public class Turismo {
	
	private String matricula;
	private String marca;
	private String modelo;
	private int cilindrada;
	private boolean disponible;
	
	/**
	 * Constructor copia
	 * @param turismo
	 */
	public Turismo (Turismo turismo) {
		
		matricula = turismo.getMatricula();
		marca = turismo.getMarca();
		modelo = turismo.getModelo();
		cilindrada = turismo.getCilindrada();
		
	}
	
	/**
	 * Constructor con parámetros
	 * @param matricula del turismo
	 * @param marca del turismo
	 * @param modelo del turismo
	 * @param cilindrada del turismo
	 */
	public Turismo (String matricula, String marca, String modelo, int cilindrada) {
		
		if (compruebaMatricula(matricula))
			this.matricula = matricula;
		else
			throw new ExcepcionAlquilerVehiculos ("La matrícula introducida no es válida.");
		
		this.marca = marca;
		this.modelo = modelo;
		
		if (cilindrada > 0)
			this.cilindrada = cilindrada;
		else
			throw new ExcepcionAlquilerVehiculos ("La cilidrada no puede ser negativa.");
	}
	
	/**
	 * Método que comprueba que la matrícula introducida
	 * sigue el patrón correcto.
	 * @param matricula
	 * @return
	 */
	private boolean compruebaMatricula(String matricula) {
		Pattern patron = Pattern.compile("[0-9]{4}[B-DF-HJ-NP-TV-Z]{3}");
		Matcher emparejador = patron.matcher(matricula);
		
		return emparejador.matches();
	}
	
	/**
	 * Método que devuelve la matrícula
	 * @return matrícula del vehículo
	 */
	public String getMatricula() {
		return matricula;
	}

	/**
	 * Método que devuelve la marca
	 * @return marca del vehículo
	 */
	public String getMarca() {
		return marca;
	}
	
	/**
	 * Método que devuelve el modelo
	 * @return modelo del vehículo
	 */
	public String getModelo() {
		return modelo;
	}
	
	/**
	 * Método que devuelve la cilidrada
	 * @return cilindrada del vehículo
	 */
	public int getCilindrada() {
		return cilindrada;
	}
	
	/**
	 * Método que devuelve un boolean
	 * @return true o false dependiendo de si el vehículo está disponible o no
	 */
	public boolean getDisponible() {
		return disponible;
	}
	
	/**
	 * Método que cambia el estado del objeto Turismo y 
	 * que acepta como parámetro un tipo de dato boolean
	 * @param disponible
	 */
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	@Override
	public String toString() {
		return "-:Turismo:- matricula: " + matricula + " - marca: " + marca + " - modelo: " + modelo + " - cilindrada: "
				+ cilindrada + " - disponible: " + disponible + "";
	}
	
		
}
