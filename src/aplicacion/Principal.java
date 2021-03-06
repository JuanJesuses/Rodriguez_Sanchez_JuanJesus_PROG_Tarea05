package aplicacion;

import utilidades.Entrada;
import tarea05.Alquiler;
import tarea05.AlquilerVehiculos;
import tarea05.Cliente;
import tarea05.ExcepcionAlquilerVehiculos;
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
		
		Cliente cliente1 = new Cliente ("Bilbo Bolsón", "12345678A", "C/La Runa, 32", "Bolsón Cerrado", "01005");
		Cliente cliente2 = new Cliente ("Meriadoc Brandigamo", "23456789B", "C/La Runa, 72", "Hobbitón", "63541");
		Cliente cliente3 = new Cliente ("Peregrin Tuc", "34567890C", "C/La Runa, 29", "Bolsón Cerrado", "22456");
		
		nuevoAlquilerVehiculos.addCliente(cliente1);
		nuevoAlquilerVehiculos.addCliente(cliente2);
		nuevoAlquilerVehiculos.addCliente(cliente3);
		
		Turismo turismo1 = new Turismo ("4512BCD", "Opel", "Astra", 1100);
		Turismo turismo2 = new Turismo ("7628HKG", "Citröen", "Xsara", 1900);
		Turismo turismo3 = new Turismo ("2356CDH", "Hyunday", "Elantra", 1600);
		
		nuevoAlquilerVehiculos.addTurismo(turismo1);
		nuevoAlquilerVehiculos.addTurismo(turismo2);
		nuevoAlquilerVehiculos.addTurismo(turismo3);
		
		System.out.println("***********************");
		System.out.println("*ALQUILER DE VEHÍCULOS*");
		System.out.println("***********************");
		System.out.println("");
		
		do {
			
			System.out.println("");
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
				System.out.println("\nSeleccione una opción del menú  entre 0 y 9:");
				opcionMenu = Entrada.entero();
			}while (opcionMenu < 0 || opcionMenu > 9);
			
			switch(opcionMenu) {
				
				case 1:
					
					Cliente nuevoCliente = null;
															
					do {
						System.out.println("\n||-AÑADIR CLIENTE-||");
						System.out.println("********************");
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
						
						try {
							nuevoCliente = new Cliente(nombre, dni, direccion, localidad, codigoPostal);
						}catch (ExcepcionAlquilerVehiculos e) {
							System.out.println("\nError, los datos introducidos no son correctos: ");
							System.out.println("\nVuelva a introducir los datos.");
						}
						
						try {
							nuevoAlquilerVehiculos.addCliente(nuevoCliente);
						}catch (ExcepcionAlquilerVehiculos e) {
							System.out.println("");
							System.out.printf("ERROR", e.getMessage());
							System.out.println("");
						}
						
						System.out.println("\n¿Quiere añadir otro cliente (s/n)?");
						nuevo = Entrada.caracter();
						
					}while(nuevo == 's');
					
					break;
				
				case 2:
					
					do {
						System.out.println("\n||-BORRAR CLIENTE-||");
						System.out.println("********************");
						System.out.println("");
						System.out.println("\nIntroduzca el DNI del cliente que quiera eliminar: ");
						dni = Entrada.cadena();
						System.out.println("\nVa a eliminar el cliente " + nuevoAlquilerVehiculos.getCliente(dni));
						
						try {
							nuevoAlquilerVehiculos.delCliente(dni);
							System.out.println("\nCliente eliminado de forma satisfactoria.");
						}catch (Exception e) {
							System.out.printf("\nERROR", e.getMessage());
						}
						
						System.out.println("\n¿Desea eliminar otro cliente (s/n)?");
						nuevo = Entrada.caracter();
					}while(nuevo == 's');
					
					break;
					
				case 3:
					
					System.out.println("\n||-LISTADO DE CLIENTES-||");
					System.out.println("*************************");
					for(Cliente cliente : nuevoAlquilerVehiculos.getClientes()) {
						if(cliente != null)
							System.out.println(cliente);
					}
					
					break;
					
				case 4:
					
					Turismo nuevoTurismo = null;
									
					do {
						System.out.println("\n||-AÑADIR TURISMO-||");
						System.out.println("********************");
						System.out.println("Introduzca el número de matrícula: ");
						matricula = Entrada.cadena();
						System.out.println("Introduzca la marca del vehículo: ");
						marca = Entrada.cadena();
						System.out.println("Introduzca el modelo: ");
						modelo = Entrada.cadena();
						System.out.println("Introduzca la cilindrada: ");
						cilindrada = Entrada.entero();
						
						try {
							nuevoTurismo = new Turismo(matricula, marca, modelo, cilindrada);
						}catch (ExcepcionAlquilerVehiculos e) {
							System.out.println("\nLos datos introducidos no son correctos.");
							System.out.println("\nVuelva a introducir los datos.");
						}
						
						try {
							nuevoAlquilerVehiculos.addTurismo(nuevoTurismo);
						}catch(ExcepcionAlquilerVehiculos e) {
							System.out.printf("\nERROR", e.getMessage());
						}
						
						
						System.out.println("\n¿Quiere añadir otro vehículo (s/n)?");
						nuevo = Entrada.caracter();
					}while(nuevo == 's');
					
					break;
				
				case 5:
					
					do {
						System.out.println("\n||-BORRAR TURISMO-||");
						System.out.println("********************");
						System.out.println("");
						System.out.println("Introduzca la matrícula del vehículo que quiera eliminar: ");
						matricula = Entrada.cadena();
						System.out.println("Va a eliminar el vehículo " + nuevoAlquilerVehiculos.getTurismo(matricula));
						
						try {
							nuevoAlquilerVehiculos.delTurismo(matricula);
							System.out.println("\nVehículo eliminado de forma satisfactoria.");
						}catch (ExcepcionAlquilerVehiculos e) {
							System.out.printf("\nERROR", e.getMessage());
						}
												
						System.out.println("\n¿Desea eliminar otro vehículo (s/n)?");
						nuevo = Entrada.caracter();
						
					}while(nuevo == 's');
					
					break;
				
				case 6:
					
					System.out.println("\n||-LISTADO DE VEHÍCULOS-||");
					System.out.println("**************************");
					System.out.println("");
					for(Turismo turismo : nuevoAlquilerVehiculos.getTurismos()) {
						if(turismo != null)
							System.out.println(turismo);
					}
					
					break;
					
				case 7:
					
					do {
						System.out.println("\n||-CREAR NUEVO ALQUILER-||");
						System.out.println("**************************");
						System.out.println("");
						System.out.println("Introduzca el DNI del cliente: ");
						String dniClienteAlta = Entrada.cadena();
						nuevoAlquilerVehiculos.getCliente(dniClienteAlta);
						nuevoCliente = nuevoAlquilerVehiculos.getCliente(dniClienteAlta);
						System.out.println("Introduzca la matrícula del vehículo: ");
						String matriculaVehiculoAlta = Entrada.cadena();
						nuevoAlquilerVehiculos.getTurismo(matriculaVehiculoAlta);
						nuevoTurismo = nuevoAlquilerVehiculos.getTurismo(matriculaVehiculoAlta);
						
						if(nuevoCliente == null || nuevoTurismo == null) {
							System.out.println("\nError. Los datos introducidos no se encuentran en el sistema.");
						}else {
							try {
								nuevoAlquilerVehiculos.openAlquiler(nuevoCliente, nuevoTurismo);
								System.out.println("\nEl alquiler se ha generado correctamente.");
							}catch(ExcepcionAlquilerVehiculos e) {
								System.out.printf("\nError, ya hay un alquiler en curso con los datos seleccionados.", e.getMessage());
							}
						}
																							
						System.out.println("\n¿Quiere dar de alta un nuevo alquiler (s/n)?");
						nuevo = Entrada.caracter();
					}while(nuevo == 's');
					
					break;
					
				case 8:
					
					do {
						System.out.println("\n||-CERRAR ALQUILER-||");
						System.out.println("*********************");
						System.out.println("");
						System.out.println("Introduzca el DNI del cliente: ");
						String dniClienteBaja = Entrada.cadena();
						nuevoAlquilerVehiculos.getCliente(dniClienteBaja);
						nuevoCliente = nuevoAlquilerVehiculos.getCliente(dniClienteBaja);//Cliente para alta de nuevo alquiler
						System.out.println("Introduzca la matrícula del vehículo: ");
						String matriculaVehiculoBaja = Entrada.cadena();
						nuevoAlquilerVehiculos.getTurismo(matriculaVehiculoBaja);
						nuevoTurismo = nuevoAlquilerVehiculos.getTurismo(matriculaVehiculoBaja);//Turismo para alta de nuevo alquiler
						
						if(nuevoCliente == null || nuevoTurismo == null) {
							System.out.println("\nError, no existe ningún alquiler con esos datos.");
						}else {
							try {
								nuevoAlquilerVehiculos.closeAlquiler(nuevoCliente, nuevoTurismo);
								System.out.println("\nAlquiler cerrado de forma satisfactoria.");
							}catch(ExcepcionAlquilerVehiculos e) {
								System.out.printf("\nERROR", e.getMessage());
							}
						}
						
						
						System.out.println("\n¿Quiere dar de baja otro alquiler (s/n)?");
						nuevo = Entrada.caracter();
						
					}while(nuevo == 's');
					
					break;
					
				case 9:
					
					System.out.println("\n||-LISTADO DE ALQUILERES ACTIVOS-||");
					System.out.println("***********************************");
					System.out.println("");
					for(Alquiler alquiler : nuevoAlquilerVehiculos.getAlquileres()) {
						if(alquiler != null)
							System.out.println(alquiler);
					}
				
				default:
			
			}// Fin del switch
			
		}while (opcionMenu != 0);
	
	}//Fin del main

}//Fin de la clase
