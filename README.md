# Nisum API

API REST que expone los endpoints: 

```
POST   ->  http://localhost:8080/login
POST   ->  http://localhost:8080/users
GET    ->  http://localhost:8080/users
PATCH  ->  http://localhost:8080/users/{uuid}
DELETE ->  http://localhost:8080/users/{uuid}
```

_Para mas información ver: [Prueba Backend Spring.pdf](./demo/docs/Ejercicio_JAVA-Especialista_Integracion-BCI.docx.pdf)_

## Comenzando 🚀

_Estas instrucciones te permitirán obtener una copia del proyecto en funcionamiento en tu máquina local para pruebas._

### Pre-requisitos 📋

_Herramientas necesarias para correr la aplicación_

```
git version 2.38.1
java 17.0.9 (Oracle Corporation 17.0.9+11-LTS-201)
```

### Construcción 🔧

+ Abrir una terminal y realizar los siguiente pasos.

```
git clone https://github.com/gustavo-9189/nisum.git
cd nisum
./gradlew build
```
+ _./gradlew build_ construirá la aplicación y ejecutará los tests unitarios.

### Correr la aplicación (local) ⚙️

_Desde una terminal, dentro del directorio del proyecto (/nisum). Realizar los siguientes pasos_

```
./gradlew run
```
+ Para saber el estado de salud de la aplicación, ir a: http://localhost:8080/actuator/health
+ Para probar la aplicación local, ir a: http://localhost:8080/swagger-ui/index.html#/

### Pruebas con Insomnia REST
_Insomnia es un cliente REST, con el cual se podran realizar pruebas a la API desplegada_
+ Descargarse la herramienta desde https://insomnia.rest/download
+ Instalarla e importar el archivo json [nisum.json](./demo/docs/Nisum_2023-12-01.json)
+ Ir a Preferences -> Data -> Import Data
+ Luego, ir a Personal Projects -> Nisum y clickear sobre la collection user
+ Una vez dentro de la collection, en el endpoint login, vamos a poder obtener el token para acceder a los endpoints
+ Colocando las credenciales:
```
{
	"email": "gustavo@gmail.com",
	"password": "gustavo"
}
```
+ Luego en el header Authorization, vamos a obtener nuestro token de Autorizacion para acceder a los endpoints


## Autor ✒️

* **Gustavo Martínez** - [gustavo-9189](https://github.com/gustavo-9189)
