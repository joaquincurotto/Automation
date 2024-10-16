Este repositorio contiene los scripts de automatización diseñados para probar funcionalidades específicas de una aplicación web. A continuación se detallan los pasos para clonar, importar y ejecutar las pruebas.

Pasos para comenzar

1. Clonar el repositorio
Clona este repositorio en tu máquina local utilizando el siguiente comando:
git clone <URL del repositorio>

2. Importar el proyecto
Abre tu IDE de preferencia (Eclipse o IntelliJ) y sigue estos pasos para importar el proyecto como un proyecto Maven existente:

En Eclipse:
Selecciona Archivo -> Importar -> Proyecto Maven existente.
Navega hasta la ubicación del proyecto y selecciona la carpeta del repositorio clonado.

En IntelliJ:
Selecciona Archivo -> Nuevo -> Proyecto desde el código fuente.
Elige la carpeta del proyecto y asegúrate de que Maven esté configurado correctamente.

3. Ejecutar los tests
Ejecuta los casos de prueba desde el archivo testng.xml, que se encuentra en la raíz del proyecto. Esto generará los reportes automáticamente al finalizar la ejecución.

4. Consideraciones especiales
Si deseas ejecutar el caso de prueba WEB más de una vez, es importante actualizar el nombre de usuario dentro del DataProvider. De lo contrario, el caso fallará debido a que el sistema validará que el usuario ya existe, impidiendo la creación de duplicados.
