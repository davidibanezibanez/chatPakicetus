# chatPakicetus
redes de computadores ufro 2024-1 david ibáñez trabajo recuperativo

IMPORTANTE: El server para el chat es originalmente mi pc conectado a mi router (IP Pública: 181.160.232.90 )a través del puerto 9999. A continuación indicaré en detalle la configuración necesaria en mi código para usar otro servidor y otro cliente.

La IP del servidor se debe cambiar en la línea 10 de la clase DynamicGUIChatClient, la cual se encuentra en chatPakicetus/src/main/java.

Respecto al puerto, puede quedar como 9999, pero en caso de desear cambiarlo, sería en la línea 11 de la clase DynamicGUIChatClient, la cual se encuentra en chatPakicetus/src/main/java y en la línea 6 de la clase ChatServer, la cual se encuentra en chatPakicetus/src/main/java.

Para probar el programa, primero ejecute el servidor, es decir la clase ChatServer y luego ejecute el o los clientes, es decir la clase DynamicGUIChatClient.

Para utilizar esta aplicación, el equipo requeriría tener instalado JDK 17 o superior y JRE 17 o superior.

Demostración de la aplicación, explicación de proceso de configuración y muestra de código en YouTube: https://youtu.be/HNfix7R-VY8
