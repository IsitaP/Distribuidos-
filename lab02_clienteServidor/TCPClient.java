/*#######################################################################################
 # Fecha: 29-08-2025
 # Autor: Isabella Palacio Fajardo, Ana Sofia Grass, Sergio Ortiz, Juan Sebastian Vargas
 # Tema:
 #   - Comunicación Cliente-Servidor en Java
 #   - Implementación con Sockets TCP
 #   - Manejo de múltiples clientes mediante hilos (Multithreading)
#######################################################################################*/

import java.net.*;
import java.io.*;

// Define la clase pública TCPClient
public class TCPClient {
  public static void main(String[] args) throws Exception { // Punto de entrada; puede lanzar excepciones
    try { // Bloque para capturar y manejar cualquier error de E/S o conexión

      Socket socket = new Socket("127.0.0.1", 8888); // Crea y abre un socket hacia el servidor en localhost, puerto 8888

      DataInputStream inStream = new DataInputStream(socket.getInputStream());   // Canal para leer datos que envía el servidor
      DataOutputStream outStream = new DataOutputStream(socket.getOutputStream()); // Canal para enviar datos al servidor

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // Lector para capturar texto desde el teclado (entrada estándar)

      String clientMessage = "", serverMessage = ""; // Variables para guardar el mensaje del cliente y la respuesta del servidor

      while (!clientMessage.equals("bye")) { // Bucle: continúa hasta que el usuario escriba "bye"
        System.out.println("Enter number :"); // Muestra un prompt en la consola
        clientMessage = br.readLine();        // Lee una línea escrita por el usuario

        outStream.writeUTF(clientMessage); // Envía al servidor el mensaje en formato UTF
        outStream.flush();                 // Fuerza el envío inmediato del contenido del buffer

        serverMessage = inStream.readUTF(); // Espera y lee la respuesta del servidor (también en UTF)
        System.out.println(serverMessage);  // Imprime la respuesta del servidor en consola
      } // Fin del while cuando clientMessage es "bye"

      outStream.close(); // Cierra el flujo de salida hacia el servidor
      inStream.close();  // Cierra el flujo de entrada desde el servidor
      br.close();        // Cierra el lector de teclado
      socket.close();    // Cierra la conexión del socket

    } catch (Exception e) {        // Si ocurre algún error (conexión, I/O, etc.)
      System.out.println(e);       // Imprime el error por consola
    }                               // Fin del catch
  }                                 // Fin del main
}                                   // Fin de la clase TCPClient

