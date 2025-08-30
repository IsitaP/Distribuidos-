# Lab2 - Cliente/Servidor TCP Multihilo

**Universidad Pontificia Javeriana**  
**Autores:** Isabella Palacio, Ana Sofia Grass, Juan Sebastian Vargas 
**Fecha:** 29/08/2025  

Este laboratorio implementa un **servidor TCP multihilo** y un **cliente TCP**.  
Cada conexión de cliente es atendida por un hilo independiente en el servidor.

---

## 📂 Estructura del proyecto
- `MultithreadedSocketServer.java`: servidor en el puerto `8888`; crea un `ServerClientThread` por cliente.  
- `ServerClientThread.java`: maneja el diálogo; recibe un número y responde su cuadrado; termina con `"bye"`.  
- `TCPClient.java`: cliente interactivo que lee desde consola, envía y muestra la respuesta.  

---

## ⚙️ Requisitos
- JDK 8 o superior  
- PowerShell / CMD (Windows) o cualquier shell en Linux/Mac  

---

## 🛠️ Compilación
```bash
cd "C:\Users\anaso\OneDrive\Escritorio\sistemas-distribuidos-\Primer Corte\Lab2\lab02_clienteServidor"
javac *.java
