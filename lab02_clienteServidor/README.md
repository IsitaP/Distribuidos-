# Laboratorio: Cliente-Servidor en Java

## 📌 Descripción
Este proyecto implementa un modelo **Cliente-Servidor** en Java usando **Sockets TCP**.  
El servidor es **multihilo**, permitiendo manejar múltiples clientes en paralelo.  

## 📂 Archivos principales
- `MultithreadedSocketServer.java` → Inicia el servidor.
- `ServerClientThread.java` → Atiende a cada cliente en un hilo independiente.
- `TCPClient.java` → Cliente TCP que se conecta al servidor.

## ⚙️ Requisitos
- Java JDK 17 o superior.
- Consola o IDE (IntelliJ / VS Code).

## ▶️ Ejecución

1. Compilar todos los archivos:
   ```bash
   javac *.java
