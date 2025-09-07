# Taller Socket Mailbox
En este laboratorio con ayuda del lenguaje de java se implemento un sistema de comunicación cliente-servidor usando el protocolo TCP y UDP 

## funcionamiento UDP 
1. Servidor (socketudpser)
-  un socket UDP en el puerto 6000.
- Se queda a la espera de mensajes desde cualquier cliente.
- Cada mensaje recibido se convierte en texto y se muestra en consola.
- El servidor se detiene cuando recibe un mensaje que comienza con "fin"
2. Cliente (socketudpcli)
- Crea un socket UDP para enviar mensajes.
- Toma como argumento la dirección IP del servidor (ejemplo: localhost o 192.168.x.x).
- Permite al usuario escribir mensajes desde la terminal.
- Cada mensaje se envía como un datagrama UDP al servidor en el puerto 6000.
- El cliente finaliza cuando el usuario escribe un mensaje que empieza con "fin".
## Ejemplo de implementacion UDP
Para comenzar con las pruebas de implementacion,  se ejecuta el servidor UDP (socketudpser) para que se quede "a la escucha" y pueda recibir mensajes desde los clientes.
<img width="663" height="92" alt="image" src="https://github.com/user-attachments/assets/aab27929-571b-45f9-9cac-b78805870a02" />

Con el servidor activo, se ejecuta el cliente UDP (socketudpcli) en otra terminal, indicando como argumento la dirección IP del servidor (en este caso, localhost o la IP de la máquina).
<img width="651" height="105" alt="image" src="https://github.com/user-attachments/assets/01a197f7-34fd-48a1-834d-def32c1e9054" />
Se introduce el mensaje que se quiere enviar 
<img width="639" height="65" alt="image" src="https://github.com/user-attachments/assets/59202498-7545-49dd-a290-384091623f43" />

por otro lado, en la consola del servidor imprime el mensaje enviado por el cliente UDP( socketudpcli)
<img width="585" height="127" alt="image" src="https://github.com/user-attachments/assets/ea93999a-0b00-426a-8901-dbd38029c1f2" />

para cerrar la conexión del servidor, desde cliente se debe escribir la palabra "fin".
<img width="657" height="176" alt="image" src="https://github.com/user-attachments/assets/0e33317c-61e7-4e80-b0a9-d73143bb6cfe" />

## ejecución 
1. Compilar los archivos
   
Primero se deben compilar todos los ficheros .java (servidor y cliente).
En la consola, se ubica en la carpeta de talleres y ejecuta
```bash
javac *.java
```
2. Iniciar el servidor
   
En una terminal , se debe correr primero el servidor
```bash
 java socketudpser
```
3. Conectar clientes locales
   
En otra terminal , en la misma máquina, se puede iniciar un cliente con:
```bash
java  socketudpcli 172.19.100.27
```
4. 5. Finalizar la conexión
   
Para cerrar  cliente, solo se necesita escribir:
```bash
fin
```
