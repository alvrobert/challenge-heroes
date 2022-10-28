# Challenge 
Este repositorio contiene las fuentes para solucionar el challenge enviado

Las herramientas que se usaron para la constuccion del mismo son las siguientes:
  * Java
  * SpringBoot
  * maven
  * Docker
  * H2 (Base en memoria)

# Correr proyecto

Para poder correr el proyecto localmente se puede realziar a travez de ejecucion de un contenedor de docker o localmente con el uso de un ide

Para compilar el proyecto se debe ejecutar el siguiente comando :  

 * mvn package install

Si se desea levantar un contenedor con el proyecto se deben ejecutar los siguientes comandos:

  * En la raiz del proyecto ejecutar: docker build -t client-service:v1 .
y para ejecutar la imagen en el contenedor, ejecutar el siguiente comando:
  * docker run --rm -d  -p 8080:8080/tcp client-service:v1

Esto levantara el proyecto en un contedor expuesto en el puerto 8888

# Documentacion

Se genero un swagger para poder tener a la mano la documentacion de los diferentes servicios implementados,
la url del swagger es: http://localhost:8080/swagger-ui/#/client-controller

El proyecto se encuentra deployado en Heroku donde la url base es : https://heroes-client-service.herokuapp.com

Para ingresar al swagger desplegado es con la siguiente url: https://heroes-client-service.herokuapp.com/swagger-ui/#/