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

Para compilar el proyecto se debe ejecutar el siguiente comando :  mvn package install
Si se desea levantar un contenedor con el proyecto se deben ejecutar los siguientes comandos

en la raiz del proyecto ejecutar docker build -t client-service:v1 .
y para ejecutar la imagen en el contenedor, ejecutar el siguiente comando: docker run -p 8888:8888 --name client-service. 
esto levantara el proyecto en un contedor expuesto en el puerto 8888

