package aplicacion;

import utilidades.Entrada;
import tarea05.Alquiler;
import tarea05.AlquilerVehiculos;
import tarea05.Cliente;
import tarea05.Turismo;

/**
 * 
 * @author Juan Jesús
 *
 */
public class Principal {
	
	public static void main(String[] args) {
		
		int opcionMenu; //Variable para escoger una opción del menú principal
		String nombre, dni, direccion, localidad, codigoPostal;
		String matricula, marca, modelo;
		int cilindrada;
		char nuevo = 'n';
		AlquilerVehiculos nuevoAlquilerVehiculos = new AlquilerVehiculos(); //Se crea un objeto de tipo alquilerVehiculos
		
		System.out.println("Alquiler de vehículos");
		System.out.println("");
		
		do {
			
			System.out.println("1. Añadir cliente.");
			System.out.println("2. Borrar cliente.");
			System.out.println("3. Listar clientes.");
			System.out.println("4. Añadir turismo.");
			System.out.println("5. Borrar turismo.");
			System.out.println("6. Listar turismos.");
			System.out.println("7. Iniciar alquiler.");
			System.out.println("8. Cerrar Alquiler.");
			System.out.println("9. Listar alquileres.");
			System.out.println("0. Salir de la aplicación.");
			System.out.println("");
			
			do {
				System.out.println("Selecciones una opción del menú  entre 0 y 9:");
				opcionMenu = Entrada.entero();
			}while (opcionMenu < 0 || opcionMenu > 9);
			
			switch(opcionMenu) {
				
				case 1:
					
					do {
						System.out.println("AÑADIR CLIENTE");
						System.out.println("");
						System.out.println("Introduzca el nombre: ");
						nombre = Entrada.cadena();
						System.out.println("Introduzca el DNI: ");
						dni = Entrada.cadena();
						System.out.println("Introduzca la dirección del cliente: ");
						direccion = Entrada.cadena();
						System.out.println("Introduzca la localidad: ");
						localidad = Entrada.cadena();
						System.out.println("Introduzca el código postal: ");
						codigoPostal = Entrada.cadena();
						Cliente nuevoCliente = new Cliente(nombre, dni, direccion, localidad, codigoPostal);
						nuevoAlquilerVehiculos.addCliente(nuevoCliente);
						
						System.out.println("¿Quiere añadir otro cliente (s/n)?");
						nuevo = Entrada.caracter();
						
					}while(nuevo == 's');
												
					break;
				
				case 2:
					do {
						System.out.println("BORRAR CLIENTE");
						System.out.println("");
						System.out.println("Introduzca el DNI del cliente que quiera eliminar: ");
						dni = Entrada.cadena();
						System.out.println("Va a eliminar el cliente " + nuevoAlquilerVehiculos.getCliente(dni));
						nuevoAlquilerVehiculos.delCliente(dni);
						
						System.out.println("¿Desea eliminar otro cliente (s/n)?");
						nuevo = Entrada.caracter();
					}while(nuevo == 's');
					break;
					
				case 3:
					
					System.out.println("LISTADO DE CLIENTES:");
					System.out.println("");
					for(Cliente cliente : nuevoAlquilerVehiculos.getClientes()) {
						if(cliente != null)
							System.out.println(cliente);
					}
					
					break;
					
				case 4:
					
					do {
						System.out.println("AÑADIR TURISMO");
						System.out.println("");
						System.out.println("Introduzca el número de matrícula: ");
						matricula = Entrada.cadena();
						System.out.println("Introduzca la marca del vehículo: ");
						marca = Entrada.cadena();
						System.out.println("Introduzca el modelo: ");
						modelo = Entrada.cadena();
						System.out.println("Introduzca la cilindrada: ");
						cilindrada = Entrada.entero();
						Turismo nuevoTurismo = new Turismo(matricula, marca, modelo, cilindrada);
						nuevoAlquilerVehiculos.addTurismo(nuevoTurismo);
						
						System.out.println("¿Quiere añadir otro vehículo (s/n)?");
						nuevo = Entrada.caracter();
						
					}while(nuevo == 's');
					
					break;
				
				case 5:
					
					do {
						System.out.println("BORRAR TURISMO");
						System.out.println("");
						System.out.println("Introduzca la matrícula del vehículo que quiera eliminar: ");
						matricula = Entrada.cadena();
						System.out.println("Va a eliminar el vehículo " + nuevoAlquilerVehiculos.getTurismo(matricula));
						nuevoAlquilerVehiculos.delTurismo(matricula);
						
						System.out.println("¿Desea eliminar otro vehículo (s/n)?");
						nuevo = Entrada.caracter();
						
					}while(nuevo == 's');
					break;
				
				case 6:
					
					System.out.println("LISTADO DE VEHÍCULOS");
					System.out.println("");
					for(Turismo turismo : nuevoAlquilerVehiculos.getTurismos()) {
						if(turismo != null)
							System.out.println(turismo);
					}
					break;
					
				case 7:
					
					do {
						System.out.println("CREAR NUEVO ALQUILER");
						System.out.println("");
						System.out.println("Introduzca el DNI del cliente: ");
						String dniClienteAlta = Entrada.cadena();
						nuevoAlquilerVehiculos.getCliente(dniClienteAlta);
						Cliente nuevoCliente = nuevoAlquilerVehiculos.getCliente(dniClienteAlta);//Cliente para alta de nuevo alquiler
						System.out.println("Introduzca la matrícula del vehículo: ");
						String matriculaVehiculoAlta = Entrada.cadena();
						nuevoAlquilerVehiculos.getTurismo(matriculaVehiculoAlta);
						Turismo nuevoTurismo = nuevoAlquilerVehiculos.getTurismo(matriculaVehiculoAlta);//Turismo para alta de nuevo alquiler
						
						nuevoAlquilerVehiculos.openAlquiler(nuevoCliente, nuevoTurismo);
												
						System.out.println("¿Quiere dar de alta un nuevo alquiler (s/n)?");
						nuevo = Entrada.caracter();
					}while(nuevo == 's');
					break;
					
				case 8:
					
					do {
						
						System.out.println("CERRAR ALQUILER");
						System.out.println("");
						System.out.println("");
						System.out.println("Introduzca el DNI del cliente: ");
						String dniClienteBaja = Entrada.cadena();
						nuevoAlquilerVehiculos.getCliente(dniClienteBaja);
						Cliente nuevoCliente = nuevoAlquilerVehiculos.getCliente(dniClienteBaja);//Cliente para alta de nuevo alquiler
						System.out.println("Introduzca la matrícula del vehículo: ");
						String matriculaVehiculoBaja = Entrada.cadena();
						nuevoAlquilerVehiculos.getTurismo(matriculaVehiculoBaja);
						Turismo nuevoTurismo = nuevoAlquilerVehiculos.getTurismo(matriculaVehiculoBaja);//Turismo para alta de nuevo alquiler
						
						nuevoAlquilerVehiculos.closeAlquiler(nuevoCliente, nuevoTurismo);
						
						System.out.println("¿Quiere dar de baja otro alquiler (s/n)?");
						nuevo = Entrada.caracter();
						
					}while(nuevo == 's');
					break;
					
				case 9:
					
					System.out.println("LISTADO DE ALQUILERES ACTIVOS");
					System.out.println("");
					for(Alquiler alquiler : nuevoAlquilerVehiculos.getAlquileres()) {
						if(alquiler != null)
							System.out.println(alquiler);
					}
				
				default:
			
			}
			
		}while (opcionMenu != 0);
	
	}

}
