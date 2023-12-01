# Nisum API

_Servicio que expone 3 endpoints para un API REST de usuarios._

_Para mas información ver: [Prueba Backend Spring.pdf](./docs/Ejercicio_JAVA-Especialista_Integracion-BCI.docx.pdf)_

## Comenzando 🚀

_Estas instrucciones te permitirán obtener una copia del proyecto en funcionamiento en tu máquina local para pruebas._

### Pre-requisitos 📋

_Herramientas necesarias para correr la aplicación_

```
git version 2.38.1
Gradle 8.4
java 17.0.9 (Oracle Corporation 17.0.9+11-LTS-201)
```

### Construcción 🔧

+ Abrir una terminal y realizar los siguiente pasos.

```
git clone https://github.com/gustavo-9189/nisum.git
cd nisum
cd demo
gradle build
```
+ _gradle build_ construirá la aplicación y ejecutará los tests unitarios.

### Correr la aplicación (local) ⚙️

_Desde una terminal, dentro del directorio del proyecto. Realizar los siguientes pasos_

```
gradle run
```
+ Para saber el estado de salud de la aplicación, ir a: http://localhost:8080/actuator/health
+ Para probar la aplicación local, ir a: http://localhost:8080/swagger-ui.html

### Pruebas con Insomnia REST
_Insomnia es un cliente REST, con el cual se podran realizar pruebas a la API desplegada_
+ Descargarse la herramienta desde https://insomnia.rest/download
+ Instalarla e importar el archivo json [nisum.json](./docs/nisum.json)
+ Ir a Preferences -> Data -> Import Data

## Autor ✒️

* **Gustavo Martínez** - [gustavo-9189](https://github.com/gustavo-9189)
