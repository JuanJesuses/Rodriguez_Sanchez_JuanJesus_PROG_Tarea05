package tarea05;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Alquiler {
	
	private Date fecha;
	private int dias;
	private final SimpleDateFormat FORMATO_FECHA = new SimpleDateFormat ("dd/MM/yyyy HH:mm");
	private final int MS_DIA = 1000*60*60*24;
	private final double PRECIO_DIA = 30.0;
	private Cliente cliente;
	private Turismo turismo;
	private boolean disponible;
	
	
	public Alquiler (Cliente cliente, Turismo turismo) {
		
		this.cliente = cliente;
		this.turismo = turismo;
		fecha = new Date();
		dias = 0;
		disponible = false;
		
	}


	public Date getFecha() {
		return fecha;
	}


	public int getDias() {
		return dias;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public Turismo getTurismo() {
		return turismo;
	}
	
	public double getPrecio() {
		return PRECIO_DIA*getDias() + turismo.getCilindrada()/100;
	}
	
	public void close() {
		Date entrega = new Date();
		dias = difDias(entrega, fecha);
		disponible = true;
	}
	
	private int difDias(Date fechaRecogida, Date fechaEntrega) {
		long milisegundos = fechaRecogida.getTime() - fechaEntrega.getTime();
		long dias = milisegundos / MS_DIA;
		
		return (int) dias+1;
	}
	
	

}
