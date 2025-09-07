# Taller Socket Mailbox
En este laboratorio con ayuda del lenguaje de java se implemento un sistema de comunicación cliente-servidor usando el protocolo TCP y UDP 

## funcionamiento 

1. Servidor (socketudpser)
-  un socket UDP en el puerto 6000.
- Se queda a la espera de mensajes desde cualquier cliente.
- Cada mensaje recibido se convierte en texto y se muestra en consola.
- El servidor se detiene cuando recibe un mensaje que comienza con "fin"

