/*#######################################################################################
 # Fecha: 8-08-2025
 # Autor: Isabella Palacio Fajardo, Ana Sofia Grass, Sergio Ortiz, Juan Sebastian Vargas
 # Tema:
 #   - ejecución secuencial y la concurrente en Java, aplicando el concepto de hilos
#######################################################################################*/

package threadsJarroba; // Paquete del ejemplo
public class Main { // Ejecución secuencial sin hilos

	public static void main(String[] args) { // Punto de entrada

		Cliente cliente1 = new Cliente("Cliente 1", new int[] { 2, 2, 1, 5, 2, 3 }); // Crea cliente 1 con tiempos por producto
		Cliente cliente2 = new Cliente("Cliente 2", new int[] { 1, 3, 5, 1, 1 }); // Crea cliente 2 con tiempos por producto

		Cajera cajera1 = new Cajera("Cajera 1"); // Instancia cajera 1
		Cajera cajera2 = new Cajera("Cajera 2"); // Instancia cajera 2

		// Tiempo inicial de referencia
		long initialTime = System.currentTimeMillis(); // Captura tiempo base (ms)

		cajera1.procesarCompra(cliente1, initialTime); // Procesa al cliente 1 (secuencial)
		cajera2.procesarCompra(cliente2, initialTime); // Procesa al cliente 2 (secuencial)
	}
}
