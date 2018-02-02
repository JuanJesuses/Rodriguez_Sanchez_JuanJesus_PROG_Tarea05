package tarea05;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author Juan Jesús
 *
 */
public class Alquiler {
	
	private Date fecha;
	private int dias;
	private final SimpleDateFormat FORMATO_FECHA = new SimpleDateFormat ("dd/MM/yyyy HH:mm");
	private final int MS_DIA = 1000*60*60*24;
	private final double PRECIO_DIA = 30.0;
	private Cliente cliente;
	private Turismo turismo;
	private boolean disponible;
	
	/**
	 * Constructor que acepta parámetros de tipo objeto, en concreto
	 * de tipo Cliente y Turismo. Este constructor crea la fecha actual
	 * en el momento de crear el objeto alquiler y pone por defecto el 
	 * la disponibilidad del turismo a false.
	 * @param cliente
	 * @param turismo
	 */
	public Alquiler (Cliente cliente, Turismo turismo) {
		
		this.cliente = cliente;
		this.turismo = turismo;
		fecha = new Date();
		dias = 0;
		disponible = false;
		
	}

	/**
	 * Método que devuelve la fecha
	 * @return la fecha actual
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * Método que devuelve el número de días
	 * @return número de dias de un alquiler activo
	 */
	public int getDias() {
		return dias;
	}

	/**
	 * Método que devuelve el cliente
	 * @return cliente asociado a un alquiler
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * Método que devuelve el vehículo
	 * @return vehículo asociado a un alquiler
	 */
	public Turismo getTurismo() {
		return turismo;
	}
	
	/**
	 * Método que devuelve el precio del alquler de un vehículo
	 * @return el precio del alquiler dependiendo del número de días y 
	 * la cilindrada del vehículo
	 */
	public double getPrecio() {
		return PRECIO_DIA*getDias() + turismo.getCilindrada()/100;
	}
	
	/**
	 * Método que devuelve la disponibilidad del alquiler
	 * @return el disponibilidad del alquiler
	 */
	public boolean disponible() {
		return disponible;
	}
	
	/**
	 * Método que termina un alquiler y pone 
	 * un vehículo como disponible para volver a ser
	 * alquilado.
	 */
	public void close() {
		Date entrega = new Date(); //entrega es la fecha de devolución del vehículo
		dias = difDias(entrega, fecha); // dias son los días que el vehículo ha estado en alquiler
		disponible = true;
	}
	
	/**
	 * Método que calcula los días transcurridos entre la fecha de recogida del vehículo
	 * hasta la fecha de entrega del mismo para cerrar el alquler
	 * @param fechaRecogida fecha en que el cliente recoge el vehículo
	 * @param fechaEntrega fecha en que el cliente devuelve el vehículo
	 * @return los dias transcurridos entre las fechas de recogida y entrega
	 */
	private int difDias(Date fechaRecogida, Date fechaEntrega) {
		long milisegundos = fechaRecogida.getTime() - fechaEntrega.getTime();
		long dias = milisegundos / MS_DIA;
		
		return (int) dias+1;
	}

	@Override
	public String toString() {
		return "--:Alquiler:-- \nfecha: " + FORMATO_FECHA.format(getFecha()) + " DÍAS: " + dias + "\nPRECIO: " + getPrecio() + "\n" + cliente + "\n" + turismo + 
			   "\nDISPONIBLE: " + disponible + "";
	}

}
