# chatPakicetus
redes de computadores ufro 2024-1 david ibáñez trabajo recuperativo

IMPORTANTE: He subido un video a Youtube demostrando la funcionalidad debido a que el código que presento es sólo de observación, ya que el programa no va a funcionar si se intenta probar. A continuación explicaré detalladamente porqué no funcionará. El server para el chat es mi pc conectado a mi router a través del puerto 9999. Por lo tanto el server debe estar encendido en mi pc y la ip pública de mi router actualizada en el código para que funcione.

Para usar otro pc en otro lugar como server, sería necesario en primer lugar configurar el router y los puertos de esta nueva red y ejecutar la clase ChatServidor.java ubicada en src/main/java para iniciar el servidor, y posteriormente, ajustar el código en la clase DynamicGUIChatClient.java ubicada en src/main/java estableciendo cual es la ip pública de ese router. Entonces sería posible ejecutar el cliente y desplegar la interfaz gráfica a través de la cual se puede chatear. Para utilizar esta aplicación, el equipo requeriría tener instalado JDK 17 o superior y JRE 17 o superior.

Demostración de la aplicación, explicación de proceso de configuración y muestra de código en YouTube: https://youtu.be/HNfix7R-VY8
