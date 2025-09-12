/*#######################################################################################
 # Fecha: 8-08-2025
 # Autor: Isabella Palacio Fajardo, Ana Sofia Grass, Sergio Ortiz, Juan Sebastian Vargas
 # Tema:
 #   - ejecución secuencial y la concurrente en Java, aplicando el concepto de hilos
#######################################################################################*/

package threadsJarroba; // Paquete del ejemplo
public class MainThread { // Uso de hilos extendiendo Thread

	public static void main(String[] args) { // Punto de entrada

		Cliente cliente1 = new Cliente("Cliente 1", new int[] { 2, 2, 1, 5, 2, 3 }); // Cliente 1 con tiempos por producto
		Cliente cliente2 = new Cliente("Cliente 2", new int[] { 1, 3, 5, 1, 1 }); // Cliente 2 con tiempos por producto

		// Tiempo inicial de referencia
		long initialTime = System.currentTimeMillis(); // Tiempo base (ms)
		CajeraThread cajera1 = new CajeraThread("Cajera 1", cliente1, initialTime); // Hilo para cajera 1
		CajeraThread cajera2 = new CajeraThread("Cajera 2", cliente2, initialTime); // Hilo para cajera 2

		cajera1.start(); // Inicia hilo 1
		cajera2.start(); // Inicia hilo 2
	}
}
