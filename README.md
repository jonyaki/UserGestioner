# UserGestioner

Requisitos previos
JDK 1.8 o superior
Gradle 6.0 o superior

## Configuración
El archivo de configuración se encuentra en src/main/resources/application.properties. Asegúrese de actualizar los valores de configuración según sea necesario.

## Ejecución
Para ejecutar la aplicación, ejecute el siguiente comando en la línea de comandos:
./gradlew bootRun
La aplicación estará disponible en http://localhost:8080.

## Empaquetado
Para empaquetar la aplicación en un archivo .jar, ejecute el siguiente comando en la línea de comandos:
./gradlew bootJar
El archivo .jar se generará en el directorio build/libs.

## Pruebas
Para ejecutar las pruebas, ejecute el siguiente comando en la línea de comandos:
./gradlew test
