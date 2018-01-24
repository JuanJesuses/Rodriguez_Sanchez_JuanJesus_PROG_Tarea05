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

}
