# Sopa De Letras

## Tabla de Contenido
1. [Información General](#Información-General)
2. [Tecnologías](#Tecnologías)
3. [Instalación](#Instalación)
4. [Crear Imagen Docker](#Crear-Imagen-Docker)
5. [Publicar Imagen Docker](#Publicar-Imagen-Docker)
6. [Descargar Imagen Docker](#Descargar-Imagen-Docker)
7. [Mejoras](#Mejoras)

## Información General

Sopa de Letras en adelante SDL nace como un proyecto/microservicio a requerimiento de la empresa SITRACK para el proceso de una vacante 
al puesto de desarrollador JAVA. 

SDL Consiste en una serie de servicios REST para crear, visualizar la lista de palabras que se incluyen en la SDL creada, visualizar 
la SDL y un ultimo servicio para indicar las coordenadas de una palabra encontrada en la SDL.

* [POST] http://host/alphabetSoup/
* [GET] http://host/alphabetSoup/list/{id}
* [GET] http://host/alphabetSoup/view/{id}
* [PUT] http://host/alphabetSoup/{id}
 
## Tecnologías

* Java 1.8 update 351
* Maven 3.8.6
* Spring Boot 2.7.5
* IDE Spring Tool Suite 4.16.1
  
## Instalación

  3.1. Descargar Spring Tool Suite versión 4.16.1.RELEASE desde [Spring Tool Suite 4.16.1](https://download.springsource.com/release/STS4/4.16.1.RELEASE/dist/e4.25/spring-tool-suite-4-4.16.1.RELEASE-e4.25.0-win32.win32.x86_64.self-extracting.jar)

  > La url anterior se descomprimirá automáticamente y dejará una carpeta sts-4.16.1.RELEASE 
  > si no se descomprime de forma automática puede dar doble click y en la ruta que se indique se creará la carpeta mencionada.
  
  3.2. Ingresar a la carpeta sts-4.16.1.RELEASE y dar click en el ejecutable SpringToolSuite4.exe para abrir el IDE
  
  > En el primer ingreso nos suguiere un directorio para utilizar como espacio de trabajo.  
	Para este ejemplo presionaremos Browse y crearemos el directorio Workspace en la raiz (disco c) junto con seleccionarlo.   ***C:\Workspace***  
  Luego damos al botón Launch para iniciar nuestro IDE.
  
  3.3. En el siguiente enlace [Java Runtime Enviroment (JRE)](https://www.java.com/es/download/) presionar "Descargar Java"
  
  > Ejecutar doble click en el ejecutable descargado ***jre-8u351-windows-x64.exe*** y seguir los pasos para su instalación
  
  3.4 En Spring Tool Suite ir al menú superior y seleccionar ***Window > Preferences***. Dentro de la ventana haremos lo siguiente.
  
  3.4.1 Ubicar en el Menú al lado izquierdo la opción ***Java*** luego ***Installed JRE*** y dar click en ***Add*** y ***Standar VM***  
   
  * Dentro de la nueva ventana presionaremos el botón Directory para añadir JRE home para lo cual tendremos que ubicar el siguiente  
   directorio donde se instalo Java que por lo general es ***C:\Program Files\Java\jre1.8.0_351***. Dar click en Seleccionar Carpeta y luego click en Finish.
   > Al salir de la ventana nos aseguramos que este seleccionada la nueva versión que hemos añadido ***jre1.8.0_351*** y dar en Apply.  

  3.4.2 En el Menú opción ***Java*** ir a ***Compiler*** y en la opción Compiler asegurarse que ***compilance level*** esté seleccionada la opción 1.8
  
  3.4.3 En el menú opción ***Maven*** corroborar que la versión sea 3.8.6 que viene por defecto y saltar el punto 3.4.4
	
  3.4.4 Descargar Maven versión 3.8.6 desde [MAVEN 3.8.6](https://dlcdn.apache.org/maven/maven-3/3.8.6/binaries/apache-maven-3.8.6-bin.zip)
  
  * Una vez descargado descomprimimos el archivo ***apache-maven-3.8.6-bin.zip*** (para este ejemplo) en ***C:\Tool\Maven***  
  * Ya descomprimido vamos al IDE menú ***Window > Preferences > Maven > Installation*** y damos al botón ***Add***   
  * En la ventana que se abrirá damos al botón ***Directory*** y seleccionamos nuestra carpeta  ***C:\Tool\Maven\apache-maven-3.8.6*** y click en ***Finish***
  > Antes de salir seleccionamos la versión incluida apache-maven-3.8.6 y presionamos ***Apply and Close***
  
  3.5 Descargar el Código Fuente del microservicio Sopa de Letras el cual se encuentra en el repositorio publico [GitHub](https://github.com/Yerkito85/sopaDeLetras.git)
  
  * Para descargarlo en el IDE Menú ***File > Import***  
  * En la ventana que se abrira ***Git*** seleccionamos ***Projects from Git*** y damos al botón ***Next***
  * Luego seleccionamos ***Clone URI*** presionamos el botón ***Next***
  * Pegamos lo siguiente en el campo URI ***https://github.com/Yerkito85/sopaDeLetras.git*** y damos a ***Next***
  * Luego abrirá la pantalla Branch Selection estando seleccionado "main" damos a ***Next***
  * En la ventana Local Destination pondremos el directorio ***C:\Workspace*** que creamos anteriormente y presionamos ***Finish*** lo cual terminará de importar y damos a cerrar el wizar.
  
  3.6 Importar el proyecto en nuestro IDE .
  
  * Para importar nuestro propyecto vamos al  Menú ***File > Import*** nuevamente esta vez seleccionando Maven > Existing Maven Project  
  * En Root Directory debieramops seleccionar > C:\Workspace o C:\Workspace\sopaDeLetras y Finish  
  
  3.7 Actualizar Dependencias Maven.
  
  * Para actualizar las dependencias daremos click derecho sobre el proyecto importado e iremos a la opción ***Maven > Update Project***  
  * Daremos check en la opción Update of ***Snapshots/Releases*** y presionamos ***OK***
  
  3.8 Correr nuestro proyecto.
  
  * Daremos click derecho sobre el proyecto ***Run as > Spring Boot App ya podremos interactuar con nuestro microservicio.
  
## Crear Imagen Docker

4.1 Primero Instalaremos WSL (necesario) abriendo una consola ***Simbolo de sistema*** ejecutar ***wsl.exe --install*** y reiniciar equipo.
> O en su defecto abrir PowerShell y ejecutar ***Enable-WindowsOptionalFeature -Online -FeatureName $("VirtualMachinePlatform", "Microsoft-Windows-Subsystem-Linux")*** y dar a la opción ***Y / yes*** y reiniciar equipo.  

4.2 Descargar Docker Desktop desde [DOCKER](https://www.docker.com/products/docker-desktop/) y seguir los pasos de instalación.

4.3 Ir a la raiz del proyecto /sopa y ejecutar vía consola ***docker build -t sopa01 .***  

4.4 Luego podremos ver la imagen construida ***sopa01*** con ***docker images***  

4.5 Por último ejecutar ***docker run --sopa01 sopa01:latest***  

## Publicar Imagen Docker

5.1 Logearse con ***docker login***  

5.2 Crear TAG con ***docker tag sopa01 yerkomendez/sopa01:latest***  

5.3 Pasar TAG al Docker Hub con ***docker push yerkomendez/sopa01:latest***  

## Descargar Imagen Docker

* Descargar Imagen con ***docker pull yerkomendez/sopa01***

## Mejoras

* Mensaje de que completo la SDL (no era requerimiento)
* Manejar tematicas
* Elegir nivel (cantidad de palabras o tamaño automatico) 
* Servicio REST para dar pistas, ejemplo: fila o columna o coordenada
* Interfaz grafica para interactuar
* Manejo de JWT (Seguridad)
* Manejo de sesión para limpiar memoria




 




