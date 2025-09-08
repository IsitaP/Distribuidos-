/*#######################################################################################
 # Fecha: 8-08-2025
 # Autor: Isabella Palacio Fajardo, Ana Sofia Grass, Sergio Ortiz, Juan Sebastian Vargas
 # Tema:
 #   - Comunicación Cliente-Servidor en Java
 #   - Implementación con Sockets TCP y UDP
#######################################################################################*/
import java.net.*;
import java.io.*;
public class sockettcpser {
   public static void main(String argv[]) {
      System.out.println("Prueba de sockets TCP (servidor)");
      ServerSocket socket;
      boolean fin = false;

      try {
         socket = new ServerSocket(6001);
         Socket socket_cli = socket.accept();
         DataInputStream in =
            new DataInputStream(socket_cli.getInputStream());
         do {
            String mensaje ="";
            mensaje = in.readUTF();
            System.out.println(mensaje);
         } while (1>0);
      }
      catch (Exception e) {
         System.err.println(e.getMessage());
         System.exit(1);
      }
   }
}

