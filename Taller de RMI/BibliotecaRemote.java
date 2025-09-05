/*#######################################################################################
 # Fecha: 29-08-2025
 # Autor: Isabella Palacio Fajardo, Ana Sofia Grass, Sergio Ortiz, Juan Sebastian Vargas
 # Tema:
 #   - Programación distribuida en Java
 #   - Comunicación Cliente-Servidor con RMI
 #   - Manejo de objetos remotos
 #   - Persistencia de datos en archivo plano
 #   - Acceso concurrente de múltiples clientes
#######################################################################################*/
import java.rmi.Remote;
import java.rmi.RemoteException;

//Interfaz remota para el servicio de Biblioteca.
//Aquí se definen las operaciones que un cliente puede invocar mediante
//RMI sobre un conjunto de libros almacenados en el servidor DB.
//Cada método puede lanzar una RemoteException ya que las operaciones entre el cliente
//y el servidor son a través de la red.
public interface BibliotecaRemote extends Remote {
  String prestarPorISBN(String isbn) throws RemoteException;
  String prestarPorTitulo(String titulo) throws RemoteException;
  String consultarPorISBN(String isbn) throws RemoteException;
  String devolverPorISBN(String isbn) throws RemoteException;
}
